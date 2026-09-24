# 7.04 — Tags Únicas

**Missão:** De várias listas de tags, uma por produto, montar uma única lista sem repetição.

**Implemente:** `challenges.m07.f04.Tags`

```java
public static List<String> tagsUnicas(List<List<String>> listasDeTags)
```

**Regras**
- Junta todas as tags de todas as listas internas numa única lista, sem duplicatas, mantendo a ordem em que cada tag apareceu pela primeira vez.
- `listasDeTags` nula → `IllegalArgumentException`.
- `listasDeTags` vazia, ou só com listas vazias → lista vazia.
- Implemente com `flatMap` + `distinct`, não com um `Set` montado manualmente.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[["java","spring"], ["java","sql"]]` | `["java", "spring", "sql"]` |
| `[[], ["x"]]` | `["x"]` |

<details><summary>Dica</summary>

`listasDeTags.stream().flatMap(List::stream)` transforma um `Stream<List<String>>` num `Stream<String>` só, achatando um nível — depois é só `.distinct().toList()`.

</details>

**Revisa:** `LinkedHashSet` para manter ordem de primeira aparição (fase 2.24) — aqui quem garante isso é `distinct()` num stream sequencial.
**Rodar:** `mvn test -Dtest=TagsTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
