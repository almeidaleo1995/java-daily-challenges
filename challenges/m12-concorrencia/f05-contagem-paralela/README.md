# 12.05 — Contagem Paralela

**Missão:** Contar ocorrências de palavras dividindo a lista entre várias threads, todas somando no mesmo mapa.

**O que vamos trabalhar:** **coleções concorrentes** — um `Map` que várias threads atualizam ao mesmo tempo sem corromper (`ConcurrentHashMap`), e o `merge` atômico para contar.

**Na prática:** repartir a lista em pedaços (cada thread pega uma faixa de índices) e cada thread faz `mapa.merge(palavra, 1, Integer::sum)`. Depois, `join` em todas. Por que não `HashMap`? Porque escritas simultâneas podem perder dados ou até travar. Por que não `get` + `put`? Porque não é atômico (race condition da f01).

**Glossário rápido**
- **`ConcurrentHashMap`** — `Map` seguro para acesso de várias threads.
- **`merge(chave, 1, Integer::sum)`** — "se não existe, coloca 1; se existe, soma 1" — atomicamente.
- **Particionar** — dividir o trabalho em faixas (`subList` ou índices).
- **Thread-safe** — pode ser usada por várias threads ao mesmo tempo com segurança.

**Pesquise sobre:** `java ConcurrentHashMap merge` · `java HashMap thread safe problema` · `java dividir lista em partes subList`

**Implemente:** `challenges.m12.f05.ContagemParalela`

```java
public static Map<String, Integer> contarPalavras(List<String> palavras, int numeroDeThreads) throws InterruptedException
```

**Regras**
- Divide `palavras` em `numeroDeThreads` pedaços (aproximadamente iguais) e processa cada pedaço numa thread.
- Todas as threads somam no **mesmo** mapa compartilhado — um `HashMap` comum corromperia com escritas concorrentes; use `ConcurrentHashMap` com `merge(palavra, 1, Integer::sum)`.
- Espera todas as threads terminarem antes de devolver o mapa.
- `palavras` nulo → `IllegalArgumentException`. `numeroDeThreads` menor ou igual a zero → `IllegalArgumentException`.

**Exemplos**

| `palavras` | `numeroDeThreads` | Resultado |
|---|---|---|
| `["a","b","a","c","b","a"]` | `3` | `{a=3, b=2, c=1}` |

<details><summary>Dica</summary>

`mapa.merge(palavra, 1, Integer::sum)` faz "se a chave não existe, coloca `1`; se existe, soma `1` ao valor atual" — tudo numa operação atômica só, segura mesmo com várias threads chamando ao mesmo tempo.

</details>

**Revisa:** `Map`/`getOrDefault` (Mundo 2), `Thread` (fase 12.01).
**Rodar:** `mvn test -Dtest=ContagemParaleloTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
