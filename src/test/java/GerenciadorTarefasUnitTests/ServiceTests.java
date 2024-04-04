package GerenciadorTarefasUnitTests;

import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTests {
    
    private TarefaService tarefaService;
    
    @BeforeEach
    public void setUp() {
        tarefaService = new TarefaService();
    }
    
    @Test
    public void testCriaTarefa() {
        tarefaService.criaTarefa("Tarefa 1", "Descrição da Tarefa 1", "2024-04-03", "Alta");
        Tarefa tarefa = tarefaService.getTarefa("Tarefa 1");
        assertNotNull(tarefa);
        assertEquals("Tarefa 1", tarefa.getNome());
    }
    
    @Test
    public void testCriaTarefaNomeNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            tarefaService.criaTarefa(null, "Descrição da Tarefa 1", "2024-04-03", "Alta");
        });
    }
    
    @Test
    public void testCriaTarefaNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            tarefaService.criaTarefa("", "Descrição da Tarefa 1", "2024-04-03", "Alta");
        });
    }
    
    @Test
    public void testGetTarefa() {
        tarefaService.criaTarefa("Tarefa 2", "Descrição da Tarefa 2", "2024-04-03", "Média");
        Tarefa tarefa = tarefaService.getTarefa("Tarefa 2");
        assertNotNull(tarefa);
        assertEquals("Tarefa 2", tarefa.getNome());
    }
    
    @Test
    public void testGetTarefaInexistente() {
        Tarefa tarefa = tarefaService.getTarefa("Tarefa Inexistente");
        assertNull(tarefa);
    }
    
    @Test
    public void testEsvazia() {
        tarefaService.criaTarefa("Tarefa 3", "Descrição da Tarefa 3", "2024-04-03", "Baixa");
        tarefaService.criaTarefa("Tarefa 4", "Descrição da Tarefa 4", "2024-04-03", "Baixa");
        tarefaService.esvazia();
        Tarefa tarefa1 = tarefaService.getTarefa("Tarefa 3");
        Tarefa tarefa2 = tarefaService.getTarefa("Tarefa 4");
        assertNull(tarefa1);
        assertNull(tarefa2);
    }

    @Test
    void testAtualizarNomeTarefa() {
        tarefaService.criaTarefa("Tarefa 5", "Descrição da Tarefa 5", "2024-04-03", "Baixa");
        String nome = "Tarefa 5";
        String novoNome = "Tarefa 5.5";
        Tarefa tarefa = tarefaService.getTarefa("Tarefa 5");
        assertEquals("Tarefa 5", tarefa.getNome());
        tarefaService.atualizarNomeTarefa(nome, novoNome);
        tarefa = tarefaService.getTarefa("Tarefa 5.5");
        assertEquals("Tarefa 5.5", tarefa.getNome());
    }

    @Test
    void testAtualizarDescrTarefa() {
        tarefaService.criaTarefa("Tarefa 6", "Descrição da Tarefa 6", "2024-04-03", "Baixa");
        String descr = "Descrição da Tarefa 6";
        String novaDescr = "Descrição da Tarefa 6.5";
        Tarefa tarefa = tarefaService.getTarefa("Tarefa 6");
        assertEquals(descr, tarefa.getDescricao());
        tarefaService.atualizarDescrTarefa("Tarefa 6", novaDescr);
        tarefa = tarefaService.getTarefa("Tarefa 6");
        assertEquals(novaDescr, tarefa.getDescricao());
    }

    @Test
    void testAtualizarDataTarefa() {
        tarefaService.criaTarefa("Tarefa 7", "Descrição da Tarefa 7", "2024-04-03", "Baixa");
        String data = "2024-04-03";
        String newData = "2024-05-03";
        Tarefa tarefa = tarefaService.getTarefa("Tarefa 7");
        assertEquals(data, tarefa.getData());
        tarefaService.atualizarDataTarefa("Tarefa 7", newData);
        tarefa = tarefaService.getTarefa("Tarefa 7");
        assertEquals(newData, tarefa.getData());
    }

    @Test
    void testAtualizarPrioridadeTarefa() {
        tarefaService.criaTarefa("Tarefa 8", "Descrição da Tarefa 8", "2024-04-03", "baixa");
        String p1 = "baixa";
        String p2 = "media";
        Tarefa tarefa = tarefaService.getTarefa("Tarefa 8");
        assertEquals(p1, tarefa.getPrioridade());
        tarefaService.atualizarPrioridadeTarefa("Tarefa 8", p2);
        tarefa = tarefaService.getTarefa("Tarefa 8");
        assertEquals(p2, tarefa.getPrioridade());
    }

    @Test
    void testExcluirTarefa() {
        // Teste para exclusão de uma tarefa existente
        tarefaService.criaTarefa("Tarefa 2", "Descrição da Tarefa 2", "2024-04-03", "alta");
        tarefaService.excluirTarefa("Tarefa 2");
        assertEquals(0, tarefaService.contaTarefas());
    }

    @Test
    void testContaTarefas() {
        // Teste para contar o número de tarefas
        tarefaService.criaTarefa("Tarefa 3", "Descrição da Tarefa 3", "2024-04-03", "media");
        tarefaService.criaTarefa("Tarefa 4", "Descrição da Tarefa 4", "2024-04-03", "alta");
        assertEquals(2, tarefaService.contaTarefas());
    }

    @Test
    void testListarTarefas() {
        // Teste para listar as tarefas cadastradas
        tarefaService.criaTarefa("Tarefa 5", "Descrição da Tarefa 5", "2024-04-03", "baixa");
        tarefaService.criaTarefa("Tarefa 6", "Descrição da Tarefa 6", "2024-04-03", "media");
        String expected = "";
        expected += "Tarefas:\n---\nNome: Tarefa 5\nDescrição: Descrição da Tarefa 5\nData: 2024-04-03\nPrioridade: baixa\n---\nNome: Tarefa 6\nDescrição: Descrição da Tarefa 6\nData: 2024-04-03\nPrioridade: media\n---";
        assertEquals(expected, tarefaService.listarTarefas());
    }

}
