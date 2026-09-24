# Trilha em Mundos — Specification

## Problem Statement

Os 43 desafios vivem numa lista plana (`challenges/NNN`), sem agrupamento por tema, com README longo de 12 seções e sem noção de progresso. O usuário já domina sintaxe e Collections básicas e quer percorrer todo o conteúdo de Java relevante para um desenvolvedor sênior (base: índice do dev.java/learn), em ordem, com exercícios curtos, revisão cumulativa e sensação de jogo — subindo de nível.

## Goals

- [ ] Todo o conteúdo de código do dev.java/learn relevante a sênior (+ Algoritmos e Design do CLAUDE.md) coberto em 15 mundos, cada fase nova ≤ 20 min.
- [ ] Os 43 desafios existentes distribuídos nos mundos do tema deles, sem perder histórico nem soluções.
- [ ] Nível intermediário desde a primeira fase nova: nada de reexplicar o básico, nada de avançado sem ponte.
- [ ] Toda fase de todos os mundos gerada completa (README + esqueleto + testes) de uma vez.
- [ ] Progresso visível num único arquivo (`PROGRESSO.md`) com XP e título.
- [ ] CLAUDE.md define o fluxo de dica, revisão com perguntas e checagem de sintaxe.

## Out of Scope

| Feature | Reason |
| --- | --- |
| JavaFX, JLink, Modules (JPMS) | Não cabem em exercício de 20 min num único módulo Maven |
| JDK tools, JFR, GC tuning, segurança/criptografia, FFM API | Operação/infra da JVM, não exercício de código com teste unitário |
| App/site/dashboard HTML para a trilha | Markdown resolve; nada novo pra manter |
| Contagem automática de XP (script) | `PROGRESSO.md` editado pelo Claude na revisão basta |
| Soluções dos exercícios | Regra do CLAUDE.md: nunca entregar solução |

---

## Assumptions & Open Questions

| Assumption / decision | Chosen default | Rationale | Confirmed? |
| --- | --- | --- | --- |
| Destino de 001–043 | Distribuídos por tema: laços/Strings/arrays/ternário/`Character` → Mundo 1; `List`/`Set`/`Map`/`Deque` → Mundo 2; 043 (Conta Bancária) → chefe do Mundo 2. Cada mundo lista primeiro as fases antigas (ordem original), depois as novas | Pedido do usuário: "coloca direto nos temas" | y |
| Nível das fases novas | Intermediário: partem do que o glossário mostra que o usuário já sabe (ex.: Mundo 1 novo = `BigDecimal`, overflow, `switch` expression, `equals` vs `==`) | Pedido do usuário: nem básico, nem avançado demais | y |
| 043 excede 20 min | Mantido como está (legado, 50 min); regra de ≤ 20 min vale só para fases novas | Não reescrever enunciado já entregue | n |
| Volume de geração | Todos os mundos 1–15 gerados completos agora | Escolha do usuário | y |
| Estrutura de pastas | `challenges/mNN-slug/fNN-slug/README.md`; chefe em `challenges/mNN-slug/chefe-slug/`; README do mundo em `challenges/mNN-slug/README.md` | Tema visível na árvore; slug facilita navegar | n |
| Pacote Java | `challenges.mNN.fNN` e `challenges.mNN.chefe` | Pacote não aceita hífen nem começar com dígito | n |
| Numeração das fases migradas | `fNN` sequencial dentro do mundo, na ordem original dos antigos NNN; classes mantêm o nome; README antigo mantém o conteúdo, só ganha a linha de origem ("antigo 023") | Preserva ordem histórica e soluções | n |
| Mecânica de jogo | XP = estrelas × 10 por fase concluída; título por chefes derrotados (0–1 Estagiário, 2–4 Júnior, 5–8 Pleno, 9–12 Sênior, 13–15 Staff); chefe libera o próximo mundo | Um mecanismo simples e determinístico, sem script | n |
| Chefes com enredo contínuo | Todos os chefes a partir do Mundo 1 evoluem o mesmo domínio (um mercadinho: produtos, estoque, pedidos), cada um autocontido no próprio pacote | "Sequência de evolução" pedida, sem acoplar código entre mundos | n |
| README enxuto | Mundo: 1 frase + 4–6 tópicos "o que é". Fase: Missão, Regras, Exemplos, Dica em `<details>`, Revisa, rodapé ⭐/tempo/XP. Substitui o template de 12 seções | Usuário não gosta de ler muito | n |
| Verificação de compilação | Pedir ao usuário permissão para eu rodar só `mvn -q test-compile` (nunca `mvn test`); sem permissão, o usuário roda ao fim de cada mundo | CLAUDE.md proíbe `mvn` por conta própria; compilar esqueleto não faz parte do exercício | n |

