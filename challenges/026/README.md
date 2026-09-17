# Nome

Colapsar Espaços

# Objetivo

Reforçar `StringBuilder` e estado entre iterações, como no desafio 004 —
dessa vez o estado é "o caractere anterior já era um espaço?".

# Contexto

Você recebe um texto digitado às pressas, com espaços repetidos entre
palavras, e quer normalizar pra sempre ter só um espaço entre cada uma.

# Regras

Implemente o método:

```java
public static String colapsar(String texto)
```

na classe `challenges.day026.ColapsarEspacos`.

- `texto` nunca é `null`, mas pode ser vazio.
- `texto` não tem espaços no início nem no fim.
- Devolva o texto com toda sequência de espaços consecutivos substituída
  por um único espaço.

# Entrada

Uma `String` não nula, sem espaços no início/fim.

# Saída esperada

Uma nova `String` sem espaços duplicados.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `""` |
| `"sem espaco"` | `"sem espaco"` |
| `"a   b  c"` | `"a b c"` |
| `"a  b"` | `"a b"` |
| `"a1  2b"` | `"a1 2b"` |
| `"oi!  tudo bem?"` | `"oi! tudo bem?"` |

# Restrições

- Sem regex, sem `String.replaceAll`.
- Use `StringBuilder` pra montar o resultado.
- Um único laço sobre o texto.

# Dicas

- Mesma ideia do desafio 004: guarde um estado entre iterações. Aqui o
  estado é um `boolean` — "o último caractere que eu coloquei no resultado
  já era um espaço?".
- Só acrescente um espaço no `StringBuilder` se o caractere atual for
  espaço **e** o estado disser que o anterior não era.

# Critérios de avaliação

- Todos os testes de `ColapsarEspacosTest` passam
  (`mvn test -Dtest=ColapsarEspacosTest`).
- Uso de `StringBuilder`, sem regex.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`StringBuilder` construindo uma `String` nova com estado sobre o caractere
anterior — mesma base do desafio 004, decidindo o que **não** incluir no
resultado.

# Próximo desafio

Revisão de `StringBuilder` com um `boolean` alternando a cada letra.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `StringBuilder`
- Estado entre iterações do laço (caractere anterior)
