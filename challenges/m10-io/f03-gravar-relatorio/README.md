# 10.03 — Gravar Relatório

**Missão:** Gravar uma lista de linhas num arquivo, sobrescrevendo qualquer conteúdo anterior.

**O que vamos trabalhar:** **escrever** arquivo com `Files` e controlar a política: criar se não existir, **sobrescrever** se existir. Também o cuidado com `\n` entre linhas, sem linha vazia sobrando no fim.

**Na prática:** junte as linhas num único texto com `\n` entre elas e grave. Alternativamente há um método que grava uma lista de linhas, mas adiciona uma quebra no final — compare com o que o teste exige.

**Glossário rápido**
- **`Files.writeString` / `Files.write`** — gravam texto/linhas num arquivo.
- **`StandardOpenOption`** — opções de abertura: `CREATE`, `TRUNCATE_EXISTING`, `APPEND`.
- **`String.join("\n", linhas)`** — junta as linhas com separador, sem separador no final.
- **Sobrescrever vs. acrescentar** — `TRUNCATE_EXISTING` apaga o anterior; `APPEND` adiciona ao fim.

**Pesquise sobre:** `java Files.writeString StandardOpenOption` · `java String.join` · `java sobrescrever vs append arquivo`

**Implemente:** `challenges.m10.f03.GravadorDeRelatorio`

```java
public static void gravar(Path arquivo, List<String> linhas) throws IOException
```

**Regras**
- Grava cada elemento de `linhas` como uma linha do arquivo, separadas por `"\n"`, sem linha em branco no final.
- Se `arquivo` já existir, o conteúdo anterior é **totalmente substituído** — nunca acrescentado.
- Se `arquivo` não existir, ele é criado.
- `arquivo` ou `linhas` nulos → `IllegalArgumentException`.

**Exemplos**

`gravar(arquivo, List.of("linha 1", "linha 2"))` seguido de `Files.readString(arquivo)` devolve `"linha 1\nlinha 2"`.

Chamar `gravar` de novo com `List.of("nova linha")` no mesmo `arquivo` faz `Files.readString(arquivo)` devolver só `"nova linha"` — o conteúdo antigo não sobra.

<details><summary>Dica</summary>

`String.join("\n", linhas)` monta o conteúdo; `Files.writeString(arquivo, conteudo, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)` grava criando se não existir e truncando se existir — sem os dois `StandardOpenOption`, o comportamento padrão de `Files.writeString` já é create+truncate, mas deixá-los explícitos documenta a intenção.

</details>

**Revisa:** `Files.readAllLines`/`Files.lines` (fases 10.01–10.02) — aqui a via é a oposta, escrever em vez de ler.
**Rodar:** `mvn test -Dtest=GravadorDeRelatorioTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
