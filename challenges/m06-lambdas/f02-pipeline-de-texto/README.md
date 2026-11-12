# 6.02 — Pipeline de Texto

**Missão:** Aplicar uma sequência de transformações de texto, uma depois da outra, sem escrever um laço para cada combinação possível.

**O que vamos trabalhar:** **`Function<T, R>`** — uma transformação "entra um valor, sai outro" — e como encadear várias em sequência.

**Na prática:** o resultado de uma função vira a entrada da próxima. Comece com o `texto` e vá substituindo-o pelo resultado de cada transformação da lista. Lista vazia? O texto passa intacto.

**Glossário rápido**
- **`Function<T, R>`** — recebe `T`, devolve `R` (método `apply`).
- **Referência de método (`String::strip`)** — atalho de lambda quando você só chama um método existente: `s -> s.strip()`.
- **Pipeline** — sequência de etapas em que a saída de uma é a entrada da seguinte.
- **Elemento neutro** — sem transformações, o resultado é o próprio texto.

**Pesquise sobre:** `java Function apply` · `java referência de método ::` · `java Function andThen compose`

**Implemente:** `challenges.m06.f02.PipelineDeTexto`

```java
public static String aplicar(String texto, List<Function<String, String>> transformacoes)
```

**Regras**
- Aplica cada função de `transformacoes` em sequência sobre o resultado da anterior, começando por `texto`.
- `transformacoes` vazia → devolve `texto` sem nenhuma alteração.
- `texto` ou `transformacoes` nulos → `IllegalArgumentException`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `"  Ola Mundo  "`, `[String::strip, String::toLowerCase]` | `"ola mundo"` |
| `"abc"`, `[]` | `"abc"` |
| `"a"`, `[s -> s + "b", s -> s + "c"]` | `"abc"` |

<details><summary>Dica</summary>

`Function<String, String>` tem um método `andThen(Function)` que devolve uma nova função composta — mas para uma *lista* de funções, é mais direto acumular o resultado num laço: `texto = transformacao.apply(texto)` a cada volta.

</details>

**Revisa:** method reference (`String::strip`) é uma lambda que só chama um método existente.
**Rodar:** `mvn test -Dtest=PipelineDeTextoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
