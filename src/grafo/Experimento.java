package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Experimento {
	
	public static void main(String[] args) {
        int n = 2000;
        long semente = 42; // Semente registrada no texto para reprodutibilidade
        double[] densidades = {0.001, 0.05, 0.5};

        System.out.println("=== INICIANDO EXPERIMENTO (ITENS 4 E 5) ===");
        System.out.println("Semente utilizada: " + semente);
        System.out.println("Aguarde, calculando tempos...\n");

        for (double delta : densidades) {
            System.out.println("--------------------------------------------------");
            System.out.println("Densidade configurada (Delta): " + delta);

            // 1. GERA A LISTA DE ARESTAS UMA ÚNICA VEZ (Garante o mesmo grafo para ambos)
            List<int[]> arestasGeradas = GeradorGrafos.gerarArestasAleatorias(n, delta, semente);
            int mMedido = arestasGeradas.size(); // O 'm' real medido exigido pelo padrão
            System.out.println("Quantidade de Arestas obtida (m medido): " + mMedido);

            // ==========================================
            // TESTE COM GRAFO MATRIZ
            // ==========================================
            Grafo gMatriz = new GrafoMatriz(n);
            for (int[] aresta : arestasGeradas) {
                gMatriz.inserirArestas(aresta[0], aresta[1]);
            }

            double tempoMatriz = medirMedianaTempo(gMatriz);
            long espacoMatriz = (long) n * n; // Fórmula do livro: n²

            System.out.printf("  [Matriz] Espaço: %d posições | Tempo Mediano: %.4f s\n", 
                    espacoMatriz, tempoMatriz);

            // ==========================================
            // TESTE COM GRAFO LISTA
            // ==========================================
            Grafo gLista = new GrafoLista(n);
            for (int[] aresta : arestasGeradas) {
                gLista.inserirArestas(aresta[0], aresta[1]);
            }

            double tempoLista = medirMedianaTempo(gLista);
            long espacoLista = n + (2L * mMedido); // Fórmula do livro: n + 2m

            System.out.printf("  [Lista]  Espaço: %d posições | Tempo Mediano: %.4f s\n", 
                    espacoLista, tempoLista);
        }
    }

    // Executa o algoritmo de contagem 3 vezes e retorna a mediana dos tempos
    private static double medirMedianaTempo(Grafo g) {
        List<Double> tempos = new ArrayList<>();

        for (int k = 0; k < 3; k++) {
            long inicio = System.nanoTime();
            ContarTriangulos.contar(g);
            long fim = System.nanoTime();
            
            // Converte a diferença de nanosegundos para segundos
            double tempoSegundos = (fim - inicio) / 1_000_000_000.0;
            tempos.add(tempoSegundos);
        }

        // Ordena a lista de 3 elementos e pega o do meio (índice 1), que é a mediana
        Collections.sort(tempos);
        return tempos.get(1);
    }
}
