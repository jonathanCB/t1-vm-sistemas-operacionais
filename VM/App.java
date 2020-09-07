// ---------------------------------------------- instancia e testa VM
public class App {
	public static void main(String args[]) {
		//VM vmTestes = new VM();
		VM vm = new VM();
		//VM vmP2 = new VM();
		//VM vmP3 = new VM();
		//VM vmP4 = new VM();

		// para rodar todos, tirar de modo comentario
		//vmTestes.testeProgramas();		
		//System.out.println("\n\n\n");
		//vmP1.p1Fibonacci();
		//System.out.println("\n\n\n");
		vm.p1Fibonacci();
		vm.p2FibonacciComJMP();
		vm.p3Fatorial();
		vm.p4BubbleSort();
		System.out.println("\n\n\n");
		//vmP3.p3Fatorial();
		//System.out.println("\n\n\n");		
		//vmP4.p4BubbleSort();
		//System.out.println("\n\n\n");

		int cont = 0;
		for(boolean it: gerenteDeMemoria.memoria){
			System.out.println(it+" "+cont);
			cont++;
		}

		for(paginas it: gerenteDeMemoria.todasPagi){
			System.out.println(it.toString());
		}
		gerenteDeMemoria.desaloca("p4");

		for(paginas it: gerenteDeMemoria.todasPagi){
			System.out.println(it.toString());
		}

		gerenteDeMemoria gm = new gerenteDeMemoria();
		gm.dump(VM.m, 0, 167);

		

	}
}