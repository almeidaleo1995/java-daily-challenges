# 7.01 — Produtos Caros

**Missão:** Dos produtos acima de um preço mínimo, listar os nomes do mais caro para o mais barato.

**O que vamos trabalhar:** o básico de **Stream** — um "cano" de etapas (`filter` → `sorted` → `map` → `toList`) que substitui o laço com `if` e lista temporária.

**Na prática:** pense em três verbos: *mantenha* só os caros, *ordene* do maior para o menor preço, *troque* cada produto pelo nome. Cada verbo é uma etapa do stream. A grande dúvida costuma ser o `sorted`: como passar um critério de ordenação? (dica: `Comparator`).

**Glossário rápido**
- **Stream** — sequência de elementos processada em etapas, sem alterar a lista original.
- **Operação intermediária** — devolve outro stream (`filter`, `map`, `sorted`); só roda quando há uma terminal.
- **Operação terminal** — dispara tudo e produz resultado (`toList`, `count`, `sum`).
- **`Comparator.comparing(...)` / `.reversed()`** — monta um critério de ordenação a partir de um campo.

**Pesquise sobre:** `java stream filter map sorted toList` · `java Comparator comparing reversed` · `java stream operação intermediária terminal`

**Implemente:** `challenges.m07.f01.Catalogo` (`Produto` já vem pronto no esqueleto — não altere)

```java
public static List<String> nomesAcimaDe(List<Produto> produtos, BigDecimal minimo)
```

**Regras**
- `Produto(String nome, BigDecimal preco)`.
- Mantém só produtos com `preco` **estritamente maior** que `minimo`.
- Ordena o resultado por preço decrescente e devolve só os nomes.
- `produtos` ou `minimo` nulos → `IllegalArgumentException`.
- Implemente com um pipeline de Stream (`filter` → `sorted` → `map` → `toList`), não com laço.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[("A",10), ("B",30), ("C",20)]`, `minimo=15` | `["B", "C"]` |
| `[("A",10)]`, `minimo=10` | `[]` (10 não é maior que 10) |

<details><summary>Dica</summary>

`produtos.stream().filter(p -> p.preco().compareTo(minimo) > 0).sorted(Comparator.comparing(Produto::preco).reversed()).map(Produto::nome).toList()` — mas tente montar você mesmo antes de olhar isso de novo.

</details>

**Revisa:** `Comparator.comparing`/`reversed` (fase 2.19); `BigDecimal.compareTo` para comparar valores (fase 1.26 — nunca `==`).
**Rodar:** `mvn test -Dtest=CatalogoTest`

⭐☆☆☆☆ · ~10 min · +10 XP
