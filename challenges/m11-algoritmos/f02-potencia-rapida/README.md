# 11.02 — Potência Rápida

**Missão:** Calcular `base^expoente` por divisão e conquista, sem multiplicar a base `expoente` vezes.

**Implemente:** `challenges.m11.f02.Potencia`

```java
public static long potencia(int base, int expoente)
```

**Regras**
- `expoente` negativo → `IllegalArgumentException`.
- `expoente == 0` → `1`, para qualquer `base`.
- Implemente recursivo: `potencia(base, exp)` = `potencia(base, exp/2)²` (ajustando o caso ímpar), não um laço multiplicando `expoente` vezes.

**Exemplos**

| `base` | `expoente` | Resultado |
|---|---|---|
| `2` | `10` | `1024` |
| `-2` | `3` | `-8` |

<details><summary>Dica</summary>

Se `expoente` é par, `base^expoente = (base^(expoente/2))²`. Se é ímpar, `base^expoente = base * base^(expoente-1)`. Isso corta o expoente pela metade a cada duas chamadas em vez de decrementar de 1 em 1.

</details>

**Revisa:** recursão (chamada de método dentro de si mesmo).
**Rodar:** `mvn test -Dtest=PotenciaTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
