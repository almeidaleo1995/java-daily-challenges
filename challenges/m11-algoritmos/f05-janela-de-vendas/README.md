# 11.05 — Janela de Vendas

**Missão:** Achar a maior soma de `tamanhoJanela` dias seguidos de vendas, sem somar o intervalo inteiro de novo a cada posição.

**Implemente:** `challenges.m11.f05.JanelaDeslizante`

```java
public static int maiorSomaJanela(int[] vendas, int tamanhoJanela)
```

**Regras**
- `tamanhoJanela` menor ou igual a zero, ou maior que `vendas.length` → `IllegalArgumentException`.
- `vendas` nulo → `IllegalArgumentException`.
- Devolve a maior soma entre todas as janelas de `tamanhoJanela` posições consecutivas.
- O(n): calcule a soma da primeira janela uma vez, depois deslize — a cada passo, some o elemento que entra e subtraia o que sai. Não some a janela inteira de novo a cada posição.

**Exemplos**

| `vendas` | `tamanhoJanela` | Resultado |
|---|---|---|
| `[2,1,5,1,3,2]` | `3` | `9` (`5+1+3`) |
| `[2,1,5,1,3,2]` | `1` | `5` (o maior elemento sozinho) |

<details><summary>Dica</summary>

`somaJanela -= vendas[i - tamanhoJanela]` (sai) `; somaJanela += vendas[i]` (entra), a cada posição `i` a partir da primeira janela completa. Guarde o maior valor visto.

</details>

**Revisa:** array e acumulador (Mundo 1).
**Rodar:** `mvn test -Dtest=JanelaDeslizanteTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
