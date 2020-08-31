package VM;

// ---------------------------------------------- instancia e testa VM
public class App {
	public static void main(String args[]) {
		VM vmTestes = new VM();
		VM vmP1 = new VM();
		VM vmP2 = new VM();
		VM vmP3 = new VM();
		VM vmP4 = new VM();

		// para rodar todos, tirar de modo comentario
		vmTestes.testeProgramas();		
		System.out.println("\n\n\n");
		vmP1.p1Fibonacci();
		System.out.println("\n\n\n");
		vmP2.p2FibonacciComJMP();
		System.out.println("\n\n\n");
		//vmP3.p3Fatorial();
		System.out.println("\n\n\n");		
		vmP4.p4BubbleSort();
		System.out.println("\n\n\n");
	}
}