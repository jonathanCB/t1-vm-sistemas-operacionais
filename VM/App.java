// ---------------------------------------------- instancia e testa VM
public class App {
	public static void main(String args[]) {
		VM vm = new VM();

		vm.p1Fibonacci("p1");
		vm.p2FibonacciComJMP("p2");
		vm.p3Fatorial("p3");
		vm.p4BubbleSort("p4");
		
		vm.cpuRunProg("p1");
		vm.cpuRunProg("p2");
		vm.cpuRunProg("p3");
		vm.cpuRunProg("p4");

		for(paginas it: VM.todasPagi){
			System.out.println(it.toString());
		}		

		gerenteDeMemoria gm = new gerenteDeMemoria();
		gm.dump(VM.m, 0, 180);

		

	}
}