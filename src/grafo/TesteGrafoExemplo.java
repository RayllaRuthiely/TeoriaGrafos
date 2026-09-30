package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TesteGrafoExemplo {

	public static void main(String[] args) {
		
		System.out.println("=== INICIANDO TESTES DO ITEM 2 ===\n");
		
		// 1. Criando as duas instâncias com n = 5 vértices (0 a 4)
        Grafo gMatriz = new GrafoMatriz(5);
        Grafo gLista = new GrafoLista(5);
        
     // Definindo as arestas com base na Figura 3.1 (ajustadas para começar do índice 0)
        // Feito (1-based): {v1,v2}, {v1,v3}, {v2,v3}, {v2,v4}, {v3,v5}, {v4,v5}
        // No Java (0-based):  {0,1},   {0,2},   {1,2},   {1,3},   {2,4},   {3,4}
        int[][] arestasExemplo = {
            {0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 4}, {3, 4}
        };
        
     // Populando ambos os grafos
        for (int[] aresta : arestasExemplo) {
            gMatriz.inserirArestas(aresta[0], aresta[1]);
            gLista.inserirArestas(aresta[0], aresta[1]);
        }
        
     // 2. Executando as validações para a Matriz
        System.out.println("--- Testando GrafoMatriz ---");
        validarGrafo(gMatriz);

        System.out.println("\n--- Testando GrafoLista ---");
        validarGrafo(gLista);
        
        // Teste extra aproveitando o Passo 5
        System.out.println("\n--- Teste de Triângulos ---");
        System.out.println("Triângulos na Matriz: " + ContarTriangulos.contar(gMatriz));
        System.out.println("Triângulos na Lista: " + ContarTriangulos.contar(gLista));
}
        
        private static void validarGrafo(Grafo g) {
            // Validação 1 e 2: Ordem e Tamanho
            int n = g.ordem();
            int m = g.tamanho();
            System.out.println("Ordem (n = 5): " + n + " -> " + (n == 5 ? "OK" : "ERRO"));
            System.out.println("Tamanho (m = 6): " + m + " -> " + (m == 6 ? "OK" : "ERRO"));

            // Validação 3: Sequência de graus (3, 3, 2, 2, 2)
            // Nota: a ordem exata depende de qual vértice tem qual grau. 
            // Vértices 0 e 1 têm grau 3; 2, 3 e 4 têm grau 2 no nosso mapeamento.
            List<Integer> grausObtidos = new ArrayList<>();
            int somaGraus = 0;
            for (int v : g.vertices()) {
                int grauV = g.grau(v);
                grausObtidos.add(grauV);
                somaGraus += grauV;
            }
            
            // Vamos ordenar em ordem decrescente para comparar com o enunciado (3,3,2,2,2)
            grausObtidos.sort((a, b) -> b - a);
            List<Integer> sequenciaEsperada = Arrays.asList(3, 3, 2, 2, 2);
            
            System.out.println("Sequência de graus esperada: " + sequenciaEsperada);
            System.out.println("Sequência de graus obtida:   " + grausObtidos);
            System.out.println("Validação da sequência: " + (grausObtidos.equals(sequenciaEsperada) ? "OK" : "ERRO"));

            // Validação 4: Lema do aperto de mão (Soma dos graus == 2m)
            System.out.println("Soma dos graus: " + somaGraus);
            System.out.println("Valor de 2m: " + (2 * m));
            System.out.println("Lema do aperto de mão: " + (somaGraus == 2 * m ? "OK" : "ERRO"));
   }
}
