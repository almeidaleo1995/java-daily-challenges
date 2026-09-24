# Trilha em Mundos — Tasks

## Execution Protocol (MANDATORY -- do not skip)

Implement these tasks with the `tlc-spec-driven` skill: **activate it by name and follow its Execute flow and Critical Rules.** Do not search for skill files by filesystem path. The skill is the source of truth for the full flow (per-task cycle, sub-agent delegation, adequacy review, Verifier, discrimination sensor).

**If the skill cannot be activated, STOP and tell the user - do not proceed without it.**

---

**Design**: `.specs/features/trilha-mundos/design.md`
**Status**: Draft

---

## Test Coverage Matrix

> Generated from codebase, project guidelines, and spec - confirm before Execute. Guidelines found: `CLAUDE.md` (seção Testes: JUnit 5, só comportamento entrada → saída, nunca revela o algoritmo; nunca rodar `mvn` por conta própria — exceção aprovada em 2026-09-24: `mvn -q test-compile`), `pom.xml` (JUnit 5.10.2, surefire, spotless/google-java-format). Amostras: `src/test/java/challenges/day043/ContaBancariaTest.java`, `day035`.

| Code Layer | Required Test Type | Coverage Expectation | Location Pattern | Run Command |
| --- | --- | --- | --- | --- |
| Exercício novo (esqueleto + teste) | unit (o teste É o entregável; nasce vermelho por design) | Toda regra do README tem ≥ 1 teste; todo caso inválido do README tem teste da exceção exata; exemplos do README aparecem no teste com os mesmos valores; fase ≥ 4 testes, chefe ≥ 6 | `src/test/java/challenges/mNN/{fNN,chefe}/*Test.java` | `mvn -q test-compile` (o usuário roda `mvn test -Dtest=XTest`) |
| Exercício migrado | none — só muda `package` | Nenhum teste alterado além da linha `package`; mesma contagem de `@Test` antes e depois | idem | `mvn -q test-compile` |
| Markdown (README, PROGRESSO, GLOSSARIO, CLAUDE.md, templates) | none | Todo link relativo aponta para arquivo existente | `challenges/**/*.md`, `CLAUDE.md` | checagem de links (script PowerShell na própria task) |

## Gate Check Commands

> Generated from codebase - confirm before Execute.

| Gate Level | When to Use | Command |
| --- | --- | --- |
| Quick | Tasks de exercício | `mvn -q test-compile` |
| Full | Última task de cada fase | `mvn -q test-compile` + checagem de links de todos os `.md` em `challenges/` |
| Build | Tasks só de Markdown | checagem de links dos `.md` alterados |

**Garantia de teste correto (proposta, depende de aprovação):** para cada exercício novo, o autor escreve uma solução de referência **num worktree temporário fora do repo**, roda o teste só ali (fica verde), injeta 1 erro (fica vermelho) e apaga o worktree. A solução nunca é commitada nem mostrada ao usuário. Sem isso, um valor esperado errado no teste só aparece quando o usuário travar nele.

---

## Execution Plan

Phases run sequentially; tasks inside a phase run in order.

### Phase 1: Fundação

```
T1 → T2 → T3 → T4 → T5 → T6
```

### Phase 2: Mundos 1–5

```
T7 → T8 → T9 → T10 → T11
```

### Phase 3: Mundos 6–10

```
T12 → T13 → T14 → T15 → T16
```

### Phase 4: Mundos 11–15

```
T17 → T18 → T19 → T20 → T21
```

---

## Task Breakdown

### T1: Migrar desafios antigos para o Mundo 1

**What**: `git mv` dos 24 desafios de laço/String/array (tabela "Mundo 1" do design) para `challenges/m01-sintaxe-strings-arrays/fNN-slug/` e `challenges.m01.fNN`, trocando só a linha `package` e acrescentando no topo do README `> Antigo desafio NNN · Mundo 1, fase NN`.
**Where**: `challenges/m01-sintaxe-strings-arrays/`
**Depends on**: None
**Reuses**: arquivos existentes em `challenges/NNN/` e `src/*/java/challenges/dayNNN/`
**Requirement**: MIG-01, MIG-02, MIG-04

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] 24 pastas de enunciado e 48 arquivos Java movidos com `git mv` (histórico preservado)
- [x] Nenhuma diferença além de `package`, a linha de origem e o nome de pacote/caminho citado nos README
- [x] Quantidade de `@Test` igual antes e depois
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: none
**Gate**: quick

