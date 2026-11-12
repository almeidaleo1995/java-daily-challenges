# 👑 Chefe do Mundo 11 — Mercadinho v9: Troco Mínimo

**Missão:** Calcular a menor quantidade de moedas do caixa que fecha exatamente um valor de troco.

**O que vamos trabalhar:** **programação dinâmica de baixo para cima** (*bottom-up*) — o clássico "problema do troco": a menor quantidade de moedas que forma um valor. Reúne memoização (f03), laços e `Optional` (Mundo 6).

**Na prática:** o array `menorPara[0..valor]` guarda a melhor resposta para **cada valor menor**. Pergunte-se: se eu já sei a melhor resposta para todos os valores abaixo de `v`, como uso isso para achar a de `v`, olhando cada moeda? E como representar "esse valor é impossível" sem causar overflow ao somar 1?

**Glossário rápido**
- **Bottom-up** — resolve primeiro os valores pequenos e usa eles para os maiores.
- **Subestrutura ótima** — a melhor solução de `v` usa a melhor solução de `v - moeda`.
- **Marcador de "impossível"** — valor especial (ex.: `Integer.MAX_VALUE`/`valor + 1`); cuidado com overflow ao somar 1.
- **Guloso (greedy)** — escolher sempre a maior moeda **não** funciona em geral (ex.: moedas `[1, 3, 4]` e valor 6).

**Pesquise sobre:** `problema do troco programação dinâmica` · `coin change problem` · `programação dinâmica bottom-up vs top-down`

**Implemente:** `challenges.m11.chefe.Troco`

```java
public static Optional<Integer> menorQuantidadeDeMoedas(int[] moedas, int valor)
```

**Regras**
- `moedas` são as denominações disponíveis no caixa (não precisa ter `1`).
- `valor == 0` → `Optional.of(0)` (nenhuma moeda necessária).
- Devolve `Optional` com a **menor** quantidade de moedas que soma exatamente `valor`; se nenhuma combinação fechar o valor, `Optional.empty()`.
- `moedas` nulo, vazio, ou com alguma denominação menor ou igual a zero → `IllegalArgumentException`.
- `valor` negativo → `IllegalArgumentException`.
- Nada de recursão pura testando toda combinação (explode exponencialmente): construa um array `menorPara[0..valor]` de baixo para cima — programação dinâmica.

**Exemplos**

Com `moedas = [1, 5, 10, 25]`:

| `valor` | Resultado | Por quê |
|---|---|---|
| `63` | `Optional[6]` | `25+25+10+1+1+1` |
| `0` | `Optional[0]` | nada a trocar |

Com `moedas = [5, 10]`:

| `valor` | Resultado | Por quê |
|---|---|---|
| `3` | `Optional.empty()` | nenhuma combinação de `5` e `10` soma `3` |

<details><summary>Dica</summary>

`menorPara[0] = 0`. Para cada `v` de `1` até `valor`, tente cada moeda `m <= v`: se `menorPara[v - m]` já tem solução, `menorPara[v]` é o menor entre o que já tinha e `menorPara[v - m] + 1`. No fim, `menorPara[valor]` é a resposta (se nunca foi preenchido, não tem solução).

</details>

**Revisa:** memoização (fase 11.03), `Optional` (Mundo 6), validação de argumento (Mundo 4).
**Rodar:** `mvn test -Dtest=TrocoTest`

⭐⭐⭐⭐⭐ · ~20 min · +50 XP

---

Concluir este chefe libera o **Mundo 12 — Concorrência**.