**Open questions:** none - all resolved or logged above (linhas `n` = defaults do agente, aprovados junto com a spec).

---

## User Stories

### P1: Mapa do jogo ⭐ MVP

**User Story**: Como aluno, quero um mapa com todos os mundos e fases, meu XP e meu título, para saber onde estou e o que falta.

**Acceptance Criteria**:

1. The `challenges/PROGRESSO.md` SHALL list all 15 worlds in order, each with its phases as checkboxes linking to the phase README.  <!-- ubiquitous -->
2. The `challenges/PROGRESSO.md` SHALL show current XP and current title at the top.  <!-- ubiquitous -->
3. WHEN a phase is approved in review THEN Claude SHALL tick its checkbox and add ⭐ × 10 to XP in `PROGRESSO.md`.  <!-- event-driven -->
4. WHEN a chefe is approved THEN Claude SHALL mark the next world as unlocked and recompute the title.  <!-- event-driven -->

**Independent Test**: Abrir `PROGRESSO.md`: 001–034 marcados, XP e título coerentes com eles, links abrem os READMEs.

---

### P1: Desafios antigos nos seus temas ⭐ MVP

**User Story**: Como aluno, quero cada um dos meus 43 desafios dentro do mundo do tema dele, sem perder nada.

**Acceptance Criteria**:

1. WHEN migration runs THEN each `challenges/NNN/` SHALL be moved with `git mv` to `challenges/mNN-slug/fNN-slug/` of its theme world, per the mapping in the design (043 → `m02-collections/chefe-conta-bancaria/`).  <!-- event-driven -->
2. WHEN migration runs THEN each `src/{main,test}/java/challenges/dayNNN/` SHALL move to the matching `challenges/mNN/fNN` (043 → `m02/chefe`) with the `package` line updated and no other code change.  <!-- event-driven -->
3. The `GLOSSARIO.md` SHALL have every Desafio/Teste link pointing to the new paths.  <!-- ubiquitous -->
4. IF any README references `dayNNN`, `NNN/README.md` or `mvn test -Dtest=` of a moved class THEN it SHALL be updated to the new package/path.  <!-- unwanted-behavior -->

**Independent Test**: `git log --follow` em um arquivo movido mostra o histórico; `mvn -q test-compile` compila.

---

### P1: Fases novas de todos os mundos geradas ⭐ MVP

**User Story**: Como aluno, quero todos os exercícios prontos para fazer em sequência, do intermediário ao avançado.

**Acceptance Criteria**:

1. The trilha SHALL contain worlds 1–15 as listed in the design; each world SHALL have a world README, 4–8 new phases and 1 chefe (worlds 1–2 also keep their migrated phases).  <!-- ubiquitous -->
2. Each phase SHALL declare Dificuldade (⭐1–5), Tempo (5–20 min) and XP; no phase SHALL exceed 20 minutes.  <!-- ubiquitous -->
3. Each phase SHALL have a skeleton class whose public methods throw `UnsupportedOperationException("TODO: implementar")` and a JUnit 5 test that asserts only input → output behavior.  <!-- ubiquitous -->
4. Each phase README SHALL have a "Revisa" line naming at least one concept already in `GLOSSARIO.md` or in an earlier phase.  <!-- ubiquitous -->
5. WHERE the world number is 3 or higher, the chefe SHALL combine the current world with at least two earlier worlds and SHALL continue the mercadinho storyline.  <!-- optional-feature -->
6. IF a concept is already in the glossary (e.g. what a `String` or `Map` is) THEN world READMEs SHALL NOT re-explain it.  <!-- unwanted-behavior -->
7. The world README SHALL be at most 1 sentence + 6 bullets.  <!-- ubiquitous -->

**Independent Test**: Escolher qualquer fase, ler o README em < 1 min, rodar `mvn test -Dtest=<Classe>Test` e ver os testes falharem com `UnsupportedOperationException`.

---

### P1: CLAUDE.md com o fluxo do jogo ⭐ MVP

**User Story**: Como aluno, quero que o Claude siga sempre o mesmo fluxo de dica, revisão e progresso, sem eu ter que pedir de novo.

**Acceptance Criteria**:

1. The CLAUDE.md SHALL describe the new structure (mundos, fases, chefes, pacotes) replacing the `NNN/dayNNN` section.  <!-- ubiquitous -->
2. WHEN the user asks for a hint THEN CLAUDE.md SHALL require the existing 5-level ladder, starting at level 1.  <!-- event-driven -->
3. WHEN the user asks for review THEN CLAUDE.md SHALL require 3–5 direct questions (why this choice, what happens in edge case X, alternative Y) before approving.  <!-- event-driven -->
4. WHEN the user asks to check syntax THEN CLAUDE.md SHALL require pointing the line and the rule broken, never rewriting the method.  <!-- event-driven -->
5. IF the user's answers show the concept was not understood THEN CLAUDE.md SHALL require no XP and one more guiding question instead of the answer.  <!-- unwanted-behavior -->
6. WHEN a phase is approved THEN CLAUDE.md SHALL require updating `GLOSSARIO.md` and `PROGRESSO.md` in the same step.  <!-- event-driven -->

