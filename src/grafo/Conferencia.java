package grafo;

import java.util.HashMap;
import java.util.Map;

public class Conferencia {
	
	public static Map<String, Object> conferir(Grafo g) {
        int n = g.ordem();
        int m = g.tamanho();
        
        int somaGraus = 0;
        int isolados = 0;
        
        for (int i : g.vertices()) {
            int grauV = g.grau(i);
            somaGraus += grauV;
            if (grauV == 0) {
                isolados++;
            }
        }
        
        // Fórmula para o máximo de arestas: n * (n - 1) / 2
        long maximoArestas = (long) n * (n - 1) / 2;
        double densidade = maximoArestas > 0 ? (double) m / maximoArestas : 0.0;
        
        // Lema do aperto de mão: soma dos graus deve ser exatamente o dobro de arestas
        boolean apertoDeMaoValido = (somaGraus == 2 * m);
        
        Map<String, Object> analise = new HashMap<>();
        analise.put("n", n);
        analise.put("m", m);
        analise.put("soma_graus", somaGraus);
        analise.put("aperto_de_mao", apertoDeMaoValido);
        analise.put("isolados", isolados);
        analise.put("densidade", densidade);
        
        return analise;
    }
	
}
