# Nome

Contador de Dígitos

# Objetivo

Reforçar `charAt`/`length` combinado com métodos de classificação de
`Character`, como no desafio 012 — dessa vez com `Character.isDigit()`.

# Contexto

Você quer saber quantos dígitos existem num texto — por exemplo, pra
validar se uma senha tem números suficientes.

# Regras

Implemente o método:

```java
public static int contarDigitos(String texto)
```

na classe `challenges.day040.ContadorDeDigitos`.

- `texto` nunca é `null`, mas pode ser vazio.
- Conte quantos caracteres de `texto` são dígitos (`0` a `9`).

# Entrada

Uma `String` não nula.

# Saída esperada

Um `int` com a quantidade de dígitos.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `0` |
| `"abc"` | `0` |
| `"abc123"` | `3` |
| `"1a2b3c"` | `3` |

# Restrições

- Sem regex.
- Percorra com `charAt`/`length`, igual ao desafio 012.

# Dicas

- Mesmo padrão do desafio 012: percorrer índice por índice com `charAt`,
  testando uma condição por caractere.
- Existe um método em `Character` que responde diretamente "esse caractere
  é um dígito?", sem comparar manualmente com `'0'` e `'9'`.

# Critérios de avaliação

- Todos os testes de `ContadorDeDigitosTest` passam
  (`mvn test -Dtest=ContadorDeDigitosTest`).
- Sem regex.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`charAt`/`length` com `Character.isDigit()` — mesma base do desafio 012,
com outro método de classificação.

# Próximo desafio

Revisão de `Character.isWhitespace()`, contando espaços num texto.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
15 minutos

Conceitos:

- `charAt()` / `length()`
- `Character.isDigit()`
