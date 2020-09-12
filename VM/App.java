// ---------------------------------------------- instancia e testa VM
public class App {
	public static void main(String args[]) {
		//criando a vm
		VM vm = new VM();
		int cont;

		//teste 1 - frames sem e com uso, disposicao dos programas na memoria

		System.out.println("dump dos frames sem nenhnum programa");
		cont = 0;
		for(Boolean it: gerenteDeMemoria.frames){
			System.out.println(" frame "+cont+" = "+it);
			cont++;
		}

		System.out.println("alocando os programas em memoria"+"\nP1,"+" P2,");
		vm.p1Fibonacci(0001);
		vm.p2FibonacciComJMP(0002);

		System.out.println("dump dos frames com todos programas");
		cont = 0;
		for(Boolean it: gerenteDeMemoria.frames){
			System.out.println(" frame "+cont+" = "+it);
			cont++;
		}

		System.out.println("todos os programas no process control block");
		for(processo it: processControlBlock.TodosProcessos){
			System.out.println(it.toString());
		}	
		
		System.out.println("dump da memoria com todos programas");
		VM.gm.dump(VM.m, 0, 122);



		//teste 2 - executando programas e desalocando programas

		System.out.println("executando os programas ja alocados em memoria"+"\nP1,"+" P2,");
		vm.cpuRunProg(0001);
		vm.cpuRunProg(0002);
		
		System.out.println("dump da memoria com todos programas apos execucao");
		VM.gm.dump(VM.m, 0, 150);

		System.out.println("desalocando o p1");
		gerenteDeMemoria.desaloca(0001);

		System.out.println("dump da memoria apos desalocar o p1");
		VM.gm.dump(VM.m, 0, 150);

		System.out.println("dump dos frames apos desalocar o p1");
		cont = 0;
		for(Boolean it: gerenteDeMemoria.frames){
			System.out.println(" frame "+cont+" = "+it);
			cont++;
		}
	}
}