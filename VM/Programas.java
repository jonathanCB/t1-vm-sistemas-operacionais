package VM;

    // -------------------------------------------- programas a disposicao para
	// copiar na memoria (vide aux.carga)
	public class Programas {
		public Word[] testeProgramas = new Word[] {
			new Word(Opcode.LDI, 0, -1, 12),
			new Word(Opcode.STD, 0, -1, 40),

			new Word(Opcode.LDI, 0, -1, 20),
			new Word(Opcode.STD, 0, -1, 41),

			new Word(Opcode.LDI, 0, -1, 12),
			new Word(Opcode.STD, 0, -1, 42),

			new Word(Opcode.LDI, 0, -1, 1),
			new Word(Opcode.STD, 0, -1, 43),

			new Word(Opcode.LDI, 0, -1, 29),
			new Word(Opcode.STD, 0, -1, 44),
			
			new Word(Opcode.LDI, 0, -1, -12),
			new Word(Opcode.STD, 0, -1, 45),

			new Word(Opcode.LDI, 0, -1, 0),
			new Word(Opcode.STD, 0, -1, 46),

			new Word(Opcode.LDI, 3, -1, 6), 
			new Word(Opcode.LDI, 4, -1, 6), 
			new Word(Opcode.LDI, 5, -1, 20), 
			new Word(Opcode.LDI, 6, -1, 33), 
			new Word(Opcode.LDI, 7, -1, 38), 		
			new Word(Opcode.LDI, 0, -1, 40), 

			new Word(Opcode.JMPIE, 6, 3, -1), 

			new Word(Opcode.SUBI, 3, -1, 1),  
			new Word(Opcode.LDX, 1, 0, -1),  
			new Word(Opcode.ADDI, 0, -1, 1), 
			new Word(Opcode.LDX, 2, 0, -1), 
			new Word(Opcode.SUB, 2, 1, -1), 
			new Word(Opcode.JMPIG, 5, 2, -1),

			new Word(Opcode.LDX, 2, 0, -1),
			new Word(Opcode.STX, 0, 1, -1),
			new Word(Opcode.SUBI, 0, -1, 1),
			new Word(Opcode.STX, 0, 2, -1),
			new Word(Opcode.ADDI, 0, -1, 1),
			new Word(Opcode.JMPI, 5, 0 , -1),

			new Word(Opcode.JMPIE, 7, 4, -1),
			new Word(Opcode.SUBI, 4, -1, 1),
			new Word(Opcode.LDI, 0, -1, 40),
			new Word(Opcode.LDI, 3, -1, 6),
			new Word(Opcode.JMPIG, 5, 0, -1),

			new Word(Opcode.STOP, -1, -1, -1)

		};
		
		//programa p1-fibonacci
		public Word[] p1Fibonacci = new Word[] {
			new Word(Opcode.LDI, 0, -1, 0),
			new Word(Opcode.LDI, 1, -1, 1),
			new Word(Opcode.LDI, 2, -1, 18), // posicao para escrita
			new Word(Opcode.LDI, 3, -1, 10), // reg para n de fibo
			new Word(Opcode.LDI, 7, -1, 16), // 4  //reg para stop
		
			new Word(Opcode.STX, 2, 0, -1), //inicio loop
			new Word(Opcode.ADDI,2,-1,1),
			new Word(Opcode.SUBI,3,-1,1),
			new Word(Opcode.JMPIE, 7, 3, -1),
			new Word(Opcode.STX, 2, 1, -1),
			new Word(Opcode.ADDI,2,-1,1),
			new Word(Opcode.SUBI,3,-1,1),
			new Word(Opcode.JMPIE, 7, 3, -1),
			new Word(Opcode.ADD,0,1,-1),
			new Word(Opcode.ADD,1,0,-1),
			new Word(Opcode.JMP, -1, -1, 5), //volta pro loop
			
			new Word(Opcode.STOP,-1,-1,-1)
		};	

		//programa p2 - fibonnaci com jump
		public Word[] p2FibonacciComJMP = new Word[] {
			new Word(Opcode.LDI, 0, -1, 8), //alterar o valor de P para negativo ou positivo
			new Word(Opcode.STD,0,-1,25),
			new Word(Opcode.LDD, 1, -1, 25),
			new Word(Opcode.LDI, 7, -1, 8),
			new Word(Opcode.JMPIG, 7, 1, -1),
			new Word(Opcode.LDI, 3, -1, -1),
			new Word(Opcode.STD,3,-1,26),
			new Word(Opcode.STOP, -1, -1, -1), // 7

			new Word(Opcode.LDI, 0, -1, 0),
			new Word(Opcode.LDI, 1, -1, 1),
			new Word(Opcode.LDI, 2, -1, 27), // posicao para escrita
			new Word(Opcode.LDD, 3, -1, 25), // reg para n de fibo
			new Word(Opcode.LDI, 7, -1, 7), // 12  //reg para stop
		
			new Word(Opcode.STX, 2, 0, -1), //inicio loop
			new Word(Opcode.ADDI,2,-1,1),
			new Word(Opcode.SUBI,3,-1,1),
			new Word(Opcode.JMPIE, 7, 3, -1),
			new Word(Opcode.STX, 2, 1, -1),
			new Word(Opcode.ADDI,2,-1,1),
			new Word(Opcode.SUBI,3,-1,1),
			new Word(Opcode.JMPIE, 7, 3, -1),
			new Word(Opcode.ADD,0,1,-1),
			new Word(Opcode.ADD,1,0,-1),
			new Word(Opcode.JMP, -1, -1, 13)	//volta pro loop
		};
		
		//programa p3-fatorial
		public Word[] p3Fatorial = new Word[] {
			new Word(Opcode.LDI, 0, -1, 1),
			new Word(Opcode.LDI, 1, -1, 5),
			new Word(Opcode.STD, 1, -1, 20),

			new Word(Opcode.SUB, 1, 0, -1),
			new Word(Opcode.STD, 1, -1, 21),

			new Word(Opcode.LDD, 1, -1, 20),
			new Word(Opcode.LDD, 2, -1, 21),

			new Word(Opcode.MULT, 1, 2, -1),
			new Word(Opcode.SUB, 2, 0, -1),	
			new Word(Opcode.STD, 2, -1, 22),

			new Word(Opcode.MULT, 1, 2, -1),
			new Word(Opcode.SUB, 2, 0, -1),	
			new Word(Opcode.STD, 2, -1, 23),	
			
			new Word(Opcode.MULT, 1, 2, -1),
			new Word(Opcode.SUB, 2, 0, -1),	
			new Word(Opcode.STD, 2, -1, 23),	

			new Word(Opcode.STD, 1, -1, 24),
			new Word(Opcode.STOP, -1, -1, -1) 
		};

		//programa p4-BubbleSort
		public Word[] p4BubbleSort = new Word[] {
					//Carregando os valores na posição 40 de memória em diante
					new Word(Opcode.LDI, 0, -1, 12),
					new Word(Opcode.STD, 0, -1, 36),

					new Word(Opcode.LDI, 0, -1, 20),
					new Word(Opcode.STD, 0, -1, 37),

					new Word(Opcode.LDI, 0, -1, 12),
					new Word(Opcode.STD, 0, -1, 38),

					new Word(Opcode.LDI, 0, -1, 1),
					new Word(Opcode.STD, 0, -1, 39),

					new Word(Opcode.LDI, 0, -1, 29),
					new Word(Opcode.STD, 0, -1, 40),
					
					new Word(Opcode.LDI, 3, -1, 4),
					new Word(Opcode.LDI, 4, -1, 4),
					new Word(Opcode.LDI, 5, -1, 16),
					new Word(Opcode.LDI, 6, -1, 29),
					new Word(Opcode.LDI, 7, -1, 34),
		
					new Word(Opcode.LDI, 0, -1, 36),
					new Word(Opcode.JMPIE, 6, 3, -1),
					new Word(Opcode.SUBI, 3, -1, 1),
					new Word(Opcode.LDX, 1, 0, -1),
					new Word(Opcode.ADDI, 0, -1, 1),
					new Word(Opcode.LDX, 2, 0, -1),
					new Word(Opcode.SUB, 2, 1, -1),
					new Word(Opcode.JMPIG, 5, 2, -1),
					new Word(Opcode.LDX, 2, 0, -1),
					new Word(Opcode.STX, 0, 1, -1),
					new Word(Opcode.SUBI, 0, -1, 1),
					new Word(Opcode.STX, 0, 2, -1),
					new Word(Opcode.ADDI, 0, -1, 1),
					new Word(Opcode.JMPI, 5, 0 , -1),
					new Word(Opcode.JMPIE, 7, 4, -1),
					new Word(Opcode.SUBI, 4, -1, 1),
					new Word(Opcode.LDI, 0, -1, 36),
					new Word(Opcode.LDI, 3, -1, 4),
					new Word(Opcode.JMPIG, 5, 0, -1),
					new Word(Opcode.STOP, -1, -1, -1)
		};
	}