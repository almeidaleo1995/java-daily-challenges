# 👑 Chefe do Mundo 8 — Mercadinho v6: Pagamentos

**Missão:** Calcular a taxa de cada forma de pagamento aceita pela loja — cada uma com sua própria regra — e somar a taxa de um lote de pagamentos.

**Implemente:** `challenges.m08.chefe.CalculadoraDeTaxas` (`Pagamento`, `Pix`, `Cartao` e `Boleto` já vêm prontos no esqueleto — não altere)

```java
public static BigDecimal taxa(Pagamento pagamento)
public static BigDecimal taxaTotal(List<Pagamento> pagamentos)
```

**Regras**
- `Pagamento` é `sealed`, permitindo só `Pix(BigDecimal valor)`, `Cartao(BigDecimal valor, int parcelas)` e `Boleto(BigDecimal valor, int diasParaVencer)`.
- `Pix`: taxa `0.00`.
- `Cartao`: `valor × 0.03 × parcelas` (3% por parcela).
- `Boleto`: `valor × 0.02` se `diasParaVencer > 30`; senão `valor × 0.01`.
- Toda taxa com escala 2 e `RoundingMode.HALF_EVEN`.
- `taxa`: implemente com `switch` com pattern sobre `Pagamento`, exaustivo (sem `default`); o caso de `Boleto` precisa de uma guarda (`when`) para os dois cenários de prazo.
- `taxaTotal`: soma `taxa(p)` de cada pagamento da lista, com um pipeline de Stream — não um laço `for`.
- `pagamento` ou `pagamentos` nulos → `IllegalArgumentException`.

**Exemplos**

| Pagamento | Taxa |
|---|---|
| `Pix(100.00)` | `0.00` |
| `Cartao(100.00, 3)` | `9.00` |
| `Boleto(100.00, 45)` | `2.00` |
| `Boleto(100.00, 10)` | `1.00` |

Com `[Pix(50), Cartao(100,1), Boleto(200,45)]`: `taxaTotal` = `0.00 + 3.00 + 4.00 = 7.00`.

<details><summary>Dica</summary>

`pagamentos.stream().map(CalculadoraDeTaxas::taxa).reduce(BigDecimal.ZERO, BigDecimal::add)` reaproveita o próprio `taxa` dentro do pipeline — implemente `taxa` primeiro e teste ele sozinho antes de escrever `taxaTotal`.

</details>

**Revisa:** `switch` com pattern e guarda (fase 8.02), `sealed` exaustivo (fase 8.03), `reduce`/soma com Stream (Mundo 7).
**Rodar:** `mvn test -Dtest=CalculadoraDeTaxasTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 9 — Datas e Regex**.