**Commit**: `refactor(m01): move syntax, string and array challenges into world 1`

---

### T2: Migrar desafios antigos para o Mundo 2

**What**: Igual ao T1 para os 18 desafios de Collections e o 043 como `challenges/m02-collections/chefe-conta-bancaria/` / `challenges.m02.chefe`.
**Where**: `challenges/m02-collections/`
**Depends on**: T1
**Reuses**: procedimento do T1
**Requirement**: MIG-01, MIG-02, MIG-04

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] 19 pastas de enunciado e 38 arquivos Java movidos com `git mv`
- [x] `challenges/NNN/` e `src/*/java/challenges/dayNNN/` não existem mais
- [x] Quantidade de `@Test` igual antes e depois
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: none
**Gate**: quick

**Commit**: `refactor(m02): move collection challenges into world 2`

---

### T3: Atualizar links do glossário

**What**: Reescrever as colunas Desafio e Teste de `GLOSSARIO.md` para os caminhos novos, sem mudar nenhuma outra célula.
**Where**: `challenges/GLOSSARIO.md`
**Depends on**: T2
**Reuses**: tabela de migração do design
**Requirement**: MIG-03

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] Todo link relativo do glossário aponta para arquivo existente
- [x] Colunas Conceito, Exemplo e Por que usamos idênticas às de antes (diff só nos links)

**Tests**: none
**Gate**: build

**Commit**: `docs(glossario): point links to world paths`

---

### T4: Templates novos

**What**: Criar `MUNDO.template.md`, `FASE.template.md`, `Fase.java.template`, `FaseTest.java.template` no formato do design e apagar os três templates antigos.
**Where**: `challenges/templates/`
**Depends on**: T3
**Reuses**: `challenges/templates/Challenge.java.template`
**Requirement**: TPL-01

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] README de fase no template: Missão, Implemente, Regras, Exemplos, Dica em `<details>`, Revisa, Rodar, rodapé ⭐ · min · XP
- [x] README de mundo no template: 1 frase + até 6 tópicos + Chefe + Fonte
- [x] Templates Java usam `challenges.mNN.fNN` e `UnsupportedOperationException("TODO: implementar")`

**Tests**: none
**Gate**: build

**Commit**: `docs(templates): add world and phase templates`

---

### T5: CLAUDE.md com o fluxo do jogo

**What**: Reescrever as seções "Como funcionam os desafios", "Execução de comandos", "Glossário" e "Progressão de fases" do CLAUDE.md para mundos, fases e chefes, e acrescentar as seções "Revisão com perguntas", "Checagem de sintaxe" e "Progresso e XP". O papel de mentor, a lista "Nunca faça isso" e a escada de dicas continuam iguais.
**Where**: `CLAUDE.md`
**Depends on**: T4
**Reuses**: CLAUDE.md atual
**Requirement**: FLUXO-01, FLUXO-02, FLUXO-03, FLUXO-04, FLUXO-05, FLUXO-06

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] Revisão: de 3 a 5 perguntas diretas antes de aprovar; sem XP se a resposta mostrar que o conceito não ficou claro
- [x] Sintaxe: apontar linha e regra quebrada, sem reescrever o método
- [x] Aprovação atualiza `GLOSSARIO.md` e `PROGRESSO.md` no mesmo passo
- [x] Exceção de comando registrada: Claude pode rodar só `mvn -q test-compile`, e só ao gerar/mover desafios
- [x] Sempre `mvn test -Dtest=Classe`, nunca `mvn test` sem filtro

**Tests**: none
**Gate**: build

**Commit**: `docs(claude): describe world flow, review quiz and progress rules`

---

### T6: PROGRESSO.md e README da trilha

