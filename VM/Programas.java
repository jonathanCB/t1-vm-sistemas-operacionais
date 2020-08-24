
    // -------------------------------------------- programas a disposicao para
	// copiar na memoria (vide aux.carga)
	public class Programas {
		public Word[] testeProgramas = new Word[] {
			new Word(Opcode.LDI, 0, -1, 15), //alterar o valor de P para negativo ou positivo
			new Word(Opcode.STD,0,-1,30),
			new Word(Opcode.LDD, 1, -1, 30),
			new Word(Opcode.LDI, 2, -1, 8),
			new Word(Opcode.JMPIG, 2, 1, -1),
			new Word(Opcode.LDI, 3, -1, -1),
			new Word(Opcode.STD,3,-1,31),
			new Word(Opcode.STOP, -1, -1, -1),

			new Word(Opcode.LDI, 1, -1, 0),
			new Word(Opcode.LDI, 2, -1, 1),
			new Word(Opcode.STD,1,-1,32),
			new Word(Opcode.STD,2,-1,33),
			new Word(Opcode.SUBI,0,-1,2),
			new Word(Opcode.STD,0,-1,34),

			
			new Word(Opcode.STOP, -1, -1, -1)
		};
		
		//programa p1
		public Word[] p1Fibonacci = new Word[] {
			new Word(Opcode.LDI,0,-1,0),
			new Word(Opcode.STD,0,-1,17),
			new Word(Opcode.LDI,1,-1,1),
			new Word(Opcode.STD,1,1,18),
			new Word(Opcode.LDI,7,-1,19),
			new Word(Opcode.LDI,5,-1,6),
			new Word(Opcode.LDI,6,-1,28),
			new Word(Opcode.LDI,2,-1,0),
			new Word(Opcode.ADD,2,0,-1),
			new Word(Opcode.LDI,0,-1,0),
			new Word(Opcode.ADD,0,1,-1),
			new Word(Opcode.ADD,1,2,-1),
			new Word(Opcode.STX,7,1,-1),
			new Word(Opcode.ADDI,7,-1,1),
			new Word(Opcode.SUB,6,7,-1),
			new Word(Opcode.JMPIG,5,6,-1),
			new Word(Opcode.STOP,-1,-1,-1)
		};	
		
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

			new Word(Opcode.STD, 1, -1, 29),
			new Word(Opcode.STOP, -1, -1, -1) 
		};
	}