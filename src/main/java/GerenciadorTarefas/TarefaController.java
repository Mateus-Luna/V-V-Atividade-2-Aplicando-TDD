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

}
