package GerenciadorTarefas;

public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController() {
        tarefaService = new TarefaService();
    }

    public void criarTarefa(String nome, String descricao, String data, String prioridade) {
        Tarefa tarefa = new Tarefa(nome, descricao, data, prioridade);
        tarefaService.criaTarefa(tarefa);
    }

    public Tarefa getTarefa(String nome) {
        return tarefaService.getTarefa(nome);
    }

    public void esvazia() {
        tarefaService.esvazia();
    }

    public void atualizarNomeTarefa(String nome, String nomeAlterado) {
        tarefaService.atualizarNomeTarefa(nome, nomeAlterado);
    }

    public void atualizarDecrTarefa(String nome, String descrAlterado) {
        tarefaService.atualizarDescrTarefa(nome, descrAlterado);
    }

    public void atualizarDataTarefa(String nome, String dataAlterado) {
        tarefaService.atualizarDataTarefa(nome, dataAlterado);
    }

    public void atualizarPrioridadeTarefa(String nome, String prioridadeAlterada) {
        tarefaService.atualizarPrioridadeTarefa(nome, prioridadeAlterada);
    }

}
