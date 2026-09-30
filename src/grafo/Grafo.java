package grafo;

import java.util.List;

public interface Grafo {
	
	int ordem();
	int tamanho();
	List<Integer> vertices();
	List<Integer> vizinhos(int j);
	int grau(int j);
	boolean temArestas(int i, int j);
	void inserirArestas(int i, int j);
	
}
