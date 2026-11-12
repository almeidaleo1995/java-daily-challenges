# 10.01 — Linhas Úteis

**Missão:** Contar quantas linhas um arquivo de texto tem.

**O que vamos trabalhar:** o primeiro contato com **arquivos** em Java moderno: `Path` (o endereço do arquivo) e `Files` (as operações). Sem `File`/`FileReader` antigos.

**Na prática:** você recebe um `Path` e precisa saber quantas linhas o arquivo tem. A pergunta é: ler tudo para uma lista e contar, ou contar sem guardar nada? Para esta fase, qualquer um serve; as próximas mostram por que a escolha importa.

**Glossário rápido**
- **`Path`** — caminho de um arquivo/pasta (`Path.of("dados.txt")`).
- **`Files`** — classe utilitária com métodos estáticos (`readAllLines`, `lines`, `write`, `walk`).
- **`IOException`** — exceção **checked** de I/O (o `throws IOException` já está na assinatura; você não captura aqui).
- **`NoSuchFileException`** — subtipo de `IOException` para arquivo inexistente.

**Pesquise sobre:** `java Files readAllLines` · `java Path.of` · `java NoSuchFileException`

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
