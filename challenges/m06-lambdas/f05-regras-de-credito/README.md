# 6.05 — Regras de Crédito

**Missão:** Aprovar ou negar crédito combinando três regras independentes numa única decisão, sem uma cadeia de `if`.

**O que vamos trabalhar:** **composição de `Predicate`** — montar uma regra grande a partir de regras pequenas usando `and`, `or` e `negate`, cada uma com nome e testável sozinha.

**Na prática:** crie três `Predicate<Cliente>` (maior de idade, renda mínima, tem restrição) e combine: `idade.and(renda).and(restricao.negate())`. Depois é só `.test(cliente)`.

**Glossário rápido**
- **`Predicate.and(outro)`** — verdadeiro só se os dois forem.
- **`Predicate.or(outro)`** — verdadeiro se pelo menos um for.
- **`Predicate.negate()`** — inverte o resultado.
- **Método `default` de interface** — é assim que `and`/`or`/`negate` existem em `Predicate` (você viu isso na fase 3.05).

**Pesquise sobre:** `java Predicate and or negate` · `java combinar predicates` · `java regras de negócio com lambdas`

**Implemente:** `challenges.m06.f05.RegrasDeCredito` (`Cliente` já vem pronto no esqueleto — não altere)

```java
public static boolean aprovado(Cliente cliente)
```

**Regras**
- `Cliente(int idade, double renda, boolean temRestricao)`.
- Aprovado quando: `idade >= 18` **e** `renda >= 2000` **e** `temRestricao` é `false`.
- `cliente` nulo → `IllegalArgumentException`.
- Implemente combinando `Predicate<Cliente>` com `.and(...)` e `.negate()` — não uma expressão booleana única com `&&`.

**Exemplos**

| `idade` | `renda` | `temRestricao` | `aprovado` |
|---|---|---|---|
| 25 | 3000 | `false` | `true` |
| 17 | 3000 | `false` | `false` (menor de idade) |
| 25 | 1000 | `false` | `false` (renda insuficiente) |
| 25 | 3000 | `true` | `false` (tem restrição) |

<details><summary>Dica</summary>

Três `Predicate<Cliente>`, um por regra — o de restrição pode ser um method reference (`Cliente::temRestricao`) seguido de `.negate()`. Combine os três com `.and(...).and(...)` e chame `.test(cliente)` no final.

</details>

**Revisa:** `Predicate<T>` (fase 6.01) — aqui os predicados se combinam em vez de serem usados sozinhos.
**Rodar:** `mvn test -Dtest=RegrasDeCreditoTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
