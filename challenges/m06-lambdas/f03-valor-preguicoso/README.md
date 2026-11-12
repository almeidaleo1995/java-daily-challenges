# 6.03 — Valor Preguiçoso

**Missão:** Adiar um cálculo caro até que alguém realmente precise do resultado — e nunca refazer esse cálculo depois.

**O que vamos trabalhar:** **`Supplier<T>`** e **avaliação preguiçosa (lazy)** — adiar um cálculo até o primeiro uso e **guardar** o resultado para nunca refazer.

**Na prática:** a classe guarda o `Supplier` sem chamá-lo. No primeiro `obter()` você chama `get()` e memoriza o valor; nos seguintes devolve o memorizado. Cuidado: se o valor calculado for `null`, "já calculei?" não pode ser decidido olhando só o valor. O que mais você precisa guardar?

**Glossário rápido**
- **`Supplier<T>`** — não recebe nada, devolve `T` (método `get`).
- **Lazy (preguiçoso)** — só calcula quando alguém pede.
- **Memoização / cache de valor** — guardar o resultado para reaproveitar.
- **Flag (`boolean`)** — variável de controle de estado ("já foi calculado").

**Pesquise sobre:** `java Supplier get` · `java lazy initialization` · `java memoização`

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
