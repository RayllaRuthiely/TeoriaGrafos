# Representação Computacional de Grafos

Este projeto apresenta a implementação e a comparação de duas formas de representação de grafos: **matriz de adjacência** e **lista de adjacência**.

A atividade tem como objetivo analisar como diferentes estruturas de representação influenciam o custo das operações realizadas sobre um grafo, utilizando como principal operação a **contagem de triângulos**.

## Objetivos

* Implementar `GrafoMatriz` e `GrafoLista` a partir da interface `Grafo`;
* Construir e testar o grafo;
* Verificar propriedades básicas do grafo, como número de vértices, número de arestas e graus;
* Gerar grafos aleatórios com diferentes densidades;
* Medir o tempo de execução de `contar_triangulos`;
* Comparar o espaço ocupado pelas duas representações;
* Analisar os resultados obtidos em relação ao custo esperado das operações.

## Implementações

O projeto utiliza duas representações:

* **GrafoMatriz:** utiliza uma matriz de adjacência para armazenar as conexões entre os vértices.
* **GrafoLista:** utiliza listas de adjacência para armazenar os vizinhos de cada vértice.

Ambas as implementações seguem a interface `Grafo` e foram desenvolvidas sem a utilização de bibliotecas externas de grafos.

## Testes

As duas implementações são testadas utilizando o grafo.

Exemplo:

* `n = 6` vértices;
* `m = 8` arestas;
* sequência de graus `(4, 3, 3, 3, 2, 1)`;
* soma dos graus igual a `2m`.

Esses testes permitem verificar se as duas representações estão construindo corretamente o mesmo grafo.

## Medição de desempenho

Para analisar o comportamento das representações, são utilizados grafos aleatórios com:

* `n = 2000` vértices;
* densidade aproximadamente `0,001`;
* densidade aproximadamente `0,05`;
* densidade aproximadamente `0,5`.

Para cada densidade, o tempo da operação `contar_triangulos` é medido pelo menos três vezes, utilizando a **mediana** das execuções.

Também é comparado o espaço utilizado por cada representação:

* **Matriz:** `n²` posições;
* **Lista:** `n + 2m` posições.

Os resultados são organizados em uma tabela para facilitar a comparação entre as duas implementações.

## Análise

A análise busca responder:

* Qual representação foi mais rápida em cada densidade?
* Por que o desempenho se comportou dessa maneira?
* A ordem de desempenho entre matriz e lista muda conforme a densidade aumenta?
* Os resultados observados concordam com o custo teórico de `contar_triangulos`?
* Caso exista alguma diferença entre a previsão teórica e a medição, quais fatores podem explicá-la?

O objetivo não é apenas apresentar os tempos obtidos, mas **interpretar as medições e relacioná-las ao custo das estruturas utilizadas**.

## Estrutura do projeto

```text
src/
└── grafo/
    ├── Grafo.java
    ├── GrafoMatriz.java
    ├── GrafoLista.java
    └── Main.java
```

## Resultado esperado

Ao final da atividade, espera-se compreender como a escolha da representação de um grafo pode afetar o **tempo de execução** e o **espaço utilizado**, especialmente quando a densidade do grafo aumenta.


## Equipe

- Raylla Ruthiely Gomes Santana | https://github.com/RayllaRuthiely
- Nariann Tolentino Sena | https://github.com/narianntolentino-create
- Jhully Stephane Marinho Napoliao | ***********