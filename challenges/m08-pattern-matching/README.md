# Mundo 8 — Pattern Matching (Java 21)
> `instanceof` com cast manual e `switch` com `default` genérico escondem casos que o compilador poderia pegar por você.

- **`instanceof` com pattern** — testar o tipo e já capturar a variável tipada, numa linha.
- **`switch` com pattern** — um `case` por tipo, sem cast.
- **Guarda (`when`)** — refinar um `case` de pattern com uma condição extra.
- **`sealed`/`permits`** — declarar de antemão toda a família de tipos possível, para o `switch` cobrir todos sem `default`.
- **Record pattern** — desestruturar um `record` (e um `record` dentro dele) direto no `case`.

**Chefe:** Mercadinho v6: Pagamentos — calcular a taxa de cada forma de pagamento por uma hierarquia `sealed`.
**Fonte:** https://dev.java/learn/language/fp/
