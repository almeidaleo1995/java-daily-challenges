# 14.04 — Preço em Camadas

**Missão:** Empilhar imposto e desconto num preço sem alterar a classe do preço original.

**Implemente:** `challenges.m14.f04.PrecoBase`, `ComImposto` e `ComDesconto` (`Preco` já vem pronta no esqueleto — não altere)

```java
public PrecoBase(double valor)
public ComImposto(Preco precoBase, double percentual)
public ComDesconto(Preco precoBase, double percentual)
// valor() em todos: double
```

**Regras**
- `PrecoBase.valor()` devolve o `valor` recebido no construtor, sem alteração.
- `ComImposto.valor()` = `precoBase.valor() * (1 + percentual / 100)`.
- `ComDesconto.valor()` = `precoBase.valor() * (1 - percentual / 100)`.
- `ComImposto` e `ComDesconto` recebem um `Preco` (não um `double`) no construtor — podem embrulhar `PrecoBase` **ou outro decorador**, empilhando efeitos.
- `precoBase` nulo, ou `percentual` negativo → `IllegalArgumentException`, nos dois decoradores.

**Exemplos**

| Composição | Resultado |
|---|---|
| `new ComImposto(new PrecoBase(100), 20)` | `120.0` |
| `new ComImposto(new ComDesconto(new PrecoBase(100), 10), 20)` | `108.0` (100 → 90 com desconto → 108 com imposto) |

<details><summary>Dica</summary>

`ComImposto` e `ComDesconto` não guardam um número — guardam **outro `Preco`** e chamam `.valor()` nele antes de aplicar seu próprio ajuste. É por isso que dá pra embrulhar um decorador dentro do outro: cada camada só enxerga a de dentro através da interface `Preco`, sem saber se é `PrecoBase` ou outro decorador.

</details>

**Revisa:** interface e polimorfismo (Mundo 3), Strategy (fase 14.01 — composição por interface é a mesma ideia).
**Rodar:** `mvn test -Dtest=PrecoTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
