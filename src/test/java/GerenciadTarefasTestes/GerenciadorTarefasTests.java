package GerenciadTarefasTestes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaController;

public class GerenciadorTarefasTests {

    private TarefaController driver;

    String nome = "Estudar V&V";
    String descr = "Estudar TDD";
    String data = "06/03/2024";
    String prioridade = "alta";

    @BeforeEach
	void setUp() {
        driver = new TarefaController();
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
        driver.criarTarefa(nome, descr, data, prioridade);
        Tarefa tarefa = driver.getTarefa("Estudar V&V");
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
        driver.criarTarefa(nome, descr, data, prioridade);
        Tarefa tarefa = driver.getTarefa("Estudar V&V");
        assertEquals(nome, tarefa.getNome());
        assertEquals(descr, tarefa.getDescricao());
        assertEquals(data, tarefa.getData());
        assertEquals(prioridade, tarefa.getPrioridade());

        driver.criarTarefa(nome, descr, data, prioridade);
        driver.atualizarNomeTarefa(nome, nomeAlterado);
        driver.atualizarDecrTarefa(nomeAlterado, descrAlterado);
        driver.atualizarDataTarefa(nomeAlterado, dataAlterado);
        driver.atualizarPrioridadeTarefa(nomeAlterado, prioridadeAlterada);
        tarefa = driver.getTarefa(nomeAlterado);
        
        // Assert:
        assertEquals(nomeAlterado, tarefa.getNome());
        assertEquals(descrAlterado, tarefa.getDescricao());
        assertEquals(dataAlterado, tarefa.getData());
        assertEquals(prioridadeAlterada, tarefa.getPrioridade());
    }

}
