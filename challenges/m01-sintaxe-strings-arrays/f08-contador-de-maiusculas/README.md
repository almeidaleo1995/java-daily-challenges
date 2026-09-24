> Antigo desafio 012 · Mundo 1, fase 08

# Nome

Contador de Maiúsculas

# Objetivo

Reforçar percorrer uma `String` caractere a caractere com `charAt`/`length`,
como no desafio 003.

# Contexto

Você precisa saber quantas letras maiúsculas existem num texto — por
exemplo, pra detectar se alguém digitou com Caps Lock ligado sem querer.

# Regras

Implemente o método:

```java
public static int contarMaiusculas(String texto)
```

na classe `challenges.m01.f08.ContadorMaiusculas`.

- `texto` nunca é `null`, mas pode ser vazio.
- Conte quantos caracteres de `texto` são letras maiúsculas (`A` a `Z`).
- Não há caracteres acentuados na entrada.
- Números, espaços e pontuação não contam.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `int` com a quantidade de letras maiúsculas.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `0` |
| `"abc"` | `0` |
| `"ABC"` | `3` |
| `"Java Challenges"` | `2` |
| `"AbC123"` | `2` |

# Restrições

- Sem regex.
- Percorra com `charAt`/`length`, igual ao desafio 003.

# Dicas

- Mesmo padrão do desafio 003: percorrer índice por índice com `charAt`,
  só muda a condição que você testa em cada caractere.
- Existe um método em `Character` que responde diretamente "esse caractere
  é maiúsculo?" — vale usar em vez de comparar manualmente com `'A'` e
  `'Z'`.

# Critérios de avaliação

- Todos os testes de `ContadorMaiusculasTest` passam
  (`mvn test -Dtest=ContadorMaiusculasTest`).
- Sem regex.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Percorrer uma `String` com `charAt`/`length`, testando uma condição por
caractere — mesma base do desafio 003, em outro contexto.

# Próximo desafio

Revisão de `StringBuilder` e estado entre iterações, como no desafio 004.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `charAt()` / `length()`
- `Character.isUpperCase()`
