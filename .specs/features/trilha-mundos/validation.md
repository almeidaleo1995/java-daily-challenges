# Trilha em Mundos Validation

**Date**: 2026-09-24
**Spec**: `.specs/features/trilha-mundos/spec.md`
**Diff range**: `1ac0877..HEAD` (22 commits, 503 files changed, +11161/-258); Round 2 fix batch `8f18bb6..10dc70e` (10 commits)
**Verifier**: independent sub-agent (author ≠ verifier)
**Final status (after Round 2)**: ✅ PASS — see "Round 2 Re-Verification" below

---

## Task Completion

| Task | Status | Notes |
| --- | --- | --- |
| T1 | ✅ Done | `a6dd4b7` — 24 folders/48 files moved via `git mv`, history preserved (`git log --follow` shows continuous history) |
| T2 | ✅ Done | `06ea66b` — 18 folders + 043→chefe moved |
| T3 | ✅ Done | `53f1eca` — GLOSSARIO.md links rewritten, 0 broken links found |
| T4 | ✅ Done | `1db658e` — `challenges/templates/{MUNDO,FASE}.template.md`, `Fase.java.template`, `FaseTest.java.template` exist |
| T5 | ✅ Done | `9754987` — CLAUDE.md rewritten with mundos/fases/chefes flow |
| T6 | ✅ Done | `381490c` — PROGRESSO.md created, XP/title recomputed and verified correct (720 XP, see MAPA-02 below) |
| T7 | ✅ Done (with gap) | `6023026` — m01 new phases + boss exist; boss test count OK (8), but see MUN-04 gap below for other worlds |
| T8 | ✅ Done | `c832364` — m02 new phases exist |
| T9 | ✅ Done | `3a9613f` — m03 POO + Estoque boss |
| T10 | ⚠️ Partial | `6367d4f` — m04 exists but f02 (2 tests) and f04 (3 tests) and chefe (4 tests) fall short of the Coverage Expectation (≥4/≥6) |
| T11 | ⚠️ Partial | `dd260a8` — m05 exists but f01 (3), f05 (3) fall short of ≥4 |
| T12 | ⚠️ Partial | `318b278` — m06 exists but chefe (5) falls short of ≥6 |
| T13 | ⚠️ Partial | `43324ed` — m07 exists but f07 (3) falls short of ≥4 |
| T14 | ✅ Done | `09364e7` — m08 counts all ≥4/≥6 |
| T15 | ⚠️ Partial | `f481b0a` — m09 exists but chefe (5) falls short of ≥6 |
| T16 | ❌ Gap | `0694683` — m10 f02/f03/f04 (3 each) and chefe (3) badly short of ≥4/≥6 |
| T17 | ✅ Done | `e9aa7e6` — m11 counts all ≥4/≥6; DP boss large-input value recomputed correct (405) |
| T18 | ❌ Gap | `f782a66` — m12 f01/f02 (3), f06/f07/f08 (2) and chefe (4) badly short of ≥4/≥6 |
| T19 | ⚠️ Partial | `db2ab11` — m13 f04 (3) and chefe (4) fall short |
| T20 | ⚠️ Partial | `f91f108` — m14 chefe (5) falls short of ≥6 |
| T21 | ✅ Done | `8f18bb6` — m15 counts all ≥4/≥6; boss test recomputed correct |

All 21 tasks are structurally complete (every file exists, every world compiles). The gap is a spec-precision/coverage shortfall inside several tasks marked `[x]` in `tasks.md` (see MUN-04 below), not a missing-file problem.

---

## Spec-Anchored Acceptance Criteria

### P1: Mapa do jogo

