# 9.02 — Tempo em Ligação

**Missão:** Somar várias durações no formato `HH:mm:ss` numa duração total.

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
