> Antigo desafio 006 · Mundo 2, fase 01

# Nome

Sem Repetidos

# Objetivo

Abrir a fase de Collections filtrando uma `List` para remover valores
repetidos, guardando o que já foi visto sem depender de índices nem de
percorrer o resultado inteiro a cada verificação.

# Contexto

Você recebe os IDs de cliente extraídos de um arquivo de log, na ordem em que
apareceram. IDs podem se repetir várias vezes ao longo do arquivo, mas você só
quer a lista de IDs distintos, na ordem da primeira vez que cada um apareceu.

# Regras

Implemente o método:

```java
public static List<Integer> semRepetidos(List<Integer> numeros)
```

na classe `challenges.m02.f01.SemRepetidos`.

- `numeros` nunca é `null`, mas pode ser vazia.
- Devolva uma nova `List<Integer>` com cada valor aparecendo **uma única
  vez**, na ordem da **primeira aparição** em `numeros`.
- A lista recebida como parâmetro não pode ser modificada.
- Os números podem ser negativos.

# Entrada

Uma `List<Integer>` não nula.

# Saída esperada

Uma nova `List<Integer>` sem valores repetidos, preservando a ordem da
primeira aparição de cada um.

# Exemplos

| numeros | retorno |
|---|---|
| `[]` | `[]` |
| `[1, 2, 3]` | `[1, 2, 3]` |
| `[1, 2, 2, 3, 1]` | `[1, 2, 3]` |
| `[5, 5, 5]` | `[5]` |
| `[-1, 2, -1, 0]` | `[-1, 2, 0]` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Percorra `numeros` com for-each, sem usar índice.
- Não modifique a `List` recebida como parâmetro.

# Dicas

- Pra montar o resultado na ordem certa, uma `List` resolve. Mas pra responder
  rápido "esse valor já apareceu antes?", existe uma Collection feita
  exatamente pra isso — pense em qual delas não permite duplicados.
- Você pode usar duas Collections ao mesmo tempo: uma só de apoio, pra
  lembrar o que já viu; outra é o resultado que você devolve.
- `for (int numero : numeros)` percorre a lista sem precisar de índice nem de
  `.get(i)` — é a forma idiomática de andar por uma `List`.

# Critérios de avaliação

- Todos os testes de `SemRepetidosTest` passam
  (`mvn test -Dtest=SemRepetidosTest`).
- Nenhum uso de Streams.
- A lista recebida como parâmetro não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Guardar e consultar dados com `List` e `Set` em vez de arrays e índices,
percorrer uma Collection com for-each, e decidir qual Collection usar de
acordo com a pergunta que ela precisa responder ("já vi isso?" vs "em que
ordem eu vi?").

# Próximo desafio

Seguimos em Collections trocando `Set` por `Map`: de "já vi esse valor?" para
"quantas vezes eu vi esse valor?".

---

Dificuldade:
⭐☆☆☆☆

Tempo:
20 minutos

Conceitos:

- `List` (criar, adicionar, devolver)
- `Set` (contains/add, sem duplicados)
- Iteração com for-each
