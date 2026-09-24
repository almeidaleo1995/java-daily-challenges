# 5.03 — Caixa de Números

**Missão:** Guardar qualquer tipo numérico (`Integer`, `Double`, `Long`...) na mesma classe genérica, mas impedir que alguém a use com um tipo que não seja número.

**Implemente:** `challenges.m05.f03.CaixaNumerica<T extends Number>`

```java
public CaixaNumerica(T valor)
public T getValor()
public double dobro()
```

**Regras**
- `valor` nulo lança `IllegalArgumentException`.
- `getValor()` devolve o valor guardado, no tipo original (`T`).
- `dobro()` devolve o valor multiplicado por 2, como `double`.

**Exemplos**

| Entrada | `dobro()` |
|---|---|
| `new CaixaNumerica<>(5)` | `10.0` |
| `new CaixaNumerica<>(2.5)` | `5.0` |

<details><summary>Dica</summary>

`<T extends Number>` restringe `T` a `Number` ou qualquer subtipo dele (`Integer`, `Double`, `Long`...) — tentar `new CaixaNumerica<String>(...)` nem compila. Toda `Number` tem um método que converte para `double`, não importa qual seja o tipo concreto guardado.

</details>

**Revisa:** Tipo limitado — restringir `T` em vez de deixá-lo totalmente livre, diferente da fase 5.02, onde `T` podia ser qualquer `Comparable`.
**Rodar:** `mvn test -Dtest=CaixaNumericaTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
