# 11.01 — Busca Binária

**Missão:** Achar o índice de um valor num array ordenado sem varrer posição por posição.

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
