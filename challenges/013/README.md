# Nome

Removedor de Repetidos Consecutivos

# Objetivo

Reforçar `StringBuilder` mantendo estado entre iterações do laço (o
caractere anterior), como no desafio 004 — desta vez removendo repetições
em vez de contá-las.

# Contexto

Você recebe um texto onde, por erro de digitação, algumas letras se
repetiram seguidas (`"aaabccca"`). Quer devolver o texto com cada sequência
de caracteres iguais e consecutivos reduzida a um único caractere.

# Regras

Implemente o método:

```java
public static String removerConsecutivosRepetidos(String texto)
```

na classe `challenges.day013.RemovedorDeRepetidos`.

- `texto` nunca é `null`, mas pode ser vazio.
- Cada sequência de caracteres iguais e **consecutivos** vira um único
  caractere.
- Só sequências consecutivas contam: `"aabbaa"` vira `"aba"`, não `"ab"`.
- Maiúscula e minúscula são caracteres diferentes: `"aA"` continua `"aA"`.
- Texto vazio devolve texto vazio.

# Entrada

Uma `String` não nula.

# Saída esperada

Uma nova `String` sem repetições consecutivas.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `""` |
| `"abc"` | `"abc"` |
| `"aaabccca"` | `"abca"` |
| `"aabbaa"` | `"aba"` |
| `"aA"` | `"aA"` |
| `"aaaa"` | `"a"` |

# Restrições

- Sem regex, sem recursão.
- Use `StringBuilder`, igual ao desafio 004.

# Dicas

- Mesmo raciocínio do desafio 004: guarde o caractere anterior numa
  variável que sobrevive entre as voltas do laço.
- A diferença pro desafio 004 é o que você faz quando o caractere atual é
  igual ao anterior: lá você contava, aqui você simplesmente ignora.

# Critérios de avaliação

- Todos os testes de `RemovedorDeRepetidosTest` passam
  (`mvn test -Dtest=RemovedorDeRepetidosTest`).
- Uso de `StringBuilder`, sem regex.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`StringBuilder` construindo uma nova `String` a partir de outra, mantendo
estado (o caractere anterior) entre as iterações do laço.

# Próximo desafio

Revisão de percorrer array guardando o melhor valor visto até agora, como
no desafio 005.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- `StringBuilder`
- Estado entre iterações (caractere anterior)
