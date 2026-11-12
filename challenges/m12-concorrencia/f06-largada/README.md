# 12.06 — Largada

**Missão:** Fazer várias threads começarem a "correr" exatamente no mesmo instante, não uma depois da outra.

**O que vamos trabalhar:** **sincronizar o início** de várias threads com um `CountDownLatch` — uma "trava de largada" que as threads esperam abrir.

**Na prática:** cada thread chega no latch e **espera** (`await`); quando todas estão prontas, quem coordena libera (`countDown`) e todas saem juntas. A lista compartilhada tem que ser segura para threads. Pergunta-guia: como saber que **todas** já estão esperando antes de liberar? (pense num segundo latch).

**Glossário rápido**
- **`CountDownLatch(n)`** — contador que começa em `n`; `await()` bloqueia até chegar a `0`; `countDown()` decrementa.
- **Barreira / sincronização** — ponto onde threads esperam umas pelas outras.
- **Lista thread-safe** — `Collections.synchronizedList` ou `CopyOnWriteArrayList`.
- **Por que não `sleep`?** — dormir "um tempinho" não prova que todos estão prontos; é torcer pela sorte.

**Pesquise sobre:** `java CountDownLatch await countDown` · `java CopyOnWriteArrayList` · `java Collections synchronizedList`

**Implemente:** `challenges.m12.f06.Largada`

```java
public static List<Integer> largadaSimultanea(int numeroDeCorredores) throws InterruptedException
```

**Regras**
- Cria `numeroDeCorredores` threads, uma por corredor (numerados de `0` a `numeroDeCorredores - 1`).
- Cada thread **espera um sinal de largada** antes de adicionar seu número a uma lista compartilhada e segura para concorrência.
- Só depois que todas as threads estão prontas e esperando, o sinal de largada é liberado de uma vez.
- Devolve a lista com os `numeroDeCorredores` números, um de cada corredor (a ordem pode variar entre execuções).
- `numeroDeCorredores` menor ou igual a zero → `IllegalArgumentException`.
- Nada de `Thread.sleep` para "esperar todo mundo ficar pronto" — isso não garante nada, é só sorte de tempo.

**Exemplos**

| `numeroDeCorredores` | Resultado |
|---|---|
| `5` | uma lista com `0, 1, 2, 3, 4`, em alguma ordem |

<details><summary>Dica</summary>

`CountDownLatch largada = new CountDownLatch(1)`. Cada thread do corredor chama `largada.await()` antes de correr — isso bloqueia até o latch chegar a zero. Depois de criar (mas não iniciar a contagem) todas as threads, chame `largada.countDown()` uma vez: todas acordam ao mesmo tempo.

</details>

**Revisa:** `List` thread-safe (`Collections.synchronizedList` ou similar), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=LargadaTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
