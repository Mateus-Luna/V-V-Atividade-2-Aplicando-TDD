package GerenciadTarefasFunctionalTests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import GerenciadorTarefas.Tarefa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;



public class PEtests extends FunctionalTests {

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
    void nomeCompMinimoMenosUmTest() {
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
            assertEquals("Nome da tarefa não pode ser nulo!", e.getMessage());
        }
    }

    @Test
    void nomeComprimentoMinimoTest() {
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
    void nomeComprimentoMaximoTest() {
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
    void nomeComprimentoMaximoMaisUmTest() {
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
    void descrVazioTest() {
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
    void descrCompMinimoMenosUmTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
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
            assertEquals("Descrição da tarefa não pode ser nulo!", e.getMessage());
        }
    }

    @Test
    void descrComprimentoMinimoTest() {
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
    void descrComprimentoMaximoTest() {
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
    void descrComprimentoMaximoMaisUmTest() {
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
    void dataNoIntervaloTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        String data = "20/12/2024";
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
    void dataAbaixoMinimaTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        LocalDate dataAtual = LocalDate.now().minusDays(1);
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
    void dataMinimaTest() {
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
    void dataMaximaTest() {
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
    void dataAcimaMaximaTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        LocalDate dataAtual = LocalDate.now().plusYears(1).plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = dataAtual.format(formatter);
        prioridade = "alta";
        // Act:
        try {
            driver.criarTarefa(nome, descr, data, prioridade);
            fail("A exceção esperada não foi lançada");
        }
        // Assert:
        catch (IllegalArgumentException e) {
            assertEquals("Tempo de vencimento da tarefa não pode ultrapassar 1 ano!", e.getMessage());
        }
    }

}