**What**: Criar `PROGRESSO.md` com os 15 mundos, todas as fases do design (links), 001–034 marcados, XP e título calculados, e a seção "Próximos mundos". Reduzir `challenges/README.md` a um parágrafo explicando mundos, fases, chefes e onde fica o progresso.
**Where**: `challenges/PROGRESSO.md`
**Depends on**: T5
**Reuses**: mapa das fases e backlog do design
**Requirement**: MAPA-01, MAPA-02, MAPA-03, MAPA-04, BACK-01, BACK-02

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] 15 mundos na ordem; mundos 1 e 2 liberados, 3 a 15 com 🔒
- [x] XP = soma de ⭐ × 10 das fases 001–034; título = Estagiário (0 chefes)
- [x] Seção "Próximos mundos" com os 6 temas do design
- [x] Links das fases migradas funcionam (os das fases novas passam a funcionar conforme T7–T21)

**Tests**: none
**Gate**: full

**Commit**: `docs(progresso): add game map with xp, titles and backlog`

---

### T7: Mundo 1 — fases novas e chefe

**What**: README do mundo + f25–f29 + chefe Cupom Fiscal (README, esqueleto, teste), conforme o design.
**Where**: `challenges/m01-sintaxe-strings-arrays/`
**Depends on**: None
**Reuses**: templates do T4; padrão de esqueleto de `challenges.m02.f14` (antigo 035)
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (confirmar APIs de `BigDecimal`, `Math.addExact`, `String.format`)
- Skill: NONE

**Done when**:

- [x] 6 exercícios com README, esqueleto e teste; ≥ 4 testes por fase e ≥ 6 no chefe
- [x] Cada README cabe no template, tem ⭐, tempo ≤ 20 min, XP e linha Revisa
- [x] Testes cobrem os exemplos do README com os mesmos valores e cada caso inválido com a exceção exata
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m01): add number, bigdecimal and switch phases with cupom fiscal boss`

---

### T8: Mundo 2 — fases novas

**What**: README do mundo + f19–f24 (o chefe é o 043 migrado).
**Where**: `challenges/m02-collections/`
**Depends on**: T7
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`Comparator`, `TreeSet`, `PriorityQueue`, `SequencedCollection`)
- Skill: NONE

**Done when**:

- [x] 6 exercícios completos; ≥ 4 testes por fase
- [x] f22 testa o contrato via `HashSet`/`HashMap`, não chamando `equals` direto
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m02): add comparator, tree, priority and equality phases`

---

### T9: Mundo 3 — POO

**What**: README do mundo + f01–f05 + chefe Mercadinho v1: Estoque.
**Where**: `challenges/m03-poo/`
**Depends on**: T8
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (records, construtor compacto, enums)
- Skill: NONE

**Done when**:

- [x] 6 exercícios completos; tipos que o teste instancia existem no esqueleto só com o necessário para compilar
- [x] O chefe usa `Map` (M2) e `BigDecimal` (M1)
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m03): add oop world with estoque boss`

---

### T10: Mundo 4 — Exceções

**What**: README do mundo + f01–f04 + chefe Mercadinho v2: Pedido Atômico.
**Where**: `challenges/m04-excecoes/`
**Depends on**: T9
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`AutoCloseable`, `addSuppressed`)
- Skill: NONE

**Done when**:

- [x] 5 exercícios completos; código "dado" marcado `// Dado: não altere.`
- [x] Testes verificam o tipo da exceção, a `cause` (f03) e as suprimidas (f04)
- [x] O chefe testa o rollback: estado inalterado após falha
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m04): add exceptions world with atomic order boss`

---

### T11: Mundo 5 — Generics

**What**: README do mundo + f01–f05 + chefe Mercadinho v3: Repositório.
**Where**: `challenges/m05-generics/`
**Depends on**: T10
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (wildcards, `LinkedHashMap.removeEldestEntry`)
- Skill: NONE

**Done when**:

- [x] 5 exercícios completos; as assinaturas genéricas do esqueleto já são as finais (o exercício é o corpo)
- [x] Gate check passes: `mvn -q test-compile` + checagem de links de `challenges/`

**Tests**: unit
**Gate**: full

**Commit**: `feat(m05): add generics world with repository boss`

---

### T12: Mundo 6 — Lambdas e Optional

**What**: README do mundo + f01–f05 + chefe Mercadinho v4: Promoções.
**Where**: `challenges/m06-lambdas/`
**Depends on**: None
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`java.util.function`, `Optional`)
- Skill: NONE

**Done when**:

- [x] 5 exercícios completos; f03 testa que o `Supplier` roda uma vez só (contador no teste)
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m06): add lambdas and optional world with promotions boss`

