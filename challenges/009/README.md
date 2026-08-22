# Nome

Fila de Carregamento

# Objetivo

Conhecer as duas ordens de saída opostas — FIFO (fila) e LIFO (pilha) — e usar
as duas na mesma tarefa: um pedaço da fila sai invertido, o resto sai na
ordem em que chegou.

# Contexto

No centro de distribuição os pacotes chegam pela esteira, um atrás do outro, e
são carregados no caminhão nessa ordem. A regra mudou: os primeiros pacotes da
esteira são os que serão entregues **por último**, então precisam entrar
invertidos, pra ficarem no fundo do caminhão. Do pacote seguinte em diante,
tudo segue a ordem de chegada.

# Regras

Implemente o método:

```java
public static List<String> reordenar(List<String> pacotes, int primeiros)
```

na classe `challenges.day009.FilaDeCarregamento`.

- `pacotes` nunca é `null` e nunca contém `null`.
- `primeiros` diz quantos pacotes do começo da fila devem sair invertidos.
- Se `primeiros` for negativo ou maior que o tamanho de `pacotes`, lance
  `IllegalArgumentException`.
- Devolva uma **nova** `List<String>` com os `primeiros` pacotes em ordem
  invertida, seguidos pelos demais na ordem original.
- A lista recebida como parâmetro não pode ser modificada.
- Pode haver códigos repetidos.

# Entrada

Uma `List<String>` não nula e um `int`.

# Saída esperada

Uma nova `List<String>` com os pacotes na ordem de carregamento. Ou uma
`IllegalArgumentException`, se `primeiros` estiver fora do intervalo válido.

# Exemplos

| pacotes | primeiros | retorno |
|---|---|---|
| `["A", "B", "C", "D"]` | `2` | `["B", "A", "C", "D"]` |
| `["A", "B", "C", "D"]` | `4` | `["D", "C", "B", "A"]` |
| `["A", "B", "C"]` | `0` | `["A", "B", "C"]` |
| `["A"]` | `1` | `["A"]` |
| `["A", "A", "B"]` | `2` | `["A", "A", "B"]` |
| `[]` | `0` | `[]` |
| `["A", "B"]` | `3` | lança `IllegalArgumentException` |
| `["A", "B"]` | `-1` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Sem `Collections.reverse`, sem `List.subList`, sem `pacotes.get(i)` — nada
  de acesso por índice na lista de entrada.
- Use `Deque` (`ArrayDeque`) para as duas ordens. Não use `java.util.Stack`
  (classe legada, sincronizada à toa) nem `LinkedList`.
- Não modifique a `List` recebida como parâmetro.

# Dicas

- Se você guarda A, B, C numa estrutura e eles saem A, B, C, que ordem é essa?
  E se saem C, B, A? Dê nome às duas antes de escrever qualquer código.
- Um `ArrayDeque` faz os dois papéis, dependendo dos métodos que você chama:
  de um lado `offer`/`poll`, do outro `push`/`pop`. Olhe na documentação em
  que ponta cada um desses métodos mexe — é isso que muda a ordem de saída.
- Pense em duas etapas separadas: primeiro os `primeiros` pacotes, que
  precisam sair invertidos; depois o resto, que sai igual chegou. Qual
  estrutura serve cada etapa?
- Faça o teste no papel com `["A", "B", "C", "D"]` e `primeiros = 2` antes de
  codar. Anote o que entra e o que sai de cada estrutura, passo a passo.

# Critérios de avaliação

- Todos os testes de `FilaDeCarregamentoTest` passam
  (`mvn test -Dtest=FilaDeCarregamentoTest`).
- Nenhum uso de Streams, `Collections.reverse`, `subList` ou acesso por
  índice.
- `ArrayDeque` usado nos dois papéis (fila e pilha).
- Lança `IllegalArgumentException` para `primeiros` fora do intervalo.
- A lista recebida como parâmetro não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

A diferença entre FIFO e LIFO na prática, `Deque`/`ArrayDeque` nos dois
papéis (`offer`/`poll` vs `push`/`pop`), e validar um parâmetro numérico
contra o tamanho da entrada.

# Próximo desafio

Até aqui você sempre devolveu tipos que já vinham prontos: `int`, `String`,
`List`. O próximo desafio abre a fase 3 (POO) — em vez de uma lista de
códigos soltos, um tipo seu, que sabe o que é e o que pode responder.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
30 minutos

Conceitos:

- `Queue`/`Deque` e a ordem FIFO (`offer`, `poll`)
- `Deque` como pilha e a ordem LIFO (`push`, `pop`)
- Validar um parâmetro numérico contra o tamanho da entrada
