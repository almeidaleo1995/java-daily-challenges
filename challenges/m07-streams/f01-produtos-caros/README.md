# 7.01 — Produtos Caros

**Missão:** Dos produtos acima de um preço mínimo, listar os nomes do mais caro para o mais barato.

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
