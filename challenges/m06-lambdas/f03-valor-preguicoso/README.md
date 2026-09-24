# 6.03 — Valor Preguiçoso

**Missão:** Adiar um cálculo caro até que alguém realmente precise do resultado — e nunca refazer esse cálculo depois.

**Implemente:** `challenges.m06.f03.Preguicoso<T>`

```java
public Preguicoso(Supplier<T> fornecedor)
public T obter()
```

**Regras**
- `fornecedor` nulo no construtor → `IllegalArgumentException`.
- Nada é calculado no construtor.
- A primeira chamada de `obter()` invoca `fornecedor.get()` e guarda o resultado.
- Qualquer chamada seguinte de `obter()` devolve o valor guardado, **sem** invocar `fornecedor` de novo — mesmo que o valor calculado seja `null`.

**Exemplos**

Com `new Preguicoso<>(() -> "resultado")`: antes de chamar `obter()`, o fornecedor nunca foi chamado; depois de duas chamadas a `obter()`, o fornecedor foi chamado exatamente uma vez e as duas retornam `"resultado"`.

<details><summary>Dica</summary>

Um campo `boolean` (ou verificar se o campo do valor ainda não foi preenchido) para saber se já calculou. Cuidado: se o valor calculado puder ser `null`, comparar o campo com `== null` para decidir "já calculei" não funciona — use uma flag separada.

</details>

**Revisa:** `Predicate<T>` (fase 6.01) é uma interface funcional; `Supplier<T>` é outra, sem parâmetro, só devolvendo um valor.
**Rodar:** `mvn test -Dtest=PreguicosoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
