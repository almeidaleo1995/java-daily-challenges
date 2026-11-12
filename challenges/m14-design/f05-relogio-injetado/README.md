# 14.05 — Relógio Injetado

**Missão:** Refatorar um código que chama `LocalDate.now()` direto (impossível de testar de forma determinística) pra receber o relógio de fora.

**O que vamos trabalhar:** **testabilidade** — código que chama `LocalDate.now()` direto depende do relógio do computador, então o resultado muda a cada dia e fica impossível de testar com valor fixo. A solução: **injetar** um `Clock` de fora.

**Na prática:** em vez de `LocalDate.now()`, use a versão que recebe um `Clock` e guarde esse `Clock` no construtor. Em produção você passa o relógio do sistema; no teste passa um relógio **fixo** — o teste fica determinístico.

**Glossário rápido**
- **`Clock`** — abstração do "relógio" do `java.time`; `LocalDate.now(clock)`.
- **`Clock.fixed(instant, zona)`** — relógio parado, perfeito para testes.
- **`Clock.systemDefaultZone()`** — relógio real (o que você usaria em produção).
- **Determinístico** — mesma entrada, mesmo resultado, sempre.
- **Injeção de dependência** — receber o que você usa em vez de criá-lo dentro da classe.

**Pesquise sobre:** `java Clock fixed teste` · `java LocalDate now clock` · `injeção de dependência testabilidade`

**Implemente:** `challenges.m14.f05.GeradorDeBoleto` (`GeradorDeBoletoAcoplado` já vem pronto no esqueleto, só pra você ver o problema — não altere, e note que ele **não tem teste**: é impossível testar de forma determinística com `LocalDate.now()` fixo direto no código)

```java
public GeradorDeBoleto(Clock relogio)
public String gerar(String cliente, double valor)
```

**Regras**
- `relogio` nulo no construtor → `IllegalArgumentException`.
- `gerar(cliente, valor)`: `cliente` nulo ou em branco → `IllegalArgumentException`. `valor` menor ou igual a zero → `IllegalArgumentException`.
- Devolve `"cliente|valor|vencimento"`, onde `vencimento` é a data de hoje (segundo o `relogio` injetado — nunca `LocalDate.now()` sem argumento) mais 30 dias, no formato `LocalDate` padrão (`AAAA-MM-DD`).

**Exemplos**

Com `relogio` fixo em `2024-01-01` (`Clock.fixed(Instant.parse("2024-01-01T00:00:00Z"), ZoneId.of("UTC"))`):

| Chamada | Resultado |
|---|---|
| `gerar("Ana", 100.0)` | `"Ana\|100.0\|2024-01-31"` |

<details><summary>Dica</summary>

`LocalDate.now(relogio)` faz a mesma coisa que `LocalDate.now()`, só que a partir do `Clock` passado em vez do relógio real do sistema. Em teste, `Clock.fixed(...)` sempre devolve o mesmo instante — é isso que torna `GeradorDeBoleto` testável, ao contrário de `GeradorDeBoletoAcoplado`.

</details>

**Revisa:** `LocalDate`/`plusDays` (Mundo 9), validação de argumento (Mundo 4).
**Rodar:** `mvn test -Dtest=GeradorDeBoletoTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
