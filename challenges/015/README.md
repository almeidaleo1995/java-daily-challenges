# Nome

Elementos Repetidos

# Objetivo

Reforçar `List`, `Set` e for-each, como no desafio 006 — desta vez
guardando quem **repete**, em vez de quem é único.

# Contexto

Você recebe os IDs de cliente extraídos de um log, na ordem em que
apareceram. Agora você quer saber quais IDs apareceram **mais de uma
vez** — útil pra detectar duplicidade de cadastro.

# Regras

Implemente o método:

```java
public static List<Integer> repetidos(List<Integer> numeros)
```

na classe `challenges.day015.ElementosRepetidos`.

- `numeros` nunca é `null`, mas pode ser vazia.
- Devolva uma nova `List<Integer>` com cada valor que aparece **mais de uma
  vez** em `numeros`, cada um aparecendo **uma única vez** no resultado.
- A ordem do resultado é a ordem em que cada valor foi **percebido como
  repetido** — ou seja, a ordem da sua **segunda** aparição em `numeros`,
  não da primeira.
- A lista recebida como parâmetro não pode ser modificada.
- Os números podem ser negativos.

# Entrada

Uma `List<Integer>` não nula.

# Saída esperada

Uma nova `List<Integer>` só com os valores repetidos, na ordem da segunda
aparição de cada um.

# Exemplos

| numeros | retorno |
|---|---|
| `[1, 2, 3, 2, 1, 4]` | `[2, 1]` |
| `[1, 2, 3]` | `[]` |
| `[]` | `[]` |
| `[5, 5, 5]` | `[5]` |
| `[1, 1, 2, 2]` | `[1, 2]` |

# Restrições

- Sem Streams.
- Use `List` para o resultado e `Set` para controlar o que já foi visto,
  igual ao desafio 006.
- Não modifique a `List` recebida como parâmetro.

# Dicas

- Você precisa lembrar de duas coisas diferentes ao longo do laço: "já vi
  esse valor antes?" e "já coloquei esse valor no resultado?". Cada
  pergunta pode precisar da sua própria estrutura.
- Pense em `[5, 5, 5]`: o valor repete duas vezes (na 2ª e na 3ª aparição),
  mas só entra **uma vez** no resultado — o que evita que ele entre de
  novo na terceira aparição?

# Critérios de avaliação

- Todos os testes de `ElementosRepetidosTest` passam
  (`mvn test -Dtest=ElementosRepetidosTest`).
- Sem Streams.
- A lista recebida como parâmetro não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`List` e `Set` trabalhando juntos, cada um guardando uma pergunta
diferente sobre o mesmo dado — mesma base do desafio 006.

# Próximo desafio

Revisão de `Map` e `getOrDefault`, como no desafio 007.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `List` e `Set` (ou `HashSet`)
- for-each
- Duas estruturas guardando duas perguntas diferentes sobre o mesmo dado
