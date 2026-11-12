# 8.02 — Classificador com Guarda

**Missão:** Classificar um valor por tipo **e** por condição, num único `switch`.

**O que vamos trabalhar:** **`switch` com pattern** — escolher por tipo no `switch`, e refinar com uma **guarda** (`when`) quando só o tipo não basta (ex.: `Integer` negativo vs positivo). Também: `case null`.

**Na prática:** cada `case` é um tipo + nome de variável (`case Integer i when i < 0 -> ...`). **A ordem importa**: o `switch` vai de cima para baixo e usa o primeiro que casar. Pergunta-guia: o `case Integer i` genérico (sem guarda) fica antes ou depois dos específicos?

**Glossário rápido**
- **`switch` expression** — `switch` que devolve valor, com `->` (sem `break`).
- **Guarda (`when`)** — condição extra num `case`.
- **`case null`** — trata `null` explicitamente (sem isso, o `switch` lança `NullPointerException`).
- **`default`** — caso final para "qualquer outro tipo".

**Pesquise sobre:** `java switch pattern matching when` · `java 21 case null switch` · `java switch expression`

**Implemente:** `challenges.m08.f02.ClassificadorDeValor`

```java
public static String classificar(Object valor)
```

**Regras**
- `valor` é `Integer` negativo → `"negativo"`.
- `valor` é `Integer` igual a zero → `"zero"`.
- `valor` é `Integer` positivo → `"positivo"`.
- `valor` é `String` em branco (`isBlank()`) → `"string vazia"`.
- `valor` é `String` não vazia → `"string: " + valor`.
- `valor` é `null` → `"nulo"` (sem lançar exceção aqui — este método trata `null` como um caso válido).
- Qualquer outro tipo → `"outro"`.
- Implemente com um único `switch` sobre `valor`, usando `case Tipo variavel when condição ->` para os casos que precisam de condição extra, e `case null ->` para o `null`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `-5` | `"negativo"` |
| `0` | `"zero"` |
| `7` | `"positivo"` |
| `""` | `"string vazia"` |
| `"oi"` | `"string: oi"` |
| `null` | `"nulo"` |
| `3.14` | `"outro"` |

<details><summary>Dica</summary>

```java
switch (valor) {
  case Integer i when i < 0 -> "negativo";
  case Integer i when i == 0 -> "zero";
  case Integer i -> "positivo";
  ...
}
```

A ordem importa: um `case Integer i when i < 0` antes de um `case Integer i` sem guarda garante que o mais específico seja testado primeiro. `case null ->` é uma opção só de `switch` com pattern — em um `switch` clássico, `null` lançaria `NullPointerException`.

</details>

**Revisa:** `instanceof` com pattern (fase 8.01) — aqui o mesmo tipo de decisão vira um `switch` só, com condições (`when`) no lugar de vários `if`.
**Rodar:** `mvn test -Dtest=ClassificadorDeValorTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
