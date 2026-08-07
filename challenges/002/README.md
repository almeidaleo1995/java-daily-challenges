# Nome

Soma dos Dígitos

# Objetivo

Praticar laços de repetição (`while` ou `for`), reaproveitando os
operadores `%` e `/` que você já usou no desafio 001, agora aplicados
repetidamente.

# Contexto

Você está construindo um utilitário que recebe um número inteiro e retorna
a soma dos seus dígitos.

# Regras

Implemente o método:

```java
public static int somarDigitos(int numero)
```

na classe `challenges.day002.SomaDigitos`.

- `numero` é sempre maior ou igual a zero.
- O retorno é a soma de todos os dígitos de `numero`.

# Entrada

Um número inteiro não negativo (`int >= 0`).

# Saída esperada

Um `int` com a soma dos dígitos.

# Exemplos

| numero | retorno |
|---|---|
| 0 | 0 |
| 5 | 5 |
| 123 | 6 |
| 9999 | 36 |
| 1020 | 3 |

# Restrições

- Não converta o número para `String` (nada de `numero + ""`, `charAt`,
  `split`, etc.) — resolva só com aritmética.
- Sem arrays.
- Sem recursão.

# Dicas

- Você já sabe pegar o último dígito de um número (usou `%` no desafio 001).
- Depois de usar um dígito, como você "descarta" ele pra expor o próximo?
  Pensa no operador de divisão inteira (`/`).
- `while` é uma boa escolha quando você não sabe de antemão quantas vezes
  vai repetir — a condição de parada aqui é o número "acabar".

# Critérios de avaliação

- Todos os testes de `SomaDigitosTest` passam (`mvn test -Dtest=SomaDigitosTest`).
- Não usa conversão para `String`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Laços de repetição (`while`/`for`), acumuladores, condição de parada de
loop, operador módulo e divisão inteira.

# Próximo desafio

Vamos continuar em laços, agora percorrendo caracteres de uma `String`.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- Laços de repetição (while/for)
- Acumuladores
- Operador módulo e divisão inteira
