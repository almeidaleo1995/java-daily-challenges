# 9.01 — Idade Exata

**Missão:** Calcular a idade em anos completos entre duas datas, sem contar dias na mão.

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
