import java.util.ArrayList;

public class teste {
    public static void main(String args[]) {
        VM vm = new VM();

        /*
        vm.p1Fibonacci();
		vm.p2FibonacciComJMP();
		vm.p3Fatorial();
		vm.p4BubbleSort();
        */
        int cont = 0;
		for(boolean it: gerenteDeMemoria.memoria){
			System.out.println(it+" "+cont);
			cont++;
		}

		for(paginas it: VM.todasPagi){
			System.out.println("\n"+it.toString());
        }
        
        gerenteDeMemoria gm = new gerenteDeMemoria();
		gm.dump(VM.m, 0, 207);

    }
}