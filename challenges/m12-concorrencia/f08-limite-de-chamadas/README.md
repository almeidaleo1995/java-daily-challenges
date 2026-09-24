# 12.08 — Limite de Chamadas

**Missão:** Garantir que no máximo N "chamadas" rodem ao mesmo tempo, mesmo disparando muito mais que isso de uma vez (rate limiting).

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
