# 6.04 — E-mail do Gerente

**Missão:** Buscar o e-mail do gerente de um funcionário numa cadeia com três pontos de falha, sem nenhum `if` explícito de `null`.

**O que vamos trabalhar:** **`Optional<T>`** — um "pacote" que pode ou não ter um valor, para encadear etapas que podem falhar **sem** vários `if (x != null)`.

**Na prática:** três coisas podem faltar (funcionário, gerente, e-mail do gerente). Em vez de `if` aninhado, você começa com um `Optional`, e usa `map`/`flatMap` para seguir a cadeia: se qualquer elo vier vazio, o resultado inteiro fica vazio.

**Glossário rápido**
- **`Optional.empty()` / `Optional.of(x)` / `Optional.ofNullable(x)`** — formas de criar.
- **`map`** — transforma o conteúdo se existir; senão continua vazio.
- **`flatMap`** — igual ao `map`, mas quando a função **já devolve** um `Optional` (evita `Optional<Optional<...>>`).
- **`null`** — "ausência" sem aviso; o `Optional` torna a ausência explícita no tipo.

**Pesquise sobre:** `java Optional map flatMap diferença` · `java Optional ofNullable` · `java Optional evitar null`

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
