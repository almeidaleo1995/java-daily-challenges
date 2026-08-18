# Nome

Contador de Frequência

# Objetivo

Continuar a fase de Collections trocando `Set` por `Map`: sair de "já vi
esse valor?" para "quantas vezes eu vi esse valor?".

# Contexto

Você recebe os IDs de produto de todas as vendas do dia, na ordem em que
aconteceram. Antes você só queria saber quais produtos foram vendidos (sem
repetição). Agora o gerente quer mais: quantas unidades de cada produto
saíram.

# Regras

Implemente o método:

```java
public static Map<Integer, Integer> contarFrequencia(List<Integer> numeros)
```

na classe `challenges.day007.ContadorFrequencia`.

- `numeros` nunca é `null`, mas pode ser vazia.
- Devolva um `Map<Integer, Integer>` em que cada chave é um valor que
  apareceu em `numeros`, e o valor associado é **quantas vezes** ele
  apareceu.
- A ordem das chaves no `Map` não importa.
- A lista recebida como parâmetro não pode ser modificada.
- Os números podem ser negativos.

# Entrada

Uma `List<Integer>` não nula.

# Saída esperada

Um `Map<Integer, Integer>` com a contagem de ocorrências de cada valor.

# Exemplos

| numeros | retorno |
|---|---|
| `[]` | `{}` |
| `[1, 2, 3]` | `{1=1, 2=1, 3=1}` |
| `[1, 2, 2, 3, 1, 1]` | `{1=3, 2=2, 3=1}` |
| `[5, 5, 5]` | `{5=3}` |
| `[-1, 2, -1, 0]` | `{-1=2, 2=1, 0=1}` |

# Restrições

- Sem Streams (isso fica pra fase 4).
- Sem `Collections.frequency`.
- Percorra `numeros` com for-each, sem usar índice.
- Não modifique a `List` recebida como parâmetro.

# Dicas

- Um `Map<Integer, Integer>` guarda pares chave/valor. Pra cada número da
  lista, a chave é o número e o valor é a contagem dele até agora.
- Antes de somar 1 à contagem de um número, você precisa saber: essa é a
  primeira vez que ele aparece, ou já existe uma contagem guardada? Existe
  um método de `Map` que responde "essa chave já existe?" antes de você
  decidir o que colocar nela.
- Existe também um método que devolve o valor de uma chave, ou um valor
  padrão caso a chave ainda não exista — ele evita ter que testar
  `containsKey` na mão.

# Critérios de avaliação

- Todos os testes de `ContadorFrequenciaTest` passam
  (`mvn test -Dtest=ContadorFrequenciaTest`).
- Nenhum uso de Streams nem de `Collections.frequency`.
- A lista recebida como parâmetro não é alterada.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Guardar e consultar pares chave/valor com `Map`, decidir entre `get`,
`containsKey` e `getOrDefault`, e escolher `Map` em vez de `Set` quando a
pergunta muda de "já vi isso?" para "quantas vezes eu vi isso?".

# Próximo desafio

Ainda em Map: usar essa contagem pra responder uma pergunta nova — qual foi
o valor que mais se repetiu.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
25 minutos

Conceitos:

- `Map` (put, get, containsKey, getOrDefault)
- Contagem de ocorrências
- Iteração com for-each