| Criterion | Spec-defined outcome | `file:line` + evidence | Result |
| --- | --- | --- | --- |
| MAPA-01: PROGRESSO.md lists all 15 worlds with phase checkboxes linking to READMEs | 15 world sections, each phase a `- [ ]`/`- [x]` link | `challenges/PROGRESSO.md:5-210` — 15 `## Mundo N` headings confirmed by directory listing (`ls challenges/m*`); links verified resolving (0/205 broken, see Link Integrity) | ✅ PASS |
| MAPA-02: shows current XP and title at top | precise XP/title line | `challenges/PROGRESSO.md:3` — `**Título:** Estagiário · **XP:** 720 · **Chefes:** 0/15`; recomputed independently: 34 migrated checkboxes (m01 f01-21 stars: 1,2,2,3,3,1,2,2,3,3,2,2,2,1,2,2,2,2,3,2,3 + m02 f01-13 stars: 1,2,3,3,2,2,3,3,2,2,2,1,1) × 10 = 720 | ✅ PASS |
| MAPA-03: approved phase ticks checkbox + XP | event-driven, not testable statically | n/a — behavioral rule lives in CLAUDE.md, not a file state | ⚠️ Spec-precision gap (process rule, not verifiable from static state) |
| MAPA-04: chefe approval unlocks next world + recomputes title | event-driven | `CLAUDE.md:120-131` "Progresso e XP" section requires this on chefe approval | ✅ PASS (rule present and correctly worded) |

### P1: Desafios antigos nos seus temas

| Criterion | Spec-defined outcome | `file:line` + evidence | Result |
| --- | --- | --- | --- |
| MIG-01: each `challenges/NNN/` moved via `git mv` to theme world, 043→`m02/chefe-conta-bancaria` | folders moved with history | `git log --oneline --follow -- src/test/java/challenges/m02/chefe/ContaBancariaTest.java` shows continuous history through the move commit `06ea66b`; `find challenges -maxdepth 1 -regex '.*/[0-9][0-9][0-9]$'` returns nothing (old folders gone) | ✅ PASS |
| MIG-02: `src/{main,test}` moved with only `package` line changed | zero other diff | `diff <(git show a6dd4b7~1:src/main/java/challenges/day001/Classificador.java) <(git show a6dd4b7:src/main/java/challenges/m01/f01/Classificador.java)` → only line 1 (`package challenges.day001;` → `package challenges.m01.f01;`) differs | ✅ PASS |
| MIG-03: GLOSSARIO.md links point to new paths | all links resolve | `challenges/GLOSSARIO.md:8-12` sample links (`m01-sintaxe-strings-arrays/f01-.../README.md`, `../src/test/java/challenges/m01/f01/ClassificadorTest.java`) resolve; full-repo link-check script found 0/205 broken across 156 `.md` files | ✅ PASS |
| MIG-04: README/test-count integrity, no `dayNNN` references left | 0 references, same `@Test` count | `find src -type d -iname 'day*'` → empty; migrated-phase `@Test` sum = 229, matches pre-feature total of 230 minus the 1 `WelcomeTest` (never part of the 43, stays in root `challenges` package per design) | ✅ PASS |

### P1: Fases novas de todos os mundos geradas

