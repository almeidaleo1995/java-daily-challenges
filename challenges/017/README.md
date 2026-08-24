# Nome

Palavra Menos Frequente

# Objetivo

Reforçar `LinkedHashMap`, `entrySet` e desempate, como no desafio 008 —
desta vez buscando o **mínimo**, não o máximo.

# Contexto

Você recebe as palavras de um texto, na ordem em que aparecem, e quer saber
qual delas foi a **menos** usada — útil pra encontrar termos raros num
documento.

# Regras

Implemente o método:

```java
public static String menosFrequente(List<String> palavras)
```

na classe `challenges.day017.PalavraMenosFrequente`.

- `palavras` nunca é `null`.
- Se `palavras` estiver vazia, lance `IllegalArgumentException`.
- Devolva a palavra que aparece **menos vezes** em `palavras`.
- Em caso de empate, devolva a que apareceu **primeiro** em `palavras`.

# Entrada

Uma `List<String>` não nula.

# Saída esperada

Uma `String` com a palavra menos frequente, ou uma
`IllegalArgumentException` se a lista estiver vazia.

# Exemplos

| palavras | retorno |
|---|---|
| `["a", "b", "a", "c", "b", "a"]` | `"c"` |
| `["x", "y"]` | `"x"` |
| `["z"]` | `"z"` |
| `[]` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams.
- Use `LinkedHashMap` e `entrySet`, igual ao desafio 008.

# Dicas

- Mesmo raciocínio do desafio 008: primeiro conte as ocorrências num
  `LinkedHashMap` (pra preservar a ordem de primeira aparição), depois
  percorra o `entrySet` procurando o campeão.
- No desafio 008 o desempate mantinha o **primeiro** encontrado usando
  comparação estrita (`>`). Pra manter essa mesma regra buscando o
  **menor**, qual comparação estrita você precisa usar no lugar de `>`?

# Critérios de avaliação

- Todos os testes de `PalavraMenosFrequenteTest` passam
  (`mvn test -Dtest=PalavraMenosFrequenteTest`).
- Uso de `LinkedHashMap` e `entrySet`, sem Streams.
- Lança `IllegalArgumentException` para lista vazia.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`LinkedHashMap`/`entrySet` buscando um mínimo com desempate pela primeira
aparição — mesma base do desafio 008, invertida.

# Próximo desafio

Revisão de `ArrayDeque` como pilha, como no desafio 009.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- `LinkedHashMap`
- `entrySet()` / `Map.Entry`
- Desempate com comparação estrita
- `IllegalArgumentException`
