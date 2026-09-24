# 8.03 — Formas Seladas

**Missão:** Calcular a área de uma forma geométrica cobrindo **todos** os tipos possíveis, sem um `default` que esconderia um tipo esquecido.

**Implemente:** `challenges.m08.f03.Calculadora` (`FormaSelada`, `Circulo`, `Retangulo` e `Triangulo` já vêm prontos no esqueleto — não altere)

```java
public static double area(FormaSelada forma)
```

**Regras**
- `FormaSelada` é uma interface `sealed` que só permite `Circulo(double raio)`, `Retangulo(double largura, double altura)` e `Triangulo(double base, double altura)`.
- Círculo: `Math.PI * raio²`. Retângulo: `largura * altura`. Triângulo: `base * altura / 2`.
- `forma` nulo → `IllegalArgumentException`.
- Implemente com `switch` com pattern sobre `forma`, **sem `default`** — o compilador só aceita isso porque `FormaSelada` é `sealed` e todo tipo permitido tem um `case`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `new Circulo(2)` | `12.566...` (`Math.PI * 4`) |
| `new Retangulo(3, 4)` | `12.0` |
| `new Triangulo(6, 4)` | `12.0` |

<details><summary>Dica</summary>

```java
switch (forma) {
  case Circulo c -> Math.PI * c.raio() * c.raio();
  case Retangulo r -> r.largura() * r.altura();
  case Triangulo t -> t.base() * t.altura() / 2;
}
```

Se você tentar remover um dos três `case`, o código para de compilar — é exatamente essa a garantia que `sealed` + `switch` exaustivo oferece, e o motivo de não precisar de `default`.

</details>

**Revisa:** interface + polimorfismo (fase 3.03) — `sealed` é o mesmo conceito, mas com a lista de implementações fechada e conhecida em tempo de compilação.
**Rodar:** `mvn test -Dtest=CalculadoraTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
