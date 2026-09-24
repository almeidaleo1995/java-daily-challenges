# 👑 Chefe do Mundo 1 — Cupom Fiscal

**Missão:** Fechar o Mundo 1 juntando tudo: parsear texto (`split`), fazer contas de dinheiro certas (`BigDecimal`), decidir um desconto por tipo (`switch`) e montar o recibo (`StringBuilder` + `String.format`).

**Implemente:** `challenges.m01.chefe.CupomFiscal`

```java
public static String gerar(List<String> linhasDeItens)
```

**Regras**
- Cada linha de `linhasDeItens` tem o formato `"nome;quantidade;precoUnitario;tipo"` (campos separados por `;`).
- `tipo` decide o desconto sobre o subtotal do item: `"A"` → 0%, `"B"` → 5%, `"C"` → 10%. Qualquer outro tipo lança `IllegalArgumentException`.
- `subtotal = precoUnitario * quantidade`, com o desconto do tipo aplicado, arredondado para 2 casas com `RoundingMode.HALF_EVEN`.
- O relatório tem uma linha por item no formato `"NOME           xQTD  R$ SUBTOTAL"` (nome em 15 colunas à esquerda, `x` + quantidade em 3 colunas à esquerda, subtotal em 8 colunas à direita com 2 casas), separadas por `"\n"`, e termina com `"TOTAL: R$ X.XX"` (soma de todos os subtotais).
- `linhasDeItens` nula ou vazia, linha com número de campos diferente de 4, `quantidade` menor ou igual a zero, ou `precoUnitario` negativo lançam `IllegalArgumentException`.

**Exemplos**

Com `["Caneta;2;3.50;A", "Caderno;1;20.00;B"]`:
- Caneta: subtotal `7.00` (sem desconto).
- Caderno: subtotal `19.00` (`20.00` com 5% de desconto).
- Total: `26.00`.

Com `["Caneta;0;3.50;A"]` → lança `IllegalArgumentException` (quantidade zero).

<details><summary>Dica</summary>

`switch` como *expression* devolve um valor — dá pra atribuir o percentual de desconto direto a uma variável, sem `if`/`else` encadeado. `split(";")` devolve um array de `String`; valide o tamanho antes de acessar cada posição, senão um `ArrayIndexOutOfBoundsException` escapa em vez do `IllegalArgumentException` esperado.

</details>

**Revisa:** `BigDecimal`/`setScale` (fase 1.26), `switch` expression (fase 1.27), `String.format` com largura (fase 1.29), `StringBuilder` (desafio 004).
**Rodar:** `mvn test -Dtest=CupomFiscalTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP

---

Concluir este chefe libera o **Mundo 2 — Collections**.
