package VM;

// --------------------- definicoes da CPU
// ---------------------------------------------------------------
public enum Interrupts { // possiveis interrupcoes
    noInterrupt, intEnderecoInvalido, intInstrucaoInvalida, intSTOP;
}