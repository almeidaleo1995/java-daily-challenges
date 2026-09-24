# 3.02 — Produto

**Missão:** Modelar um produto como `record`, com validação obrigatória em toda criação e um jeito de "alterar" um campo sem mutar o objeto original.

**Implemente:** `challenges.m03.f02.Produto`

```java
public record Produto(String nome, BigDecimal preco) { ... }
public Produto comPreco(BigDecimal novoPreco)
```

**Regras**
- `nome` nulo ou em branco, ou `preco` nulo ou negativo, lançam `IllegalArgumentException` — validados no próprio construtor do `record`, não num método separado.
- `comPreco(novoPreco)` devolve um **novo** `Produto`, com o mesmo `nome` e o `novoPreco`. O `Produto` original não muda.

**Exemplos**

```java
Produto caneta = new Produto("Caneta", new BigDecimal("3.50"));
Produto reajustada = caneta.comPreco(new BigDecimal("4.00"));

caneta.preco();       // ainda 3.50
reajustada.preco();   // 4.00
```

<details><summary>Dica</summary>

Um `record` pode declarar um **construtor compacto** — `public Produto { ... }`, sem lista de parâmetros repetida — que roda antes de os campos serem atribuídos, ideal para validar. Um `record` não tem `setters`; o padrão para "alterar" um campo é criar uma instância nova reaproveitando os outros campos — chamado de "wither" (o oposto de um "getter").

</details>

**Revisa:** `record` (desafio 043 usava classe comum; aqui o mesmo papel de carregar dados é feito por um `record`, mais enxuto).
**Rodar:** `mvn test -Dtest=ProdutoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
