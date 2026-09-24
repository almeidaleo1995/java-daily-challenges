# 8.02 — Classificador com Guarda

**Missão:** Classificar um valor por tipo **e** por condição, num único `switch`.

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
