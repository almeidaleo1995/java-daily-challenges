# 14.04 — Preço em Camadas

**Missão:** Empilhar imposto e desconto num preço sem alterar a classe do preço original.

**O que vamos trabalhar:** padrão **Decorator** — embrulhar um objeto em outro que implementa a **mesma interface**, adicionando comportamento (imposto, desconto) sem mexer na classe original e podendo empilhar quantas camadas quiser.

**Na prática:** `PrecoBase` devolve o valor puro. `ComImposto` e `ComDesconto` recebem **outro `Preco`** (não um `double`), pedem o `valor()` dele e aplicam o seu efeito. Como todos são `Preco`, `new ComDesconto(new ComImposto(new PrecoBase(100), 10), 5)` funciona. Pergunta-guia: o resultado muda se você inverter a ordem das camadas?

**Glossário rápido**
- **Decorator** — "embrulho" com a mesma interface do objeto embrulhado.
- **Composição** — um objeto contém outro (em vez de herdar dele).
- **Empilhar decoradores** — aplicar efeitos em sequência, cada um sobre o anterior.
- **Percentual** — `10` significa `10%`, então a conta usa `/ 100`.

**Pesquise sobre:** `padrão decorator java` · `composição vs herança java` · `design patterns decorator exemplo`

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
