> Antigo desafio 032 · Mundo 2, fase 11

# Nome

Apenas Únicos

# Objetivo

Reforçar `List`, `Set` e for-each, como no desafio 006 — dessa vez
devolvendo só os valores que aparecem **exatamente uma vez**, não os
distintos.

# Contexto

Você recebe os códigos de produto de todas as vendas do dia e quer saber
quais produtos venderam **uma única unidade** — candidatos a "baixo giro",
diferente de saber só quais produtos venderam (isso já é o desafio 006).

# Regras

Implemente o método:

```java
public static List<Integer> apenasUnicos(List<Integer> numeros)
```

na classe `challenges.m02.f11.ApenasUnicos`.

- `numeros` nunca é `null`, mas pode ser vazia.
- Devolva uma nova `List<Integer>` com os valores que aparecem **exatamente
  uma vez** em `numeros`, na ordem em que aparecem.
- A lista recebida não pode ser modificada.

# Entrada

Uma `List<Integer>` não nula.

# Saída esperada

Uma nova `List<Integer>` só com os valores que não se repetem.

# Exemplos

| numeros | retorno |
|---|---|
| `[]` | `[]` |
| `[1, 2, 2, 3, 4, 4, 5]` | `[1, 3, 5]` |
| `[1, 1, 1]` | `[]` |
| `[5]` | `[5]` |

# Restrições

- Sem Streams (isso fica pra fase 4), sem `Map`.
- Percorra `numeros` com for-each, sem índice.
- Não modifique a lista recebida como parâmetro.

# Dicas

- Você não precisa contar quantas vezes cada valor aparece — só precisa
  saber "esse valor já apareceu antes?" e, se sim, "ele já apareceu **mais
  de uma vez**?". Dois `Set` resolvem isso sem precisar de `Map`: um
  guarda tudo que já foi visto, outro guarda o que já foi visto **de
  novo**.
- No final, um valor é "único" se ele está no primeiro `Set` mas não está
  no segundo.

# Critérios de avaliação

- Todos os testes de `ApenasUnicosTest` passam
  (`mvn test -Dtest=ApenasUnicosTest`).
- Nenhum uso de Streams nem `Map`.
- A lista recebida não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Usar mais de um `Set` ao mesmo tempo pra responder perguntas diferentes
sobre os mesmos dados ("já vi?" vs "já vi de novo?") — mesma base do
desafio 006, com uma regra de filtro mais específica.

# Próximo desafio

Revisão de `List`/`Set`, filtrando uma lista pelo que **não** está num
conjunto de exclusão.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `List` (criar, adicionar, devolver)
- `Set` (contains/add)
- Iteração com for-each
