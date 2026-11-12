> Antigo desafio 039 · Mundo 2, fase 18

# Nome

Produto Mais Caro

# Objetivo

Reforçar valor sentinela e desempate estrito, como nos desafios 008 e 017 —
dessa vez sobre duas listas paralelas, sem usar `Map`.

# Contexto

Você tem os nomes e os preços dos produtos de um catálogo, na mesma ordem
(a posição `i` de uma lista corresponde à posição `i` da outra), e quer
saber qual produto é o mais caro.

# O que vamos trabalhar

Achar o **maior valor** com desempate por posição, sem `Map`: duas **listas paralelas** (nomes e preços).

# Na prática

O índice `i` é a "cola" entre as duas listas. Percorra por índice guardando a melhor posição (ou o melhor preço e o nome). Pergunte-se: o que você compara a cada passo? Com `>` ou `>=`, quem vence um empate?

# Glossário rápido

- **Listas paralelas** — alinhadas por índice.
- **`List<Double>`** — lista de objetos `Double` (não `double`).
- **Estado do melhor** — índice (ou valor) do candidato atual.

# Pesquise sobre

`java List get índice for` · `java achar maior valor em lista` · `java List<Double>`

# Regras

Implemente o método:

```java
public static String maisCaro(List<String> produtos, List<Double> precos)
```

na classe `challenges.m02.f18.ProdutoMaisCaro`.

- `produtos` e `precos` nunca são `null` e sempre têm o **mesmo tamanho**.
- Se as listas estiverem vazias, lance `IllegalArgumentException`.
- Devolva o nome do produto com o **maior** preço.
- Em caso de empate, devolva o produto que aparece **primeiro** nas
  listas.

# Entrada

Duas listas não nulas e do mesmo tamanho: `List<String>` e `List<Double>`.

# Saída esperada

Uma `String` com o produto mais caro, ou uma `IllegalArgumentException` se
as listas estiverem vazias.

# Exemplos

| produtos | precos | retorno |
|---|---|---|
| `["caneta", "caderno"]` | `[2.5, 15.0]` | `"caderno"` |
| `["a", "b"]` | `[10.0, 10.0]` | `"a"` |
| `["x"]` | `[5.0]` | `"x"` |
| `[]` | `[]` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams, sem `Map`.
- Percorra as listas por índice (elas precisam ser lidas em pares).

# Dicas

- Sem `Map`, você não tem `entrySet` — percorra as duas listas pela mesma
  posição com um índice, comparando `precos.get(i)` com o melhor preço
  visto até agora.
- Mesma ideia de sentinela do desafio 017, mas buscando o **maior**: pode
  começar com um valor bem baixo (`Double.NEGATIVE_INFINITY`), ou usar o
  primeiro elemento como ponto de partida, como no desafio 005.

# Critérios de avaliação

- Todos os testes de `ProdutoMaisCaroTest` passam
  (`mvn test -Dtest=ProdutoMaisCaroTest`).
- Sem Streams, sem `Map`.
- Lança `IllegalArgumentException` para listas vazias.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Buscar um máximo com desempate estrito sobre duas listas paralelas, sem o
apoio de `Map`/`entrySet` — juntando os desafios 005, 008 e 017 numa versão
sem Collection de apoio.

# Próximo desafio

Revisão de `Character.isDigit()`, contando dígitos num texto.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- Valor sentinela
- Desempate com comparação estrita
- `IllegalArgumentException`
- Percorrer duas listas paralelas pela mesma posição
