# 2.19 — Ranking de Jogadores

**Missão:** Ordenar uma lista de jogadores por pontuação, sem escrever a comparação à mão com `if`/`else`.

**O que vamos trabalhar:** **`Comparator`** — um objeto que diz **como comparar** dois elementos, para ordenar sem escrever `if`/`else` à mão. Com `comparing`, `reversed` e `thenComparing` você monta o critério por peças.

**Na prática:** o critério tem duas regras: pontuação **decrescente**, depois nome **crescente** em caso de empate. Pergunte-se: como ordenar por um campo do `record`? Como inverter a ordem? Como acrescentar um segundo critério?

**Glossário rápido**
- **`Comparator.comparing(Jogador::pontuacao)`** — critério por campo.
- **`.reversed()`** — inverte a ordem.
- **`.thenComparing(...)`** — critério de desempate.
- **`List.sort(comparator)`** — ordena a própria lista (**no lugar**).
- **`record`** — classe de dados enxuta (`jogador.pontuacao()`).

**Pesquise sobre:** `java Comparator comparing thenComparing` · `java List sort Comparator` · `java Comparator reversed`

**Implemente:** `challenges.m02.f19.Ranking`

```java
public static void ordenarPorPontuacao(List<Jogador> jogadores)
```

`Jogador` já vem pronto no esqueleto: `record Jogador(String nome, int pontuacao)`.

**Regras**
- Ordena `jogadores` **no lugar** (a própria lista é modificada), do maior para o menor `pontuacao`.
- Em caso de empate na pontuação, desempata pelo `nome` em ordem alfabética crescente.

**Exemplos**

Com `[("Bia", 10), ("Ana", 20), ("Caio", 20)]`, depois de `ordenarPorPontuacao`, a lista fica `[("Ana", 20), ("Caio", 20), ("Bia", 10)]` (Ana antes de Caio: mesma pontuação, "Ana" vem antes na ordem alfabética).

<details><summary>Dica</summary>

`List` tem um método `sort(Comparator)` que ordena a própria lista, sem devolver uma nova. `Comparator.comparing(Jogador::pontuacao)` ordena do menor pro maior — só falta inverter. Encadear um segundo critério de desempate tem um método próprio, para não precisar escrever um `Comparator` novo do zero.

</details>

**Revisa:** Desempate mantendo o primeiro encontrado (desafio 008) — aqui o desempate é explícito, por um segundo critério, não pela ordem de chegada.
**Rodar:** `mvn test -Dtest=RankingTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
