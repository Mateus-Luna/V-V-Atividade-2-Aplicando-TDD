package GerenciadorTarefas;

public class TarefaService {

    TarefaRepository tarefaRepository;

    public TarefaService() {
        tarefaRepository = new TarefaRepository();
    }

    public void criaTarefa(Tarefa tarefa) {
        tarefaRepository.addTarefa(tarefa.getNome(), tarefa);
    }

    public Tarefa getTarefa(String nome) {
        return tarefaRepository.getTarefa(nome);
    }

    public void esvazia() {
        tarefaRepository.clearRepository();
    }

}
