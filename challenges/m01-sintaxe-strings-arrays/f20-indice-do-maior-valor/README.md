> Antigo desafio 029 · Mundo 1, fase 20

# Nome

Índice do Maior Valor

# Objetivo

Reforçar guardar o índice em vez do valor, como no desafio 014 — lá era o
índice do **menor**, aqui é o índice do **maior**.

# Contexto

Você quer saber **onde** está o maior valor de um array, não só qual é o
valor — por exemplo, pra saber em qual posição do dia aconteceu o pico de
temperatura.

# Regras

Implemente o método:

```java
public static int indiceDoMaior(int[] numeros)
```

na classe `challenges.m01.f20.IndiceDoMaiorValor`.

- `numeros` tem pelo menos 1 posição.
- Devolva o índice do maior valor em `numeros`.
- Em caso de empate, devolva o índice da **primeira** ocorrência.

# Entrada

Um `int[]` com pelo menos 1 elemento.

# Saída esperada

Um `int` com o índice do maior valor.

# Exemplos

| numeros | retorno |
|---|---|
| `[3, 7, 2, 9, 4]` | `3` |
| `[5, 5, 5]` | `0` |
| `[1]` | `0` |
| `[9, 1, 2]` | `0` |

# Restrições

- Um único laço sobre o array.
- Sem `Arrays.sort`.

# Dicas

- Mesmo raciocínio do desafio 014, só que comparando pra achar o maior em
  vez do menor: guarde a **posição** do melhor valor visto até agora, não
  o valor em si — pra reler o valor, é só indexar o array nessa posição.
- Repare no desempate: qual comparação (`>` ou `>=`) garante que só o
  **primeiro** empatado fica registrado?

# Critérios de avaliação

- Todos os testes de `IndiceDoMaiorValorTest` passam
  (`mvn test -Dtest=IndiceDoMaiorValorTest`).
- Sem `Arrays.sort`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Guardar a posição do melhor valor em vez do valor em si, com desempate pela
primeira ocorrência — mesma base do desafio 014, buscando o máximo.

# Próximo desafio

Revisão de look-ahead comparando um elemento com o próximo, como no
desafio 013 (que era sobre `String`, agora é sobre array).

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- Array (`length`, índice)
- Guardar o índice em vez do valor
- Desempate com comparação estrita
