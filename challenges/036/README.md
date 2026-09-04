# Nome

Contagem Por Tamanho

# Objetivo

Reforçar `Map` e `getOrDefault`, como no desafio 007 — dessa vez a chave do
`Map` não é o dado em si, e sim algo **calculado** a partir dele.

# Contexto

Você quer um raio-x rápido do tamanho das palavras de um texto: quantas
palavras têm 1 letra, quantas têm 2, e assim por diante.

# Regras

Implemente o método:

```java
public static Map<Integer, Integer> contarPorTamanho(List<String> palavras)
```

na classe `challenges.day036.ContagemPorTamanho`.

- `palavras` nunca é `null`, mas pode ser vazia.
- Devolva um `Map<Integer, Integer>` em que cada chave é um tamanho de
  palavra (`palavra.length()`) e o valor é quantas palavras de `palavras`
  têm esse tamanho.
- A ordem das chaves no `Map` não importa.
- A lista recebida não pode ser modificada.

# Entrada

Uma `List<String>` não nula.

# Saída esperada

Um `Map<Integer, Integer>` com a contagem de palavras por tamanho.

# Exemplos

| palavras | retorno |
|---|---|
| `[]` | `{}` |
| `["a", "bb", "cc", "ddd"]` | `{1=1, 2=2, 3=1}` |
| `["oi", "ola"]` | `{2=1, 3=1}` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Percorra `palavras` com for-each, sem índice.
- Não modifique a lista recebida.

# Dicas

- A diferença pro desafio 007 é só uma: a chave que você usa no `Map` não é
  a palavra, é `palavra.length()`. O resto — `getOrDefault` pra buscar a
  contagem atual, `put` pra atualizar — é idêntico.

# Critérios de avaliação

- Todos os testes de `ContagemPorTamanhoTest` passam
  (`mvn test -Dtest=ContagemPorTamanhoTest`).
- Nenhum uso de Streams.
- A lista recebida não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`Map`/`getOrDefault` com uma chave derivada do dado original (um valor
calculado, não o dado bruto) — mesma base do desafio 007, generalizando o
que pode virar chave.

# Próximo desafio

Revisão de `LinkedHashMap`, `entrySet` e desempate, como no desafio 008.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `Map` (put, get, getOrDefault)
- Chave derivada do dado (`length()` como chave)
- Iteração com for-each
