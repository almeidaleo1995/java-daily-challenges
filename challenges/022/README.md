# Nome

Contador de Consoantes

# Objetivo

Reforçar percorrer uma `String` caractere a caractere com `charAt`/`length`,
como nos desafios 003 e 012.

# Contexto

Você quer saber quantas consoantes existem num texto — por exemplo, pra
calcular estatísticas simples sobre um parágrafo.

# Regras

Implemente o método:

```java
public static int contarConsoantes(String texto)
```

na classe `challenges.day022.ContadorDeConsoantes`.

- `texto` nunca é `null`, mas pode ser vazio.
- Conte quantas letras de `texto` **não** são vogais (`a`, `e`, `i`, `o`,
  `u`), ignorando maiúsculas/minúsculas.
- Não há caracteres acentuados na entrada.
- Números, espaços e pontuação não contam como consoante.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `int` com a quantidade de consoantes.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `0` |
| `"aeiou"` | `0` |
| `"Java"` | `2` |
| `"banana"` | `3` |
| `"Ola Mundo!"` | `4` |

# Restrições

- Sem regex.
- Percorra com `charAt`/`length`, igual aos desafios 003 e 012.

# Dicas

- Mesmo padrão de sempre: percorrer índice por índice com `charAt`. O que
  muda é a condição — precisa ser letra **e** não pode ser vogal.
- `Character.isLetter()` ajuda a descartar espaço, pontuação e dígito antes
  de checar se é vogal.

# Critérios de avaliação

- Todos os testes de `ContadorDeConsoantesTest` passam
  (`mvn test -Dtest=ContadorDeConsoantesTest`).
- Sem regex.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Percorrer uma `String` com `charAt`/`length`, testando uma condição
composta por caractere — mesma base dos desafios 003 e 012.

# Próximo desafio

Revisão de `toCharArray()` e autoboxing `char` → `Character`, como no
desafio 016.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
15 minutos

Conceitos:

- `charAt()` / `length()`
- `Character.isLetter()`
