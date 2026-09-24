# Mundo 7 — Streams
> O laço que soma, filtra e agrupa quase sempre vira uma linha só — se você enxergar o pipeline em vez do passo a passo.

- **`filter`/`map`/`sorted`** — os três verbos que resolvem a maioria dos pipelines.
- **`Collectors.groupingBy`** — "uma pergunta por chave", sem `Map` manual.
- **`Collectors.toMap`** com função de merge — juntar valores repetidos numa chave sem sobrescrever.
- **`flatMap`** — achatar uma lista de listas numa só.
- **`partitioningBy`** — um `groupingBy` de exatamente duas chaves: `true` e `false`.
- **`IntStream`/`summaryStatistics`** — estatísticas de uma coleção numérica sem acumular na mão.

**Chefe:** Mercadinho v5: Relatório de Vendas — top 3 produtos, faturamento por categoria e ticket médio a partir da mesma lista de vendas.
**Fonte:** https://dev.java/learn/api/collections-and-streams/
