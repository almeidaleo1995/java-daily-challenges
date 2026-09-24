# 👑 Chefe do Mundo 9 — Mercadinho v7: Validade de Lotes

**Missão:** Separar os produtos já vencidos dos que estão perto de vencer, a partir dos lotes em estoque.

**Implemente:** `challenges.m09.chefe.ControleDeValidade` (`LoteDeProduto` já vem pronto no esqueleto — não altere)

```java
public static List<String> vencidos(List<LoteDeProduto> lotes, LocalDate hoje)
public static List<String> proximosDoVencimento(List<LoteDeProduto> lotes, LocalDate hoje, int diasDeAlerta)
```

**Regras**
- `LoteDeProduto(String produto, LocalDate validade)`.
- `vencidos`: nomes dos produtos cuja `validade` é **anterior** a `hoje`, em ordem alfabética.
- `proximosDoVencimento`: nomes dos produtos cujos dias até vencer (`hoje` → `validade`, via `ChronoUnit.DAYS`) estão entre `0` e `diasDeAlerta`, **ambos inclusive** — ou seja, ainda não venceram, mas vencem dentro da janela de alerta. Ordenados pela validade, da mais próxima para a mais distante.
- `lotes` ou `hoje` nulos → `IllegalArgumentException`.
- `diasDeAlerta` negativo → `IllegalArgumentException`.
- Implemente com pipelines de Stream (`filter` → `sorted` → `map` → `toList`).

**Exemplos**

Com `lotes = [("Leite","2024-05-10"), ("Arroz","2024-06-01"), ("Feijão","2024-05-20")]` e `hoje = "2024-05-15"`:

| Chamada | Resultado |
|---|---|
| `vencidos(lotes, hoje)` | `["Leite"]` (10/05 é antes de 15/05) |
| `proximosDoVencimento(lotes, hoje, 7)` | `["Feijão"]` (vence em 5 dias; Arroz vence em 17, fora da janela; Leite já venceu) |

<details><summary>Dica</summary>

`ChronoUnit.DAYS.between(hoje, lote.validade())` devolve um `long` negativo se `validade` já passou, zero se é hoje, positivo se é no futuro — a mesma conta serve para os dois métodos, só muda o filtro.

</details>

**Revisa:** `LocalDate`/diferença de datas (fase 9.01), `filter`/`sorted`/`map` (Mundo 7), `record` (Mundo 3).
**Rodar:** `mvn test -Dtest=ControleDeValidadeTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 10 — I/O**.
