> Antigo desafio 001 · Mundo 1, fase 01

# Nome

Classificador de Número

# Objetivo

Praticar variáveis, operadores aritméticos/relacionais e estruturas
condicionais (`if`/`else`) em Java.

# Contexto

Você está construindo um pequeno utilitário que recebe um número inteiro e
descreve duas coisas sobre ele: o sinal e a paridade.

# O que vamos trabalhar

Decisões com `if`/`else` e operadores. O programa olha para um número e responde duas perguntas independentes: é positivo, negativo ou zero? É par ou ímpar?

# Na prática

São duas decisões separadas que viram duas partes de um texto. Pergunte-se: que operador diz o "resto" de uma divisão? Qual resto distingue par de ímpar? E o zero, é um caso à parte do resto das regras?

# Glossário rápido

- **`if` / `else`** — executa um trecho só se a condição for verdadeira.
- **Operador relacional (`>`, `<`, `==`)** — compara dois valores e dá `true` ou `false`.
- **`%` (resto)** — `7 % 2` é `1`; `8 % 2` é `0`.
- **Concatenação** — juntar textos com `+`.

# Pesquise sobre

`java if else exemplo` · `java operador módulo resto da divisão` · `java concatenar strings`

# Regras

Implemente o método:

```java
public static String classificar(int numero)
```

na classe `challenges.m01.f01.Classificador`.

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
