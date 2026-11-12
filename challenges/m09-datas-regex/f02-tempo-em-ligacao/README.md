# 9.02 — Tempo em Ligação

**Missão:** Somar várias durações no formato `HH:mm:ss` numa duração total.

**O que vamos trabalhar:** `Duration` (tempo em horas/minutos/segundos) e como **ler** um texto `HH:mm:ss` validando o formato. É a hora de decidir: dividir a string na mão ou usar uma API de data/hora?

**Na prática:** cada texto vira uma `Duration`; some todas. Formato inválido deve virar `IllegalArgumentException`, então pense em **onde** o erro estoura (qual exceção o Java lança ao falhar a conversão, e como você a traduz — Mundo 4).

**Glossário rápido**
- **`Duration`** — quantidade de tempo (horas, minutos, segundos), não uma data.
- **`Duration.ZERO`** — duração vazia; elemento neutro da soma.
- **`plus`** — soma duas durações (devolve nova; é imutável).
- **`LocalTime.parse`** — converte `"HH:mm:ss"` em horário; outra rota possível.

**Pesquise sobre:** `java Duration plus somar` · `java LocalTime parse HH:mm:ss` · `java DateTimeParseException`

**Implemente:** `challenges.m09.f02.TempoDeLigacao`

```java
public static Duration somar(List<String> duracoes)
```

**Regras**
- Cada elemento de `duracoes` está no formato `"HH:mm:ss"` (horas, minutos, segundos).
- Devolve a soma de todas como um `Duration`.
- `duracoes` vazia → `Duration.ZERO`.
- `duracoes` nula, ou algum elemento fora do formato `HH:mm:ss` → `IllegalArgumentException`.

**Exemplos**

| Entrada | Resultado (`toSeconds()`) |
|---|---|
| `["00:10:00", "01:05:30"]` | `4530` (1h15m30s) |
| `[]` | `0` |

<details><summary>Dica</summary>

Não existe um "parser de HH:mm:ss" pronto para `Duration` (o formato dele é outro, tipo `PT1H15M30S`). Separe a `String` pelos `:` (`String.split(":")`), converta cada pedaço para número e monte com `Duration.ofHours(h).plusMinutes(m).plusSeconds(s)` — depois some os `Duration` de cada linha.

</details>

**Revisa:** `String.split` e conversão de texto para número (fases anteriores de Strings, Mundo 1).
**Rodar:** `mvn test -Dtest=TempoDeLigacaoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
