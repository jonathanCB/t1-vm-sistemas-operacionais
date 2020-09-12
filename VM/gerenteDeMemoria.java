/*
faz a particao da memoria em frames, a partir de informaçoes obtidas da VM
aloca programas na memoria, envia esses programas em forma de processo para o process control block
desaloca esses programas da memoria e avisa o process control block que o programa foi desalocado
dump da memoria
*/

public class gerenteDeMemoria {
    private int nPagi;
    public static boolean[] frames;
    
    //contrutor do gerente de memoria, ao ser iniciado cria os frames a partir do tamanho da memoria / pelo tamanho da pagina, e inicia todos os frames com true ou false
    public gerenteDeMemoria() {
        for (int i = 0; i < VM.m.length; i++) {
			VM.m[i] = new Word(Opcode.___, -1, -1, -1);
		};
        frames = new boolean[(VM.tamMem / VM.tamPagi)];
        for (int i = 0; i < frames.length; i++) {
            if(i%2 == 0){
                frames[i] = false;  // false = ocupado || true = livre
            }else{
                frames[i] = true;
            }        
        }
    }

    //ao receber um programa, calcula o tamanho dele, se tiver espaço, aloca em memoria
    //tambem cria um processo com o ID do programa e as paginas onde esse programa esta em memoria
    public boolean alocacao(Word[] p, int tamProg, int ID) {
        if(tamProg%VM.tamPagi == 0){
            nPagi = ((tamProg/VM.tamPagi));
        }
        else{
            nPagi = ((tamProg/VM.tamPagi)+1);
        }
        int cont = 0;
        int posProg = 0;        
        for(int i=0; i<frames.length; i++){
            if(frames[i] == true){
                cont++;
            }
        }
        if(cont >= nPagi){                        
            cont = 0;
            processControlBlock.TodosProcessos.add(new processo(ID));
            int pos = processControlBlock.TodosProcessos.size()-1;
            for(int i=0; i<frames.length; i++){
                if(frames[i] == true){
                    cont++;
                    frames[i] = false;
                    processControlBlock.TodosProcessos.get(pos).addPagina(i);
                    for (int j=(i*VM.tamPagi); j<(i+1)*VM.tamPagi; j++) {
                        if(posProg < p.length){
                            VM.m[j].opc = p[posProg].opc;
                            VM.m[j].r1 = p[posProg].r1;
                            VM.m[j].r2 = p[posProg].r2;
                            VM.m[j].p = p[posProg].p;
                            posProg++;
                        }
                        else{
                            break;
                        }
                    }
                }
                if(cont == nPagi){ 
                    return true;
                }
            }
        }
        return false;
    }

    //dado o id de um processo, o gerente de memoria, troca os frames com false(ocupado) para true(livre)
    //tambem avisa o PCB qual o id do processo que foi desalocado
    public static void desaloca(int ID){
        for(int i=0; i<processControlBlock.TodosProcessos.size(); i++){
            if(processControlBlock.TodosProcessos.get(i).ID == ID){
                for(Integer p: processControlBlock.TodosProcessos.get(i).getLista()){
                    for(int j=0; j<frames.length; j++){
                        if(p == j){
                            frames[j] = true;
                            for (int k=(j*VM.tamPagi); k<(j+1)*VM.tamPagi; k++) {
                                VM.m[k] = new Word(Opcode.___, -1, -1, -1);
                            }
                        }
                    }
                }
            }            
        }
        processControlBlock.encerraProcesso(ID);
    }

    // formata a impressao do dump de memoria
    public void dump(Word w) {
    System.out.print("[ " + w.opc + ", " + w.r1 + ", " + w.r2 + ", " + w.p + " ] " + "\n");
    }

    //imprime umm dump da memoria, na posicao ini até o fim informado por parametro
    public void dump(Word[] m, int ini, int fim) {
        for (int i = ini; i < fim; i++) {
            System.out.print(i + ": ");
            dump(m[i]);
        }
    }
}

