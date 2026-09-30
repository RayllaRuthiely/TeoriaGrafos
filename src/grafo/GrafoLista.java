package grafo;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class GrafoLista implements Grafo{
	
	//Atributos
	private int n;
	private int m;
	private Set<Integer>[] adj;
	
	//Construtor
	@SuppressWarnings("unchecked")
	public GrafoLista(int n) {
		this.n = n;
		this.m = 0;
		// Cria o array de referências para conjuntos
		this.adj = new HashSet[n];
		// Inicializa cada conjunto vazio para cada vértice
		for (int i = 0; i < n; i++) {
			this.adj[i] = new HashSet<>();
		}
	}
	
	@Override
	// Retorna a quantidade de vértices
	public int ordem() {
		return this.n;
	}
	@Override
	// Retorna a quantidade de arestas
	public int tamanho() {
		return this.m;
	}
	@Override
	// Retorna uma lista contendo todos os vértices de 0 a n-1
	public List<Integer> vertices() {
		List<Integer> listaVertices = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			listaVertices.add(i);
		}
		return listaVertices;
	}
	
	@Override
	// Retorna os vizinhos do vértice j convertidos para uma List<Integer>
	public List<Integer> vizinhos(int j) {
		// Como a interface pede List, transformamos o HashSet interno em ArrayList
		
		return new ArrayList<>(this.adj[j]);
	}
	
	@Override
	public int grau(int j) {
		// O tamanho do conjunto já indica o grau do vértice diretamente
		return this.adj[j].size();
	}
	
	@Override
	// Verifica se existe aresta entre i e j pesquisando no conjunto em O(1)
	public boolean temArestas(int i, int j) {
		return this.adj[i].contains(j);
	}

	@Override
	// Impede a criação de um laço e insere a aresta nas duas extremidades
	public void inserirArestas(int i, int j) {
		if (i == j) {
			throw new IllegalArgumentException("Laço não é permitido em grafo simples.");
		}
		// Se a aresta já existe no conjunto, ignora (evita duplicar)
		if (this.adj[i].contains(j)) {
			return;
		}
		this.adj[i].add(j); // Adiciona j na lista de i
		this.adj[j].add(i); // Adiciona i na lista de j (simetria)
		this.m++;
	}
}
