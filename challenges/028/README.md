# Nome

Segundo Maior Valor

# Objetivo

Reforçar acumular o "melhor" durante o laço, como no desafio 005 — dessa
vez mantendo **dois** candidatos ao mesmo tempo, não só um.

# Contexto

Você quer saber o segundo maior valor de um array de pontuações, sem
ordenar o array inteiro só pra achar dois valores.

# Regras

Implemente o método:

```java
public static int segundoMaior(int[] numeros)
```

na classe `challenges.day028.SegundoMaiorValor`.

- `numeros` tem pelo menos 2 posições, todas com valores distintos entre
  si.
- Devolva o segundo maior valor de `numeros`.

# Entrada

Um `int[]` com pelo menos 2 elementos distintos.

# Saída esperada

Um `int` com o segundo maior valor.

# Exemplos

| numeros | retorno |
|---|---|
| `[3, 7, 2, 9, 4]` | `7` |
| `[5, 1]` | `1` |
| `[10, 20, 30]` | `20` |
| `[1, 2]` | `1` |

# Restrições

- Sem ordenar o array (nada de `Arrays.sort`).
- Um único laço sobre o array.

# Dicas

- No desafio 005 você manteve "atual" e "melhor". Aqui você precisa manter
  **dois** melhores: o maior e o segundo maior, os dois atualizados a cada
  passo.
- Quando um novo valor bate o recorde atual, o que acontece com o antigo
  recorde? E quando ele não bate o recorde, mas ainda assim é maior que o
  segundo lugar?

# Critérios de avaliação

- Todos os testes de `SegundoMaiorValorTest` passam
  (`mvn test -Dtest=SegundoMaiorValorTest`).
- Sem `Arrays.sort`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Acumular dois valores relacionados durante um único laço, atualizando os
dois a cada passo — mesma base do desafio 005, com um segundo candidato.

# Próximo desafio

Revisão de guardar o índice do maior valor, como no desafio 014 (que
guardava o índice do menor).

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- Array (`length`, índice)
- Acumular dois valores durante o laço
