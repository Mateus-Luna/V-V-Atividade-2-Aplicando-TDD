package GerenciadTarefasTestes;

import static org.junit.jupiter.api.Assertions.*;
import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GerenciadorTarefasTests {

    private TarefaController driver;
    String nome;
    String descr;
    String data;
    String prioridade;
    
    @BeforeEach
	void setUp() {
        driver = new TarefaController();
        nome = "Estudar V&V";
        descr = "Estudar TDD";
        data = "06/03/2024";
        prioridade = "alta";
        driver.criarTarefa(nome, descr, data, prioridade);
    }

    @AfterEach
    void tearDown() {
        driver.esvazia();
    }

    @Test
    void CriarTarefaTest() {
        /* AAA pattern */
        // Arrenge:
        // Act:
        Tarefa tarefa = driver.getTarefa(nome);
        // Assert:
        assertEquals(nome, tarefa.getNome());
        assertEquals(descr, tarefa.getDescricao());
        assertEquals(data, tarefa.getData());
        assertEquals(prioridade, tarefa.getPrioridade());
    }

    @Test
    void AtualizarTarefaTest() {
        /* AAA pattern */
        // Arrenge:
        String nomeAlterado = "Estudar V&V Alterado";
        String descrAlterado = "Estudar TDD Alterado";
        String dataAlterado = "05/03/2024";
        String prioridadeAlterada = "media";

        // Act:
        driver.atualizarNomeTarefa(nome, nomeAlterado);
        driver.atualizarDecrTarefa(nomeAlterado, descrAlterado);
        driver.atualizarDataTarefa(nomeAlterado, dataAlterado);
        driver.atualizarPrioridadeTarefa(nomeAlterado, prioridadeAlterada);
        Tarefa tarefa = driver.getTarefa(nomeAlterado);
        
        // Assert:
        assertEquals(nomeAlterado, tarefa.getNome());
        assertEquals(descrAlterado, tarefa.getDescricao());
        assertEquals(dataAlterado, tarefa.getData());
        assertEquals(prioridadeAlterada, tarefa.getPrioridade());
    }

    void excluirTarefaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Praticar TDD";
        descr = "Excluir as tarefas do gerenciador de tarefas";
        data = "06/03/2024";
        prioridade = "baixa";
        // Act:
        int cont = driver.contaTarefas();
        // Assert:
        assertEquals(cont, 1);
        driver.criarTarefa(nome, descr, data, prioridade);
        cont = driver.contaTarefas();
        assertEquals(cont, 2);
        driver.excluirTarefa("Praticar TDD");
        cont = driver.contaTarefas();
        assertEquals(cont, 1);
    }

    @Test
    void listarTarefasTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Prova de Programação Concorrente";
        descr = "Estudar o leite de Manoel";
        data = "03/03/2024";
        prioridade = "baixa";
        driver.criarTarefa(nome, descr, data, prioridade);
        nome = "Prova de Redes de Computadores";
        descr = "Revisar anotações de Marcela";
        data = "06/03/2024";
        prioridade = "media";
        driver.criarTarefa(nome, descr, data, prioridade);
        nome = "Ensinar Rebeca";
        descr = "Ajudar a menina com tarefas de casa e revisar para provas";
        data = "11/03/2024";
        prioridade = "baixa";
        driver.criarTarefa(nome, descr, data, prioridade);
        nome = "Desafio I da codex";
        descr = "Preparar site em wordpress com Vimerson";
        data = "10/03/2024";
        prioridade = "alta";
        driver.criarTarefa(nome, descr, data, prioridade);
        nome = "Trabalho de Metodologia Científica";
        descr = "Preparar os slides que serão apresentados em sala de aula";
        data = "10/03/2024";
        prioridade = "baixa";
        driver.criarTarefa(nome, descr, data, prioridade);
        // Texto:
        String provapc =
        "Nome: Prova de Programação Concorrente" + "\n" +
        "Descrição: Estudar o leite de Manoel" + "\n" +
        "Data: 03/03/2024" + "\n" +
        "Prioridade: baixa";
        String provarc =
        "Nome: Prova de Redes de Computadores" + "\n" +
        "Descrição: Revisar anotações de Marcela" + "\n" +
        "Data: 06/03/2024" + "\n" +
        "Prioridade: media";
        String rebeca =
        "Nome: Ensinar Rebeca" + "\n" +
        "Descrição: Ajudar a menina com tarefas de casa e revisar para provas" + "\n" +
        "Data: 11/03/2024" + "\n" +
        "Prioridade: baixa";
        String vev =
        "Nome: Estudar V&V" + "\n" +
        "Descrição: Estudar TDD" + "\n" +
        "Data: 06/03/2024" + "\n" +
        "Prioridade: alta";
        String codex =
        "Nome: Desafio I da codex" + "\n" +
        "Descrição: Preparar site em wordpress com Vimerson" + "\n" +
        "Data: 10/03/2024" + "\n" +
        "Prioridade: alta";
        String metodoc =
        "Nome: Trabalho de Metodologia Científica" + "\n" +
        "Descrição: Preparar os slides que serão apresentados em sala de aula" + "\n" +
        "Data: 10/03/2024" + "\n" +
        "Prioridade: baixa";
        String total =
        "Tarefas:" + "\n" +
        "---" + "\n" +
        provapc + "\n" +
        "---" + "\n" +
        provarc + "\n" +
        "---" + "\n" +
        vev + "\n" +
        "---" + "\n" +
        metodoc + "\n" +
        "---" + "\n" +
        codex + "\n" +
        "---" + "\n" +
        rebeca + "\n" +
        "---";
        // Act:
        String listarTarefas = driver.listarTarefas();
        // Assert:
        assertEquals(listarTarefas, total);
    }

}
