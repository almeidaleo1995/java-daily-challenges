> Antigo desafio 014 · Mundo 1, fase 10

# Nome

Índice do Menor Valor

# Objetivo

Reforçar percorrer um `int[]` guardando o melhor valor visto até agora,
como no desafio 005 — desta vez buscando um mínimo e devolvendo a
**posição**, não uma contagem.

# Contexto

Você recebe as leituras de um sensor e precisa saber **onde**, na
sequência, aconteceu a leitura mais baixa — não só qual foi o valor.

# Regras

Implemente o método:

```java
public static int indiceDoMenor(int[] numeros)
```

na classe `challenges.m01.f10.IndiceDoMenor`.

- `numeros` nunca é `null`.
- Se `numeros` estiver vazio, lance `IllegalArgumentException`.
- Devolva o **índice** da primeira ocorrência do menor valor em `numeros`.
- Os números podem ser negativos.
- Se o menor valor se repetir, devolva o índice da **primeira** vez que ele
  aparece.

# Entrada

Um `int[]` não nulo.

# Saída esperada

Um `int` com o índice do menor valor, ou uma `IllegalArgumentException` se
o array estiver vazio.

# Exemplos

| numeros | retorno |
|---|---|
| `{5, 3, 8, 1, 1}` | `3` |
| `{4}` | `0` |
| `{-2, -5, -5, 0}` | `1` |
| `{7, 7, 7}` | `0` |
| `{}` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams, sem `Arrays.sort`, sem `Arrays.stream(...).min()`.
- Percorra o array comparando cada posição com o melhor valor guardado até
  ali, igual ao desafio 005.

# Dicas

- Mesmo padrão do desafio 005: uma variável para o melhor valor visto e
  outra para a posição desse valor, as duas atualizadas juntas.
- A diferença de "estritamente menor" (`<`) para "menor ou igual"
  (`<=`) na comparação decide se um empate troca o índice guardado ou não —
  qual dos dois te dá a **primeira** ocorrência?

# Critérios de avaliação

- Todos os testes de `IndiceDoMenorTest` passam
  (`mvn test -Dtest=IndiceDoMenorTest`).
- Sem Streams nem `Arrays.sort`.
- Lança `IllegalArgumentException` para array vazio.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Percorrer um array guardando o melhor valor e sua posição ao mesmo tempo, e
decidir o critério de desempate certo pra "primeira ocorrência" — mesma
base do desafio 005 e do desempate do desafio 008.

# Próximo desafio

Revisão de `List`, `Set` e for-each, como no desafio 006.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- Array (`length`, índice)
- Acumular o melhor valor (e sua posição) durante o laço
- `IllegalArgumentException` para entrada vazia
