> Antigo desafio 034 · Mundo 2, fase 13

# Nome

Contador de Palavras

# Objetivo

Reforçar `Map` e `getOrDefault`, como no desafio 007 — mesma técnica,
contando palavras em vez de números.

# Contexto

Você recebe todas as palavras digitadas na busca de um site, na ordem em
que aconteceram, e quer saber quantas vezes cada palavra foi buscada.

# Regras

Implemente o método:

```java
public static Map<String, Integer> contarPalavras(List<String> palavras)
```

na classe `challenges.m02.f13.ContadorDePalavras`.

- `palavras` nunca é `null`, mas pode ser vazia.
- Devolva um `Map<String, Integer>` em que cada chave é uma palavra que
  apareceu em `palavras`, e o valor é quantas vezes ela apareceu.
- A ordem das chaves no `Map` não importa.
- A lista recebida não pode ser modificada.

# Entrada

Uma `List<String>` não nula.

# Saída esperada

Um `Map<String, Integer>` com a contagem de cada palavra.

# Exemplos

| palavras | retorno |
|---|---|
| `[]` | `{}` |
| `["java", "python", "java"]` | `{java=2, python=1}` |
| `["a", "a", "a"]` | `{a=3}` |

# Restrições

- Sem Streams (isso fica pra fase 4), sem `Collections.frequency`.
- Percorra `palavras` com for-each, sem índice.
- Não modifique a lista recebida.

# Dicas

- Exatamente o desafio 007, só que a chave agora é `String` em vez de
  `Integer`. O método que busca o valor atual (ou um padrão) funciona do
  mesmo jeito.

# Critérios de avaliação

- Todos os testes de `ContadorDePalavrasTest` passam
  (`mvn test -Dtest=ContadorDePalavrasTest`).
- Nenhum uso de Streams nem `Collections.frequency`.
- A lista recebida não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`Map`/`getOrDefault` contando ocorrências — mesma base do desafio 007, com
chave `String`.

# Próximo desafio

Revisão de `Map`/`getOrDefault` acumulando uma soma em vez de uma
contagem.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
15 minutos

Conceitos:

- `Map` (put, get, getOrDefault)
- Contagem de ocorrências
- Iteração com for-each
