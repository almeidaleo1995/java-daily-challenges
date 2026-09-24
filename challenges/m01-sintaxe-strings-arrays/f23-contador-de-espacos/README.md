> Antigo desafio 041 · Mundo 1, fase 23

# Nome

Contador de Espaços

# Objetivo

Reforçar `charAt`/`length` combinado com métodos de classificação de
`Character`, como no desafio 012 — dessa vez com `Character.isWhitespace()`.

# Contexto

Você quer saber quantos espaços em branco existem num texto — por exemplo,
pra estimar quantas palavras ele tem sem usar `split`.

# Regras

Implemente o método:

```java
public static int contarEspacos(String texto)
```

na classe `challenges.m01.f23.ContadorDeEspacos`.

- `texto` nunca é `null`, mas pode ser vazio.
- Conte quantos caracteres de `texto` são espaço em branco (`Character.isWhitespace`).

# Entrada

Uma `String` não nula.

# Saída esperada

Um `int` com a quantidade de espaços em branco.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `0` |
| `"semespaco"` | `0` |
| `"ola mundo"` | `1` |
| `"a  b   c"` | `4` |

# Restrições

- Sem regex, sem `String.split`.
- Percorra com `charAt`/`length`, igual ao desafio 012.

# Dicas

- Mesmo padrão do desafio 012 e do 040: percorrer índice por índice,
  testando uma condição por caractere.
- `Character.isWhitespace()` cobre espaço, tab e outros caracteres em
  branco — não precisa comparar só com `' '`.

# Critérios de avaliação

- Todos os testes de `ContadorDeEspacosTest` passam
  (`mvn test -Dtest=ContadorDeEspacosTest`).
- Sem regex nem `split`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`charAt`/`length` com `Character.isWhitespace()` — mesma base do desafio
012, com outro método de classificação.

# Próximo desafio

Revisão de `Character.isLowerCase()` combinado com busca de índice e
exceção.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
15 minutos

Conceitos:

- `charAt()` / `length()`
- `Character.isWhitespace()`
