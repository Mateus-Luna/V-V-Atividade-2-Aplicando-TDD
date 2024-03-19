package GerenciadorTarefas;

public class TarefaService {

    TarefaRepository tarefaRepository;

    public TarefaService() {
        tarefaRepository = new TarefaRepository();
    }

    public void criaTarefa(String nome, String descricao, String data, String prioridade) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome da tarefa não pode ser nulo ou vazio.");
        }
        Tarefa tarefa = new Tarefa(nome, descricao, data, prioridade);
        tarefaRepository.addTarefa(tarefa.getNome(), tarefa);
    }

    public Tarefa getTarefa(String nome) {
        return tarefaRepository.getTarefa(nome);
    }

    public void esvazia() {
        tarefaRepository.clearRepository();
    }

    public void atualizarNomeTarefa(String nome, String nomeAlterado) {
        tarefaRepository.atualizarNomeTarefa(nome, nomeAlterado);
    }

    public void atualizarDescrTarefa(String nome, String descrAlterado) {
        tarefaRepository.atualizarDescrTarefa(nome, descrAlterado);
    }

    public void atualizarDataTarefa(String nome, String dataAlterado) {
        tarefaRepository.atualizarDataTarefa(nome, dataAlterado);
    }

    public void atualizarPrioridadeTarefa(String nome, String prioridadeAlterada) {
        tarefaRepository.atualizarPrioridadeTrefa(nome, prioridadeAlterada);
    }

    public void excluirTarefa(String nome) {
        tarefaRepository.removeTarefa(nome);
    }

    public int contaTarefas() {
        return tarefaRepository.contaTarefas();
    }

    public String listarTarefas() {
        return tarefaRepository.listarTarefas();
    }

}
