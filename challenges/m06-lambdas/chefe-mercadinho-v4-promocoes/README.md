# 👑 Chefe do Mundo 6 — Mercadinho v4: Promoções

**Missão:** Aplicar uma lista de promoções (cada uma uma função de preço → preço) e, por cima, um cupom opcional — sem nunca deixar o preço final negativo.

**O que vamos trabalhar:** juntar **`Function`** (promoções em cadeia), **`Optional`** (cupom que pode não existir) e **`BigDecimal`** (dinheiro com arredondamento controlado).

**Na prática:** três passos em ordem: (1) aplicar cada promoção sobre o preço, uma depois da outra; (2) se houver cupom, aplicar o desconto sobre o resultado **já promocionado**; (3) travar em zero se negativo e arredondar para 2 casas. Repare que a ordem importa (cupom não incide sobre o preço original).

**Glossário rápido**
- **`Optional.isPresent` / `ifPresent` / `map`** — formas de usar o cupom só se existir.
- **`BigDecimal.multiply` / `subtract`** — contas exatas (não mudam o original: devolvem novo).
- **`setScale(2, RoundingMode.HALF_EVEN)`** — fixa 2 casas decimais, arredondando "para o par mais próximo" (arredondamento bancário).
- **`BigDecimal.ZERO`** — constante de zero; use `compareTo` (não `equals`) para comparar valores.

**Pesquise sobre:** `java BigDecimal setScale RoundingMode HALF_EVEN` · `java BigDecimal compareTo vs equals` · `java Optional ifPresent`

**Implemente:** `challenges.m06.chefe.MotorDePromocoes` (`Cupom` já vem pronto no esqueleto — não altere)

```java
public static BigDecimal aplicarPromocoes(
    BigDecimal precoOriginal, List<Function<BigDecimal, BigDecimal>> promocoes, Optional<Cupom> cupom)
```

**Regras**
- `Cupom(String codigo, BigDecimal desconto)`, onde `desconto` é uma fração (`0.10` = 10%).
- Aplica cada função de `promocoes` em sequência sobre `precoOriginal`, na ordem da lista.
- Se `cupom` estiver presente, subtrai do resultado `desconto` × resultado (o cupom incide sobre o preço já promocionado, não sobre o original).
- O resultado final nunca é negativo: se ficar abaixo de zero, o retorno é `BigDecimal.ZERO` (escala 2).
- Arredondamento final sempre com escala 2 e `RoundingMode.HALF_EVEN`.
- `precoOriginal`, `promocoes` ou `cupom` nulos (o `Optional` em si nulo, não vazio) → `IllegalArgumentException`.

**Exemplos**

| `precoOriginal` | `promocoes` | `cupom` | Resultado |
|---|---|---|---|
| `100.00` | `[p -> p.multiply(0.9)]` (10% off) | `Cupom("PROMO10", 0.10)` | `81.00` |
| `50.00` | `[]` | `Optional.empty()` | `50.00` |
| `10.00` | `[p -> p.subtract(15)]` | `Optional.empty()` | `0.00` |

<details><summary>Dica</summary>

Um laço acumulando `preco = promocao.apply(preco)` resolve a lista de promoções — é o mesmo padrão da fase 6.02, só que com `BigDecimal` no lugar de `String`. O cupom entra depois, como um passo a mais só se `cupom.isPresent()`.

</details>

**Revisa:** `Function` composta (fase 6.02), `Optional` (fase 6.04), `BigDecimal`/`RoundingMode.HALF_EVEN` (fase 1.26).
**Rodar:** `mvn test -Dtest=MotorDePromocoesTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 7 — Streams**.
