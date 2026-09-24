# Mundo 9 — Datas e Regex
> Data e hora feitas na mão (contar dias, achar "próxima segunda") viram bug de fuso e ano bissexto; a API de tempo já resolveu isso.

- **`LocalDate`/`Period`** — diferença entre duas datas em anos, meses e dias.
- **`Duration`** — diferença entre dois instantes, em horas/minutos/segundos.
- **`DayOfWeek`/feriados em `Set`** — "dia útil" como regra combinável, não um `switch` gigante.
- **`ZonedDateTime`/`ZoneId`** — o mesmo instante, em horários locais diferentes.
- **`Pattern`/`Matcher`** — validar formato e extrair pedaços de um texto com grupos nomeados.

**Chefe:** Mercadinho v7: Validade de Lotes — separar produtos vencidos dos que estão perto de vencer.
**Fonte:** https://dev.java/learn/api/date-time-regex/
