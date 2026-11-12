# 5.02 — O Maior

**Missão:** Escrever um único método que encontra o maior valor de uma lista, funcionando para `Integer`, `String`, ou qualquer outro tipo que saiba comparar a si mesmo.

**O que vamos trabalhar:** **método genérico com limite (bound)** — "funciona para qualquer `T`, *desde que* `T` saiba se comparar". Assim `Integer` e `String` entram, mas um tipo sem `compareTo` não.

**Na prática:** a assinatura já vem pronta. Seu trabalho é o laço: guardar o "maior até agora" e comparar com `compareTo` (que devolve negativo, zero ou positivo). Primeira pergunta: com qual valor você começa o "maior até agora"?

**Glossário rápido**
- **Método genérico** — `<T> T metodo(...)`: o tipo é definido por chamada.
- **Bound `T extends Comparable<...>`** — restringe `T` a tipos que implementam `Comparable`.
- **`compareTo`** — `a.compareTo(b)` < 0 se `a < b`, 0 se iguais, > 0 se `a > b`.
- **`? super T`** — curinga que deixa a assinatura mais flexível (aqui você só *lê* via `compareTo`; a próxima fase explica melhor).

**Pesquise sobre:** `java método genérico extends Comparable` · `java compareTo como funciona` · `java generics bounded type`

**Implemente:** `challenges.m05.f02.Maior`

```java
public static <T extends Comparable<? super T>> T encontrar(List<T> valores)
```

**Regras**
- Devolve o maior elemento de `valores`, usando `compareTo`.
- `valores` nula ou vazia lança `IllegalArgumentException`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `encontrar(List.of(3, 7, 2))` | `7` |
| `encontrar(List.of("b", "a", "c"))` | `"c"` |
| `encontrar(List.of())` | lança `IllegalArgumentException` |

<details><summary>Dica</summary>

`<T extends Comparable<? super T>>` é o jeito genérico de dizer "qualquer tipo que sabe se comparar com ele mesmo (ou com um supertipo seu)" — é o mesmo tipo de restrição que o próprio `Collections.max` do JDK usa. Dentro do método, `a.compareTo(b)` funciona porque o compilador sabe, pela assinatura, que `T` tem esse método.

</details>

**Revisa:** Acumular o maior durante o laço (desafio 005) — aqui o tipo do valor não é mais fixo (`int`), e sim genérico.
**Rodar:** `mvn test -Dtest=MaiorTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
