# 1.27 — Tipo do Dia

**Missão:** Classificar um dia da semana usando `switch` expression — sem `break`, sem variável de retorno mutável.

**O que vamos trabalhar:** **`switch` expression** (moderno): usa `->`, não precisa de `break` e **devolve valor** diretamente. Aplicado a um `enum` (`DayOfWeek`).

**Na prática:** cada `case` mapeia um (ou vários) dia(s) a um texto. Vários valores no mesmo `case` se separam por vírgula. Pergunte-se: como cobrir "qualquer outro" sem listar todos os dias? Precisa de `default` quando os valores do enum já estão cobertos?

**Glossário rápido**
- **`switch` expression** — `String r = switch (x) { case A -> "..."; default -> "..."; };`
- **`enum`** — conjunto fixo de constantes; `DayOfWeek.MONDAY`.
- **`case A, B ->`** — vários valores no mesmo ramo.
- **Fall-through** — bug do `switch` antigo (esquecer o `break`); a seta `->` elimina.

**Pesquise sobre:** `java switch expression seta` · `java enum DayOfWeek` · `java switch fall-through break`

**Implemente:** `challenges.m01.f27.TipoDoDia`

```java
public static String classificar(DayOfWeek dia)
```

**Regras**
- `SATURDAY` e `SUNDAY` → `"Fim de semana"`.
- `MONDAY` → `"Início de semana"`.
- `FRIDAY` → `"Sexta"`.
- Qualquer outro dia (`TUESDAY`, `WEDNESDAY`, `THURSDAY`) → `"Meio de semana"`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `classificar(DayOfWeek.SATURDAY)` | `"Fim de semana"` |
| `classificar(DayOfWeek.MONDAY)` | `"Início de semana"` |
| `classificar(DayOfWeek.WEDNESDAY)` | `"Meio de semana"` |

<details><summary>Dica</summary>

`switch` expression usa `->` em vez de `case ... :` com `break`. Um rótulo pode listar vários valores separados por vírgula (`case A, B ->`). Quando o corpo de um `case` precisa de mais de uma expressão, ele vira um bloco `{ }` que termina em `yield valor;` em vez de `return`.

</details>

**Revisa:** `if`/`else` encadeado (desafio 001) — o `switch` expression resolve o mesmo problema sem repetir a variável de retorno a cada ramo.
**Rodar:** `mvn test -Dtest=TipoDoDiaTest`

⭐☆☆☆☆ · ~10 min · +10 XP
