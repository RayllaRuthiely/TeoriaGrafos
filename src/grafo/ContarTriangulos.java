package grafo;

public class ContarTriangulos {
	
	public static int contar(Grafo g) {
		int total = 0;
		
		// Loop 1: passa por todos os vértices do grafo
		for(int i: g.vertices()) {
			
			 // Loop 2: passa por todos os vizinhos do vértice i(linha)
			for(int j: g.vizinhos(i)) {
				// Filtro para garantir ordem e contar cada par uma única vez
				if(j <= i) {
					continue;
				}
				// Loop 3: passa por todos os vizinhos do vértice j(coluna)
				for(int z: g.vizinhos(j)) {
					if(z <= j) {
						continue;
					}
					// Se o vértice inicial 'i' também for vizinho de 'z', fechamos um triângulo!
					if(g.temArestas(i, z)) {
						total++;
					}
				}
			}
		}
		return total;
	}
}
