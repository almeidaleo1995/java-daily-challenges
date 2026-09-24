# Mundo 4 — Exceções
> Uma exceção mal desenhada esconde o erro real; uma bem desenhada conta exatamente o que deu errado e onde.

- **Exceção checked própria** — quando o compilador obriga quem chama a lidar com uma falha esperada.
- **`try`-with-resources** — fechar um recurso automaticamente, mesmo quando o código lança uma exceção no meio.
- **Tradução de exceção preservando `cause`** — trocar uma exceção de baixo nível por uma que faz sentido no seu domínio, sem perder o rastro original.
- **`addSuppressed`** — quando mais de uma falha acontece na mesma operação e nenhuma pode ser descartada.

**Chefe:** Mercadinho v2: Pedido Atômico — processar um pedido com várias linhas onde, se uma falhar, nenhuma mexe no estoque.
**Fonte:** https://dev.java/learn/language/annotations-exceptions/
