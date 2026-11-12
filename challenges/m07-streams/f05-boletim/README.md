# 7.05 — Boletim

**Missão:** Separar uma turma em aprovados e reprovados, e montar um boletim em texto com as duas listas.

**O que vamos trabalhar:** **`partitioningBy`** (divide em dois grupos: `true`/`false`) e **`joining`** (junta strings com separador) — e como montar um texto final a partir dos dois.

**Na prática:** primeiro particione os alunos pelo teste `nota >= corte`. Depois, para cada grupo, extraia os nomes e junte com `", "`. Por fim monte `"Aprovados: ...\nReprovados: ..."`. Cuidado com o caso de grupo vazio (o texto não some, só fica sem nomes).

**Glossário rápido**
- **`Collectors.partitioningBy(predicado)`** — devolve `Map<Boolean, List<T>>`, sempre com as duas chaves.
- **`Collectors.joining(sep)`** — concatena `CharSequence`s; funciona em streams de `String`.
- **`\n`** — quebra de linha dentro da string.
- **`map.get(true)`** — acessa o grupo dos que passaram no teste.

**Pesquise sobre:** `java Collectors partitioningBy` · `java Collectors joining` · `java stream nomes separados por vírgula`

**Implemente:** `challenges.m07.f05.Boletim` (`Aluno` já vem pronto no esqueleto — não altere)

```java
public static String gerar(List<Aluno> alunos, double notaDeCorte)
```

**Regras**
- `Aluno(String nome, double nota)`.
- Aprovado: `nota >= notaDeCorte`.
- Devolve exatamente `"Aprovados: nome1, nome2\nReprovados: nome3, nome4"`, com os nomes na ordem original de `alunos` dentro de cada grupo, separados por `", "`.
- Se um grupo ficar vazio, a linha correspondente termina logo depois de `":"` — por exemplo `"Aprovados: \nReprovados: Bia"`.
- `alunos` nula → `IllegalArgumentException`.
- Implemente com `Collectors.partitioningBy` + `Collectors.joining`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[("Ana",8), ("Bia",5), ("Caio",9)]`, `corte=6` | `"Aprovados: Ana, Caio\nReprovados: Bia"` |

<details><summary>Dica</summary>

`partitioningBy` sempre devolve um `Map<Boolean, List<T>>` com exatamente duas chaves (`true` e `false`) — nunca lança se um dos dois grupos ficar vazio, a lista correspondente só vem vazia. `String.join(", ", nomes)` (ou `Collectors.joining(", ")` dentro do próprio pipeline) resolve a junção.

</details>

**Revisa:** `groupingBy`/`counting` (fase 7.02) — `partitioningBy` é o caso especial de agrupar por uma condição de sim/não.
**Rodar:** `mvn test -Dtest=BoletimTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
