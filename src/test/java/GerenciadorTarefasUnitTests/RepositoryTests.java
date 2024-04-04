package GerenciadorTarefasUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import GerenciadorTarefas.Tarefa;
import GerenciadorTarefas.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class RepositoryTests {

    private TarefaRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new TarefaRepository();
    }

    @Test
    public void testAddTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa", "Descrição", "04/04/2024", "alta");
        repository.addTarefa("1", tarefa);
        assertTrue(repository.containsTarefa("1"));
        assertEquals(tarefa, repository.getTarefa("1"));
    }

    @Test
    public void testGetTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa", "Descrição", "04/04/2024", "alta");
        repository.addTarefa("1", tarefa);
        assertEquals(tarefa, repository.getTarefa("1"));
    }

    @Test
    public void testRemoveTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa", "Descrição", "04/04/2024", "alta");
        repository.addTarefa("1", tarefa);
        assertEquals(tarefa, repository.removeTarefa("1"));
        assertFalse(repository.containsTarefa("1"));
    }

    @Test
    public void testContainsTarefa() {
        Tarefa tarefa = new Tarefa("Tarefa", "Descrição", "04/04/2024", "alta");
        repository.addTarefa("1", tarefa);
        assertTrue(repository.containsTarefa("1"));
        assertFalse(repository.containsTarefa("2"));
    }

    @Test
    public void testClearRepository() {
        Tarefa tarefa = new Tarefa("Tarefa", "Descrição", "04/04/2024", "alta");
        repository.addTarefa("1", tarefa);
        repository.clearRepository();
        assertFalse(repository.containsTarefa("1"));
        assertNull(repository.getTarefa("1"));
    }

    @Test
    public void testAtualizarNomeTarefa() {
        repository.addTarefa("tarefa1", new Tarefa("tarefa1", "descricao1", "01/01/2024", "alta"));
        
        repository.atualizarNomeTarefa("tarefa1", "novaTarefa");
        
        assertTrue(repository.containsTarefa("novaTarefa"));
        assertFalse(repository.containsTarefa("tarefa1"));
    }

    @Test
    public void testAtualizarDescrTarefa() {
        repository.addTarefa("tarefa1", new Tarefa("tarefa1", "descricao1", "01/01/2024", "alta"));
        
        repository.atualizarDescrTarefa("tarefa1", "novaDescricao");
        
        Tarefa tarefaAtualizada = repository.getTarefa("tarefa1");
        assertEquals("novaDescricao", tarefaAtualizada.getDescricao());
    }

    @Test
    public void testAtualizarDataTarefa() {
        repository.addTarefa("tarefa1", new Tarefa("tarefa1", "descricao1", "01/01/2024", "alta"));
        
        repository.atualizarDataTarefa("tarefa1", "02/02/2024");
        
        Tarefa tarefaAtualizada = repository.getTarefa("tarefa1");
        assertEquals("02/02/2024", tarefaAtualizada.getData());
    }

    @Test
    public void testAtualizarPrioridadeTarefa() {
        repository.addTarefa("tarefa1", new Tarefa("tarefa1", "descricao1", "01/01/2024", "alta"));
        
        repository.atualizarPrioridadeTarefa("tarefa1", "baixa");
        
        Tarefa tarefaAtualizada = repository.getTarefa("tarefa1");
        assertEquals("baixa", tarefaAtualizada.getPrioridade());
    }

    @Test
    void testContarTarefas() {
        // Teste para contar o número de tarefas
        assertEquals(0, repository.contaTarefas());
        repository.addTarefa("Tarefa 1", new Tarefa("Tarefa 1", "Descrição da Tarefa 1", "2024-04-03", "baixa"));
        assertEquals(1, repository.contaTarefas());
    }

    @Test
    void testListarTarefas() {
        // Teste para listar as tarefas cadastradas
        repository.addTarefa("Tarefa 1", new Tarefa("Tarefa 1", "Descrição da Tarefa 1", "2024-04-03", "baixa"));
        repository.addTarefa("Tarefa 2", new Tarefa("Tarefa 2", "Descrição da Tarefa 2", "2024-04-03", "media"));
        String expected = "Tarefas:\n---\nNome: Tarefa 1\nDescrição: Descrição da Tarefa 1\nData: 2024-04-03\nPrioridade: baixa\n---\nNome: Tarefa 2\nDescrição: Descrição da Tarefa 2\nData: 2024-04-03\nPrioridade: media\n---";
        assertEquals(expected, repository.listarTarefas());
    }
}
