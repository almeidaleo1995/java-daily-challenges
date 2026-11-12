# 12.03 — Processamento Paralelo

**Missão:** Elevar cada número de uma lista ao quadrado usando um pool de threads, devolvendo o resultado na mesma ordem da entrada.

**O que vamos trabalhar:** **pool de threads** (`ExecutorService`) e **`Future`** — entregue tarefas a um grupo de threads reaproveitadas e receba um "recibo" (`Future`) para pegar o resultado depois.

**Na prática:** crie o pool, para cada valor `submit` uma tarefa (que devolve um resultado) e guarde o `Future` numa lista **na mesma ordem**. Depois percorra a lista chamando `get()`. Por fim, **desligue o pool** (`shutdown`), senão o programa pode não encerrar.

**Glossário rápido**
- **`ExecutorService`** — gerencia um conjunto de threads executando tarefas.
- **`Callable<T>`** — tarefa que **devolve** valor (como `Runnable`, mas com retorno).
- **`Future<T>`** — promessa de um resultado futuro; `get()` espera e entrega.
- **`shutdown()`** — para de aceitar tarefas novas e deixa as pendentes terminarem.

**Pesquise sobre:** `java ExecutorService newFixedThreadPool` · `java Future get Callable` · `java executor shutdown awaitTermination`

**Implemente:** `challenges.m12.f03.ProcessadorParalelo`

```java
public static List<Integer> processarEmParalelo(List<Integer> valores, int numeroDeThreads) throws InterruptedException, ExecutionException
```

**Regras**
- Cria um `ExecutorService` com `numeroDeThreads` threads (`Executors.newFixedThreadPool`).
- Submete uma tarefa por valor (`valor * valor`), guarda o `Future` de cada uma na ordem original.
- Lê cada `Future.get()` na mesma ordem em que foi submetido — o resultado sai na ordem da entrada, mesmo que as tarefas terminem fora de ordem.
- Desliga o executor (`shutdown()`) antes de devolver.
- `valores` nulo, ou `numeroDeThreads` menor ou igual a zero → `IllegalArgumentException`.

**Exemplos**

| `valores` | `numeroDeThreads` | Resultado |
|---|---|---|
| `[1,2,3,4,5]` | `3` | `[1,4,9,16,25]` |

<details><summary>Dica</summary>

`List<Future<Integer>> futures = new ArrayList<>();` — submeta uma tarefa por valor, na ordem, guardando cada `Future` na lista. Depois percorra `futures` chamando `.get()` em cada um, montando o resultado — a ordem dos `Future` na lista é a ordem da entrada, independente de qual terminou primeiro.

</details>

**Revisa:** `List` (Mundo 2), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=ProcessadorParaleloTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
