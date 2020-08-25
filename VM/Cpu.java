package VM;
// --------------------- definicoes da CPU
// ---------------------------------------------------------------
public class Cpu {
    // característica do processador: contexto da CPU ...
    private int pc; // ... composto de program counter,
    private Word ir; // instruction register,
    private int[] reg; // registradores da CPU
    private Interrupts irpt; // durante instrucao, interrupcao pode ser sinalizada
    private int base; // base e limite de acesso na memoria
    private int limite; // por enquanto toda memoria pode ser acessada pelo processo rodando
                        // ATE AQUI: contexto da CPU - tudo que precisa sobre o estado de um processo
                        // para executar
                        // nas proximas versoes isto pode modificar, e vai permitir salvar e restaurar
                        // um processo na CPU

    private Word[] m; // CPU acessa MEMORIA, guarda referencia 'm' a ela. memoria nao muda. E sempre
                      // a mesma.

    public Cpu(Word[] _m) { // ref a MEMORIA passada na criacao da CPU
        m = _m; // usa o atributo 'm' para acessar a memoria.
        reg = new int[8]; // aloca o espaço dos registradores
    }

    public void setContext(int _base, int _limite, int _pc) { // no futuro esta funcao vai ter que ser
        base = _base; // expandida para setar todo contexto de execucao,
        limite = _limite; // agora, setamos somente os registradores base,
        pc = _pc; // limite e pc (deve ser zero nesta versao)
        irpt = Interrupts.noInterrupt; // reset da interrupcao registrada
    }

    private boolean legal(int e) { // todo acesso a memoria tem que ser verificado
        if ((e < base) || (e > limite)) { // valida se endereco 'e' na memoria ee posicao legal
            irpt = Interrupts.intEnderecoInvalido; // caso contrario ja liga interrupcao
            return false;
        }
        ;
        return true;
    }

    public void run() { // execucao da CPU supoe que o contexto da CPU, vide acima, esta devidamente
                        // setado
        while (true) { // ciclo de instrucoes. acaba cfe instrucao, veja cada caso.
            // FETCH
            if (legal(pc)) { // pc valido
                ir = m[pc]; // busca posicao da memoria apontada por pc, guarda em ir
                // EXECUTA INSTRUCAO NO ir
                switch (ir.opc) { // DADO,JMP,JMPI,JMPIG,JMPIL,JMPIE,ADDI,SUBI,ANDI,ORI,LDI,LDD,STD,ADD,SUB,MULT,LDX,STX,SWAP,STOP;

                    case LDI: // Rd <- k
                        reg[ir.r1] = ir.p;
                        pc++;
                        break;

                    case LDD: // Rd <- [A]
                        if (legal(ir.p)) {
                            reg[ir.r1] = m[ir.p].p;
                            pc++;
                        };
                        break;

                    case LDX: // Rd <- [Rs]
                        if (legal(reg[ir.r2])) {
                            reg[ir.r1] = m[reg[ir.r2]].p;
                            pc++;
                        };
                        break;

                    case STD: // [A] <- Rs
                        if (legal(ir.p)) {
                            m[ir.p].opc = Opcode.DADO;
                            m[ir.p].p = reg[ir.r1];
                            pc++;
                        };
                        break;

                    case STX: // [Rd] <- Rs
                        if (legal(reg[ir.r1])) {
                            m[reg[ir.r1]].opc = Opcode.DADO;
                            m[reg[ir.r1]].p = reg[ir.r2];
                            pc++;
                        };
                        break;

                    case ADD: // Rd <- Rd + Rs
                        reg[ir.r1] += reg[ir.r2];
                        pc++;
                        break;

                    case ADDI: // Rd <- Rd + k
                        reg[ir.r1] += ir.p;
                        pc++;
                        break;

                    case SUB: // Rd <- Rd - Rs
                        reg[ir.r1] -= reg[ir.r2];
                        pc++;
                        break;

                    case SUBI: // Rd <- Rd - k
                        reg[ir.r1] -= ir.p;
                        pc++;
                        break;

                    case MULT: // Rd <- Rd * Rs
                        reg[ir.r1] *= reg[ir.r2];
                        pc++;
                        break;

                    case JMP: // PC <- k
                        if (legal(ir.p)) {
                            pc = ir.p;
                        };
                        break;

                    case JMPI: // PC <- Rs
                        if (legal(reg[ir.r1])) {
                            pc = reg[ir.r1];
                        };
                        break;

                    case JMPIG: // If Rc > 0 Then PC <- Rs Else PC <- PC +1
                        if (legal(reg[ir.r1])) {
                            if (reg[ir.r2] > 0) {
                                pc = reg[ir.r1];
                                break;
                            } else {
                                pc++;
                                break;
                            }
                        };
                        break;

                    case JMPIL: // If Rc < 0 Then PC <- Rs Else PC <- PC +1
                        if (legal(reg[ir.r1])) {
                            if (reg[ir.r2] < 0) {
                                pc = reg[ir.r1];
                                break;
                            } else {
                                pc++;
                                break;
                            }
                        };
                        break;

                    case JMPIE: // If Rc = 0 Then PC <- Rs Else PC <- PC +1
                        if (legal(reg[ir.r1])) {
                            if (reg[ir.r2] == 0) {
                                pc = reg[ir.r1];
                                break;
                            } else {
                                pc++;
                                break;
                            }
                        };
                        break;

                        /*
                    case ANDI: // Rd <- Rd and k  if Rd = k -> 1 | if Rd != k -> 0
                        if (ir.p == reg[ir.r1]) {
                            
                        };
                        break;
                        */

                    case SWAP: // rd7 <- rd3  |  rd5 <- rd1  |  rd6 <- rd2  |  rd4 <- rd0
                        int aux;
                        aux = reg[7];
                        reg[7] = reg[3];
                        reg[3] = aux;

                        aux = reg[5];
                        reg[5] = reg[1];
                        reg[1] = aux;   
                        
                        aux = reg[6];
                        reg[6] = reg[2];
                        reg[2] = aux;

                        aux = reg[4];
                        reg[4] = reg[0];
                        reg[0] = aux;
                        pc++;
                        break;

                    // falta entrar no switch ANDI,ORI

                    case STOP: // para execucao
                        irpt = Interrupts.intSTOP;
                        break;

                    case DADO:
                        pc++;
                        break;

                    default:

                        break;
                }
            }
            // verifica int - agora simplesmente para programa em qualquer caso
            if (!(irpt == Interrupts.noInterrupt)) {
                System.out.print("Interrupcao ");
                System.out.println(irpt);
                break; // break sai do loop da cpu
            }
        }
    }
}