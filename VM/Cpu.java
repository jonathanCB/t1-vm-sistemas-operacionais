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

                    case LDI: // R1 <- p
                        reg[ir.r1] = ir.p;
                        pc++;
                        break;

                    case LDD: // R1 <- [p]
                        if (legal(ir.p)) {
                            reg[ir.r1] = m[ir.p].p;
                            pc++;
                        };
                        break;

                    case LDX: // R1 <- [R2]
                        if (legal(reg[ir.r2])) {
                            reg[ir.r1] = m[reg[ir.r2]].p;
                            pc++;
                        };
                        break;

                    case STD: // [P] <- R1
                        if (legal(ir.p)) {
                            m[ir.p].opc = Opcode.DADO;
                            m[ir.p].p = reg[ir.r1];
                            pc++;
                        };
                        break;

                    case STX: // [R1] <- R2
                        if (legal(reg[ir.r1])) {
                            m[reg[ir.r1]].opc = Opcode.DADO;
                            m[reg[ir.r1]].p = reg[ir.r2];
                            pc++;
                        };
                        break;

                    case ADD: // R1 <- R1 + R2
                        reg[ir.r1] += reg[ir.r2];
                        pc++;
                        break;

                    case ADDI: // R1 <- R1 + p
                        reg[ir.r1] += ir.p;
                        pc++;
                        break;

                    case SUB: // R1 <- R1 - R2
                        reg[ir.r1] -= reg[ir.r2];
                        pc++;
                        break;

                    case SUBI: // R1 <- R1 - p
                        reg[ir.r1] -= ir.p;
                        pc++;
                        break;

                    case MULT: // R1 <- R1 * R2
                        reg[ir.r1] *= reg[ir.r2];
                        pc++;
                        break;

                    case JMP: // PC <- p
                        if (legal(ir.p)) {
                            pc = ir.p;
                        };
                        break;

                    case JMPI: // PC <- R1
                        if (legal(reg[ir.r1])) {
                            pc = reg[ir.r1];
                        };
                        break;

                    case JMPIG: // If R2 > 0 Then PC <- R1 Else PC <- PC +1
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

                    case JMPIL: // If R2 < 0 Then PC <- R1 Else PC <- PC +1
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

                    case JMPIE: // If R2 = 0 Then PC <- R1 Else PC <- PC +1
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
                        
                    case JMPIM: // PC <- [p] vai para a posicao p na memoria, pega o valor de p da memoria e pula o pc para esse valor p que estiver la
                        if (legal(ir.p)) {
                            if (legal(m[ir.p].p)) {
                                pc = m[ir.p].p;
                                break;
                            }
                        };
                        break;    
                        
                    case JMPIMG: // If R1 > 0 Then PC <- [vai para a posicao p, pega o dado p que tiver la e usa esse p como pc] Else PC <- PC +1
                        if (legal(ir.p)) {                            
                            if(reg[ir.r1] > 0){
                                if (legal(m[ir.p].p)) {
                                    pc = m[ir.p].p;
                                    break;
                                }
                            }
                            else {
                                pc++;
                                break;
                            }
                        };
                        break;

                    case JMPIML: // If R1 < 0 Then PC <- [vai para a posicao p, pega o dado p que tiver la e usa esse p como pc] Else PC <- PC +1
                        if (legal(ir.p)) {                            
                            if(reg[ir.r1] < 0){
                                if (legal(m[ir.p].p)) {
                                    pc = m[ir.p].p;
                                    break;
                                }
                            }
                            else {
                                pc++;
                                break;
                            }
                        };
                        break;

                    case JMPIME: // If R1 = 0 Then PC <- [vai para a posicao p, pega o dado p que tiver la e usa esse p como pc] Else PC <- PC +1
                        if (legal(ir.p)) {                            
                            if(reg[ir.r1] == 0){
                                if (legal(m[ir.p].p)) {
                                    pc = m[ir.p].p;
                                    break;
                                }
                            }
                            else {
                                pc++;
                                break;
                            }
                        };
                        break;

                    case SWAP: // T <- Ra | Ra <- Rb | Rb <- T
                        int aux;
                        aux = reg[ir.r1];
                        reg[ir.r1] = reg[ir.r2];
                        reg[ir.r2] = aux;
                        pc++;
                        break;                    

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