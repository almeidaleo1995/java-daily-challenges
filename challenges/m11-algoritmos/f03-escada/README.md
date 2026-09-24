# 11.03 — Escada

**Missão:** Contar de quantas formas diferentes dá pra subir uma escada de `degraus` degraus, subindo 1 ou 2 por vez.

**Implemente:** `challenges.m11.f03.Escada`

```java
public static long formasDeSubir(int degraus)
```

**Regras**
- `degraus` negativo → `IllegalArgumentException`.
- `degraus == 0` → `1` (já está no topo, uma única forma: não subir nada).
- A recursão pura (`formasDeSubir(n) = formasDeSubir(n-1) + formasDeSubir(n-2)`) recalcula o mesmo subproblema um número exponencial de vezes. Guarde cada resultado já calculado num `Map<Integer, Long>` antes de recalcular.

**Exemplos**

| `degraus` | Resultado | Por quê |
|---|---|---|
| `2` | `2` | `1+1` ou `2` |
| `5` | `8` | soma das formas de `3` e `4` degraus |

<details><summary>Dica</summary>

Antes de calcular `formasDeSubir(n)` recursivamente, confira se `n` já está no `Map`. Se estiver, devolva o valor guardado. Se não, calcule, guarde no `Map` e só então devolva — essa é a memoização.

</details>

**Revisa:** `Map`/`getOrDefault` (Mundo 2), recursão (fase 11.02).
**Rodar:** `mvn test -Dtest=EscadaTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
