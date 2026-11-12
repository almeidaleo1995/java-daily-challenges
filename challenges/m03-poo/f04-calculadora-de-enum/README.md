# 3.04 — Calculadora de Enum

**Missão:** Fazer cada operação de uma calculadora se comportar de um jeito diferente, sem um `switch`/`if` gigante decidindo qual conta fazer.

**O que vamos trabalhar:** `enum` com **comportamento por constante** — cada valor (`SOMA`, `DIVISAO`...) carrega a sua própria conta, no lugar de um `switch` central decidindo tudo.

**Na prática:** `Operacao` é um enum com um método `abstract aplicar(a, b)`. Cada constante escreve a implementação logo após o nome, entre `{ }`. Um segundo método, `porSimbolo`, percorre as constantes e acha a que tem o símbolo pedido.

**Glossário rápido**
- **`enum`** — conjunto fixo de constantes nomeadas; em Java, cada uma é um objeto e pode ter campos e métodos.
- **Método `abstract` no enum** — obriga cada constante a fornecer sua implementação.
- **`values()`** — método estático de todo enum: devolve um array com todas as constantes.
- **`ArithmeticException`** — exceção padrão do Java para contas inválidas (ex.: divisão inteira por zero).

**Pesquise sobre:** `java enum com método abstrato` · `java enum campos e construtor` · `java enum values()`

**Implemente:** `challenges.m03.f04.Operacao`

```java
public abstract double aplicar(double a, double b);
public static Operacao porSimbolo(String simbolo)
```

**Regras**
- `Operacao` tem quatro constantes: `SOMA` (`"+"`), `SUBTRACAO` (`"-"`), `MULTIPLICACAO` (`"*"`), `DIVISAO` (`"/"`).
- Cada constante implementa `aplicar` com sua própria conta.
- `DIVISAO.aplicar(a, 0)` lança `ArithmeticException`.
- `porSimbolo(simbolo)` devolve a constante cujo símbolo bate. Símbolo que não corresponde a nenhuma operação lança `IllegalArgumentException`.

**Exemplos**

| Chamada | Resultado |
|---|---|
| `Operacao.SOMA.aplicar(2, 3)` | `5.0` |
| `Operacao.porSimbolo("*").aplicar(3, 4)` | `12.0` |
| `Operacao.DIVISAO.aplicar(1, 0)` | lança `ArithmeticException` |
| `Operacao.porSimbolo("%")` | lança `IllegalArgumentException` |

<details><summary>Dica</summary>

Um `enum` pode ter um método `abstract`, e cada constante fornece sua própria implementação num bloco `{ }` logo depois dela — sem precisar de `switch` para decidir o comportamento. Todo `enum` tem um método estático `values()` que devolve todas as constantes, na ordem declarada — útil para procurar uma constante por um dos seus campos.

</details>

**Revisa:** `IllegalArgumentException` para entrada não reconhecida (desafio 008).
**Rodar:** `mvn test -Dtest=OperacaoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
