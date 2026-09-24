# 7.03 — Faturamento por Categoria

**Missão:** Somar o valor de cada venda, agrupado por categoria, num `Map`.

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
