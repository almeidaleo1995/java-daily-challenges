# 3.04 — Calculadora de Enum

**Missão:** Fazer cada operação de uma calculadora se comportar de um jeito diferente, sem um `switch`/`if` gigante decidindo qual conta fazer.

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
