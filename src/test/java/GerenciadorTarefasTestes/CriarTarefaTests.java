package GerenciadorTarefasTestes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaController;

public class CriarTarefaTests {

    private TarefaController driver;

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
        String nome = "Estudar V&V";
        String descr = "Estudar TDD";
        String data = "06/03/2024";
        String prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        Tarefa tarefa = driver.getTarefa("Estudar V&V");
        // Assert:
        assertEquals(nome, tarefa.getNome());
        assertEquals(descr, tarefa.getDescricao());
        assertEquals(data, tarefa.getData());
        assertEquals(prioridade, tarefa.getPrioridade());
    }

}
