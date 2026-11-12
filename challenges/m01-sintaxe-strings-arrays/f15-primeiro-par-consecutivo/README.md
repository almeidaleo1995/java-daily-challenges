> Antigo desafio 024 · Mundo 1, fase 15

# Nome

Primeiro Par Consecutivo

# Objetivo

Reforçar `charAt`/`length` comparando um caractere com o **anterior**,
mesma base do desafio 003, agora tomando uma decisão a cada comparação em
vez de só contar.

# Contexto

Você quer detectar erros de digitação simples: encontrar o primeiro par de
caracteres iguais que aparecem **um logo depois do outro** num texto (tipo
"aa" em "annaa").

# O que vamos trabalhar

Comparar um caractere com o **anterior** dentro do laço e **parar na primeira vez** que forem iguais — devolvendo o caractere ou lançando exceção se nunca acontecer.

# Na prática

Como cada comparação usa `i - 1`, pergunte-se: de qual posição o laço pode começar sem acessar um índice inválido? O que o método faz quando o laço termina sem achar nada?

# Glossário rápido

- **`return` dentro do laço** — encerra o método na hora.
- **`IndexOutOfBounds`** — erro ao acessar posição que não existe.
- **Exceção como "não achei"** — decisão de projeto desta fase (a alternativa seria um valor especial).

# Pesquise sobre

`java return dentro de for` · `java StringIndexOutOfBoundsException` · `java comparar char com anterior`

# Regras

Implemente o método:

```java
public static char primeiroConsecutivoRepetido(String texto)
```

na classe `challenges.m01.f15.PrimeiroParConsecutivo`.

- `texto` nunca é `null`.
- Devolva o caractere que aparece duas vezes **seguidas** pela primeira vez
  em `texto` (ou seja, `texto.charAt(i) == texto.charAt(i - 1)`).
- Se não existir nenhum par consecutivo igual, lance
  `IllegalArgumentException`.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `char` com o primeiro caractere repetido consecutivamente, ou uma
`IllegalArgumentException` se não houver nenhum.

# Exemplos

| texto | retorno |
|---|---|
| `"aabbcc"` | `'a'` |
| `"abcddef"` | `'d'` |
| `"abcdef"` | lança `IllegalArgumentException` |
| `""` | lança `IllegalArgumentException` |

# Restrições

- Sem regex.
- Percorra com `charAt`/`length`.

# Dicas

- Comece a comparação a partir do segundo caractere (índice 1), olhando
  sempre pra trás: `texto.charAt(i)` contra `texto.charAt(i - 1)`.
- Textos com menos de 2 caracteres nunca têm par consecutivo — pense nesse
  caso antes de montar o laço.

# Critérios de avaliação

- Todos os testes de `PrimeiroParConsecutivoTest` passam
  (`mvn test -Dtest=PrimeiroParConsecutivoTest`).
- Sem regex.
- Lança `IllegalArgumentException` quando não há par consecutivo.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`charAt`/`length` comparando cada posição com a anterior, e uso de
`IllegalArgumentException` pra sinalizar "não existe resposta válida" —
mesma base do desafio 003, com a validação do desafio 008.

# Próximo desafio

Revisão de `StringBuilder` e estado entre iterações, como no desafio 004.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `charAt()` / `length()`
- Comparação com o caractere anterior
- `IllegalArgumentException`
