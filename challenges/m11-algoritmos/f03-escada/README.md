# 11.03 — Escada

**Missão:** Contar de quantas formas diferentes dá pra subir uma escada de `degraus` degraus, subindo 1 ou 2 por vez.

**O que vamos trabalhar:** **memoização** — guardar resultados de subproblemas já resolvidos para não recalcular. É a porta de entrada da **programação dinâmica**.

**Na prática:** pense no **último passo** dado para chegar no degrau `n`: de onde você pode ter vindo? Isso leva a uma relação entre `n` e valores menores. Escrita direto em recursão, ela repete cálculos; o desafio é guardar o que já foi calculado. Perguntas-guia: quais são os casos base? Onde mora o `Map` para sobreviver entre as chamadas?

**Glossário rápido**
- **Subproblema sobreposto** — o mesmo cálculo aparecendo várias vezes na recursão.
- **Memoização** — cache dos resultados dos subproblemas (`Map<Integer, Long>`).
- **Programação dinâmica** — resolver problemas combinando soluções de subproblemas guardadas.
- **Fibonacci** — essa sequência é a mesma da escada (com outros valores iniciais).

**Pesquise sobre:** `memoização java` · `programação dinâmica para iniciantes` · `problema da escada climbing stairs`

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
