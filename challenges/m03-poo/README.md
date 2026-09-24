# Mundo 3 — POO
> Sintaxe e Collections resolvem um problema por vez; POO organiza vários problemas relacionados dentro de um modelo coerente.

- **Imutabilidade com fábrica estática** — construtor privado, validação num único ponto de entrada.
- **Record com construtor compacto** — validação que roda em toda criação, sem repetir código.
- **"Wither"** — em vez de um `setter` que muda o objeto, um método que devolve uma cópia com um campo diferente.
- **Interface e polimorfismo** — mesmo método, comportamento diferente por tipo concreto.
- **Enum com comportamento por constante** — cada valor do enum pode ter sua própria implementação de um método.
- **Método `default` em interface** — comportamento compartilhado que um tipo implementador pode herdar ou sobrescrever.

**Chefe:** Mercadinho v1: Estoque — modelar itens de estoque com `record`, agrupar por categoria com `enum`, calcular valor total com `BigDecimal` guardado num `Map`.
**Fonte:** https://dev.java/learn/language/oop/
