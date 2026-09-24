> Antigo desafio 008 · Mundo 2, fase 03

# Nome

Produto Mais Vendido

# Objetivo

Continuar em `Map` saindo de "quantas vezes cada valor apareceu" para "qual
valor apareceu mais vezes" — usar uma contagem para responder uma pergunta
nova, com uma regra de desempate.

# Contexto

Você já sabe contar quantas vezes cada produto foi vendido no dia (desafio
007). Agora o gerente quer só um número: o ID do produto que mais vendeu. Se
dois produtos empatarem em vendas, ele quer saber qual dos dois vendeu
primeiro no dia — isso desempata a decisão de qual produto ganha destaque na
vitrine.

# Regras

Implemente o método:

```java
public static int maisFrequente(List<Integer> numeros)
```

na classe `challenges.m02.f03.MaisFrequente`.

- `numeros` nunca é `null`.
- Se `numeros` estiver vazia, lance `IllegalArgumentException`.
- Devolva o valor que mais se repete em `numeros`.
- Em caso de empate (dois ou mais valores com a mesma maior frequência),
  devolva o que **apareceu primeiro** em `numeros`.
- A lista recebida como parâmetro não pode ser modificada.
- Os números podem ser negativos.

# Entrada

Uma `List<Integer>` não nula.

# Saída esperada

Um `int` com o valor que mais se repete, respeitando a regra de desempate.
Ou uma `IllegalArgumentException`, se a lista estiver vazia.

# Exemplos

| numeros | retorno |
|---|---|
| `[7]` | `7` |
| `[1, 2, 2, 3, 1, 1]` | `1` |
| `[5, 5, 5]` | `5` |
| `[1, 2, 3]` | `1` (empate total, `1` apareceu primeiro) |
| `[2, 1, 1, 2]` | `2` (empate entre `2` e `1`, `2` apareceu primeiro) |
| `[-1, 2, -1, 0]` | `-1` |
| `[]` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Sem `Collections.max` nem `Collections.frequency`.
- Percorra as Collections com for-each, sem usar índice.
- Não modifique a `List` recebida como parâmetro.

# Dicas

- Você já sabe montar um `Map` de valor → contagem (desafio 007). Depois de
  montado, falta achar a chave com a maior contagem.
- Pra respeitar a regra de desempate sem precisar de um `Map` que preserve
  ordem, pense em percorrer `numeros` de novo (não o `Map`) e comparar a
  contagem de cada número com a melhor contagem vista até agora. Em que
  situação exatamente você deve trocar o "campeão atual" pelo número da vez —
  só quando a contagem for maior, ou também quando for igual?
- Antes de decidir "qual é o maior", pense em como validar a lista vazia: o
  que essa pergunta significa quando não há nenhum valor pra comparar?

# Critérios de avaliação

- Todos os testes de `MaisFrequenteTest` passam
  (`mvn test -Dtest=MaisFrequenteTest`).
- Nenhum uso de Streams, `Collections.max` ou `Collections.frequency`.
- Lança `IllegalArgumentException` pra lista vazia.
- Em empate, respeita a ordem de primeira aparição.
- A lista recebida como parâmetro não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Usar um `Map` como etapa intermediária para responder uma pergunta diferente
da que ele guarda diretamente, definir uma regra de desempate e mantê-la
consistente, e validar entrada inválida lançando uma exceção.

# Próximo desafio

Depois de `List`, `Set` e `Map`, faltam duas Collections na fase: `Queue` e
`Stack`. O próximo desafio troca "qual valor tem mais peso" por "em que
ordem os elementos devem sair" — a fila e a pilha resolvem isso de jeitos
opostos.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
30 minutos

Conceitos:

- `Map` como etapa intermediária (contagem → busca do maior)
- Regra de desempate mantendo ordem de primeira aparição
- `IllegalArgumentException` pra validar entrada inválida
