package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leitura {
	
	// Classe auxiliar para agrupar o relatório exigido pelo padrão de resposta
    public static class RelatorioLeitura {
        public List<String[]> pares = new ArrayList<>();
        public int linhasTotais = 0;
        public int linhasIgnoradas = 0;
        public int lacosDescartados = 0;
    }

    public static RelatorioLeitura lerPares(String caminhoArquivo) throws IOException {
        RelatorioLeitura relatorio = new RelatorioLeitura();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                relatorio.linhasTotais++;
                linha = linha.trim();
                
                // Ignora linhas vazias ou que começam com comentário '#'
                if (linha.isEmpty() || linha.startsWith("#")) {
                    relatorio.linhasIgnoradas++;
                    continue;
                }
                
                // Divide a linha por espaços em branco (para pegar as duas colunas de vértices)
                String[] campos = linha.split("\\s+");
                if (campos.length < 2) {
                    relatorio.linhasIgnoradas++;
                    continue; 
                }
                
                String u = campos[0];
                String v = campos[1];
                
                // Descarta laços (vértice conectado a si mesmo) conforme o padrão de resposta
                if (u.equals(v)) {
                    relatorio.lacosDescartados++;
                    continue;
                }
                
                relatorio.pares.add(new String[]{u, v});
            }
        }
        return relatorio;
    }

    // Traduz cada rótulo original (String) em um índice de 0 a n-1
    public static Map<String, Integer> indexar(List<String[]> pares) {
        Map<String, Integer> mapaIndices = new HashMap<>();
        for (String[] par : pares) {
            for (String rotulo : par) {
                if (!mapaIndices.containsKey(rotulo)) {
                    // O tamanho atual do mapa define o próximo índice disponível (0, 1, 2...)
                    mapaIndices.put(rotulo, mapaIndices.size());
                }
            }
        }
        return mapaIndices;
    }
	
}
