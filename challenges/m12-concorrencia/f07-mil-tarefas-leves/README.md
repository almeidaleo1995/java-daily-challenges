# 12.07 — Mil Tarefas Leves

**Missão:** Rodar mil tarefas ao mesmo tempo sem pagar o custo de mil threads de sistema operacional.

**O que vamos trabalhar:** **virtual threads** (Java 21) — threads "leves" gerenciadas pela JVM, baratas o bastante para criar milhares (ou milhões), ideais para tarefas que passam muito tempo esperando (I/O).

**Na prática:** quase igual à fase 12.03, trocando o tipo de executor por um que cria **uma virtual thread por tarefa**. Cada tarefa incrementa um contador seguro (veja f01). Para esperar o fim, `shutdown` + `awaitTermination` (ou o `try-with-resources` do executor, que também espera).

**Glossário rápido**
- **Thread de plataforma** — thread "normal", ligada a uma thread do sistema operacional; cara.
- **Virtual thread** — thread leve da JVM; muitas cabem em poucas de plataforma.
- **`newVirtualThreadPerTaskExecutor()`** — executor que cria uma virtual thread por tarefa.
- **`awaitTermination`** — espera as tarefas acabarem (com timeout).

**Pesquise sobre:** `java virtual threads` · `java 21 newVirtualThreadPerTaskExecutor` · `java virtual thread vs platform thread`

**Implemente:** `challenges.m12.f07.TarefasVirtuais`

```java
public static int executarTarefasVirtuais(int numeroDeTarefas) throws InterruptedException
```

**Regras**
- Usa `Executors.newVirtualThreadPerTaskExecutor()` — cada tarefa roda numa virtual thread própria, não numa thread de SO.
- Cada tarefa incrementa um contador compartilhado seguro para concorrência.
- Espera todas as tarefas terminarem (`awaitTermination` depois de `shutdown`, ou equivalente) antes de devolver o total.
- Devolve o total, que é sempre `numeroDeTarefas`.
- `numeroDeTarefas` menor ou igual a zero → `IllegalArgumentException`.

**Exemplos**

| `numeroDeTarefas` | Resultado |
|---|---|
| `1000` | `1000` |

<details><summary>Dica</summary>

`try (var executor = Executors.newVirtualThreadPerTaskExecutor())` — o `try`-with-resources fecha o executor automaticamente, e fechar um `ExecutorService` espera as tarefas em andamento terminarem antes de continuar.

</details>

**Revisa:** `AtomicInteger` (fase 12.01), `try`-with-resources (Mundo 4).
**Rodar:** `mvn test -Dtest=TarefasVirtuaisTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
