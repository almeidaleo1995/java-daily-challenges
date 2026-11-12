# 6.01 — Filtro Genérico

**Missão:** Filtrar qualquer lista, de qualquer tipo, sem escrever um laço específico para cada regra.

**O que vamos trabalhar:** **lambda** + **`Predicate<T>`** — passar uma *regra* (função que responde sim/não) como parâmetro, em vez de escrever um laço novo para cada critério.

**Na prática:** `filtrar` é um laço comum que, para cada elemento, pergunta `predicado.test(elemento)`. Quem *chama* `filtrar` decide a regra com uma lambda, como `n -> n % 2 == 0`.

**Glossário rápido**
- **Lambda** — função anônima curta: `(parametros) -> expressao`.
- **Interface funcional** — interface com **um** único método abstrato; é onde uma lambda "encaixa".
- **`Predicate<T>`** — interface funcional: recebe `T`, devolve `boolean` (método `test`).
- **`<T>` no método** — o mesmo `filtrar` serve para lista de `Integer`, `String`, etc.

**Pesquise sobre:** `java lambda expressão sintaxe` · `java Predicate test` · `java interface funcional`

**Implemente:** `challenges.m06.f01.Filtro`

```java
public static <T> List<T> filtrar(List<T> lista, Predicate<T> predicado)
```

**Regras**
- Devolve uma nova lista só com os elementos de `lista` para os quais `predicado.test(elemento)` é `true`, na ordem original.
- `lista` ou `predicado` nulos → `IllegalArgumentException`.
- Sem Streams — laço manual. Streams é o Mundo 7; aqui o ponto é o `Predicate` sozinho.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[1, 2, 3, 4, 5, 6]`, `n -> n % 2 == 0` | `[2, 4, 6]` |
| `["ana", "bob", "ana"]`, `s -> s.equals("ana")` | `["ana", "ana"]` |
| `[]`, `n -> true` | `[]` |

<details><summary>Dica</summary>

`Predicate<T>` é uma interface funcional com um método `test(T)` que devolve `boolean`. O método recebe a lambda como parâmetro — não precisa saber o que ela faz por dentro, só chamar `predicado.test(item)` dentro do laço.

</details>

**Revisa:** `List` (Mundo 2) — aqui o critério de inclusão vira parâmetro em vez de estar fixo no código.
**Rodar:** `mvn test -Dtest=FiltroTest`

⭐☆☆☆☆ · ~10 min · +10 XP
