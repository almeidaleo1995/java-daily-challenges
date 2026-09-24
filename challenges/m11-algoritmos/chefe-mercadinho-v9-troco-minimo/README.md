# 👑 Chefe do Mundo 11 — Mercadinho v9: Troco Mínimo

**Missão:** Calcular a menor quantidade de moedas do caixa que fecha exatamente um valor de troco.

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
