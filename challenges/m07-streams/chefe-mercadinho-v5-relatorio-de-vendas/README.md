# 👑 Chefe do Mundo 7 — Mercadinho v5: Relatório de Vendas

**Missão:** Da mesma lista de linhas de venda, extrair quatro visões diferentes: os 3 produtos que mais faturaram, o faturamento por categoria, o ticket médio e o produto campeão de vendas.

**O que vamos trabalhar:** usar tudo do Mundo 7 em quatro relatórios sobre a mesma lista: **agrupar e somar** (`groupingBy` + `reducing`), **ordenar e limitar** (`sorted`, `limit`), **média** e **`Optional`** (máximo).

**Na prática:** `top3Produtos` e `produtoMaisVendido` partem do **mesmo** primeiro passo: somar o `valor` por produto num `Map`. A partir do `Map`, um ordena e corta em 3; o outro pega o maior. `faturamentoPorCategoria` é a fase 7.03. `ticketMedio` é soma ÷ quantidade de **linhas**, com escala 2 (cuidado com lista vazia). Atenção ao desempate por nome no top 3.

**Glossário rápido**
- **`Map.Entry`** — par chave/valor de um `Map`; use `map.entrySet().stream()` para ordenar um mapa.
- **`Map.Entry.comparingByValue()`** — critério pronto de ordenação por valor.
- **`limit(n)`** — corta o stream nos primeiros `n`.
- **`max(comparator)`** — devolve `Optional` (pode ser vazio se não há elementos).
- **`BigDecimal.divide(x, escala, RoundingMode)`** — divisão com arredondamento definido (sem isso pode lançar exceção).

**Pesquise sobre:** `java Map entrySet stream sorted` · `java Comparator thenComparing desempate` · `java BigDecimal divide RoundingMode`

**Implemente:** `challenges.m07.chefe.RelatorioDeVendas` (`LinhaDeVenda` já vem pronta no esqueleto — não altere)

```java
public static List<String> top3Produtos(List<LinhaDeVenda> vendas)
public static Map<String, BigDecimal> faturamentoPorCategoria(List<LinhaDeVenda> vendas)
public static BigDecimal ticketMedio(List<LinhaDeVenda> vendas)
public static Optional<String> produtoMaisVendido(List<LinhaDeVenda> vendas)
```

**Regras**
- `LinhaDeVenda(String produto, String categoria, BigDecimal valor)`.
- `top3Produtos`: soma `valor` por `produto`, ordena decrescente pela soma (empate: nome em ordem alfabética), devolve os nomes dos até 3 primeiros — se houver menos de 3 produtos distintos, devolve todos.
- `faturamentoPorCategoria`: soma `valor` por `categoria` (igual à fase 7.03).
- `ticketMedio`: média de `valor` **por linha de venda** (não por produto), escala 2 e `RoundingMode.HALF_EVEN`. Lista vazia → `BigDecimal.ZERO` com escala 2.
- `produtoMaisVendido`: `Optional.of(nome)` do produto com maior soma de `valor`; lista vazia → `Optional.empty()`.
- `vendas` nula, em qualquer um dos quatro métodos → `IllegalArgumentException`.

**Exemplos**

Com `vendas = [("Arroz","Alimentos",30), ("Feijão","Alimentos",20), ("Arroz","Alimentos",10), ("Sabão","Limpeza",50)]`:

| Chamada | Resultado |
|---|---|
| `top3Produtos` | `["Sabão", "Arroz", "Feijão"]` (Sabão 50, Arroz 40, Feijão 20) |
| `faturamentoPorCategoria` | `{"Alimentos": 60, "Limpeza": 50}` |
| `ticketMedio` | `27.50` (110 ÷ 4 linhas) |
| `produtoMaisVendido` | `Optional.of("Sabão")` |

<details><summary>Dica</summary>

Todos os quatro métodos partem do mesmo `groupingBy(LinhaDeVenda::produto, reducing(...))` ou `groupingBy(LinhaDeVenda::categoria, reducing(...))` das fases 7.02/7.03 — a novidade aqui é ordenar o resultado do `Map` (`entrySet().stream().sorted(...)`) para pegar o topo, e reaproveitar o mesmo agrupamento em `produtoMaisVendido`.

</details>

**Revisa:** `groupingBy` + `reducing` (fase 7.03), `Comparator` com desempate (`thenComparing`, fase 2.19), `Optional` (Mundo 6).
**Rodar:** `mvn test -Dtest=RelatorioDeVendasTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 8 — Pattern Matching**.
