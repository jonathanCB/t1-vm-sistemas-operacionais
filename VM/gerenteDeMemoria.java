import java.util.ArrayList;
import java.util.List;

public class gerenteDeMemoria {
    private boolean status;  //true = livre //false = ocupado
    private int quantFrames;
    private int nPagi;
    public static List<paginas> todasPagi;
    public static boolean[] memoria;


    public void dump(Word w) {
        System.out.print("[ ");
        System.out.print(w.opc);
        System.out.print(", ");
        System.out.print(w.r1);
        System.out.print(", ");
        System.out.print(w.r2);
        System.out.print(", ");
        System.out.print(w.p);
        System.out.println("  ] ");

    }

    public gerenteDeMemoria() {
        todasPagi = new ArrayList<>();
        quantFrames = (VM.tamMem / VM.tamPagi);
        memoria = new boolean[quantFrames];
        status = true;
        for (int i = 0; i < memoria.length; i++) {
            memoria[i] = status;            
        }
    }

    public boolean alocacao(Word[] p, Word[] m, int tamProg, String ID) {
        nPagi = ((tamProg/VM.tamPagi)+1);
        int cont = 0;
        int posProg = 0;        
        for(int i=0; i<memoria.length; i++){
            if(memoria[i] == true){
                cont++;
            }
        }
        if(cont >= nPagi){                        
            cont = 0;
            todasPagi.add(new paginas(ID)); 
            for(int i=0; i<memoria.length; i++){
                if(memoria[i] == true){
                    cont++;
                    memoria[i] = false;
                    for(paginas it: todasPagi){
                        if(it.ID == ID){
                            it.addPagina(i);
                        }
                    }
                    for (int j=(i*VM.tamPagi); j<(i+1)*VM.tamPagi; j++) {
                        System.out.print(j+" ");
                        if(posProg < p.length){
                            m[j].opc = p[posProg].opc;
                            m[j].r1 = p[posProg].r1;
                            m[j].r2 = p[posProg].r2;
                            m[j].p = p[posProg].p;
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

    public static void desaloca(String ID){
        int posExcluir = 0;
        for(int i=0; i<todasPagi.size(); i++){
            if(todasPagi.get(i).ID == ID){
                posExcluir = i;
                List<Integer> pg = todasPagi.get(i).getLista();
                for(Integer p: pg){
                    for(int j=0; j<memoria.length; j++){
                        if(p == j){
                            memoria[j] = true;
                            for (int k=(j*VM.tamPagi); k<(j+1)*VM.tamPagi; k++) {
                                VM.m[k] = new Word(Opcode.___, -1, -1, -1);
                            }
                        }
                    }
                }
            }            
        }
        todasPagi.remove(posExcluir);
    }

    public void dump(Word[] m, int ini, int fim) {
        for (int i = ini; i < fim; i++) {
            System.out.print(i);
            System.out.print(":  ");
            dump(m[i]);
        }
    }
}

