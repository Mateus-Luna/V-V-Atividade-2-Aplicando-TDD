package GerenciadTarefasFunctionalTests;

import static org.junit.jupiter.api.Assertions.*;

import GerenciadorTarefas.TarefaController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class FunctionalTests {

    protected TarefaController driver;
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
    
}
