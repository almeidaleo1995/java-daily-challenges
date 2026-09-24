# Mundo 5 — Generics
> Uma classe ou método genérico funciona para qualquer tipo sem duplicar código nem perder a checagem do compilador — a alternativa é `Object` em todo lugar e `ClassCastException` em produção.

- **Classe genérica** — um tipo que parametriza o tipo dos dados que guarda.
- **Método genérico com `Comparable`** — funciona para qualquer tipo que saiba comparar a si mesmo.
- **Tipo limitado (`<T extends X>`)** — restringe o parâmetro de tipo a uma família específica.
- **PECS** (*Producer Extends, Consumer Super*) — quando usar `? extends` e quando usar `? super` num wildcard.
- **Generics com `LinkedHashMap`** — reaproveitar uma classe do JDK para implementar um cache com política própria de descarte.

**Chefe:** Mercadinho v3: Repositório — um repositório genérico que guarda qualquer tipo que se identifique, reaproveitando exceção própria (Mundo 4), `Map` (Mundo 2) e `record` (Mundo 3).
**Fonte:** https://dev.java/learn/language/fp/
