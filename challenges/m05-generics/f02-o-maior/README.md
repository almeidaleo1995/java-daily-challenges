# 5.02 — O Maior

**Missão:** Escrever um único método que encontra o maior valor de uma lista, funcionando para `Integer`, `String`, ou qualquer outro tipo que saiba comparar a si mesmo.

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
