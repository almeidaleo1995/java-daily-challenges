# 15.03 — Agendador

**Missão:** Manter uma fila de eventos futuros ordenada por horário, e saber quais já deveriam ter acontecido.

**Implemente:** `challenges.m15.f03.Agendador` (`Evento` já vem pronto no esqueleto — não altere)

```java
public Agendador(Clock relogio)
public void agendar(String titulo, LocalDateTime horario)
public Optional<Evento> proximoEvento()
public List<Evento> eventosVencidos()
```

**Regras**
- `relogio` nulo no construtor → `IllegalArgumentException`.
- `agendar`: `titulo` nulo ou em branco, ou `horario` nulo → `IllegalArgumentException`. Adiciona o evento à fila.
- `proximoEvento()`: devolve (sem remover) o evento de horário mais próximo, ou `Optional.empty()` se a fila está vazia.
- `eventosVencidos()`: remove **e devolve**, ordenados do mais antigo pro mais recente, todos os eventos cujo `horario` já passou — comparado com `LocalDateTime.now(relogio)`, nunca `LocalDateTime.now()` sem argumento.

**Exemplos**

Com o relógio fixo em `2024-01-10T12:00`:

| Agendados | `eventosVencidos()` | Sobra na fila |
|---|---|---|
| `Passado(01-05)`, `Futuro(02-01)`, `Passado(01-08)` | `[Passado(01-05), Passado(01-08)]` | `Futuro(02-01)` |

<details><summary>Dica</summary>

Uma `PriorityQueue<Evento>` com `Comparator.comparing(Evento::horario)` mantém a fila sempre ordenada por horário, sem você reordenar na mão a cada `agendar`. `peek()` olha sem remover (para `proximoEvento`); `poll()` remove e devolve o topo — chame `poll()` em laço enquanto o topo estiver vencido, pra montar `eventosVencidos()`.

</details>

**Revisa:** `PriorityQueue`/`Comparator` (Mundo 2), `Clock` injetado (fase 14.05), `Optional` (Mundo 6).
**Rodar:** `mvn test -Dtest=AgendadorTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
