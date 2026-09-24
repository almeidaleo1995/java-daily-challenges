> Antigo desafio 038 · Mundo 2, fase 17

# Nome

Produto Com Menor Estoque

# Objetivo

Reforçar valor sentinela e desempate estrito buscando um mínimo, como no
desafio 017 — dessa vez os dados já chegam prontos num `Map`, em vez de
serem contados a partir de uma `List`.

# Contexto

Você recebe o estoque atual de uma loja, já como um `Map` de produto pra
quantidade, na ordem de cadastro, e quer saber qual produto está mais perto
de acabar.

# Regras

Implemente o método:

```java
public static String menorEstoque(LinkedHashMap<String, Integer> estoque)
```

na classe `challenges.m02.f17.ProdutoComMenorEstoque`.

- `estoque` nunca é `null`.
- Se `estoque` estiver vazio, lance `IllegalArgumentException`.
- Devolva a chave (produto) com o **menor** valor (quantidade) em
  `estoque`.
- Em caso de empate, devolva o produto que aparece **primeiro** no `Map`
  (ordem de inserção).

# Entrada

Um `LinkedHashMap<String, Integer>` não nulo.

# Saída esperada

Uma `String` com o produto de menor estoque, ou uma
`IllegalArgumentException` se `estoque` estiver vazio.

# Exemplos

| estoque | retorno |
|---|---|
| `{A=5, B=2, C=8}` | `"B"` |
| `{A=5, B=2, C=2}` | `"B"` (empate, primeiro no Map) |
| `{X=10}` | `"X"` |
| `{}` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams.
- Use `entrySet` pra percorrer o `Map`.

# Dicas

- Não existe contagem a fazer aqui — o `Map` já é o dado final. O trabalho
  é só percorrer o `entrySet` procurando o menor valor.
- Igual ao desafio 017: comece com um valor sentinela (`Integer.MAX_VALUE`)
  e use comparação estrita (`<`) pra manter o desempate no primeiro
  encontrado.

# Critérios de avaliação

- Todos os testes de `ProdutoComMenorEstoqueTest` passam
  (`mvn test -Dtest=ProdutoComMenorEstoqueTest`).
- Uso de `entrySet`, sem Streams.
- Lança `IllegalArgumentException` para `Map` vazio.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Valor sentinela e desempate estrito buscando um mínimo direto num `Map`
existente — mesma base do desafio 017, sem a etapa de contagem.

# Próximo desafio

Revisão de valor sentinela e desempate buscando um máximo sobre listas
paralelas, sem `Map`.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `entrySet()` / `Map.Entry`
- Valor sentinela (`Integer.MAX_VALUE`)
- Desempate com comparação estrita
- `IllegalArgumentException`
