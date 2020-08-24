// --------------------- definicoes de opcode e palavra de memoria
// ---------------------------------------
public enum Opcode {
    DADO, ___, // se memoria nesta posicao tem um dado, usa DADO, se nao usada ee NULO
    JMP, JMPI, JMPIG, JMPIL, JMPIE, ADDI, SUBI, ANDI, ORI, LDI, LDD, STD, ADD, SUB, MULT, LDX, STX, SWAP, STOP;
}
