# 12.04 — Cotação Combinada

**Missão:** Buscar duas cotações em paralelo e somá-las, sem travar esperando uma antes de pedir a outra.

**Implemente:** `challenges.m12.f04.Cotacao`

```java
public static double cotacaoTotal(Supplier<Double> fornecedorA, Supplier<Double> fornecedorB)
```

**Regras**
- Dispara os dois fornecedores com `CompletableFuture.supplyAsync`, ao mesmo tempo (não chama um e espera antes de chamar o outro).
- Combina os dois resultados com `thenCombine`, somando.
- Se qualquer um dos dois fornecedores lançar exceção, o resultado é `-1.0` (trate com `exceptionally`).
- `fornecedorA` ou `fornecedorB` nulos → `IllegalArgumentException`.

**Exemplos**

| `fornecedorA` | `fornecedorB` | Resultado |
|---|---|---|
| `() -> 10.5` | `() -> 20.3` | `30.8` |
| `() -> { throw ... }` | `() -> 20.3` | `-1.0` |

<details><summary>Dica</summary>

`CompletableFuture.supplyAsync(fornecedorA::get).thenCombine(CompletableFuture.supplyAsync(fornecedorB::get), Double::sum).exceptionally(erro -> -1.0).join()` — cada peça faz uma parte: as duas chamadas disparam em paralelo, `thenCombine` junta o resultado das duas, `exceptionally` cobre falha de qualquer uma, `join()` espera o valor final.

</details>

**Revisa:** `Supplier` (Mundo 6), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=CotacaoTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
