# 1.26 — Preço com Desconto

**Missão:** Aplicar um desconto percentual a um preço usando `BigDecimal`, nunca `double` — dinheiro não se representa em ponto flutuante.

**Implemente:** `challenges.m01.f26.PrecoComDesconto`

```java
public static BigDecimal aplicarDesconto(BigDecimal preco, BigDecimal percentualDesconto)
```

**Regras**
- Devolve `preco` com o percentual de desconto aplicado, sempre com 2 casas decimais.
- O arredondamento é bancário: `RoundingMode.HALF_EVEN` (em caso de empate exato, arredonda para o dígito par mais próximo — não sempre para cima).
- `preco` ou `percentualDesconto` nulos, `preco` negativo, ou `percentualDesconto` fora de `[0, 100]` lançam `IllegalArgumentException`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `aplicarDesconto(100.00, 10)` | `90.00` |
| `aplicarDesconto(2.84, 12.5)` | `2.48` (empate exato em `2.485`; `HALF_EVEN` escolhe o par) |
| `aplicarDesconto(-1, 10)` | lança `IllegalArgumentException` |

<details><summary>Dica</summary>

`BigDecimal` não tem operador `-`, `*`, `/`. Os métodos são `subtract`, `multiply`, `divide`. Para fixar as casas decimais no final, existe `setScale(casas, modoDeArredondamento)`.

</details>

**Revisa:** `IllegalArgumentException` para validar parâmetro (desafios 008, 009).
**Rodar:** `mvn test -Dtest=PrecoComDescontoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
