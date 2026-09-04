# Nome

Frequência de Caracteres

# Objetivo

Reforçar `toCharArray()` e autoboxing `char` → `Character`, como no desafio
016 — dessa vez contando ocorrências em vez de só percorrer.

# Contexto

Você quer saber quantas vezes cada caractere aparece num texto, na ordem em
que cada um apareceu pela primeira vez — útil pra montar um pequeno
histograma de letras.

# Regras

Implemente o método:

```java
public static Map<Character, Integer> frequencia(String texto)
```

na classe `challenges.day023.FrequenciaDeCaracteres`.

- `texto` nunca é `null`, mas pode ser vazio.
- Devolva um `Map<Character, Integer>` com a contagem de cada caractere de
  `texto`, na ordem da primeira aparição de cada um.
- Maiúscula e minúscula são caracteres diferentes.

# Entrada

Uma `String` não nula.

# Saída esperada

Um `Map<Character, Integer>` (chaves na ordem de primeira aparição) com a
contagem de cada caractere.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `{}` |
| `"aab"` | `{a=2, b=1}` |
| `"xyz"` | `{x=1, y=1, z=1}` |
| `"aA"` | `{a=1, A=1}` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Percorra com `toCharArray()`, igual ao desafio 016.
- Use `LinkedHashMap` pra preservar a ordem de primeira aparição.

# Dicas

- `for (char c : texto.toCharArray())` percorre a `String` sem `charAt`
  nem índice, mas cada `c` vira um `char` primitivo — pra usar como chave
  de `Map<Character, Integer>`, ele precisa ser boxado uma vez, exatamente
  como no desafio 016.
- Mesma lógica de contagem do desafio 007: um método de `Map` busca o valor
  atual da chave (ou um padrão) sem precisar testar `containsKey` na mão.

# Critérios de avaliação

- Todos os testes de `FrequenciaDeCaracteresTest` passam
  (`mvn test -Dtest=FrequenciaDeCaracteresTest`).
- Uso de `toCharArray()` e `LinkedHashMap`, sem Streams.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`toCharArray()` combinado com autoboxing `char` → `Character` e contagem
via `Map`/`getOrDefault` — juntando os desafios 016 e 007.

# Próximo desafio

Revisão de `charAt`/`length` numa comparação entre caracteres vizinhos.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `toCharArray()`
- Autoboxing `char` → `Character`
- `LinkedHashMap` / `getOrDefault`
