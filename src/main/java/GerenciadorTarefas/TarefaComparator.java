package GerenciadorTarefas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TarefaComparator implements Comparator<Tarefa> {
    @Override
    public int compare(Tarefa t1, Tarefa t2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Convertendo as datas para o formato apropriado
            java.util.Date dataT1 = sdf.parse(t1.getData());
            java.util.Date dataT2 = sdf.parse(t2.getData());
            // Primeiro, comparamos as datas de vencimento
            int compareData = dataT1.compareTo(dataT2);
            if (compareData != 0) {
                return compareData;
            } else {
            // Se as datas forem iguais, comparamos as prioridades
                Map<String, Integer> prioridadeMap = new HashMap<>();
                prioridadeMap.put("baixa", 0);
                prioridadeMap.put("media", 1);
                prioridadeMap.put("alta", 2);
                
                int prioridadeT1 = prioridadeMap.get(t1.getPrioridade());
                int prioridadeT2 = prioridadeMap.get(t2.getPrioridade());
                
                return Integer.compare(prioridadeT1, prioridadeT2);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            // Se houver erro na conversão, retorna 0
            return 0;
        }

    }
}
    
