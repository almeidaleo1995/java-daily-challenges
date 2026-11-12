# 8.01 — Descritor

**Missão:** Descrever um valor de tipo desconhecido em texto, sem um cast manual para cada tipo possível.

**O que vamos trabalhar:** **`instanceof` com pattern** — testar o tipo **e** já ganhar uma variável com o tipo certo, tudo numa linha (acabou o cast manual).

**Na prática:** antes você escrevia `if (x instanceof Integer) { Integer i = (Integer) x; ... }`. Agora `if (x instanceof Integer i)` já declara `i`. Uma sequência de `if`/`else if`, um por tipo; o caso de `String` tem uma checagem extra (vazia ou não).

**Glossário rápido**
- **Pattern matching** — testar a "forma" de um valor e já extrair partes dele.
- **Variável de padrão (`i` em `instanceof Integer i`)** — só existe onde o compilador tem certeza de que o teste passou.
- **`Object`** — tipo mais genérico; pode guardar qualquer coisa, por isso precisamos descobrir o tipo real.
- **`strip()` / `isBlank()`** — checagem de texto vazio ou só com espaços.

**Pesquise sobre:** `java instanceof pattern matching` · `java 16 instanceof variável` · `java String isBlank strip`

**Implemente:** `challenges.m08.f01.Descritor`

```java
public static String descrever(Object valor)
```

**Regras**
- `valor` é `Integer` → `"inteiro: " + valor`.
- `valor` é `Boolean` → `"booleano: " + valor`.
- `valor` é `String` não vazia (depois de `strip()`) → `"texto: " + valor`.
- `valor` é `String` vazia ou só espaços → `"texto vazio"`.
- Qualquer outro tipo → `"desconhecido"`.
- `valor` nulo → `IllegalArgumentException`.
- Implemente com `instanceof` com pattern (`valor instanceof Integer i`), não com cast manual.

**Exemplos**

| Entrada | Saída |
|---|---|
| `42` | `"inteiro: 42"` |
| `true` | `"booleano: true"` |
| `"oi"` | `"texto: oi"` |
| `"   "` | `"texto vazio"` |
| `3.14` (`Double`) | `"desconhecido"` |

<details><summary>Dica</summary>

`if (valor instanceof Integer i) { return "inteiro: " + i; }` — `i` já nasce com o tipo `Integer`, sem precisar de `(Integer) valor` depois. Encadeie um `if` por tipo, na ordem que fizer sentido, com o `String` vazio antes do `String` genérico (o mais específico primeiro).

</details>

**Revisa:** `String.isBlank()` (fase 1.28 usa conceito parecido com `strip`).
**Rodar:** `mvn test -Dtest=DescritorTest`

⭐☆☆☆☆ · ~10 min · +10 XP