| Criterion | Spec-defined outcome | `file:line` + evidence | Result |
| --- | --- | --- | --- |
| MUN-01: worlds 1-15, each with world README + 4-8 new phases + 1 chefe | counts match design | Directory counts match design tables exactly (m01: 30 = 24 migrated+5 new+boss; m02: 25 = 18 migrated+6 new+boss; m03-m15 counts verified against design's phase lists) | ✅ PASS |
| MUN-02: phase declares Dificuldade/Tempo/XP, ≤20min | footer present, ≤20 | `challenges/m01-sintaxe-strings-arrays/f25-placar-seguro/README.md:32` — `⭐⭐☆☆☆ · ~10 min · +20 XP`; spot-checked across 5 sampled phases, all ≤20min | ✅ PASS |
| MUN-03: skeleton throws `UnsupportedOperationException("TODO: implementar")`, test asserts only input→output | exact throw message | `src/main/java/challenges/m01/f25/PlacarSeguro.java:8`, `m02/f19/Ranking.java:11`, `m09/f01/CalculadoraDeIdade.java:9`, `m12/f01/ContadorConcorrente.java:10`, `m14/f01/CalculadoraDeFrete.java:5,9` all throw the exact message; tests in the same 5 phases assert only value/exception, no algorithm hints | ✅ PASS |
| MUN-04: ≥4 tests/phase, ≥6 tests/chefe (Test Coverage Matrix, tasks.md:22) | precise minimum counts | **17 new-phase files below 4 tests, 7 chefe files below 6 tests** — see full list in Fix Plans below, e.g. `src/test/java/challenges/m12/f06/LargadaTest.java` (2 `@Test`), `src/test/java/challenges/m10/chefe/ImportadorDeEstoqueTest.java` (3 `@Test`, needs ≥6) | ❌ GAP |
| MUN-05: chefe (world ≥3) combines current world + ≥2 earlier worlds, continues mercadinho storyline | narrative + code combination | `challenges/m03-poo/README.md:11` (Estoque uses Map M2 + BigDecimal M1); `challenges/m12-concorrencia/chefe-mercadinho-v10-checkout-concorrente/README.md:34` (Revisa cites Mundo 4 exceptions); `src/main/java/challenges/m03/chefe/*.java` imports `java.math.BigDecimal` confirming M1 reuse | ✅ PASS |
| MUN-06: "Revisa" line cites ≥1 concept from glossary/earlier phase | present | `challenges/m01-sintaxe-strings-arrays/f25-placar-seguro/README.md:29` — `**Revisa:** IllegalArgumentException para validar entrada (desafio 008)` | ✅ PASS |
| MUN-07: world README ≤1 sentence + 6 bullets | line/bullet count | `challenges/m01-sintaxe-strings-arrays/README.md:1-11` (1 sentence + 5 bullets); `challenges/m03-poo/README.md:1-12` (1 sentence + 6 bullets) | ✅ PASS |

### P1: CLAUDE.md com o fluxo do jogo

| Criterion | Spec-defined outcome | `file:line` + evidence | Result |
| --- | --- | --- | --- |
| FLUXO-01: describes new structure, replacing NNN/dayNNN section | present | `CLAUDE.md:63-86` "Como funciona a trilha" | ✅ PASS |
| FLUXO-02: hint request requires 5-level ladder starting level 1 | ladder preserved | `CLAUDE.md:39-61` unchanged ladder | ✅ PASS |
| FLUXO-03: review requires 3-5 direct questions before approving | exact range | `CLAUDE.md:105-106` "Faça de 3 a 5 perguntas diretas" | ✅ PASS |
| FLUXO-04: syntax check points line+rule, never rewrites method | exact behavior | `CLAUDE.md:116-118` "aponte a linha e a regra quebrada. Nunca reescreva o método" | ✅ PASS |
| FLUXO-05: unclear answer → no XP + one more guiding question | exact behavior | `CLAUDE.md:110-112` "não dê a resposta certa... não aprove a fase ainda" (XP only granted on approval per line 122, so withholding approval withholds XP) | ✅ PASS |
| FLUXO-06: approval updates GLOSSARIO.md + PROGRESSO.md same step | exact behavior | `CLAUDE.md:120-131` "Progresso e XP" | ✅ PASS |

### P2: Backlog / Templates

| Criterion | Spec-defined outcome | `file:line` + evidence | Result |
| --- | --- | --- | --- |
| BACK-01: PROGRESSO.md ends with "Próximos mundos" listing ≥5 named themes | present, ≥5 items | `challenges/PROGRESSO.md:212-219` — 6 items (Modules, JVM, Diagnóstico, Testes Avançados, Segurança, Java Moderno) | ✅ PASS |
| BACK-02: starting a backlog world moves it into the main map | event-driven, not testable statically | n/a — process rule | ⚠️ Spec-precision gap |
| TPL-01: templates dir has MUNDO/FASE/code templates using `challenges.mNN.fNN` | files present | `challenges/templates/` contains `MUNDO.template.md`, `FASE.template.md`, `Fase.java.template`, `FaseTest.java.template` | ✅ PASS |

**Status**: ❌ Gaps present (MUN-04 coverage shortfall across 9 of 15 worlds) — all other criteria PASS or are non-verifiable process rules correctly documented.

---

## Discrimination Sensor

Ran in an isolated `git worktree` at `/c/repos/_scratch-trilha-sensor` (removed after). Real-tree `git status --porcelain` was empty before and after (baseline preserved).

| # | File:line | Description | Killed? |
| --- | --- | --- | --- |
| 1 | `src/main/java/challenges/m01/f26/PrecoComDesconto.java` (scratch) | Changed rounding `RoundingMode.HALF_EVEN` → `HALF_UP` in `setScale` | ✅ Killed (`PrecoComDescontoTest.arredondamentoBancarioEmEmpateExatoVaiParaOParMaisProximo` failed: expected 2.48, got 2.49) |
| 2 | `src/main/java/challenges/m09/f05/ValidadorDePlaca.java` (scratch) | Flipped return `matches()` → `!matches()` | ✅ Killed (4/5 tests failed) |
| 3 | `src/main/java/challenges/m03/chefe/Estoque.java` (scratch) | Off-by-one in `remover`: `atual.quantidade() < quantidade` → `<= quantidade` | ✅ Killed (`removerTudoFazItemDesaparecer` errored with unexpected `IllegalArgumentException`) |

**Sensor depth**: lightweight (3 targeted mutations across 3 worlds, one per sampled tier: early syntax/BigDecimal, mid regex, boss with Map-based state)
**Result**: 3/3 killed — ✅ PASS

**Secondary observation (not a mutation report line, a coverage note):** a first attempt at mutation #1 (changing the `>100` boundary check to `>=100`) *survived* — `PrecoComDescontoTest` has no case at `percentualDesconto == 100` exactly, so the boundary between "100% allowed" and "just over 100% rejected" is untested. This is a minor, single-phase test-coverage gap, listed in Fix Plans.

---

## Interactive UAT

Not performed — this is a backend-only/content feature (Markdown + Java skeletons), no user-facing runtime behavior to walk through per validate.md §3 ("For backend-only or infrastructure work, automated checks are sufficient").

---

## Code Quality

| Principle | Status |
| --- | --- |
| No features beyond what was asked | ✅ — skeletons match README scope exactly in all samples read |
| No abstractions for single-use code | ✅ |
| Only touched files required for the task | ✅ — diff is scoped to `challenges/`, `src/*/java/challenges/`, `CLAUDE.md`, `.specs/` |
| Matches existing patterns | ✅ — `final` classes with private constructors for static-method exercises (`PlacarSeguro`, `Ranking`, `CalculadoraDeIdade`, `ContadorConcorrente`), matches the reused pattern from `day035`/`day043` cited in design.md |
| Spec-anchored outcome check | ⚠️ — asserted values match spec-defined examples everywhere sampled (e.g. `PlacarSeguro`'s README example `150` = test's `assertEquals(150, ...)`; DP boss 9999→405 recomputed correct; Auditoria boss saldo/inconsistências recomputed correct), but MUN-04's *count* requirement is unmet in 9 worlds |
| Per-layer coverage (domain 1:1 AC mapping) | ❌ — see MUN-04 gap; several phases cover fewer rules than their README declares (e.g. `m04/f02` "Conexão Sempre Fechada" has only 2 tests for a phase whose Regras section almost certainly lists ≥3 cases: normal, exception-during-use, resource must still close) |
| Every test maps to a spec/README rule, no unclaimed tests | ✅ — all sampled tests trace to a README rule or example row |
| Documented guidelines followed | tasks.md Test Coverage Matrix (`≥4/≥6`); CLAUDE.md hint ladder and review flow — followed for structure, not for the numeric coverage floor |

---

## Edge Cases

- [x] Unsolved migrated exercises (035-043) moved unchanged, checkboxes unticked — confirmed in `PROGRESSO.md:28-36,53-64` (`- [ ]` for f22-f29/chefe in m01, f14-f24/chefe in m02)
- [x] Mundo 10 tests use `@TempDir` — spot-checked `m10/f02` pattern name conventions consistent with task T16's done-when claim (not individually re-opened beyond count check)
- [x] Mundo 12 concurrency tests are deterministic — `ContadorConcorrenteTest.java:14` uses `assertTimeoutPreemptively` + fixed thread/increment counts, no `Thread.sleep`

---

## Gate Check

- **Gate command**: `mvn -q test-compile`
- **Result**: 0 errors, exit code 0 (only JVM/library deprecation warnings, unrelated to this feature)
- **Test count before feature** (commit `1ac0877`): 230 `@Test` methods (229 across the 43 challenges + 1 `WelcomeTest`)
- **Test count after feature** (HEAD): 649 `@Test` methods
- **Delta**: +419 new tests
- **Skipped tests**: none
- **Failures**: none (gate is compile-only per tasks.md; `mvn test` was intentionally not run unfiltered per the task instructions — unsolved skeletons are expected to fail `mvn test -Dtest=X`, which is by design)

---

## Fix Plans

### Fix 1: New phases below the ≥4-test coverage floor (MUN-04)

- **Root cause**: 14 new-phase test files were written with fewer assertions than the Test Coverage Matrix in `tasks.md:22` requires ("fase ≥ 4 testes"). Affected: `m04/f02` (2), `m04/f04` (3), `m05/f01` (3), `m05/f05` (3), `m07/f07` (3), `m10/f02` (3), `m10/f03` (3), `m10/f04` (3), `m12/f01` (3), `m12/f02` (3), `m12/f06` (2), `m12/f07` (2), `m12/f08` (2), `m13/f04` (3).
- **Fix task**: For each file, add tests until the README's own "Regras"/"Exemplos" rows are each covered by ≥1 assertion and the total reaches ≥4. Do not weaken existing assertions to hit the count — add real new cases (e.g. `m04/f02` "Conexão Sempre Fechada" is missing a case for "exception thrown mid-use still closes the resource", which its own Regras section almost certainly requires for `try`-with-resources).
- **Priority**: Major (spec-defined numeric floor not met; the exercises still function, but 9 of 15 worlds under-test their own README rules)

### Fix 2: Boss (chefe) exercises below the ≥6-test coverage floor (MUN-04)

- **Root cause**: same as Fix 1, chefe tier. Affected: `m10/chefe` (3, worst offender — imports estoque CSV with error handling, needs more cases), `m04/chefe` (4), `m12/chefe` (4), `m13/chefe` (4), `m06/chefe` (5), `m09/chefe` (5), `m14/chefe` (5).
- **Fix task**: Add tests per boss until ≥6, covering each Regras bullet (e.g. `m12/chefe`'s "CheckoutConcorrente" README lists 5 rules but only 4 tests exist — the "estoqueRestante() nunca fica negativo" rule has no dedicated assertion).
- **Priority**: Major

### Fix 3: `PrecoComDesconto` (m01/f26) missing boundary test at exactly 100% discount

- **Root cause**: README's rule is "percentual > 100 throws", implying exactly 100 is valid, but no test exercises `percentualDesconto == 100`. A `>` vs `>=` mutation at that boundary survives the current suite (confirmed via discrimination sensor).
- **Fix task**: Add a test asserting `aplicarDesconto(preco, new BigDecimal("100"))` returns `BigDecimal.ZERO` (or the scaled equivalent) without throwing.
- **Priority**: Minor

---

## Requirement Traceability Update

| Requirement | Previous Status | New Status |
| --- | --- | --- |
| MAPA-01..04 | Pending | ✅ Verified (MAPA-03 process-rule, non-blocking) |
| MIG-01..04 | Pending | ✅ Verified |
| MUN-01, 02, 03, 05, 06, 07 | Pending | ✅ Verified |
| MUN-04 | Pending | ❌ Needs Fix |
| FLUXO-01..06 | Pending | ✅ Verified |
| BACK-01 | Pending | ✅ Verified |
| BACK-02 | Pending | ⚠️ Process-rule, non-blocking |
| TPL-01 | Pending | ✅ Verified |

---

## Summary

**Overall**: ⚠️ Issues — structurally complete, compiles clean, migration integrity intact, discrimination sensor passed 3/3, but MUN-04's numeric test-coverage floor (≥4 per phase, ≥6 per chefe) is unmet in 21 of the ~93 newly generated exercise files, spread across 9 of the 15 worlds (m04, m05, m06, m07, m09, m10, m12, m13, m14).

**Spec-anchored check**: 21/24 requirement groups matched spec outcome; 2 flagged as non-verifiable process rules (MAPA-03, BACK-02, both correctly documented in CLAUDE.md/PROGRESSO.md); 1 (MUN-04) failed on evidence.

**Sensor**: 3/3 mutations killed (PASS), plus one incidental boundary-coverage gap found and reported as Fix 3.

**Gate**: `mvn -q test-compile` passed, 0 errors, 649 tests exist (+419 vs. pre-feature baseline of 230).

**What works**: All 15 worlds exist with correct structure and file counts; migration preserved git history and test counts exactly; no `dayNNN`/`challenges/NNN` remnants; all 205 relative links in `challenges/**/*.md` resolve; CLAUDE.md fully covers the new review/hint/progress flow; DP and audit-boss expected values independently recomputed and confirmed correct.

**Issues found**: Test-count coverage floor unmet in 9 worlds (Fix 1, Fix 2 — Major); one boundary-value gap in `m01/f26` (Fix 3 — Minor).

**Next steps**: Route Fix 1 and Fix 2 to an implementer to add the missing assertions per affected phase/chefe (grounded in each README's own Regras bullets, not invented scope), then re-run this Verifier's MUN-04 check and the discrimination sensor on 2-3 of the newly strengthened files.

---

## Round 2 Re-Verification

**Date**: 2026-09-24
**Diff range**: `8f18bb6..10dc70e` (10 fix commits: `6141697`..`10dc70e`)
**Verifier**: independent sub-agent, round 2 (author ≠ verifier; fresh from round 1)
**Scope**: MUN-04 coverage floor (Fix 1, Fix 2) and the Fix 3 boundary test only. Round 1's structural/migration/AC findings (MAPA, MIG, FLUXO, BACK, TPL, MUN-01/02/03/05/06/07) were not re-checked — unaffected by this fix batch.

### Fix 1 + Fix 2: Coverage floor — file-by-file recount

| File | Old count (round 1) | New count | Floor | Meets floor? |
| --- | --- | --- | --- | --- |
| `src/test/java/challenges/m04/f02/ExecutorTest.java` | 2 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m04/f04/RetentativaTest.java` | 3 | 5 | ≥4 | ✅ |
| `src/test/java/challenges/m04/chefe/ProcessadorDePedidoTest.java` | 4 | 6 | ≥6 | ✅ |
| `src/test/java/challenges/m05/f01/ParTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m05/f05/CacheLruTest.java` | 3 | 5 | ≥4 | ✅ |
| `src/test/java/challenges/m06/chefe/MotorDePromocoesTest.java` | 5 | 7 | ≥6 | ✅ |
| `src/test/java/challenges/m07/f07/RefatoracaoTest.java` | 3 | 5 | ≥4 | ✅ |
| `src/test/java/challenges/m09/chefe/ControleDeValidadeTest.java` | 5 | 7 | ≥6 | ✅ |
| `src/test/java/challenges/m10/f02/SomaCsvTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m10/f03/GravadorDeRelatorioTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m10/f04/BuscadorDeArquivosTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m10/chefe/ImportadorDeEstoqueTest.java` | 3 | 6 | ≥6 | ✅ |
| `src/test/java/challenges/m12/f01/ContadorConcorrenteTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m12/f02/BancoTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m12/f06/LargadaTest.java` | 2 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m12/f07/TarefasVirtuaisTest.java` | 2 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m12/f08/LimitadorDeChamadasTest.java` | 2 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m12/chefe/CheckoutConcorrenteTest.java` | 4 | 6 | ≥6 | ✅ |
| `src/test/java/challenges/m13/f04/InvocadorTest.java` | 3 | 4 | ≥4 | ✅ |
| `src/test/java/challenges/m13/chefe/MapeadorCsvTest.java` | 4 | 6 | ≥6 | ✅ |
| `src/test/java/challenges/m14/chefe/CheckoutTest.java` | 5 | 6 | ≥6 | ✅ |

**Result**: 21/21 files now meet their floor (≥4 phase, ≥6 chefe). MUN-04 is fully closed.

### Trace spot-check (added tests → README rule)

Sampled 5 newly-added tests across 4 different worlds, verified each traces to a rule/example already in that exercise's own README (no invented scope):

1. `src/test/java/challenges/m04/f02/ExecutorTest.java:34-39` (`comandoDiferenteDeOkOuFalhaTambemEExecutadoERegistrado`) → `challenges/m04-.../f02-conexao-sempre-fechada/README.md` "Exemplos" section documents the `"OK"` log shape (`["aberta","executado:OK","fechada"]`); the new test generalizes that pattern to a non-`OK`/`FALHA` command, still governed by the same "executa `comando` nela" rule (README line: `Abre uma Conexao... executa comando nela`).
2. `src/test/java/challenges/m09/chefe/ControleDeValidadeTest.java:44-48` (`produtoQueVenceExatamenteNoLimiteDaJanelaEIncluido`) → README Regras: "estão entre `0` e `diasDeAlerta`, **ambos inclusive**" — the new test is a direct boundary test of the explicit "ambos inclusive" rule.
3. `src/test/java/challenges/m10/chefe/ImportadorDeEstoqueTest.java:44-54` (`linhaComFormatoErradoVaiParaOArquivoDeErros`) → README Regras: "Linha inválida (formato errado...)... a linha original (texto exato) é gravada em `arquivoDeErros`" — directly covers the "formato errado" branch not previously tested.
4. `src/test/java/challenges/m10/chefe/ImportadorDeEstoqueTest.java:57-61` (`arquivoCsvQueNaoExisteDeixaAIOExceptionSubir`) → README Regras: "`arquivoCsv` que não existe → deixe a `IOException` subir." — verbatim rule.
5. `src/test/java/challenges/m12/chefe/CheckoutConcorrenteTest.java:53-67` (`estoqueRestanteNuncaFicaNegativoSobDisputaIntensa`) → README Regras: "`estoqueRestante()` nunca fica negativo." — verbatim rule, exercised under high contention (500 threads vs. 1 unit stock).

No sampled test invents scope beyond its README; all trace to an explicit Regras bullet or Exemplos row.

### Fix 3: `m01/f26` boundary test at exactly 100%

- `src/test/java/challenges/m01/f26/PrecoComDescontoTest.java:32-37` (`percentualExatamenteCemEValidoEDevolveZero`) now asserts `aplicarDesconto(new BigDecimal("100.00"), new BigDecimal("100"))` returns `new BigDecimal("0.00")`.
- Verified against the method's own contract: README (`challenges/m01-.../f26-preco-com-desconto/README.md:12`) requires "sempre com 2 casas decimais" via `setScale(casas, modoDeArredondamento)` (README hint line 26). `100.00 - (100.00 × 100/100) = 0.00`, scaled to 2 decimals → `0.00`. The asserted expected value is correct per the contract, independently derived (not trusted from the fix commit's own claim).
- Confirmed the skeleton (`src/main/java/challenges/m01/f26/PrecoComDesconto.java`) is still unimplemented (`throw new UnsupportedOperationException`), so this is a test-only fix as required.

### Gate Check (re-run)

- **Gate command**: `mvn -q test-compile`
- **Result**: 0 errors, exit code 0 (same benign JVM/library deprecation warnings as round 1)

### Discrimination Sensor (round 2, targeting newly-added assertions)

Ran in an isolated `git worktree` at `C:\repos\_scratch-trilha-sensor2` (removed after via `git worktree remove --force`). Real-tree `git status --porcelain` confirmed identical before and after (only the pre-existing untracked `.specs/LESSONS.md`, `.specs/lessons.json`, `.specs/features/trilha-mundos/validation.md`).

Wrote real reference implementations for `challenges.m12.chefe.CheckoutConcorrente` and `challenges.m10.chefe.ImportadorDeEstoque` (both were still `UnsupportedOperationException` skeletons) and confirmed both strengthened test suites went green (6/6 and 12/12 respectively) before mutating.

| # | File:line | Description | Targets (new test) | Killed? |
| --- | --- | --- | --- | --- |
| 1 | `challenges/m12/chefe/CheckoutConcorrente.java` constructor (scratch) | Mutated zero initial stock to be treated as 1 unit available | `estoqueInicialZeroEValidoENenhumaCompraEBemSucedida` (added in `401de15`) | ✅ Killed — `expected: <0> but was: <1>` |
| 2 | `challenges/m10/chefe/ImportadorDeEstoque.java` line-parsing (scratch) | Padded malformed single-field lines with a fake `quantidade=0` instead of routing to `arquivoDeErros` | `linhaComFormatoErradoVaiParaOArquivoDeErros` (added in `8977972`) | ✅ Killed — expected list missing the spurious `LinhaDeEstoque[produto=SoUmCampo, quantidade=0]`, but it was present |

**Sensor depth**: lightweight (2 targeted mutations, each aimed at one specific newly-added assertion, on the two chefe files with the most new tests added)
**Result**: 2/2 killed — ✅ PASS

### Round 2 Compact Verdict

**Overall**: ✅ PASS — MUN-04 fully closed, Fix 3 confirmed correct, gate green, sensor 2/2 killed on newly-added assertions.

**MUN-04 tally**: 21/21 previously-failing files now meet their coverage floor (14 phase files ≥4, 7 chefe files ≥6).

**What works**: All three round-1 fix plans (Fix 1, Fix 2, Fix 3) verified closed with independent evidence — recount, README traceability spot-check, and adversarial mutation testing on the two heaviest-fix files.

**Issues found**: None.

**Next steps**: None outstanding for this fix batch. Round 1's non-blocking process-rule flags (MAPA-03, BACK-02) remain as documented, unaffected by this round.
