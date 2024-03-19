package GerenciadTarefasFunctionalTests;

import org.junit.jupiter.api.Test;

public class AVLtests extends FunctionalTests {

    @Test
    void nomeVazioTest() {
        /* AAA pattern */
        // Arrenge:
        nome = null;
        descr = "Escrever testes funcionais.";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
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
    }

    @Test
    void nomeTamanhoMaximoTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV CCCCCCCCCCCCCC";
        descr = "Escrever testes funcionais";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
    }

    @Test
    void nomeTamanhoMaximoMaisUmTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV CCCCCCCCCCCCCCC";
        descr = "Escrever testes funcionais";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
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
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
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
    }

    @Test
    void descrTamanhoMaximoTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais CCCCCCCCCCCC";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
    }

    @Test
    void descrTamanhoMaximoMaisUmTest() {
        /* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais CCCCCCCCCCCCC";
        data = "20/03/2024";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
    }

    @Test
    void dataLimInferiorTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "00/00/0000";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
    }

    @Test
    void dataLimSuperiorTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "00/00/0000";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
    }

    @Test
    void dataInvalidaTest() {
        //* AAA pattern */
        // Arrenge:
        nome = "Estudar VeV";
        descr = "Escrever testes funcionais";
        data = "00/00/0000";
        prioridade = "alta";
        // Act:
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
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
        driver.criarTarefa(nome, descr, data, prioridade);
        prioridade = "media";
        driver.criarTarefa(nome, descr, data, prioridade);
        prioridade = "baixa";
        driver.criarTarefa(nome, descr, data, prioridade);
        // Assert:
    }
    
}
