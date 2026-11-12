# 11.05 — Janela de Vendas

**Missão:** Achar a maior soma de `tamanhoJanela` dias seguidos de vendas, sem somar o intervalo inteiro de novo a cada posição.

**O que vamos trabalhar:** **janela deslizante** — em vez de somar `k` elementos de novo a cada posição, atualize a soma: entra um elemento, sai outro.

**Na prática:** somar `k` elementos de novo a cada posição repete trabalho. Pergunte-se: ao deslizar a janela uma posição, **o que mudou** em relação à janela anterior? Dá para atualizar a soma sem somar tudo outra vez? Qual variável guarda o melhor resultado até agora?

**Glossário rápido**
- **Janela deslizante (sliding window)** — um intervalo de tamanho fixo que "anda" pelo array.
- **Soma incremental** — atualizar o valor anterior em vez de recalcular tudo.
- **O(n)** vs **O(n·k)** — a ideia da janela remove o fator `k`.
- **Máximo corrente** — variável que guarda a melhor soma até agora.

**Pesquise sobre:** `janela deslizante sliding window` · `maximum sum subarray of size k` · `complexidade O(n·k)`

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
