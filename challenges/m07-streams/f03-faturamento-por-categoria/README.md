# 7.03 — Faturamento por Categoria

**Missão:** Somar o valor de cada venda, agrupado por categoria, num `Map`.

**O que vamos trabalhar:** agrupar **e somar** `BigDecimal`. Não existe `summingBigDecimal`, então você vai usar `Collectors.reducing` com `BigDecimal.ZERO` como ponto de partida.

**Na prática:** mesma ideia da fase anterior (`groupingBy` pela categoria), mas o collector de dentro agora extrai o `valor` de cada venda e **soma** tudo, começando do zero. Pergunta-guia: o que é uma "redução"? (combinar muitos valores em um só).

**Glossário rápido**
- **`reducing(identidade, mapeador, operador)`** — collector que mapeia cada item e combina os resultados com um operador.
- **Identidade** — valor inicial que não altera a soma (`BigDecimal.ZERO`).
- **`BigDecimal::add`** — referência de método que serve de operador de soma.
- **`Collectors.mapping`** — alternativa: mapeia antes de reduzir.

**Pesquise sobre:** `java Collectors reducing BigDecimal` · `java stream somar BigDecimal` · `java groupingBy reducing`

**Implemente:** `challenges.m07.f03.Faturamento` (`Venda` já vem pronto no esqueleto — não altere)

```java
public static Map<String, BigDecimal> faturamentoPorCategoria(List<Venda> vendas)
```

**Regras**
- `Venda(String categoria, BigDecimal valor)`.
- Devolve um mapa de `categoria` → soma de `valor` de todas as vendas daquela categoria.
- `vendas` vazia → mapa vazio.
- `vendas` nula → `IllegalArgumentException`.
- Implemente com `Collectors.groupingBy` combinado com `Collectors.reducing` (ou `summingUp` equivalente para `BigDecimal`, já que `Collectors.summingDouble`/`summingInt` não existem para `BigDecimal`).

**Exemplos**

| Entrada | Saída |
|---|---|
| `[("Bebidas",10), ("Bebidas",5), ("Comida",20)]` | `{"Bebidas": 15, "Comida": 20}` |

<details><summary>Dica</summary>

`Collectors.groupingBy(Venda::categoria, Collectors.reducing(BigDecimal.ZERO, Venda::valor, BigDecimal::add))` — `reducing` recebe o valor inicial, como extrair o número de cada item, e como combinar dois números.

</details>

**Revisa:** `groupingBy` + `counting` (fase 7.02) — aqui o coletor de cada grupo soma em vez de contar.
**Rodar:** `mvn test -Dtest=FaturamentoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
