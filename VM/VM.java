package VM;

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
	public int tamMem;
	public Word[] m;
	public Cpu cpu;
	public Auxilixar aux;

	public VM() {
		tamMem = 1024;
		m = new Word[tamMem]; // m ee a memoria
		for (int i = 0; i < tamMem; i++) {
			m[i] = new Word(Opcode.___, -1, -1, -1);
		}
		;
		cpu = new Cpu(m);
		aux = new Auxilixar();
	}

	// -------------------------------------------- teste da VM , veja classe de
	// programas
	public void test1() {
		Word[] p = new Programas().progMinimo;
		aux.carga(p, m);
		cpu.setContext(0, tamMem - 1, 0);
		System.out.println("---------------------------------- programa carregado ");
		aux.dump(m, 0, 15);
		System.out.println("---------------------------------- após execucao ");
		cpu.run();
		aux.dump(m, 0, 15);
	}

	public void p2Fibonacci() {
		Word[] p = new Programas().p2Fibonacci;
		aux.carga(p, m);
		cpu.setContext(0, tamMem - 1, 0);
		System.out.println("---------------------------------- programa carregado ");
		aux.dump(m, 0, 15);
		System.out.println("---------------------------------- após execucao ");
		cpu.run();
		aux.dump(m, 0, 15);
	}
}