**Independent Test**: Nova sessão, pedir "revisa meu código da fase X": Claude faz perguntas antes de aprovar.

---

### P2: Backlog de mundos futuros

**User Story**: Como aluno, quero ver o que ainda vem depois da trilha, para saber que o mapa continua.

**Acceptance Criteria**:

1. The `challenges/PROGRESSO.md` SHALL end with a "Próximos mundos" section listing each future theme with one line of scope (at least: Modules/JPMS, JVM e GC, JFR/diagnóstico, testes avançados, segurança com JDK).  <!-- ubiquitous -->
2. WHEN a backlog world is started THEN Claude SHALL move it from "Próximos mundos" into the main map with its phases.  <!-- event-driven -->

---

### P2: Templates novos

**User Story**: Como mantenedor, quero templates que gerem o README enxuto e o esqueleto no pacote novo.

**Acceptance Criteria**:

1. The `challenges/templates/` SHALL contain `MUNDO.template.md`, `FASE.template.md` and code templates using `challenges.mNN.fNN`.  <!-- ubiquitous -->

---

## Edge Cases

- IF a moved exercise was unsolved (035–043) THEN its skeleton SHALL move unchanged and its checkbox SHALL stay unticked.
- IF a test depends on the filesystem (Mundo 10) THEN it SHALL use JUnit `@TempDir`, never fixed paths.
- IF a test involves concurrency (Mundo 12) THEN it SHALL be deterministic (fixed number of tasks, `join`/`awaitTermination` with timeout) and never depend on `Thread.sleep` timing.

## Implicit-requirement sweep

| Dimension | Resolution |
| --- | --- |
| Input validation & bounds | Each phase test covers invalid input where the rules define it (AC Mundos-3) |
| Failure states | N/A because there is no runtime system; migration uses `git mv` and is reversible |
| Idempotency / duplicates | Glossário: one row per concept (existing rule) |
| Auth / rate limits | N/A because local repo with a single user |
| Concurrency / ordering | Mundo 12 tests deterministic (edge case above) |
| Data lifecycle | N/A because nothing expires |
| Observability | `PROGRESSO.md` is the only progress record |
| External-dependency failure | N/A because no new dependency; JUnit 5 only |
| State-transition integrity | Fase: pendente → aprovada (after quiz); chefe approved → next world unlocked |

---

## Requirement Traceability

| Requirement ID | Story | Phase | Status |
| --- | --- | --- | --- |
| MAPA-01 | P1: Mapa do jogo | Design | Pending |
| MAPA-02 | P1: Mapa do jogo | Design | Pending |
| MAPA-03 | P1: Mapa do jogo | Design | Pending |
| MAPA-04 | P1: Mapa do jogo | Design | Pending |
| MIG-01 | P1: Desafios antigos nos temas | Design | Pending |
| MIG-02 | P1: Desafios antigos nos temas | Design | Pending |
| MIG-03 | P1: Desafios antigos nos temas | Design | Pending |
| MIG-04 | P1: Desafios antigos nos temas | Design | Pending |
| MUN-01 | P1: Fases novas | Design | Pending |
| MUN-02 | P1: Fases novas | Design | Pending |
| MUN-03 | P1: Fases novas | Design | Pending |
| MUN-04 | P1: Fases novas | Design | Pending |
| MUN-05 | P1: Fases novas | Design | Pending |
| MUN-06 | P1: Fases novas | Design | Pending |
| MUN-07 | P1: Fases novas | Design | Pending |
| FLUXO-01 | P1: CLAUDE.md | Design | Pending |
| FLUXO-02 | P1: CLAUDE.md | Design | Pending |
| FLUXO-03 | P1: CLAUDE.md | Design | Pending |
| FLUXO-04 | P1: CLAUDE.md | Design | Pending |
| FLUXO-05 | P1: CLAUDE.md | Design | Pending |
| FLUXO-06 | P1: CLAUDE.md | Design | Pending |
| BACK-01 | P2: Backlog | Design | Pending |
| BACK-02 | P2: Backlog | Design | Pending |
| TPL-01 | P2: Templates | Design | Pending |

**Coverage:** 24 total, 0 mapped to tasks.

## Success Criteria

- [ ] `mvn -q test-compile` passa com toda a trilha gerada.
- [ ] Qualquer fase é lida em menos de 1 minuto.
- [ ] Nenhuma fase declara mais de 20 minutos.
