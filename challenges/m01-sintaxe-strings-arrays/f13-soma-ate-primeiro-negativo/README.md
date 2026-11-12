> Antigo desafio 021 · Mundo 1, fase 13

# Nome

Soma Até Primeiro Negativo

# Objetivo

Reforçar `while` percorrendo um array com parada antecipada — uma variação
do desafio 002, agora sobre uma coleção de valores em vez de dígitos de um
único número.

# Contexto

Você está somando valores de um array, mas precisa parar assim que encontrar
o primeiro número negativo — ele funciona como um sinal de "fim dos dados
válidos" e não entra na soma.

# O que vamos trabalhar

**parada antecipada** — percorrer um array somando, mas interromper o laço ao achar um valor que sinaliza "fim dos dados".

# Na prática

O valor negativo **não entra** na soma, então a decisão de parar vem **antes** de somar. Pergunte-se: que condição do laço garante parar? Existe uma instrução que sai de um laço no meio (`break`)? Qual das duas formas lhe parece mais legível?

# Glossário rápido

- **`break`** — sai imediatamente do laço.
- **Condição composta no `while`** — `i < n && numeros[i] >= 0`.
- **Curto-circuito (`&&`)** — se a primeira condição é falsa, a segunda nem é avaliada (evita acessar índice inexistente).

# Pesquise sobre

`java break em laço` · `java curto-circuito && ||` · `java percorrer array com while`

# Regras

Implemente o método:

```java
public static int somarAtePrimeiroNegativo(int[] numeros)
```

na classe `challenges.m01.f13.SomaAtePrimeiroNegativo`.

- `numeros` nunca é `null`, mas pode ser vazio.
- Some os valores de `numeros` a partir do início, parando **antes** de
  somar o primeiro número negativo encontrado.
- Se não houver nenhum número negativo, some o array inteiro.
- Array vazio devolve `0`.

# Entrada

Um `int[]` não nulo.

# Saída esperada

Um `int` com a soma parcial.

# Exemplos

| numeros | retorno |
|---|---|
| `[1, 2, 3, -1, 5]` | `6` |
| `[4, 5, 6]` | `15` |
| `[]` | `0` |
| `[-1, 2, 3]` | `0` |

# Restrições

- Use `while`, sem `for`/`for-each` nem Streams.
- Não modifique o array recebido.

# Dicas

- Você já percorreu array com índice no desafio 005. A diferença aqui é a
  condição de parada: o laço não termina só quando o índice acaba, mas
  também quando encontra um negativo.
- Pense na condição do `while` como duas perguntas em `&&`: "ainda tem
  índice pra percorrer?" e "o valor atual ainda é válido?".

# Critérios de avaliação

- Todos os testes de `SomaAtePrimeiroNegativoTest` passam
  (`mvn test -Dtest=SomaAtePrimeiroNegativoTest`).
- Uso de `while`, sem Streams.
- O array recebido não é alterado.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`while` com condição de parada composta, combinando limite de índice e uma
regra sobre o valor — mesma base do desafio 005, com saída antecipada do
laço.

# Próximo desafio

Revisão de percorrer `String` caractere a caractere com `charAt`/`length`,
como no desafio 003.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `while`
- Array (`length`, índice)
- Parada antecipada de laço
