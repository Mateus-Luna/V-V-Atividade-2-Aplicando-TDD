package GerenciadTarefasFunctionalTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import GerenciadorTarefas.Tarefa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;



public class AVLtests extends FunctionalTests {

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
    void nome1CaractereTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "E";
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
    void nomeTamanhoMaximoTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
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
    void nomeTamanhoMaximoMaisUmTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC";
        descr = "Escrever testes funcionais";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Nome da tarefa não pode ultrapassar 50 caracteres! ", e.getMessage());
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
    void descr1CaractereTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "E";
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
    void descrTamanhoMaximoTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais CCC";
        for (int i = 0; i < 7; i++) {
            descr += "CCCCCCCCCC";
        }
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
    void descrTamanhoMaximoMaisUmTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais CCC";
        for (int i = 0; i < 7; i++) {
            descr += "CCCCCCCCCC";
        }
        descr += "C";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Descrição da tarefa não pode ultrapassar 100 caracteres! ", e.getMessage());
        }
    }

    @Test
    void dataLimInferiorTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = dataAtual.format(formatter);
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
    void dataLimSuperiorTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        LocalDate dataAtual = LocalDate.now().plusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = dataAtual.format(formatter);
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
    void dataInvalidaTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "Exemplo inválido";
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Data de vencimento da tarefa não possui formato válido!", e.getMessage());
        }
    }

    @Test
    void prioridadeTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "00/00/0000";
        // Act:
        prioridade = "alta";
        driver.atualizarPrioridadeTarefa(nome, prioridade);
        // Assert:
        assertEquals(prioridade, driver.getTarefa(nome).getPrioridade());
        // Act:
        prioridade = "media";
        driver.atualizarPrioridadeTarefa(nome, prioridade);
        // Assert:
        assertEquals(prioridade, driver.getTarefa(nome).getPrioridade());
        // Act:
        prioridade = "baixa";
        driver.atualizarPrioridadeTarefa(nome, prioridade);
        // Assert:
        assertEquals(prioridade, driver.getTarefa(nome).getPrioridade());
    }
    
}
