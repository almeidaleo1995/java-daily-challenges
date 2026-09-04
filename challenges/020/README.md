# Nome

Divisões Por Dois

# Objetivo

Reforçar `do-while`, como no desafio 011: um laço que precisa rodar **pelo
menos uma vez**, mesmo quando a condição de parada já começa satisfeita.

# Contexto

Você quer saber quantas vezes um número pode ser dividido por 2 (divisão
inteira) até chegar a 0. Mesmo um número que já é 0 conta como 1 divisão —
você "divide" o 0 e confirma que já chegou lá.

# Regras

Implemente o método:

```java
public static int contarDivisoesAteZero(int numero)
```

na classe `challenges.day020.DivisoesPorDois`.

- `numero` nunca é negativo.
- Conte quantas divisões inteiras por 2 são necessárias até `numero` chegar
  a 0.
- Mesmo que `numero` já seja 0, conte pelo menos 1 divisão.

# Entrada

Um `int` não negativo.

# Saída esperada

Um `int` com a quantidade de divisões.

# Exemplos

| numero | retorno |
|---|---|
| `0` | `1` |
| `1` | `1` |
| `5` | `3` |
| `8` | `4` |

# Restrições

- Use `do-while`.
- Sem recursão, sem `Math.*`.

# Dicas

- Se você usar um `while (numero != 0)` puro, o caso `numero == 0` nunca
  entra no laço e a contagem fica errada. Que tipo de laço garante que o
  corpo roda pelo menos uma vez, e só depois checa se deve continuar?
- Mesma ideia do desafio 011: divida, conte, e só então pergunte "ainda não
  chegou a 0?".

# Critérios de avaliação

- Todos os testes de `DivisoesPorDoisTest` passam
  (`mvn test -Dtest=DivisoesPorDoisTest`).
- Uso de `do-while`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`do-while` num caso onde o corpo do laço precisa rodar mesmo quando a
condição de parada já começa verdadeira — mesma base do desafio 011.

# Próximo desafio

Revisão de `while` percorrendo um array com parada antecipada.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `do-while`
