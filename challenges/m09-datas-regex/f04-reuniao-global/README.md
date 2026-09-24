# 9.04 — Reunião Global

**Missão:** Converter um horário de referência para o horário local de outro fuso, formatado para exibição.

**Implemente:** `challenges.m09.f04.Fusos`

```java
public static String horarioEm(ZonedDateTime referencia, String zonaDestino)
```

**Regras**
- Converte `referencia` (que já tem seu próprio fuso embutido) para o fuso `zonaDestino` (ex.: `"Europe/London"`), preservando o instante — só muda a representação local.
- Devolve a data e hora resultantes formatadas como `"dd/MM/yyyy HH:mm"`.
- `referencia` ou `zonaDestino` nulos → `IllegalArgumentException`.
- `zonaDestino` que não é um fuso válido (`ZoneId.of` lança `DateTimeException`) → `IllegalArgumentException`.

**Exemplos**

Com `referencia = ZonedDateTime.of(2024, 5, 15, 10, 0, 0, 0, ZoneId.of("America/Sao_Paulo"))` (UTC-3 o ano todo) e `zonaDestino = "Europe/London"` (UTC+1 em maio, horário de verão britânico): `horarioEm` devolve `"15/05/2024 14:00"`.

<details><summary>Dica</summary>

`referencia.withZoneSameInstant(ZoneId.of(zonaDestino))` troca o fuso mantendo o mesmo instante no tempo (o oposto de só trocar o número da hora) — depois é formatar com `DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")`.

</details>

**Revisa:** `LocalDate`/`Period` (fase 9.01) — `ZonedDateTime` é a mesma família, mas carregando fuso horário junto.
**Rodar:** `mvn test -Dtest=FusosTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
