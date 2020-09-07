import java.util.ArrayList;
import java.util.List;

public class paginas {
    public String ID;
    public List<Integer> pagiProg = new ArrayList<>();

    public paginas(String ID){
        this.ID = ID;
    }

    public void addPagina(int p){
        this.pagiProg.add(p);        
    }

    public List<Integer> getLista(){
        return this.pagiProg;
    }

    @Override
    public String toString(){
        String id = this.ID+" ";
        String aux = "";
        for(Integer it: pagiProg){
            aux = aux+" "+it;
        }
        return id+aux;
    }
    
}
