# 👑 Chefe Final — Mercadinho: Auditoria

**Missão:** Fechar o caixa do mercadinho: passar por todo o histórico de vendas, devoluções e ajustes, e apontar quais produtos ficaram com saldo negativo — um erro de estoque que já aconteceu.

**Implemente:** `challenges.m15.chefe.Auditoria` (`EventoDeEstoque`/`Venda`/`Devolucao`/`Ajuste`/`RelatorioDeAuditoria` já vêm prontos no esqueleto — não altere)

```java
public static RelatorioDeAuditoria apurar(List<EventoDeEstoque> eventos)
```

**Regras**
- `EventoDeEstoque` é `sealed`: só `Venda(produto, quantidade, valorUnitario)`, `Devolucao(produto, quantidade)` e `Ajuste(produto, delta)`.
- `saldoPorProduto`: começa em `0` para cada produto que aparece em algum evento. `Venda` **subtrai** `quantidade`; `Devolucao` **soma** `quantidade`; `Ajuste` **soma** `delta` (pode ser negativo).
- `totalVendido`: soma de `quantidade * valorUnitario` de todas as `Venda`, em `BigDecimal`.
- `inconsistencias`: uma entrada `"produto: saldo"` para cada produto cujo saldo final é **negativo**, em ordem alfabética de produto.
- `Venda` com `quantidade` menor ou igual a zero, ou `valorUnitario` nulo ou negativo → `IllegalArgumentException`. `Devolucao` com `quantidade` menor ou igual a zero → `IllegalArgumentException`.
- `eventos` nulo ou vazio → `IllegalArgumentException`.

**Exemplos**

Com `[Venda(Arroz,5,10.00), Devolucao(Arroz,2), Ajuste(Arroz,-1), Venda(Feijão,100,5.00), Ajuste(Trigo,50)]`:

| Campo | Valor |
|---|---|
| `saldoPorProduto` | `{Arroz: -4, Feijão: -100, Trigo: 50}` |
| `totalVendido` | `550.00` |
| `inconsistencias` | `["Arroz: -4", "Feijão: -100"]` |

<details><summary>Dica</summary>

Um `switch` com pattern matching sobre `EventoDeEstoque` (Mundo 8) decide o sinal de cada evento: `case Venda v -> -v.quantidade(); case Devolucao d -> d.quantidade(); case Ajuste a -> a.delta();` — some isso ao saldo acumulado por produto num `Map` (Mundo 2), com `merge`. Depois, um Stream (Mundo 7) sobre as entradas do mapa, filtrando saldo negativo, ordenando pela chave, e montando a `String` de cada inconsistência.

</details>

**Revisa:** `sealed`/pattern matching (Mundo 8), Streams (Mundo 7), `Map`/`merge` (Mundo 2), `BigDecimal` (Mundo 1), validação de argumento (Mundo 4).
**Rodar:** `mvn test -Dtest=AuditoriaTest`

⭐⭐⭐⭐⭐ · ~20 min · +50 XP

---

Você fechou os quinze mundos. O que vem depois está em "Próximos mundos", no `PROGRESSO.md`.
