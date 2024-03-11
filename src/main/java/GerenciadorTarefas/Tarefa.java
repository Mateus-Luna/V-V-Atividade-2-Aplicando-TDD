package GerenciadorTarefas;

public class Tarefa {
    
    private String nome;
    private String descricao;
    private String data;
    private String prioridade;

    public Tarefa(String nome, String descricao, String data, String prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public String getPrioridade() {
        return prioridade;
    }

}
