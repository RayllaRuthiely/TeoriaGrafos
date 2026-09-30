package grafo;

import java.io.IOException;
import java.util.Map;

public class MainReal {

	public static void main(String[] args) {
		
		// Substitua pelo caminho real do arquivo no seu computador
        String caminhoArquivo = "dados/CollegeMsg.txt"; 

        System.out.println("=== EXECUÇÃO DO ITEM 7: CONJUNTO DE DADOS PÚBLICO ===");
        
        try {
            // 1. Executa lerPares
            Leitura.RelatorioLeitura relatorioL = Leitura.lerPares(caminhoArquivo);
            
            // 2. Executa indexar (Mapeamento de rótulos distintos)
            Map<String, Integer> mapaIndices = Leitura.indexar(relatorioL.pares);
            int totalRotulosDistintos = mapaIndices.size();

            // 3. Executa construir utilizando a implementação GrafoLista
            Construcao.RelatorioConstrucao relatorioC = Construcao.construir(
                relatorioL.pares, 
                mapaIndices, 
                n -> new GrafoLista(n)
            );

            // 4. Executa conferir
            Map<String, Object> relatorioConf = Conferencia.conferir(relatorioC.grafo);

            // EXTRAÇÃO DE MÉTRICAS EXIGIDAS NO PADRÃO DE RESPOSTA
            int n = (int) relatorioConf.get("n");
            int m = (int) relatorioConf.get("m");
            double deltaG = (double) relatorioConf.get("densidade");
            boolean apertoDeMao = (boolean) relatorioConf.get("aperto_de_mao");
            int isolados = (int) relatorioConf.get("isolados");

            // EXIBIÇÃO EM CONSOLE PARA AUDITORIA
            System.out.println("\n[MÉTRICAS DO CONJUNTO]");
            System.out.println("Nome do Conjunto: CollegeMsg");
            System.out.println("Origem: Stanford Network Analysis Project (SNAP)");
            System.out.println("Ordem (n obtido): " + n);
            System.out.println("Tamanho (m obtido): " + m);
            System.out.printf("Densidade Delta(G): %.5f\n", deltaG);
            
            System.out.println("\n[ELEMENTOS CONTADOS E DESCARTADOS]");
            System.out.println("Linhas Totais Processadas: " + relatorioL.linhasTotais);
            System.out.println("Linhas Ignoradas (Cabeçalhos/Erros): " + relatorioL.linhasIgnoradas);
            System.out.println("Laços Descartados: " + relatorioL.lacosDescartados);
            System.out.println("Arestas Repetidas: " + relatorioC.arestasRepetidas);
            
            System.out.println("\n[CONFERÊNCIA DE INTEGRIDADE]");
            System.out.println("Quantidade de rótulos distintos no arquivo: " + totalRotulosDistintos);
            System.out.println("Ordem (n) obtida no grafo: " + n);
            System.out.println("Os números coincidem? " + (n == totalRotulosDistintos ? "SIM (Sucesso)" : "NÃO (Erro de Indexação)"));
            System.out.println("Lema do Aperto de Mão é válido? " + (apertoDeMao ? "SIM" : "NÃO"));
            System.out.println("Vértices Isolados encontrados: " + isolados);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de dados. Verifique se o caminho está correto: " + e.getMessage());
        }
    }
		
}

