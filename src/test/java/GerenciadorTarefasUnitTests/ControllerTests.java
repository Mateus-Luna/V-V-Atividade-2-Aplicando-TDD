package GerenciadorTarefasUnitTests;

import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class ControllerTests {
    
    private TarefaController tarefaController;

    @BeforeEach
    public void setUp() {
        tarefaController = new TarefaController();
    }

    @AfterEach
    public void tearDown() {
        tarefaController.esvazia(); // Limpa os dados após cada teste
    }

    @Test
    public void testCriarTarefa() {
        // Teste para verificar se uma tarefa é criada corretamente
        tarefaController.criarTarefa("Tarefa 1", "Descrição da Tarefa 1", "2024-04-03", "Alta");
        assertNotNull(tarefaController.getTarefa("Tarefa 1"));
    }

    @Test
    public void testGetTarefa() {
        // Teste para verificar se uma tarefa pode ser obtida corretamente
        tarefaController.criarTarefa("Tarefa 2", "Descrição da Tarefa 2", "2024-04-04", "Baixa");
        Tarefa tarefa = tarefaController.getTarefa("Tarefa 2");
        assertNotNull(tarefa);
        assertEquals("Tarefa 2", tarefa.getNome());
    }

    @Test
    public void testEsvazia() {
        // Teste para verificar se o método esvazia limpa corretamente a lista de tarefas
        tarefaController.criarTarefa("Tarefa 3", "Descrição da Tarefa 3", "2024-04-05", "Média");
        tarefaController.esvazia();
        assertNull(tarefaController.getTarefa("Tarefa 3"));
    }

    @Test
    public void testAtualizarNomeTarefa() {
        tarefaController.criarTarefa("Tarefa 5", "Descrição da Tarefa 5", "2024-04-03", "Baixa");
        String nome = "Tarefa 5";
        String novoNome = "Tarefa 5.5";
        Tarefa tarefa = tarefaController.getTarefa("Tarefa 5");
        assertEquals("Tarefa 5", tarefa.getNome());
        tarefaController.atualizarNomeTarefa(nome, novoNome);
        tarefa = tarefaController.getTarefa("Tarefa 5.5");
        assertEquals("Tarefa 5.5", tarefa.getNome());
    }

    @Test
    public void testAtualizarDecrTarefa() {
        tarefaController.criarTarefa("Tarefa 6", "Descrição da Tarefa 6", "2024-04-03", "Baixa");
        String descr = "Descrição da Tarefa 6";
        String novaDescr = "Descrição da Tarefa 6.5";
        Tarefa tarefa = tarefaController.getTarefa("Tarefa 6");
        assertEquals(descr, tarefa.getDescricao());
        tarefaController.atualizarDecrTarefa("Tarefa 6", novaDescr);
        tarefa = tarefaController.getTarefa("Tarefa 6");
        assertEquals(novaDescr, tarefa.getDescricao());
    }

    @Test
    public void testAtualizarDataTarefa() {
        tarefaController.criarTarefa("Tarefa 7", "Descrição da Tarefa 7", "2024-04-03", "Baixa");
        String data = "2024-04-03";
        String newData = "2024-05-03";
        Tarefa tarefa = tarefaController.getTarefa("Tarefa 7");
        assertEquals(data, tarefa.getData());
        tarefaController.atualizarDataTarefa("Tarefa 7", newData);
        tarefa = tarefaController.getTarefa("Tarefa 7");
        assertEquals(newData, tarefa.getData());
    }

    @Test
    public void testAtualizarPrioridadeTarefa() {
        tarefaController.criarTarefa("Tarefa 8", "Descrição da Tarefa 8", "2024-04-03", "baixa");
        String p1 = "baixa";
        String p2 = "media";
        Tarefa tarefa = tarefaController.getTarefa("Tarefa 8");
        assertEquals(p1, tarefa.getPrioridade());
        tarefaController.atualizarPrioridadeTarefa("Tarefa 8", p2);
        tarefa = tarefaController.getTarefa("Tarefa 8");
        assertEquals(p2, tarefa.getPrioridade());
    }

    @Test
    void testExcluirTarefa() {
        assertEquals(0, tarefaController.contaTarefas());
        // Teste para exclusão de uma tarefa existente
        tarefaController.criarTarefa("Tarefa 2", "Descrição da Tarefa 2", "2024-04-03", "alta");
        assertEquals(1, tarefaController.contaTarefas());
        tarefaController.excluirTarefa("Tarefa 2");
        assertEquals(0, tarefaController.contaTarefas());
    }

    @Test
    void testContaTarefas() {
        // Teste para contar o número de tarefas
        tarefaController.criarTarefa("Tarefa 3", "Descrição da Tarefa 3", "2024-04-03", "media");
        tarefaController.criarTarefa("Tarefa 4", "Descrição da Tarefa 4", "2024-04-03", "alta");
        assertEquals(2, tarefaController.contaTarefas());
    }

    @Test
    void testListarTarefas() {
        // Teste para listar as tarefas cadastradas
        tarefaController.criarTarefa("Tarefa 5", "Descrição da Tarefa 5", "2024-04-03", "baixa");
        tarefaController.criarTarefa("Tarefa 6", "Descrição da Tarefa 6", "2024-04-03", "media");
        String expected = "";
        expected += "Tarefas:\n---\nNome: Tarefa 5\nDescrição: Descrição da Tarefa 5\nData: 2024-04-03\nPrioridade: baixa\n---\nNome: Tarefa 6\nDescrição: Descrição da Tarefa 6\nData: 2024-04-03\nPrioridade: media\n---";
        assertEquals(expected, tarefaController.listarTarefas());
    }

}
