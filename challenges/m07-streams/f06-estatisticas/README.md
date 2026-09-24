# 7.06 — Estatísticas

**Missão:** Resumir um array de `int` em mínimo, máximo, média e quantidade, numa única linha.

**Implemente:** `challenges.m07.f06.Estatisticas`

```java
public static String resumo(int[] valores)
```

**Regras**
- Devolve exatamente `"min=X max=Y media=Z count=N"`, onde `X`, `Y` e `N` são inteiros e `Z` é a média formatada com **2 casas decimais** (`String.format(Locale.ROOT, "%.2f", media)`).
- `valores` nulo ou vazio → `IllegalArgumentException`.
- Implemente com `IntStream.of(valores).summaryStatistics()` — não some e conte na mão.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[1, 2, 3, 4]` | `"min=1 max=4 media=2.50 count=4"` |
| `[5]` | `"min=5 max=5 media=5.00 count=1"` |

<details><summary>Dica</summary>

`IntSummaryStatistics` tem `getMin()`, `getMax()`, `getAverage()` (já `double`) e `getCount()` (`long`) — um objeto só, sem precisar de quatro variáveis acumuladoras.

</details>

**Revisa:** `String.format` com precisão (fase 1.29); `reduce`/acumular (fases 1.05 e 1.19) — aqui `summaryStatistics` faz os quatro acúmulos de uma vez.
**Rodar:** `mvn test -Dtest=EstatisticasTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
