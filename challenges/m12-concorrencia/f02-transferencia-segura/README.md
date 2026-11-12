# 12.02 — Transferência Segura

**Missão:** Transferir dinheiro entre duas contas com transferências acontecendo nos dois sentidos ao mesmo tempo, sem perder dinheiro e sem travar (deadlock).

**O que vamos trabalhar:** **locks** (`ReentrantLock`) para proteger dois recursos ao mesmo tempo, e o **deadlock** — duas threads esperando uma pela outra para sempre.

**Na prática:** transferir exige mexer em duas contas "como se fosse uma operação só". Trave as duas, verifique, mova o dinheiro, destrave (sempre no `finally`!). O truque anti-deadlock: **toda** operação trava as contas **na mesma ordem fixa**, não "origem e depois destino".

**Glossário rápido**
- **`ReentrantLock`** — trava explícita: `lock()` / `unlock()`.
- **Seção crítica** — trecho de código que só uma thread pode executar por vez.
- **Deadlock** — A espera B, B espera A; ninguém avança.
- **`try { ... } finally { lock.unlock(); }`** — garante liberar o lock mesmo com exceção (fase 4.02).

**Pesquise sobre:** `java ReentrantLock lock unlock finally` · `java deadlock como evitar ordem dos locks` · `java synchronized vs ReentrantLock`

**Implemente:** `challenges.m12.f02.Banco`

```java
public Banco(double saldoInicialA, double saldoInicialB)
public double saldoA()
public double saldoB()
public void transferirAparaB(double valor)
public void transferirBparaA(double valor)
```

**Regras**
- `valor` maior que o saldo de origem → `IllegalStateException`, sem alterar nenhum saldo.
- `saldoA() + saldoB()` é sempre igual à soma inicial, mesmo com centenas de transferências simultâneas nos dois sentidos.
- Use `ReentrantLock`, um por conta. Se `transferirAparaB` pega o lock de A e depois o de B, e `transferirBparaA` pega o de B e depois o de A, ao mesmo tempo, é deadlock. Os dois métodos precisam pegar os locks **na mesma ordem** (ex.: sempre o lock de A antes do de B), não na ordem "origem depois destino".

**Exemplos**

| Operação | Efeito |
|---|---|
| `new Banco(1000, 500).transferirAparaB(200)` | saldoA=800, saldoB=700 |
| `new Banco(100, 100).transferirAparaB(200)` | `IllegalStateException`, nada muda |

<details><summary>Dica</summary>

Dois `ReentrantLock` (`lockA`, `lockB`). Em `transferirAparaB` e em `transferirBparaA`, sempre `lockA.lock()` primeiro, depois `lockB.lock()` — nunca o contrário — e libere os dois num `finally`, na ordem inversa de aquisição.

</details>

**Revisa:** validação de estado (Mundo 4), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=BancoTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
