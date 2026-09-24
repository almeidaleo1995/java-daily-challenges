# 11.04 — Par com Soma

**Missão:** Achar dois números num array ordenado cuja soma bate com um alvo, sem comparar todo par com todo par.

**Implemente:** `challenges.m11.f04.ParComSoma`

```java
public static int[] parComSoma(int[] ordenado, int somaAlvo)
```

**Regras**
- `ordenado` está em ordem crescente.
- Devolve `{i, j}` (índices, `i < j`) tal que `ordenado[i] + ordenado[j] == somaAlvo`. Se houver mais de um par, devolve o primeiro achado varrendo das pontas para o centro.
- Sem par que bata: devolve `new int[0]`.
- `ordenado` nulo, ou com menos de 2 elementos → `IllegalArgumentException`.
- Sem `Map`, sem comparar cada elemento com todos os outros (O(n²)): use dois ponteiros, um em cada ponta.

**Exemplos**

| `ordenado` | `somaAlvo` | Resultado |
|---|---|---|
| `[1,2,3,4,9]` | `10` | `[0,4]` (`1+9`) |
| `[1,2,3]` | `100` | `[]` |

<details><summary>Dica</summary>

Comece com `esquerda = 0` e `direita = length - 1`. Some os dois. Se a soma bateu, achou. Se a soma ficou menor que o alvo, o único jeito de aumentar é mover `esquerda` pra frente (array está ordenado). Se ficou maior, mova `direita` pra trás.

</details>

**Revisa:** array e índice (Mundo 1), busca binária (fase 11.01, mesma ideia de cortar o espaço de busca).
**Rodar:** `mvn test -Dtest=ParComSomaTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
