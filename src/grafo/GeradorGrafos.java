package grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorGrafos {
	/**
     * Gera a lista de arestas uma única vez usando a probabilidade delta.
     * Atende à exigência: "gerar a lista de pares uma vez e alimentar as duas estruturas".
     */
    public static List<int[]> gerarArestasAleatorias(int n, double densidade, long semente) {
        List<int[]> arestas = new ArrayList<>();
        Random rand = new Random(semente);
        
        // Percorre estritamente i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rand.nextDouble() < densidade) {
                    arestas.add(new int[]{i, j}); // Guarda o par gerado
                }
            }
        }
        return arestas;
    }
}
