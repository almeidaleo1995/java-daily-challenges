# 7.07 — Refatore para Stream

**Missão:** Reescrever um laço imperativo como um pipeline de Stream, chegando exatamente ao mesmo resultado.

**O que vamos trabalhar:** **refatorar** — transformar um laço `for` com `if` e acumulador num pipeline de Stream **sem mudar o resultado**. Treina a leitura: "o que esse laço faz, em etapas?"

**Na prática:** abra `RefatoracaoImperativa` e descreva em português o que ela faz, em passos (*pegue só os pares → eleve ao quadrado → some*). Cada passo vira uma etapa do stream. Os mesmos testes devem passar para as duas versões.

**Glossário rápido**
- **Imperativo** — você descreve *como* fazer (laço, variável acumuladora).
- **Declarativo** — você descreve *o quê* (filtre, transforme, some).
- **`mapToInt`** — transforma `Stream<Integer>` em `IntStream` para poder usar `sum()`.
- **Refatoração** — mudar a estrutura do código sem mudar o comportamento (os testes garantem isso).

**Pesquise sobre:** `java refatorar for para stream` · `java mapToInt sum` · `java imperativo vs declarativo`

**Implemente:** `challenges.m07.f07.Refatoracao` (`RefatoracaoImperativa` já vem pronta no esqueleto — não altere; é o código a refatorar, só para referência)

```java
public static int somaDosQuadradosDosPares(List<Integer> numeros)
```

**Regras**
- Mesmo comportamento de `RefatoracaoImperativa.somaDosQuadradosDosPares`: soma o quadrado de cada número par da lista.
- `numeros` nula → `IllegalArgumentException`.
- Implemente com um pipeline de Stream (`filter` → `mapToInt` → `sum`), não com um laço `for`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[1, 2, 3, 4]` | `4 + 16 = 20` |
| `[1, 3, 5]` | `0` (nenhum par) |

<details><summary>Dica</summary>

`numeros.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum()` — `mapToInt` troca um `Stream<Integer>` por um `IntStream`, que já tem `.sum()` pronto sem precisar de `Collectors`.

</details>

**Revisa:** `filter`/`map` (fase 7.01) — aqui o objetivo não é aprender um `Collector` novo, é reconhecer quando um laço vira pipeline.
**Rodar:** `mvn test -Dtest=RefatoracaoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
