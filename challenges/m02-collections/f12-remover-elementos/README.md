> Antigo desafio 033 · Mundo 2, fase 12

# Nome

Remover Elementos

# Objetivo

Reforçar `List`, `Set` e for-each, como no desafio 006 — dessa vez usando
um `Set` como lista de exclusão em vez de detector de duplicados.

# Contexto

Você tem uma lista de IDs e uma lista de bloqueio (IDs banidos) e quer uma
nova lista só com os IDs que **não** estão bloqueados, mantendo a ordem e
qualquer repetição que já existisse.

# Regras

Implemente o método:

```java
public static List<Integer> remover(List<Integer> numeros, Set<Integer> paraRemover)
```

na classe `challenges.m02.f12.RemoverElementos`.

- `numeros` e `paraRemover` nunca são `null`, mas podem ser vazios.
- Devolva uma nova `List<Integer>` com os elementos de `numeros` que
  **não** estão em `paraRemover`, preservando ordem e repetições.
- Nem `numeros` nem `paraRemover` podem ser modificados.

# Entrada

Uma `List<Integer>` e um `Set<Integer>`, ambos não nulos.

# Saída esperada

Uma nova `List<Integer>` filtrada.

# Exemplos

| numeros | paraRemover | retorno |
|---|---|---|
| `[1, 2, 3, 2, 4]` | `{2, 4}` | `[1, 3]` |
| `[]` | `{1}` | `[]` |
| `[1, 2]` | `{}` | `[1, 2]` |
| `[5, 5, 6]` | `{6}` | `[5, 5]` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Percorra `numeros` com for-each, sem índice.
- Não modifique `numeros` nem `paraRemover`.

# Dicas

- Diferente do desafio 006, aqui o `Set` não guarda o que você já viu —
  ele já vem pronto, como uma lista de exclusão. A pergunta por elemento é
  só "esse valor está no `Set`?".
- Repare que a saída pode ter repetição (`[5, 5]` no exemplo) — você não
  está removendo duplicados, só filtrando pelo `Set`.

# Critérios de avaliação

- Todos os testes de `RemoverElementosTest` passam
  (`mvn test -Dtest=RemoverElementosTest`).
- Nenhum uso de Streams.
- `numeros` e `paraRemover` não são alterados.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`Set.contains()` como filtro sobre uma `List`, mantendo repetições — mesma
base do desafio 006, usando o `Set` de um jeito diferente (exclusão em vez
de detecção de duplicado).

# Próximo desafio

Revisão de `Map` e `getOrDefault`, contando palavras em vez de números.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
15 minutos

Conceitos:

- `List` (criar, adicionar, devolver)
- `Set` (contains)
- Iteração com for-each
