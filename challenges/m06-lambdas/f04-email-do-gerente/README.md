# 6.04 — E-mail do Gerente

**Missão:** Buscar o e-mail do gerente de um funcionário numa cadeia com três pontos de falha, sem nenhum `if` explícito de `null`.

**Implemente:** `challenges.m06.f04.Diretorio` (`Funcionario` já vem pronto no esqueleto — não altere)

```java
public Diretorio(Map<String, Funcionario> funcionarios)
public Optional<String> emailDoGerente(String nomeFuncionario)
```

**Regras**
- `funcionarios` mapeia nome → `Funcionario(nome, email, gerente)`, onde `gerente` é o nome do gerente (ou `null` se não tiver).
- `emailDoGerente(nome)` devolve `Optional.empty()` se: o funcionário não existe no diretório, ou existe mas `gerente` é `null`, ou o gerente citado não está no diretório.
- Caso contrário, devolve `Optional.of(email do gerente)`.
- `funcionarios` nulo no construtor → `IllegalArgumentException`.

**Exemplos**

Com `{"Ana": Funcionario("Ana", "ana@x.com", "Bia"), "Bia": Funcionario("Bia", "bia@x.com", null)}`:

| Chamada | Resultado |
|---|---|
| `emailDoGerente("Ana")` | `Optional.of("bia@x.com")` |
| `emailDoGerente("Bia")` | `Optional.empty()` (Bia não tem gerente) |
| `emailDoGerente("Carlos")` | `Optional.empty()` (Carlos não existe) |

<details><summary>Dica</summary>

`Optional.ofNullable(mapa.get(nome))` já resolve o primeiro ponto de falha. Dali, `.map(Funcionario::gerente)` devolve um `Optional<String>` — mas você precisa de outra busca no mapa a partir desse nome, e uma busca que já devolve `Optional` dentro de um `.map` vira `Optional<Optional<...>>`. É exatamente o problema que `flatMap` resolve.

</details>

**Revisa:** `Map` (Mundo 2); `Supplier`/cálculo adiado (fase 6.03) — aqui o "adiado" é a própria busca no mapa.
**Rodar:** `mvn test -Dtest=DiretorioTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
