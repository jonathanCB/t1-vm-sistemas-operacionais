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
	public Cpu cpu;
	public gerenteDeMemoria gm;

	public VM() {
		tamMem = 1024;  // colocar o tamanho da memoria
		tamPagi = 16; //colocar o tamanho da pagina		
		m = new Word[tamMem]; // m ee a memoria
		for (int i = 0; i < tamMem; i++) {
			m[i] = new Word(Opcode.___, -1, -1, -1);
		};
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
	
	public void p1Fibonacci() {
		int tamProg = 29;  //colocar o tamanho do programa
		String idProg = "p1";  //colocar o id do programa
		Word[] p = new Programas().p1Fibonacci;
		gm.alocacao(p, m, tamProg, idProg);
		cpu.setContext(0, tamMem - 1, 0);
		//System.out.println("---------------------------------- programa p1 carregado ");
		//gm.dump(m, 0, 18);
		//System.out.println("---------------------------------- programa p1 apos execucao ");
		//cpu.run();
		//gm.dump(m, 0, tamProg);
	}
	
	public void p2FibonacciComJMP() {
		int tamProg = 36;  //colocar o tamanho do programa
		String idProg = "p2";  //colocar o id do programa
		Word[] p = new Programas().p2FibonacciComJMP;
		gm.alocacao(p, m, tamProg, idProg);
		cpu.setContext(0, tamMem - 1, 0);
		//System.out.println("---------------------------------- programa p2 carregado ");
		//gm.dump(m, 0, 25);
		//System.out.println("---------------------------------- programa p2 apos execucao ");
		//cpu.run();
		//gm.dump(m, 0, tamProg);
	}

	public void p3Fatorial() {
		int tamProg = 33;  //colocar o tamanho do programa
		String idProg = "p3";  //colocar o id do programa
		Word[] p = new Programas().p3Fatorial;
		gm.alocacao(p, m, tamProg, idProg);
		cpu.setContext(0, tamMem - 1, 0);
		//System.out.println("---------------------------------- programa p3 carregado ");
		//gm.dump(m, 0, 28);
		//System.out.println("---------------------------------- programa p3 apos execucao ");
		//cpu.run();
		//gm.dump(m, 0, tamProg);
	}	

	public void p4BubbleSort() {
		int tamProg = 48;  //colocar o tamanho do programa
		String idProg = "p4";  //colocar o id do programa
		Word[] p = new Programas().p4BubbleSort;
		gm.alocacao(p, m, tamProg, idProg);
		cpu.setContext(0, tamMem - 1, 0);
		//System.out.println("---------------------------------- programa p4 carregado ");
		//gm.dump(m, 0, 40);
		//System.out.println("---------------------------------- programa p4 apos execucao ");
		//cpu.run();
		//gm.dump(m, 0, tamProg);
	}
		
}