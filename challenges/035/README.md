# Nome

Soma Por Categoria

# Objetivo

Reforçar `Map` e `getOrDefault`, como no desafio 007 — dessa vez acumulando
uma **soma** associada a cada chave, não uma contagem de `+1`.

# Contexto

Você tem uma lista de categorias e uma lista de valores gastos, na mesma
ordem (a posição `i` de uma corresponde à posição `i` da outra), e quer
saber o total gasto em cada categoria.

# Regras

Implemente o método:

```java
public static Map<String, Integer> somarPorCategoria(List<String> categorias, List<Integer> valores)
```

na classe `challenges.day035.SomaPorCategoria`.

- `categorias` e `valores` nunca são `null` e sempre têm o **mesmo
  tamanho**.
- Devolva um `Map<String, Integer>` em que cada chave é uma categoria e o
  valor é a soma de todos os `valores` associados a ela.
- A ordem das chaves no `Map` não importa.
- Nenhuma das listas recebidas pode ser modificada.

# Entrada

Duas listas não nulas, do mesmo tamanho: `List<String>` e `List<Integer>`.

# Saída esperada

Um `Map<String, Integer>` com a soma por categoria.

# Exemplos

| categorias | valores | retorno |
|---|---|---|
| `[]` | `[]` | `{}` |
| `["A", "B", "A"]` | `[10, 5, 3]` | `{A=13, B=5}` |
| `["X"]` | `[7]` | `{X=7}` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Percorra as listas com índice (elas precisam ser lidas em pares, na
  mesma posição).
- Não modifique `categorias` nem `valores`.

# Dicas

- Diferente do desafio 007, aqui você não soma `+1` a cada aparição — você
  soma o `valores.get(i)` correspondente. O `getOrDefault` continua
  resolvendo o "ainda não existe essa chave" do mesmo jeito, só muda o que
  você soma a ela.
- Como as duas listas precisam ser lidas em pares na mesma posição, dá pra
  usar for-each aqui? Ou você precisa de um índice pra acessar as duas ao
  mesmo tempo?

# Critérios de avaliação

- Todos os testes de `SomaPorCategoriaTest` passam
  (`mvn test -Dtest=SomaPorCategoriaTest`).
- Nenhum uso de Streams.
- `categorias` e `valores` não são alteradas.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`Map`/`getOrDefault` acumulando uma soma em vez de uma contagem, lendo duas
listas paralelas pela mesma posição — mesma base do desafio 007, com uma
regra de acumulação diferente.

# Próximo desafio

Revisão de `Map`/`getOrDefault` com uma chave derivada do dado, não o dado
em si.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `Map` (put, get, getOrDefault)
- Acumular soma associada a uma chave
- Percorrer duas listas paralelas pela mesma posição
