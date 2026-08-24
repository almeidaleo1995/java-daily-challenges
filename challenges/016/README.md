# Nome

Frequência de Caracteres

# Objetivo

Reforçar `Map` e `getOrDefault`, como no desafio 007 — agora contando
caracteres de uma `String` em vez de valores de uma `List`.

# Contexto

Você quer saber quantas vezes cada caractere aparece num texto — inclusive
espaços e pontuação —, por exemplo pra montar um contador de frequência
usado em compressão de texto.

# Regras

Implemente o método:

```java
public static Map<Character, Integer> contarCaracteres(String texto)
```

na classe `challenges.day016.ContadorDeCaracteres`.

- `texto` nunca é `null`, mas pode ser vazio.
- Devolva um `Map<Character, Integer>` em que cada chave é um caractere que
  apareceu em `texto`, e o valor associado é quantas vezes ele apareceu.
- Maiúscula e minúscula são caracteres diferentes.
- Espaços e pontuação contam como qualquer outro caractere.
- A ordem das chaves no `Map` não importa.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `Map<Character, Integer>` com a frequência de cada caractere.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `{}` |
| `"aab"` | `{a=2, b=1}` |
| `"Java"` | `{J=1, a=2, v=1}` |
| `"a a"` | `{a=2, ' '=1}` |

# Restrições

- Sem Streams.
- Use `getOrDefault`, igual ao desafio 007.

# Dicas

- Mesmo padrão do desafio 007: pra cada elemento, busque a contagem atual
  com `getOrDefault` e guarde de volta somando 1 — só que agora o elemento
  é um `char`, não um `Integer` da lista.
- `Map<Character, Integer>` — não esqueça de colocar `char` numa variável
  ou parâmetro `Character` corretamente (autoboxing cuida disso pra você).

# Critérios de avaliação

- Todos os testes de `ContadorDeCaracteresTest` passam
  (`mvn test -Dtest=ContadorDeCaracteresTest`).
- Uso de `getOrDefault`, sem Streams.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`Map`/`getOrDefault` contando ocorrências, aplicado a caracteres de uma
`String` — mesma base do desafio 007.

# Próximo desafio

Revisão de `LinkedHashMap`, `entrySet` e desempate, como no desafio 008.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `Map`/`HashMap`
- `getOrDefault`
- Percorrer uma `String` acumulando num `Map`
