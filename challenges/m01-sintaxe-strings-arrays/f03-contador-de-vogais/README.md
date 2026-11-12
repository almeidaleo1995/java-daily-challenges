> Antigo desafio 003 · Mundo 1, fase 03

# Nome

Contador de Vogais

# Objetivo

Praticar percorrer uma `String` caractere por caractere com laço, usando os
métodos básicos da classe `String` e o tipo `char`.

# Contexto

Você está escrevendo um utilitário de texto que precisa contar quantas vogais
aparecem em uma palavra ou frase.

# O que vamos trabalhar

Percorrer uma `String` **caractere por caractere** e contar os que atendem uma regra.

# Na prática

Uma `String` é uma sequência de posições (`0`, `1`, `2`...). Você visita cada posição, olha o caractere e decide se conta. Pergunte-se: como acessar o caractere de uma posição? Como não se preocupar com maiúscula/minúscula?

# Glossário rápido

- **`String.length()` / `charAt(i)`** — tamanho do texto / caractere na posição `i` (começa em `0`).
- **`char`** — tipo de um único caractere (`'a'`, com aspas simples).
- **`toLowerCase()`** — devolve o texto em minúsculas.
- **Contador** — `int` que sobe `+1` a cada acerto.

# Pesquise sobre

`java String charAt length` · `java tipo char` · `java percorrer string com for`

# Regras

Implemente o método:

```java
public static int contarVogais(String texto)
```

na classe `challenges.m01.f03.ContadorVogais`.

- `texto` nunca é `null`, mas pode ser vazio.
- Vogais são `a`, `e`, `i`, `o`, `u`, maiúsculas ou minúsculas.
- Não há caracteres acentuados na entrada.
- Qualquer outro caractere (espaço, número, pontuação) não conta.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `int` com a quantidade de vogais encontradas.

# Exemplos

| texto | retorno |
|---|---|
| `""` | 0 |
| `"xyz"` | 0 |
| `"banana"` | 3 |
| `"AEIOU"` | 5 |
| `"Java e legal 123"` | 5 |

# Restrições

- Sem Streams, sem `replaceAll`, sem regex, sem `split`.
- Sem `String.contains` sobre a string inteira — a ideia é percorrer caractere
  a caractere.
- Só laço, `char` e comparações.

# Dicas

- Existe um método de `String` que devolve o tamanho e outro que devolve o
  caractere de uma posição específica. Como você combina os dois num `for`?
- Índices de `String` em Java começam em 0 e vão até `tamanho - 1`.
- Antes de comparar, pense em como neutralizar a diferença entre maiúscula e
  minúscula — a classe `Character` tem métodos úteis, e `String` também.
- O acumulador aqui funciona igual ao do desafio 002: uma variável que começa
  em 0 e cresce quando a condição bate.

# Critérios de avaliação

- Todos os testes de `ContadorVogaisTest` passam (`mvn test -Dtest=ContadorVogaisTest`).
- Percorre a `String` com laço, sem regex nem Streams.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Laços sobre `String`, tipo `char`, métodos `length()` e `charAt()`,
comparação de caracteres, acumulador.

# Próximo desafio

Continuamos em `String`, agora construindo uma nova string a partir da
original em vez de só contar.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- Laço sobre `String` (`length()` / `charAt()`)
- Tipo `char` e comparação de caracteres
- Acumulador
