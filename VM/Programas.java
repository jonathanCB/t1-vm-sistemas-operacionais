package VM; 
    // -------------------------------------------- programas a disposicao para
	// copiar na memoria (vide aux.carga)
	public class Programas {
		public Word[] progMinimo = new Word[] {
			new Word(Opcode.LDI, 0, -1, 6),
			new Word(Opcode.LDI, 1, -1, -1),
			new Word(Opcode.JMPIE, 0, 1, -1),
			new Word(Opcode.STD, 1, -1, 19),
			new Word(Opcode.STD, 3, -1, 15),
			new Word(Opcode.STD, 0, -1, 14), 
			new Word(Opcode.STOP, -1, -1, -1) 
		};

		public Word[] p2Fibonacci = new Word[] {
			//Opcode, r1, r2, valor.
			new Word(Opcode.LDI, 0, -1, 1),
			new Word(Opcode.LDI, 1, -1, 1),
			new Word(Opcode.STD, 0, -1, 20),
			new Word(Opcode.STD, 1, -1, 21),

			new Word(Opcode.ADD, 0, 1, -1),
			new Word(Opcode.STD, 0, -1, 22),
			new Word(Opcode.LDD, 0, -1, 21),
			new Word(Opcode.LDD, 1, -1, 22),

			new Word(Opcode.ADD, 0, 1, -1),
			new Word(Opcode.STD, 0, -1, 23),
			new Word(Opcode.LDD, 0, -1, 22),
			new Word(Opcode.LDD, 1, -1, 23),

			new Word(Opcode.ADD, 0, 1, -1),
			new Word(Opcode.STD, 0, -1, 24),
			new Word(Opcode.LDD, 0, -1, 23),
			new Word(Opcode.LDD, 1, -1, 24),

			new Word(Opcode.ADD, 0, 1, -1),
			new Word(Opcode.STD, 0, -1, 25),

			new Word(Opcode.STOP, -1, -1, -1) 
		};
	}