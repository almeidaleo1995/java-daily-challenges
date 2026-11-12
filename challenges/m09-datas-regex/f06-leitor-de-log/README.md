# 9.06 — Leitor de Log

**Missão:** Extrair data, hora, nível e mensagem de uma linha de log, nomeando cada pedaço em vez de contar posições de grupo.

**O que vamos trabalhar:** regex com **grupos nomeados** — "capturar" pedaços do texto e acessá-los pelo **nome** (`data`, `hora`, `nivel`, `mensagem`), em vez de por posição.

**Na prática:** escreva um padrão em que cada pedaço é um grupo `(?<nome>...)`. Se casar, leia cada grupo com `matcher.group("nome")` e monte o `LinhaDeLog`; se não, devolva `Optional.empty()`. Cuidado com o fim: a mensagem é "o resto da linha".

**Glossário rápido**
- **`Pattern.compile(regex)`** — compila o padrão (reaproveitável, mais eficiente que recompilar).
- **`Matcher`** — objeto que aplica o padrão a um texto (`matches()`, `find()`, `group(...)`).
- **Grupo nomeado `(?<data>\d{4}-\d{2}-\d{2})`** — captura com nome.
- **`.+`** — "um ou mais de qualquer caractere" (para a mensagem).

**Pesquise sobre:** `java regex grupos nomeados` · `java Pattern Matcher group` · `regex capturar parte do texto`

**Implemente:** `challenges.m09.f06.LeitorDeLog` (`LinhaDeLog` já vem pronto no esqueleto — não altere)

```java
public static Optional<LinhaDeLog> interpretar(String linha)
```

**Regras**
- Formato esperado: `"AAAA-MM-DD HH:mm:ss NIVEL mensagem"` (ex.: `"2024-05-15 10:23:45 ERROR Falha ao conectar"`).
- `NIVEL` é uma sequência de letras maiúsculas; `mensagem` é o resto da linha (pode ter espaços).
- Se `linha` casa com o formato → `Optional.of(new LinhaDeLog(data, hora, nivel, mensagem))`.
- Se não casa → `Optional.empty()`.
- `linha` nula → `IllegalArgumentException`.
- Implemente com um `Pattern` de **grupos nomeados** (`(?<data>...)`) e `Matcher.group("data")` — não conte posições de grupo (`group(1)`, `group(2)`...).

**Exemplos**

| Entrada | Resultado |
|---|---|
| `"2024-05-15 10:23:45 ERROR Falha ao conectar"` | `Optional.of(LinhaDeLog("2024-05-15","10:23:45","ERROR","Falha ao conectar"))` |
| `"linha sem formato nenhum"` | `Optional.empty()` |

<details><summary>Dica</summary>

`Pattern.compile("^(?<data>\\d{4}-\\d{2}-\\d{2}) (?<hora>\\d{2}:\\d{2}:\\d{2}) (?<nivel>[A-Z]+) (?<mensagem>.+)$")` — depois `Matcher m = padrao.matcher(linha); if (m.matches()) { ... m.group("data") ... }`.

</details>

**Revisa:** `Pattern`/`matches` (fase 9.05) — aqui, além de validar o formato, você também extrai pedaços dele.
**Rodar:** `mvn test -Dtest=LeitorDeLogTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
