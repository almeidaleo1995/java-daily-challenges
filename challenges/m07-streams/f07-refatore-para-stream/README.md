# 7.07 — Refatore para Stream

**Missão:** Reescrever um laço imperativo como um pipeline de Stream, chegando exatamente ao mesmo resultado.

**Implemente:** `challenges.m07.f07.Refatoracao` (`RefatoracaoImperativa` já vem pronta no esqueleto — não altere; é o código a refatorar, só para referência)

```java
public static int somaDosQuadradosDosPares(List<Integer> numeros)
```

**Regras**
- Mesmo comportamento de `RefatoracaoImperativa.somaDosQuadradosDosPares`: soma o quadrado de cada número par da lista.
- `numeros` nula → `IllegalArgumentException`.
- Implemente com um pipeline de Stream (`filter` → `mapToInt` → `sum`), não com um laço `for`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[1, 2, 3, 4]` | `4 + 16 = 20` |
| `[1, 3, 5]` | `0` (nenhum par) |

<details><summary>Dica</summary>

`numeros.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum()` — `mapToInt` troca um `Stream<Integer>` por um `IntStream`, que já tem `.sum()` pronto sem precisar de `Collectors`.

</details>

**Revisa:** `filter`/`map` (fase 7.01) — aqui o objetivo não é aprender um `Collector` novo, é reconhecer quando um laço vira pipeline.
**Rodar:** `mvn test -Dtest=RefatoracaoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
