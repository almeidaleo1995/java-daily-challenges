# 10.01 — Linhas Úteis

**Missão:** Contar quantas linhas um arquivo de texto tem.

**Implemente:** `challenges.m10.f01.ContadorDeLinhas`

```java
public static long contar(Path arquivo) throws IOException
```

**Regras**
- Devolve a quantidade de linhas de `arquivo`.
- `arquivo` nulo → `IllegalArgumentException`.
- `arquivo` que não existe → deixe a `IOException` (`NoSuchFileException`) subir, não capture.

**Exemplos**

| Conteúdo do arquivo | Resultado |
|---|---|
| `"a\nb\nc"` | `3` |
| `""` (arquivo vazio) | `0` |

<details><summary>Dica</summary>

`Files.readAllLines(arquivo)` já devolve uma `List<String>` com uma entrada por linha — o tamanho da lista é a resposta. É a forma mais simples de I/O: lê tudo de uma vez, sem `try`-with-resources.

</details>

**Revisa:** `List.size()` (Mundo 2).
**Rodar:** `mvn test -Dtest=ContadorDeLinhasTest`

⭐☆☆☆☆ · ~10 min · +10 XP
