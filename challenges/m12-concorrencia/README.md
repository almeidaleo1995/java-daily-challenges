# Mundo 12 — Concorrência
> Código que roda certo sozinho pode voltar errado quando duas threads tocam o mesmo estado ao mesmo tempo.

- **Condição de corrida** — dois `Thread`s lendo e escrevendo o mesmo dado sem coordenação perdem incrementos.
- **`Atomic*` / CAS** — operações que acontecem inteiras, sem outra thread interromper no meio.
- **`ReentrantLock`** — trava explícita; a ordem em que threads pegam locks decide se dá deadlock.
- **`ExecutorService` / `Future`** — pool de threads que roda tarefas e devolve resultados sob demanda.
- **`CompletableFuture`** — compor tarefas assíncronas (`thenCombine`, `exceptionally`) sem bloquear na mão.
- **`CountDownLatch` / `Semaphore`** — sincronizar uma largada simultânea ou limitar quantas threads entram ao mesmo tempo.
- **Virtual threads** — milhares de tarefas leves sem o custo de uma `Thread` de SO cada.

**Chefe:** Mercadinho v10: Checkout Concorrente — vender sem nunca passar do estoque, mesmo com todo mundo comprando ao mesmo tempo.
**Fonte:** https://dev.java/learn/api/virtual-threads/
