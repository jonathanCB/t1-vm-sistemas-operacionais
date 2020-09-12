/*
serve para criar processos com um id unico e com paginas de memoria.
as paginas servem tanto para armazenar o programa como para armazenar os dados do programa
*/

import java.util.ArrayList;
import java.util.List;

public class processo {
    public int ID;
    public List<Integer> pagiProg = new ArrayList<>();

    //cria um processo sem paginas com o id informado
    public processo(int ID){        
        this.ID = ID;
    }

    //adiciona paginas a um processo existente
    public void addPagina(int p){
        this.pagiProg.add(p);        
    }

    //retorna a lista de paginas de um processo
    public List<Integer> getLista(){
        return this.pagiProg;
    }

    //imprime o id od processo bem como as paginas do mesmo
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
