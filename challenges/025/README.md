# Nome

Capitalizar Palavras

# Objetivo

Reforçar `StringBuilder` e estado entre iterações, como no desafio 004 —
agora o estado é "a próxima letra começa uma palavra nova?".

# Contexto

Você recebe um texto todo em minúsculas e quer capitalizar a primeira letra
de cada palavra, deixando o resto minúsculo — como um corretor de "Título
De Texto" bem simples.

# Regras

Implemente o método:

```java
public static String capitalizar(String texto)
```

na classe `challenges.day025.CapitalizarPalavras`.

- `texto` nunca é `null`, mas pode ser vazio.
- `texto` não tem espaços no início, no fim, nem repetidos entre palavras.
- Palavras são separadas por um único espaço (`' '`).
- Devolva o texto com a primeira letra de cada palavra em maiúscula e todas
  as outras em minúscula.

# Entrada

Uma `String` não nula, sem espaços extras.

# Saída esperada

Uma nova `String` com cada palavra capitalizada.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `""` |
| `"ola"` | `"Ola"` |
| `"ola mundo"` | `"Ola Mundo"` |
| `"java e demais"` | `"Java E Demais"` |

# Restrições

- Sem regex, sem `String.split`.
- Use `StringBuilder` pra montar o resultado.
- Um único laço sobre o texto.

# Dicas

- Mesma ideia do desafio 004: guarde um estado entre iterações. Aqui, em
  vez de "caractere anterior e contagem", o estado é um `boolean`: "a letra
  atual é a primeira de uma palavra?".
- Esse `boolean` começa `true` (a primeira letra do texto sempre começa uma
  palavra) e vira `true` de novo toda vez que você encontra um espaço.
- `Character.toUpperCase()` e `Character.toLowerCase()` convertem um `char`
  sem precisar comparar com `'a'`/`'A'` manualmente.

# Critérios de avaliação

- Todos os testes de `CapitalizarPalavrasTest` passam
  (`mvn test -Dtest=CapitalizarPalavrasTest`).
- Uso de `StringBuilder`, sem regex nem `split`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`StringBuilder` construindo uma `String` nova com estado entre iterações —
dessa vez um `boolean` de controle, não um valor guardado do caractere
anterior.

# Próximo desafio

Revisão de `StringBuilder` com um estado diferente: colapsar espaços
repetidos.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `StringBuilder`
- Estado entre iterações do laço (`boolean` de controle)
