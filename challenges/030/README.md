# Nome

Índice do Primeiro Declive

# Objetivo

Reforçar look-ahead — comparar um elemento com o **próximo**, em vez de
guardar o anterior numa variável — mesma técnica do desafio 013, agora
aplicada a um array de números.

# Contexto

Você quer encontrar o primeiro ponto de um array onde a sequência "cai": um
valor maior que o seguinte. É o primeiro sinal de que os dados pararam de
crescer.

# Regras

Implemente o método:

```java
public static int indicePrimeiroDeclive(int[] numeros)
```

na classe `challenges.day030.IndicePrimeiroDeclive`.

- `numeros` tem pelo menos 2 posições.
- Devolva o menor índice `i` tal que `numeros[i] > numeros[i + 1]`.
- Se a sequência nunca cair (for sempre crescente ou igual), lance
  `IllegalArgumentException`.

# Entrada

Um `int[]` com pelo menos 2 elementos.

# Saída esperada

Um `int` com o índice do primeiro declive, ou uma
`IllegalArgumentException` se não houver nenhum.

# Exemplos

| numeros | retorno |
|---|---|
| `[1, 2, 5, 3, 4]` | `2` |
| `[5, 1, 2]` | `0` |
| `[1, 2, 3]` | lança `IllegalArgumentException` |
| `[1, 1, 1]` | lança `IllegalArgumentException` |
| `[5, 1, 2, 4, 3]` | `0` (primeiro declive, não o último) |

# Restrições

- Não guarde o valor anterior numa variável — compare sempre com o
  **próximo** elemento (`numeros[i + 1]`), igual ao desafio 013.
- Um único laço sobre o array.

# Dicas

- No desafio 013 você comparava `texto.charAt(i)` com `texto.charAt(i +
  1)`. Aqui é o mesmo princípio, só que com `numeros[i]` e `numeros[i +
  1]`.
- Cuidado com o limite do laço: se você olha pra `i + 1`, até onde `i` pode
  ir sem estourar o array?
- Elementos iguais (`numeros[i] == numeros[i + 1]`) não contam como
  declive — só um valor estritamente maior que o próximo conta.

# Critérios de avaliação

- Todos os testes de `IndicePrimeiroDeclive` passam
  (`mvn test -Dtest=IndicePrimeiroDeclive`).
- Comparação feita olhando pro próximo elemento, não guardando o anterior.
- Lança `IllegalArgumentException` quando não há declive.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Look-ahead num array — comparar a posição atual com a seguinte — mesma
técnica do desafio 013, trocando `String` por array de `int` e somando a
validação com exceção do desafio 008.

# Próximo desafio

Revisão de `List` e `Set` combinando duas coleções, como no desafio 006.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- Array (`length`, índice)
- Look-ahead (comparar com o próximo elemento)
- `IllegalArgumentException`
