# 9.01 — Idade Exata

**Missão:** Calcular a idade em anos completos entre duas datas, sem contar dias na mão.

**O que vamos trabalhar:** a API moderna de datas (`java.time`): `LocalDate` (data sem hora) e `Period` (diferença em anos/meses/dias). Esqueça `Date` e `Calendar`.

**Na prática:** idade = anos **completos** entre duas datas. Se o aniversário ainda não chegou este ano, a pessoa não fez a idade cheia. Em vez de comparar mês e dia na mão, existe uma classe que já calcula a diferença entre duas `LocalDate`.

**Glossário rápido**
- **`LocalDate`** — data sem hora e sem fuso (`2024-05-15`). Imutável.
- **`Period`** — diferença entre datas em anos, meses e dias (`getYears()`).
- **`Period.between(a, b)`** — calcula o período de `a` até `b`.
- **`isAfter` / `isBefore`** — comparam datas sem usar `compareTo`.

**Pesquise sobre:** `java LocalDate Period between` · `java calcular idade LocalDate` · `java.time LocalDate isAfter`

**Implemente:** `challenges.m09.f01.CalculadoraDeIdade`

```java
public static int idadeEmAnos(LocalDate nascimento, LocalDate hoje)
```

**Regras**
- Devolve quantos anos completos se passaram entre `nascimento` e `hoje`.
- `nascimento` ou `hoje` nulos → `IllegalArgumentException`.
- `nascimento` posterior a `hoje` → `IllegalArgumentException`.

**Exemplos**

| `nascimento` | `hoje` | Resultado |
|---|---|---|
| `1990-05-15` | `2024-05-14` | `33` (aniversário ainda não chegou) |
| `1990-05-15` | `2024-05-15` | `34` (aniversário é hoje) |

<details><summary>Dica</summary>

`Period.between(nascimento, hoje)` devolve um `Period` com anos, meses e dias já calculados corretamente (inclusive considerando ano bissexto) — `getYears()` é a resposta.

</details>

**Revisa:** nenhum conceito anterior direto — este é o ponto de entrada da API de datas.
**Rodar:** `mvn test -Dtest=CalculadoraDeIdadeTest`

⭐☆☆☆☆ · ~10 min · +10 XP
