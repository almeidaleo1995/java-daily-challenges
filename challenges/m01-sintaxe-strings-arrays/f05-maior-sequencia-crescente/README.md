> Antigo desafio 005 · Mundo 1, fase 05

# Nome

Maior Sequência Crescente

# Objetivo

Fechar a fase de sintaxe percorrendo um `int[]`, comparando cada elemento com o
anterior e guardando o melhor resultado visto até agora — sem o apoio dos
métodos de `String`.

# Contexto

Você recebe a série de leituras de um sensor, na ordem em que foram medidas.
Quer saber qual foi o maior trecho em que o valor só subiu, leitura após
leitura, sem cair nem repetir. É o mesmo tipo de análise que um gráfico de
temperatura faz pra destacar "6 dias seguidos de alta".

# Regras

Implemente o método:

```java
public static int maiorSequencia(int[] numeros)
```

na classe `challenges.m01.f05.SequenciaCrescente`.

- `numeros` nunca é `null`, mas pode ser vazio.
- Devolva o **tamanho** (quantidade de elementos) do maior trecho de posições
  **consecutivas** em ordem **estritamente crescente**.
- Estritamente crescente: cada elemento é **maior** que o anterior. Valores
  iguais quebram a sequência (`{1, 1}` tem sequências de tamanho 1).
- Array vazio devolve `0`. Um único elemento devolve `1`.
- Os números podem ser negativos.
- Se houver empate, o tamanho é o mesmo — não importa qual trecho venceu.

# Entrada

Um `int[]` não nulo.

# Saída esperada

Um `int` com o tamanho da maior sequência crescente.

# Exemplos

| numeros | retorno |
|---|---|
| `{}` | `0` |
| `{5}` | `1` |
| `{1, 2, 3, 4}` | `4` |
| `{4, 3, 2, 1}` | `1` |
| `{1, 2, 1, 2, 3, 1}` | `3` |
| `{1, 1, 2}` | `2` |
| `{-3, -1, 0, -5, 7}` | `3` |

# Restrições

- Sem Streams, sem `Arrays.sort`, sem `Collections`, sem `List`.
- Sem recursão.
- Um único laço sobre o array.

# Dicas

- No desafio anterior você guardava estado entre iterações (o caractere atual e
  a contagem). Aqui é a mesma ideia, com uma variável a mais: além da contagem
  atual, você precisa lembrar da **melhor** contagem já vista.
- Comparar com o anterior significa que a primeira posição não tem com quem
  comparar. Pense se o laço começa em `0` ou em `1` — e o que isso muda no
  valor inicial das suas variáveis.
- Quando a sequência quebra, a contagem atual não vira `0`. O elemento que
  quebrou já é o começo de uma sequência nova.
- No desafio anterior o último bloco ficava em aberto no fim do laço. Aqui esse
  problema some se você atualizar a melhor contagem no lugar certo — decida se
  isso acontece a cada iteração ou só quando a sequência quebra.
- Array vazio é o caso que quebra a lógica de "começar com 1". Teste ele
  primeiro.

# Critérios de avaliação

- Todos os testes de `SequenciaCrescenteTest` passam
  (`mvn test -Dtest=SequenciaCrescenteTest`).
- Um único laço sobre o array, sem Streams nem ordenação.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Percorrer arrays com índice, `length`, comparação com o elemento anterior,
acumular um máximo enquanto percorre e tratar os casos de borda (vazio, um
elemento, sequência que termina no fim do array).

# Próximo desafio

Fim da fase de sintaxe. A partir daqui começam as Collections: `List`, `Map` e
`Set` — guardar e buscar dados sem depender de índices.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
30 minutos

Conceitos:

- Arrays (`length`, acesso por índice)
- Comparação com o elemento anterior
- Acumular um máximo durante o laço
