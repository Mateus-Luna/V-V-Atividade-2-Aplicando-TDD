package GerenciadTarefasFunctionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import GerenciadorTarefas.Tarefa;
import org.junit.jupiter.api.Test;


public class TDtests extends FunctionalTests {

    @Test
    void todosDadosValidosTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar V&V";
        descr = "Escrever testes funcionais";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
        Tarefa tarefa = driver.getTarefa(nome);
        assertEquals(nome, tarefa.getNome());
        assertEquals(descr, tarefa.getDescricao());
        assertEquals(data, tarefa.getData());
        assertEquals(prioridade, tarefa.getPrioridade());
    }

    @Test
    void nomeInvalidoTest() {
        /* AAA pattern */
        // Arrenge:
        nome = null;
        descr = "Escrever testes funcionais.";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Nome da tarefa não pode ser nula!", e.getMessage());
        }
    }

    @Test
    void descrInvalidaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar V&V";
        descr = null;
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Descrição da tarefa não pode ser nula!", e.getMessage());
        }
    }

    @Test
    void dataInvalidaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar V&V";
        descr = "Escrever testes funcionais";
        data = null;
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Data de vencimento da tarefa não pode ser nula!", e.getMessage());
        }
    }

    @Test
    void prioridadeInvalidaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar V&V";
        descr = "Escrever testes funcionais";
        data = "20/03/2024";
        prioridade = null;
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Prioridade da tarefa não pode ser nula!", e.getMessage());
        }
    }

    @Test
    void nomeValidoTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar V&V";
        descr = null;
        data = null;
        prioridade = null;
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Tarefa inválida!", e.getMessage());
        }
    }

    @Test
    void descrValidaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = null;
        descr = "Escrever testes funcionais";
        data = null;
        prioridade = null;
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Tarefa inválida!", e.getMessage());
        }
    }

    @Test
    void dataValidaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = null;
        descr = null;
        data = "20/03/2024";
        prioridade = null;
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Tarefa inválida!", e.getMessage());
        }
    }

    @Test
    void prioridadeValidaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = null;
        descr = null;
        data = null;
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Tarefa inválida!", e.getMessage());
        }
    }

    @Test
    void nomeVazioTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "";
        descr = "Escrever testes funcionais.";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Nome da tarefa não pode ser vazio!", e.getMessage());
        }
    }

    @Test
    void descrVaziaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Descrição da tarefa não pode ser vazio!", e.getMessage());
        }
    }

    @Test
    void dataVaziaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Data da tarefa não pode ser vazio!", e.getMessage());
        }
    }

    @Test
    void prioridadeVaziaTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "20/03/2024";
        prioridade = "";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Prioridade da tarefa não pode ser vazio!", e.getMessage());
        }
    }
    
}
