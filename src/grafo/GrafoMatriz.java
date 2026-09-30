package grafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatriz implements Grafo {
	
	//Atributos
	private int n;
	private int m;
	private int[][] matriz;
	
	//Construtor
	public GrafoMatriz(int n) {
		this.n = n;
		this.m = 0;
		this.matriz = new int[n][n];
	}

	@Override
	//Retorna a quantidade de vertices
	public int ordem() {
		return this.n;
	}

	@Override
	//Retorna a quantidade de arestas
	public int tamanho() {
		return this.m;
	}

	@Override
	// Retorna uma lista contendo todos os vértices de 0 a n-1
	public List<Integer> vertices() {
		List<Integer> listaVertices = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			listaVertices.add(i);
		}
		
		return listaVertices;
	}

	@Override
	// Percorre a linha (i) e adiciona na lista todas as colunas (j) que possuem aresta (== 1)
	public List<Integer> vizinhos(int j) {
		List<Integer> listaVizinhos = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(this.matriz[j][i] == 1) {
				listaVizinhos.add(i);
			}
		}
		return listaVizinhos;
	}

	@Override
	// O grau é a quantidade de vizinhos que o vértice possui
	public int grau(int j) {
		return vizinhos(j).size();
	}

	@Override
	//Olha na linha i e coluna j da sua matriz. 
	//Se for igual a 1, significa que os vértices estão conectados (retorna true). 
	//Se for 0, não estão (retorna false).
	public boolean temArestas(int i, int j) {
		return this.matriz[i][j] == 1;
	}

	@Override
	// Impede a criação de um laço e insere a aresta de forma simétrica
	public void inserirArestas(int i, int j) {
		if(i == j) {
			throw new IllegalArgumentException("Laço não é permitido em grafo simples.");
		}
		//Se a aresta já existe (==1), não faz nada (evita duplicar)
		if(this.matriz[i][j] == 1) {
			return;
		}
		this.matriz[i][j] = 1;
		this.matriz[j][i] = 1;
		this.m++;
		
	}

}
