> Antigo desafio 042 · Mundo 1, fase 24

# Nome

Índice Primeira Minúscula

# Objetivo

Reforçar `charAt`/`length` combinado com classificação de `Character`,
como no desafio 012 — dessa vez buscando uma posição, com validação por
exceção, como no desafio 008.

# Contexto

Você quer encontrar a posição da primeira letra minúscula de um texto — por
exemplo, pra checar se um código de identificação começa só com maiúsculas
e onde a primeira exceção aparece.

# O que vamos trabalhar

Buscar uma **posição** em texto e usar **exceção** quando não há resultado (mesma ideia da fase 1.10, agora em `String`).

# Na prática

O laço percorre os caracteres e, ao achar a primeira minúscula, devolve o índice na hora. Pergunte-se: o que o método faz se o laço terminar sem achar? Por que lançar exceção é melhor aqui do que devolver `-1`?

# Glossário rápido

- **`Character.isLowerCase`** — `true` para minúsculas.
- **Valor especial (`-1`)** vs **exceção** — duas formas de dizer "não achei"; o enunciado escolhe a exceção.
- **Fail fast** — falhar logo, de forma clara, em vez de seguir com dado inválido.

# Pesquise sobre

`java Character isLowerCase` · `java IllegalArgumentException vs retornar -1` · `java return em laço`

# Regras

Implemente o método:

```java
public static int indicePrimeiraMinuscula(String texto)
```

na classe `challenges.m01.f24.IndicePrimeiraMinuscula`.

- `texto` nunca é `null`.
- Devolva o índice da primeira letra minúscula de `texto`.
- Se não houver nenhuma letra minúscula, lance `IllegalArgumentException`.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `int` com o índice da primeira letra minúscula, ou uma
`IllegalArgumentException` se não houver nenhuma.

# Exemplos

| texto | retorno |
|---|---|
| `"ABCdEF"` | `3` |
| `"aBC"` | `0` |
| `"ABC"` | lança `IllegalArgumentException` |
| `""` | lança `IllegalArgumentException` |

# Restrições

- Sem regex.
- Percorra com `charAt`/`length`.

# Dicas

- Mesmo padrão do desafio 012: percorrer índice por índice testando uma
  condição por caractere, com `Character.isLowerCase()`.
- Assim que encontrar a primeira letra minúscula, o que você já pode
  devolver? Não precisa continuar percorrendo o resto do texto.
- Se o laço terminar sem nunca satisfazer a condição, é hora de lançar a
  exceção — igual ao desafio 008 fazia com a lista vazia.

# Critérios de avaliação

- Todos os testes de `IndicePrimeiraMinusculaTest` passam
  (`mvn test -Dtest=IndicePrimeiraMinusculaTest`).
- Sem regex.
- Lança `IllegalArgumentException` quando não há letra minúscula.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`charAt`/`length` com `Character.isLowerCase()`, parando no primeiro
acerto e usando `IllegalArgumentException` pra sinalizar "não existe
resposta válida" — juntando os desafios 012 e 008.

# Próximo desafio

Um desafio maior, juntando várias dessas revisões dentro de uma classe com
estado.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `charAt()` / `length()`
- `Character.isLowerCase()`
- `IllegalArgumentException`
