# Mundo 14 — Design
> Um `if/else` que cresce a cada regra nova é um cheiro; os padrões clássicos são a resposta testada pra cada cheiro específico.

- **Strategy** — trocar o algoritmo (não o dado) por injeção, no lugar de um `if/else` gigante.
- **Builder** — montar um objeto complexo passo a passo, validando só no final.
- **Observer** — avisar vários interessados quando algo acontece, sem eles se conhecerem.
- **Decorator** — empilhar comportamento (imposto, desconto) sem alterar a classe original.
- **SRP/DIP** — uma classe faz uma coisa, e depende de uma abstração (`Clock`) em vez de uma chamada fixa (`LocalDate.now()`).

**Chefe:** Mercadinho v12: Checkout Plugável — junta Strategy, Observer e Builder num fluxo de checkout só.
**Fonte:** CLAUDE.md, fase 7 (Design) — sem seção própria no dev.java/learn.
