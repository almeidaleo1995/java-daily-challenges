# 9.03 — Próximo Dia Útil

**Missão:** Achar o próximo dia que não é fim de semana nem feriado, a partir de uma data.

**Implemente:** `challenges.m09.f03.DiaUtil`

```java
public static LocalDate proximoDiaUtil(LocalDate data, Set<LocalDate> feriados)
```

**Regras**
- Devolve o primeiro dia **depois** de `data` (nunca a própria `data`) que não cai em sábado, domingo, nem está em `feriados`.
- `data` ou `feriados` nulos → `IllegalArgumentException`.

**Exemplos**

| `data` | `feriados` | Resultado |
|---|---|---|
| sexta `2024-05-17` | `{}` | segunda `2024-05-20` (pula sábado e domingo) |
| quinta `2024-05-16` | `{2024-05-17}` (sexta é feriado) | segunda `2024-05-20` (pula sexta, sábado e domingo) |

<details><summary>Dica</summary>

`data.getDayOfWeek()` devolve um `DayOfWeek`, que tem `SATURDAY` e `SUNDAY` como constantes comparáveis com `==`. Um laço que avança um dia por vez (`data = data.plusDays(1)`) e testa as três condições a cada volta resolve sem precisar de `TemporalAdjusters`.

</details>

**Revisa:** `Set.contains` (Mundo 2) para os feriados; laço com condição de parada (Mundo 1).
**Rodar:** `mvn test -Dtest=DiaUtilTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
