# 11.01 — Busca Binária

**Missão:** Achar o índice de um valor num array ordenado sem varrer posição por posição.

**O que vamos trabalhar:** **busca binária** — em um array **ordenado**, olhar o meio, descartar a metade que não pode conter o alvo e repetir. Em vez de `n` passos, são cerca de `log₂ n`.

**Na prática:** o desafio é descobrir **como o intervalo onde o alvo ainda pode estar vai encolhendo**. Pergunte-se: que informação o elemento do meio me dá? O que eu posso descartar depois de olhar para ele? Quando o intervalo fica vazio, o que isso significa?

**Glossário rápido**
- **O(log n)** — o trabalho cresce devagar: dobrar o array só soma **1** passo.
- **Pré-condição** — a busca binária só funciona se o array estiver ordenado.
- **Intervalo de busca** — a faixa `[inicio, fim]` onde o alvo ainda pode estar.
- **Overflow no meio** — `(inicio + fim) / 2` pode estourar `int` em arrays enormes; `inicio + (fim - inicio) / 2` evita.

**Pesquise sobre:** `busca binária explicação` · `java busca binária iterativa` · `complexidade O(log n)`

**Implemente:** `challenges.m11.f01.BuscaBinaria`

```java
public static int indiceDe(int[] ordenado, int alvo)
```

**Regras**
- `ordenado` está em ordem crescente, sem repetidos.
- Devolve o índice de `alvo`, ou `-1` se não estiver no array.
- `ordenado` nulo → `IllegalArgumentException`.
- Nada de laço `for` varrendo posição por posição: corte o intervalo pela metade a cada passo (O(log n)).

**Exemplos**

| `ordenado` | `alvo` | Resultado |
|---|---|---|
| `[1,3,5,7,9,11,13]` | `7` | `3` |
| `[1,3,5,7,9,11,13]` | `6` | `-1` |

<details><summary>Dica</summary>

Mantenha `inicio` e `fim`. A cada volta, compare `alvo` com o elemento do meio: se for igual, achou; se for menor, o alvo só pode estar à esquerda (`fim = meio - 1`); se for maior, só pode estar à direita (`inicio = meio + 1`). Pare quando `inicio > fim`.

</details>

**Revisa:** array e índice (Mundo 1).
**Rodar:** `mvn test -Dtest=BuscaBinariaTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
