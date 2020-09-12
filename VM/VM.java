// PUCRS, Escola Politécnica, Engenharia de Software
// Disciplina Sistemas Operacionais
// Prof. Fernando Luís Dotti
// Trabalho - Parte I
//
// Código fornecido pelo professor como uma forma de resolver o enunciado
// Este código compila e executa na VM o pequeno programa ao final, com somente tres instrucoes diferentes.
// Alem das definicoes dos elementos solicitados, os cuidados de acesso valido a memoria, instrucoes validas,
// interrupcoes, o ciclo de instrucao com as tres fases, ja estao contemplados.
// Pede-se estudar e enteder este codigo. Os alunos podem adotar ideias parecidas.   
// Falta implementar as demais instrucoes da CPU, assim como os programas solicitados.
// Este trabalho tem menos de 200 linhas de código.
// A VM completa, construida pelo professor, incluindo o programa P1, tem 234 linhas.

public class VM {
	// -------------------------------------------- atributos e construcao da VM
	public static int tamMem;
	public static int tamPagi;
	public static Word[] m;
	public static Cpu cpu;
	public static gerenteDeMemoria gm;
	public static processControlBlock pcb;

	//inicia a VM, com o tamanho da memoria informado, o tamanho da pagina da memoria
	//cria um processes control block, um gerente de memoria e uma cpu
	public VM() {
		tamMem = 1024;  // colocar o tamanho da memoria
		tamPagi = 16; //colocar o tamanho da pagina		
		m = new Word[tamMem]; // m ee a memoria
		pcb = new processControlBlock();
		gm = new gerenteDeMemoria();
		cpu = new Cpu(m);		
	}

	// -------------------------------------------- teste da VM , veja classe de
	// programas
	/*
	public void testeProgramas() {
		Word[] p = new Programas().testeProgramas;
		aux.carga(p, m);
		cpu.setContext(0, tamMem - 1, 0);
		System.out.println("---------------------------------- programa testes carregado ");
		aux.dump(m, 0, 60);
		System.out.println("---------------------------------- programa testes apos execucao ");
		cpu.run();
		//gm.dump(m, 0, 60);
	}
*/

	// recebe o id do programa, seta o contexto na cpu e executa o programa
	public void cpuRunProg(int ID){
		for(processo it: processControlBlock.TodosProcessos){
			if(it.ID == ID){
				cpu.setContext(0, tamMem - 1, 0, ID);
				cpu.run();
			}
		}
	}
	
	public void p1Fibonacci(int ID) {
		int tamProg = 29;  //colocar o tamanho do programa
		Word[] p = new Programas().p1Fibonacci;
		gm.alocacao(p, tamProg, ID);
	}

	public void p1Fibonacci2(int ID) {
		int tamProg = 29;  //colocar o tamanho do programa
		Word[] p = new Programas().p1Fibonacci;
		gm.alocacao(p, tamProg, ID);
	}
	
	public void p2FibonacciComJMP(int ID) {
		int tamProg = 36;  //colocar o tamanho do programa
		Word[] p = new Programas().p2FibonacciComJMP;
		gm.alocacao(p, tamProg, ID);
	}

	public void p3Fatorial(int ID) {
		int tamProg = 33;  //colocar o tamanho do programa
		Word[] p = new Programas().p3Fatorial;
		gm.alocacao(p, tamProg, ID);
	}	

	public void p4BubbleSort(int ID) {
		int tamProg = 48;  //colocar o tamanho do programa
		Word[] p = new Programas().p4BubbleSort;
		gm.alocacao(p, tamProg, ID);
	}
		
}