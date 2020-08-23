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
			new Word(Opcode.LDI, 0, -1, 1),
			new Word(Opcode.ADD, 0, -1, 1),
			new Word(Opcode.STD, 0, 1, 10),
			new Word(Opcode.STD, 0, -1, 11),
			new Word(Opcode.STD, 0, -1, 12),
			new Word(Opcode.STOP, -1, -1, -1) 
		};
	}