/*
serve para manter uma lista com todos os processos da vm
ao encerrar um processo, exlui ele da lista de processos
*/


import java.util.ArrayList;
import java.util.List;

public class processControlBlock {
    public static List<processo> TodosProcessos;
    
    //contrutor do process control block, cria uma lista vazia de processos
    public processControlBlock(){
        TodosProcessos = new ArrayList<>();
    }

    //ao receber um id de um processo que deve ser encerrado, exclui ele da lista de processos
    public static void encerraProcesso(int ID){
        int posExcluir = 0;
        for(int i=0; i<TodosProcessos.size(); i++){
            if(TodosProcessos.get(i).ID == ID){
                posExcluir = i;
            }            
        }
        processControlBlock.TodosProcessos.remove(posExcluir);
    }

}