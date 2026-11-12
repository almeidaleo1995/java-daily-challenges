# 3.01 — Temperatura

**Missão:** Modelar uma temperatura como um valor imutável — depois de criado, nunca muda — criado sempre por um método de fábrica, não por `new` direto.

**O que vamos trabalhar:** um objeto **imutável** (depois de criado, nunca muda) que só nasce por um método de fábrica, nunca por `new` direto. É o jeito mais seguro de garantir que ninguém crie uma `Temperatura` inválida.

**Na prática:** você cria a classe `Temperatura`, esconde o construtor, e expõe um único "portão" (`deCelsius`) que valida o valor antes de deixar o objeto existir.

**Glossário rápido**
- **Imutável** — objeto sem nenhum jeito de alterar o estado depois de criado (campos `final`, sem setters).
- **Construtor `private`** — só código de dentro da própria classe consegue chamar.
- **Fábrica estática** — método `static` que devolve uma instância; é o lugar certo para validar.
- **Zero absoluto** — `-273.15 °C`, a menor temperatura possível (regra de negócio desta fase).

**Pesquise sobre:** `java classe imutável` · `java construtor privado static factory method` · `java final field`

**Implemente:** `challenges.m03.f01.Temperatura`

```java
public static Temperatura deCelsius(double valor)
public double celsius()
public double paraFahrenheit()
```

**Regras**
- `deCelsius` é a única forma de criar uma `Temperatura` (o construtor não é público).
- `valor` menor que `-273.15` (zero absoluto) lança `IllegalArgumentException`. `-273.15` exato é válido.
- `paraFahrenheit()` converte com a fórmula `celsius * 9/5 + 32`.
- Depois de criada, uma `Temperatura` não tem nenhum método que altere seu valor.

**Exemplos**

| Entrada | Saída |
|---|---|
| `Temperatura.deCelsius(0).paraFahrenheit()` | `32.0` |
| `Temperatura.deCelsius(100).paraFahrenheit()` | `212.0` |
| `Temperatura.deCelsius(-300)` | lança `IllegalArgumentException` |

<details><summary>Dica</summary>

Um construtor `private` só pode ser chamado de dentro da própria classe — um método `static` público faz esse papel de "porta de entrada", validando antes de construir. Isso se chama fábrica estática.

</details>

**Revisa:** `IllegalArgumentException` para validar entrada (desafio 008).
**Rodar:** `mvn test -Dtest=TemperaturaTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