---

### T13: Mundo 7 — Streams

**What**: README do mundo + f01–f07 + chefe Mercadinho v5: Relatório de Vendas.
**Where**: `challenges/m07-streams/`
**Depends on**: T12
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`Collectors`)
- Skill: NONE

**Done when**:

- [x] 8 exercícios completos; f07 traz a versão imperativa marcada `// Dado`, e o teste compara as duas saídas
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m07): add streams world with sales report boss`

---

### T14: Mundo 8 — Pattern Matching

**What**: README do mundo + f01–f04 + chefe Mercadinho v6: Pagamentos.
**Where**: `challenges/m08-pattern-matching/`
**Depends on**: T13
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (sealed, record patterns, Java 21)
- Skill: NONE

**Done when**:

- [x] 5 exercícios completos; hierarquias `sealed` já declaradas no esqueleto
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m08): add pattern matching world with payments boss`

---

### T15: Mundo 9 — Datas e Regex

**What**: README do mundo + f01–f06 + chefe Mercadinho v7: Validade de Lotes.
**Where**: `challenges/m09-datas-regex/`
**Depends on**: T14
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`java.time`, `java.util.regex`)
- Skill: NONE

**Done when**:

- [x] 7 exercícios completos; datas sempre recebidas por parâmetro (nunca `LocalDate.now()` no teste)
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m09): add dates and regex world with batch expiry boss`

---

### T16: Mundo 10 — I/O

**What**: README do mundo + f01–f05 + chefe Mercadinho v8: Importar Estoque.
**Where**: `challenges/m10-io/`
**Depends on**: T15
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`java.nio.file.Files`)
- Skill: NONE

**Done when**:

- [x] 6 exercícios completos; todo teste usa `@TempDir`
- [x] Gate check passes: `mvn -q test-compile` + checagem de links de `challenges/`

**Tests**: unit
**Gate**: full

**Commit**: `feat(m10): add io world with stock import boss`

---

### T17: Mundo 11 — Algoritmos

**What**: README do mundo + f01–f06 + chefe Mercadinho v9: Troco Mínimo.
**Where**: `challenges/m11-algoritmos/`
**Depends on**: None
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [x] 7 exercícios completos; f03 e o chefe têm um caso grande que só passa com memoização/DP (`assertTimeoutPreemptively`)
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m11): add algorithms world with change-making boss`

---

### T18: Mundo 12 — Concorrência

**What**: README do mundo + f01–f08 + chefe Mercadinho v10: Checkout Concorrente.
**Where**: `challenges/m12-concorrencia/`
**Depends on**: T17
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`java.util.concurrent`, virtual threads)
- Skill: NONE

**Done when**:

- [x] 9 exercícios completos; todo teste com `assertTimeoutPreemptively`, número fixo de tarefas e sem `Thread.sleep` como sincronização
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m12): add concurrency world with concurrent checkout boss`

---

### T19: Mundo 13 — Reflection e Anotações

**What**: README do mundo + f01–f04 + chefe Mercadinho v11: Mapeador CSV.
**Where**: `challenges/m13-reflection/`
**Depends on**: T18
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: `context7` (`java.lang.reflect`, `MethodHandles`)
- Skill: NONE

**Done when**:

- [x] 5 exercícios completos; em f03 a anotação `@Obrigatorio` vem **sem** `@Retention` (descobrir isso é parte do exercício)
- [x] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m13): add reflection world with csv mapper boss`

---

### T20: Mundo 14 — Design

