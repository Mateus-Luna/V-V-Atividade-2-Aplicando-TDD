package GerenciadorTarefas;

import java.util.HashMap;
import java.util.Map;

public class TarefaRepository {

    Map<String, Tarefa> repository;

    public TarefaRepository() {
        repository = new HashMap<>();
    }

    public void addTarefa(String id, Tarefa tarefa) {
        repository.put(id, tarefa);
    }
    
    public Tarefa getTarefa(String id) {
        return repository.get(id);
    }
    
    public Tarefa removeTarefa(String id) {
        return repository.remove(id);
    }
    
    public boolean containsTarefa(String id) {
        return repository.containsKey(id);
    }

    public void clearRepository() {
        repository.clear();
    }

    public void esvazia() {
    }

}
