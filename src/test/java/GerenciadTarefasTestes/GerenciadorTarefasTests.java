package GerenciadTarefasTestes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaController;

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

}
