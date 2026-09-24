# Mundo 6 — Lambdas e Optional
> Antes de Streams, o alicerce: tratar comportamento como valor, e nunca mais devolver `null`.

- **`Predicate<T>`** — uma pergunta de sim/não sobre um valor, combinável com `and`/`or`/`negate`.
- **`Function<T, R>`** — uma transformação, encadeável com `andThen`/`compose`.
- **`Supplier<T>`** — um valor calculado sob demanda, não antes.
- **`Optional<T>`** — um valor que pode não existir, sem usar `null` para dizer isso.
- **Method reference** — `Classe::metodo` no lugar de uma lambda que só chama um método.

**Chefe:** Mercadinho v4: Promoções — compor descontos como funções e aplicar um cupom opcional.
**Fonte:** https://dev.java/learn/language/fp/
