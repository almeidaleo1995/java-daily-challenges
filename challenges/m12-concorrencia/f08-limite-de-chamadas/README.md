# 12.08 — Limite de Chamadas

**Missão:** Garantir que no máximo N "chamadas" rodem ao mesmo tempo, mesmo disparando muito mais que isso de uma vez (rate limiting).

**O que vamos trabalhar:** **`Semaphore`** — controla quantas threads entram numa seção ao mesmo tempo (*rate limiting*). Diferente de um lock (1 por vez), o semáforo deixa entrar até **N**.

**Na prática:** cada thread faz `acquire()`, "trabalha" (um sleep curto), e `release()` (no `finally`!). Para medir o pico, mantenha um contador atômico de "quantos estão dentro agora" e guarde o **máximo** já visto. Pergunta-guia: onde exatamente você incrementa e onde decrementa o contador, em relação a `acquire`/`release`?

**Glossário rápido**
- **`Semaphore(n)`** — `n` "permissões"; `acquire()` pega uma (espera se zerou), `release()` devolve.
- **Rate limiting** — limitar quantas operações ocorrem ao mesmo tempo (ou por tempo).
- **`AtomicInteger.updateAndGet` / `accumulateAndGet`** — úteis para guardar um máximo atomicamente.
- **`InterruptedException`** — o que `sleep`/`acquire` lançam se a thread for interrompida.

**Pesquise sobre:** `java Semaphore acquire release` · `java rate limiting concorrência` · `java AtomicInteger accumulateAndGet`

**Implemente:** `challenges.m12.f08.LimitadorDeChamadas`

```java
public LimitadorDeChamadas(int maximoSimultaneo)
public int chamadasSimultaneasMaximasObservadas(int numeroDeChamadas) throws InterruptedException
```

**Regras**
- `maximoSimultaneo` menor ou igual a zero no construtor → `IllegalArgumentException`.
- `chamadasSimultaneasMaximasObservadas` dispara `numeroDeChamadas` threads ao mesmo tempo, cada uma tentando entrar numa seção protegida pelo limite; dentro da seção, simula um trabalho curto (`Thread.sleep` de poucos milissegundos, só para gerar concorrência real — isso não é sincronização, é a "chamada" acontecendo).
- Um `Semaphore(maximoSimultaneo)` controla quantas threads entram na seção ao mesmo tempo; um contador guarda o maior número de threads que estiveram dentro simultaneamente.
- Devolve esse pico observado — nunca maior que `maximoSimultaneo`.

**Exemplos**

| `maximoSimultaneo` | `numeroDeChamadas` | Resultado |
|---|---|---|
| `3` | `20` | um valor entre `1` e `3` |

<details><summary>Dica</summary>

`semaforo.acquire()` antes de entrar na seção, `semaforo.release()` num `finally` ao sair. Para medir o pico: um `AtomicInteger dentro` incrementado ao entrar, um `AtomicInteger pico` atualizado com `pico.updateAndGet(atual -> Math.max(atual, dentro.get()))`, e `dentro` decrementado ao sair.

</details>

**Revisa:** `AtomicInteger` (fase 12.01), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=LimitadorDeChamadasTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
