# Nome

Valores Comuns

# Objetivo

Reforçar `List`, `Set` e for-each, como no desafio 006 — dessa vez
comparando **duas** listas em vez de filtrar uma só.

# Contexto

Você tem duas listas de IDs de cliente (por exemplo, clientes de duas
campanhas de marketing diferentes) e quer saber quais IDs aparecem nas
**duas**, sem repetir nenhum no resultado.

# Regras

Implemente o método:

```java
public static List<Integer> comuns(List<Integer> a, List<Integer> b)
```

na classe `challenges.day031.ValoresComuns`.

- `a` e `b` nunca são `null`, mas podem ser vazias.
- Devolva uma nova `List<Integer>` com os valores que aparecem em **ambas**
  as listas, sem repetição, na ordem em que aparecem em `a`.
- Nenhuma das listas recebidas pode ser modificada.

# Entrada

Duas `List<Integer>` não nulas.

# Saída esperada

Uma nova `List<Integer>` com a interseção, sem duplicados.

# Exemplos

| a | b | retorno |
|---|---|---|
| `[1, 2, 3, 4]` | `[3, 4, 5]` | `[3, 4]` |
| `[1, 1, 2]` | `[1, 3]` | `[1]` |
| `[]` | `[1, 2]` | `[]` |
| `[1, 2]` | `[]` | `[]` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Percorra as listas com for-each, sem índice.
- Não modifique `a` nem `b`.

# Dicas

- Você precisa responder rápido "esse valor de `a` também está em `b`?" —
  qual `Collection` do desafio 006 resolve bem essa pergunta, e o que ela
  ganha se você primeiro colocar `b` inteira dentro dela?
- Pra não repetir um valor no resultado mesmo que ele apareça várias vezes
  em `a`, você também precisa lembrar o que já colocou na `List` final.

# Critérios de avaliação

- Todos os testes de `ValoresComunsTest` passam
  (`mvn test -Dtest=ValoresComunsTest`).
- Nenhum uso de Streams.
- `a` e `b` não são alteradas.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`Set` respondendo "isso já existe?" pra duas coleções ao mesmo tempo, e
`List` guardando o resultado na ordem certa — mesma base do desafio 006,
com duas entradas em vez de uma.

# Próximo desafio

Revisão de `List`/`Set`, devolvendo só os valores que aparecem exatamente
uma vez.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `List` (criar, adicionar, devolver)
- `Set` (contains/add)
- Iteração com for-each
