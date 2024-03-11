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

    public void atualizarNomeTarefa(String nome, String nomeAlterado) {
        if (containsTarefa(nome)) {
            Tarefa tarefa = repository.get(nome);
            String descr = tarefa.getDescricao();
            String data = tarefa.getData();
            String prioridade = tarefa.getPrioridade();
            repository.remove(nome);
            tarefa = new Tarefa(nomeAlterado, descr, data, prioridade);
            repository.put(nomeAlterado, tarefa);
        }
    }

    public void atualizarDescrTarefa(String nome, String descrAlterado) {
        if (containsTarefa(nome)) {
            Tarefa tarefa = repository.get(nome);
            String data = tarefa.getData();
            String prioridade = tarefa.getPrioridade();
            repository.remove(nome);
            tarefa = new Tarefa(nome, descrAlterado, data, prioridade);
            repository.put(nome, tarefa);
        }
    }

    public void atualizarDataTarefa(String nome, String dataAlterado) {
        if (containsTarefa(nome)) {
            Tarefa tarefa = repository.get(nome);
            String descr = tarefa.getDescricao();
            String prioridade = tarefa.getPrioridade();
            repository.remove(nome);
            tarefa = new Tarefa(nome, descr, dataAlterado, prioridade);
            repository.put(nome, tarefa);
        }
    }

    public void atualizarPrioridadeTrefa(String nome, String prioridadeAlterada) {
        if (containsTarefa(nome)) {
            Tarefa tarefa = repository.get(nome);
            String descr = tarefa.getDescricao();
            String data = tarefa.getData();
            repository.remove(nome);
            tarefa = new Tarefa(nome, descr, data, prioridadeAlterada);
            repository.put(nome, tarefa);
        }
    }

    public int contaTarefas() {
        return repository.size();
    }

}
