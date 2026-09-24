# 👑 Chefe do Mundo 12 — Mercadinho v10: Checkout Concorrente

**Missão:** Vender um produto para várias pessoas comprando ao mesmo tempo, sem nunca vender mais do que o estoque tem.

**Implemente:** `challenges.m12.chefe.CheckoutConcorrente`

```java
public CheckoutConcorrente(int estoqueInicial)
public int comprarConcorrentemente(int numeroDeCompradores) throws InterruptedException
public int estoqueRestante()
```

**Regras**
- `estoqueInicial` negativo → `IllegalArgumentException`.
- `comprarConcorrentemente` dispara `numeroDeCompradores` threads, cada uma tentando comprar **1 unidade**, todas ao mesmo tempo.
- Cada compra só é bem-sucedida se ainda houver estoque no instante em que a thread tenta — decrementar o estoque e checar se ainda era positivo precisa ser uma operação só, sem outra thread decrementar no meio.
- Devolve quantas compras foram bem-sucedidas. Isso é sempre `min(numeroDeCompradores, estoqueInicial)`, mesmo com `numeroDeCompradores` muito maior que o estoque — nunca mais que isso, mesmo sob concorrência.
- `estoqueRestante()` nunca fica negativo.
- `numeroDeCompradores` menor ou igual a zero → `IllegalArgumentException`.

**Exemplos**

| `estoqueInicial` | `numeroDeCompradores` | Vendas | `estoqueRestante()` |
|---|---|---|---|
| `50` | `200` | `50` | `0` |
| `10` | `5` | `5` | `5` |

<details><summary>Dica</summary>

`AtomicInteger` sozinho não basta aqui: `decrementAndGet()` deixaria o estoque ir a negativo se várias threads decrementarem ao mesmo tempo sem checar antes. Use `getAndUpdate` com uma função que só decrementa se o valor atual for maior que zero (devolve o mesmo valor se já chegou a zero), e cada thread confere o valor que a função devolveu para saber se a *sua* compra foi a que conseguiu.

</details>

**Revisa:** `AtomicInteger` (fase 12.01), validação de argumento (Mundo 4), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=CheckoutConcorrenteTest`

⭐⭐⭐⭐⭐ · ~20 min · +50 XP

---

Concluir este chefe libera o **Mundo 13 — Reflection e Anotações**.
