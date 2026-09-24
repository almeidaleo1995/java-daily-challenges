# 12.01 — Contador Disputado

**Missão:** Somar incrementos vindos de várias threads ao mesmo tempo sem perder nenhum.

**Implemente:** `challenges.m12.f01.ContadorConcorrente`

```java
public static int incrementarConcorrentemente(int numeroDeThreads, int incrementosPorThread) throws InterruptedException
```

**Regras**
- Cria `numeroDeThreads` threads; cada uma incrementa um contador compartilhado `incrementosPorThread` vezes.
- Espera todas terminarem (`join`) antes de devolver o total.
- O total devolvido é **sempre** `numeroDeThreads * incrementosPorThread`, nunca menos — um `int` comum incrementado por várias threads perde incrementos (condição de corrida); o contador precisa ser seguro para concorrência.
- `numeroDeThreads` menor ou igual a zero → `IllegalArgumentException`.
- `incrementosPorThread` negativo → `IllegalArgumentException` (`0` é válido e dá total `0`).

**Exemplos**

| `numeroDeThreads` | `incrementosPorThread` | Resultado |
|---|---|---|
| `10` | `1000` | `10000` |

<details><summary>Dica</summary>

`int contador++` não é uma operação atômica (é ler, somar, escrever — três passos). Com várias threads fazendo isso ao mesmo tempo, um incremento pode se perder. `AtomicInteger.incrementAndGet()` faz a mesma coisa como uma operação só.

</details>

**Revisa:** `Thread` (conceito novo do mundo).
**Rodar:** `mvn test -Dtest=ContadorConcorrenteTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
