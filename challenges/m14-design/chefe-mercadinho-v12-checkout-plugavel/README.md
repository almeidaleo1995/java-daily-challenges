# 👑 Chefe do Mundo 14 — Mercadinho v12: Checkout Plugável

**Missão:** Fechar um carrinho: somar os itens, calcular o frete só pelo peso do que é físico, e avisar quem estiver ouvindo.

**Implemente:** `challenges.m14.chefe.Checkout` (`ItemCheckout`/`ItemFisico`/`ItemDigital`/`EstrategiaDeFrete`/`OuvinteDeCheckout`/`ResultadoCheckout` já vêm prontos no esqueleto — não altere)

```java
public Checkout(EstrategiaDeFrete estrategiaFrete)
public void registrarOuvinte(OuvinteDeCheckout ouvinte)
public ResultadoCheckout finalizar(List<ItemCheckout> itens, double distanciaKm)
```

**Regras**
- `ItemCheckout` é `sealed`: só `ItemFisico(nome, preco, pesoKg)` e `ItemDigital(nome, preco)`.
- `subtotal` = soma do `preco()` de todos os itens.
- Peso total do frete = soma do `pesoKg` só dos `ItemFisico` — `ItemDigital` não pesa nada e não entra na conta do frete.
- `frete` = `estrategiaFrete.calcular(pesoTotal, distanciaKm)` — o `Checkout` não sabe como o frete é calculado, só delega (Strategy).
- `total` = `subtotal + frete`.
- Depois de calcular tudo, notifica **todos** os ouvintes registrados com `aoFinalizar(total)` (Observer).
- `itens` nulo ou vazio → `IllegalArgumentException`. `distanciaKm` negativa → `IllegalArgumentException`. `estrategiaFrete` nula no construtor → `IllegalArgumentException`.

**Exemplos**

Com frete `(pesoKg, distanciaKm) -> pesoKg * 0.5 + distanciaKm * 0.1` e itens `[Livro(50, 1kg), E-book(20), Fone(100, 0.5kg)]`, `distanciaKm = 100`:

| Campo | Valor |
|---|---|
| `subtotal` | `170.0` |
| `frete` | `10.75` (peso `1.5kg`: `1.5*0.5 + 100*0.1`) |
| `total` | `180.75` |

<details><summary>Dica</summary>

Para separar o peso só dos itens físicos, use `switch` com pattern matching sobre o `ItemCheckout` selado (Mundo 8): `case ItemFisico fisico -> fisico.pesoKg(); case ItemDigital digital -> 0.0;` dentro de um `mapToDouble`/`reduce` sobre o Stream de itens (Mundo 7) — ou um laço comum com `instanceof`, se preferir.

</details>

**Revisa:** Strategy (fase 14.01), Observer (fase 14.03), `sealed`/pattern matching (Mundo 8), Streams (Mundo 7).
**Rodar:** `mvn test -Dtest=CheckoutTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 15 — Chefão Final**.