**What**: README do mundo + f01–f05 + chefe Mercadinho v12: Checkout Plugável.
**Where**: `challenges/m14-design/`
**Depends on**: T19
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [ ] 6 exercícios completos; f05 traz a versão acoplada marcada `// Dado`, e o teste usa `Clock.fixed`
- [ ] Gate check passes: `mvn -q test-compile`

**Tests**: unit
**Gate**: quick

**Commit**: `feat(m14): add design world with pluggable checkout boss`

---

### T21: Mundo 15 — Chefão Final

**What**: README do mundo + f01–f04 + chefe Mercadinho Final: Auditoria.
**Where**: `challenges/m15-final/`
**Depends on**: T20
**Reuses**: templates do T4
**Requirement**: MUN-01, MUN-02, MUN-03, MUN-04, MUN-05, MUN-06, MUN-07

**Tools**:

- MCP: NONE
- Skill: NONE

**Done when**:

- [ ] 5 exercícios completos
- [ ] Todo link de `PROGRESSO.md` aponta para arquivo existente
- [ ] Gate check passes: `mvn -q test-compile` + checagem de links de `challenges/`

**Tests**: unit
**Gate**: full

**Commit**: `feat(m15): add final world with audit boss`

---

## Phase Execution Map

```
Phase 1 → Phase 2 → Phase 3 → Phase 4

Phase 1:  T1 → T2 → T3 → T4 → T5 → T6
Phase 2:  T7 → T8 → T9 → T10 → T11
Phase 3:  T12 → T13 → T14 → T15 → T16
Phase 4:  T17 → T18 → T19 → T20 → T21
```

Batches (~7 tasks, fases inteiras): **A** = Fase 1 (6) · **B** = Fase 2 (5) · **C** = Fase 3 (5) · **D** = Fase 4 (5).

---

## Task Granularity Check

| Task | Scope | Status |
| --- | --- | --- |
| T1, T2 | 1 mundo migrado (renomeação mecânica, coesa) | ⚠️ vários arquivos, uma operação só |
| T3, T4, T5, T6 | 1 arquivo / 1 pasta de templates | ✅ |
| T7–T21 | 1 mundo = 4–9 exercícios (README + esqueleto + teste cada) | ⚠️ vários arquivos, mas um mundo é a unidade que o usuário revisa e o gate compila; quebrar por exercício daria 93 commits sem ganho de verificação |

## Diagram-Definition Cross-Check

| Task | Depends On (body) | Diagram Shows | Status |
| --- | --- | --- | --- |
| T1 | None | início da Fase 1 | ✅ |
| T2 | T1 | T1 → T2 | ✅ |
| T3 | T2 | T2 → T3 | ✅ |
| T4 | T3 | T3 → T4 | ✅ |
| T5 | T4 | T4 → T5 | ✅ |
| T6 | T5 | T5 → T6 | ✅ |
| T7 | None (Fase 1 concluída) | início da Fase 2 | ✅ |
| T8 | T7 | T7 → T8 | ✅ |
| T9 | T8 | T8 → T9 | ✅ |
| T10 | T9 | T9 → T10 | ✅ |
| T11 | T10 | T10 → T11 | ✅ |
| T12 | None (Fase 2 concluída) | início da Fase 3 | ✅ |
| T13 | T12 | T12 → T13 | ✅ |
| T14 | T13 | T13 → T14 | ✅ |
| T15 | T14 | T14 → T15 | ✅ |
| T16 | T15 | T15 → T16 | ✅ |
| T17 | None (Fase 3 concluída) | início da Fase 4 | ✅ |
| T18 | T17 | T17 → T18 | ✅ |
| T19 | T18 | T18 → T19 | ✅ |
| T20 | T19 | T19 → T20 | ✅ |
| T21 | T20 | T20 → T21 | ✅ |

## Test Co-location Validation

| Task | Code Layer | Matrix Requires | Task Says | Status |
| --- | --- | --- | --- | --- |
| T1, T2 | Exercício migrado | none | none | ✅ |
| T3–T6 | Markdown | none | none | ✅ |
| T7–T21 | Exercício novo | unit | unit | ✅ |
