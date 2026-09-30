package grafo;

import java.util.List;
import java.util.Map;

public class Construcao {
	
	public static class RelatorioConstrucao {
        public Grafo grafo;
        public int arestasRepetidas = 0;
    }

    // Interface funcional para podermos passar a classe desejada (GrafoLista ou GrafoMatriz)
    public interface FabricaGrafo {
        Grafo criar(int n);
    }

    public static RelatorioConstrucao construir(List<String[]> pares, Map<String, Integer> mapaIndices, FabricaGrafo fabrica) {
        RelatorioConstrucao resultado = new RelatorioConstrucao();
        
        // n é exatamente a quantidade de rótulos únicos mapeados
        int n = mapaIndices.size();
        resultado.grafo = fabrica.criar(n);
        
        int antes = resultado.grafo.tamanho();
        
        for (String[] par : pares) {
            int i = mapaIndices.get(par[0]);
            int j = mapaIndices.get(par[1]);
            
            // Realiza a inserção respeitando os nomes da sua interface
            resultado.grafo.inserirArestas(i, j);
            
            // Se o tamanho do grafo não mudou, significa que a aresta foi ignorada/repetida
            if (resultado.grafo.tamanho() == antes) {
                resultado.arestasRepetidas++;
            }
            antes = resultado.grafo.tamanho();
        }
        
        return resultado;
    }
	
}
