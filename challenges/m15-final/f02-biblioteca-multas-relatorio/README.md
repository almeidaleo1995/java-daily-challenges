# 15.02 — Biblioteca 2: Multas e Relatório

**Missão:** Calcular multa por atraso e listar quem está com livro atrasado, do mais atrasado para o menos.

**Implemente:** `challenges.m15.f02.RelatorioDaBiblioteca` (`EmprestimoAtivo` já vem pronto no esqueleto — não altere)

```java
public static double calcularMulta(LocalDate dataEmprestimo, LocalDate hoje)
public static List<String> emprestimosAtrasados(List<EmprestimoAtivo> emprestimos, LocalDate hoje)
```

**Regras**
- Prazo de empréstimo: **14 dias** a partir de `dataEmprestimo`.
- `calcularMulta`: se `hoje` está dentro do prazo (ou é o próprio dia do vencimento), multa `0.0`. Se passou, multa é `0.5` por dia de atraso.
- `dataEmprestimo` posterior a `hoje` → `IllegalArgumentException`.
- `emprestimosAtrasados`: nomes dos **títulos** com atraso (dias de atraso `> 0`), do mais atrasado para o menos atrasado. Sem atraso, não entra na lista.
- `emprestimos` nulo → `IllegalArgumentException`.
- Implemente `emprestimosAtrasados` com pipeline de Stream (`filter` → `sorted` → `map` → `toList`).

**Exemplos**

| `dataEmprestimo` | `hoje` | `calcularMulta` |
|---|---|---|
| `2024-01-01` | `2024-01-10` | `0.0` (dentro do prazo de 14 dias) |
| `2024-01-01` | `2024-01-20` | `2.5` (vence em `01-15`, 5 dias de atraso) |

<details><summary>Dica</summary>

`ChronoUnit.DAYS.between(dataEmprestimo.plusDays(14), hoje)` dá os dias de atraso — negativo ou zero significa sem atraso (use `Math.max(0, ...)` antes de multiplicar por `0.5`). Para ordenar do mais atrasado pro menos, ordene pelo `Comparator.comparing` dos dias de atraso, invertido (`.reversed()`).

</details>

**Revisa:** `LocalDate`/`ChronoUnit` (Mundo 9), Streams (Mundo 7), `record` (fase 15.01).
**Rodar:** `mvn test -Dtest=RelatorioDaBibliotecaTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
