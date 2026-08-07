# Nome

Classificador de Número

# Objetivo

Praticar variáveis, operadores aritméticos/relacionais e estruturas
condicionais (`if`/`else`) em Java.

# Contexto

Você está construindo um pequeno utilitário que recebe um número inteiro e
descreve duas coisas sobre ele: o sinal e a paridade.

# Regras

Implemente o método:

```java
public static String classificar(int numero)
```

na classe `challenges.day001.Classificador`.

- Se `numero` for `0`, retorne exatamente `"zero"`.
- Caso contrário, retorne o sinal (`"positivo"` ou `"negativo"`) seguido de
  um espaço e da paridade (`"par"` ou `"ímpar"`).

# Entrada

Um número inteiro (`int`), podendo ser positivo, negativo ou zero.

# Saída esperada

Uma `String` no formato descrito em Regras.

# Exemplos

| numero | retorno |
|---|---|
| 4 | `"positivo par"` |
| -7 | `"negativo ímpar"` |
| 0 | `"zero"` |
| -10 | `"negativo par"` |
| 3 | `"positivo ímpar"` |

# Restrições

- Sem bibliotecas externas.
- Sem laços de repetição (não são necessários aqui).
- A ordem das palavras no retorno importa: sinal primeiro, paridade depois.

# Dicas

- O operador `%` (módulo) ajuda a descobrir se um número é par ou ímpar.
- Cuidado com números negativos: o resultado de `%` em Java pode te
  surpreender se você não conferir o que ele retorna para negativos.
- Pense em quantas comparações você realmente precisa fazer antes de montar
  a `String` final.

# Critérios de avaliação

- Todos os testes de `ClassificadorTest` passam (`mvn test -Dtest=ClassificadorTest`).
- Código formatado (`mvn spotless:apply` sem alterações pendentes).
- Sem usar loops nem arrays — só variáveis, operadores e condicionais.

# O que estou praticando

Variáveis, operadores aritméticos e relacionais, operador módulo (`%`),
estruturas condicionais (`if`/`else`), retorno de métodos, Strings.

# Próximo desafio

Vamos evoluir para estruturas de repetição (loops), construindo em cima dos
operadores e condicionais que você praticou aqui.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
20 minutos

Conceitos:

- Variáveis
- Operadores (aritméticos, relacionais, módulo)
- Condicionais if/else
- Strings
