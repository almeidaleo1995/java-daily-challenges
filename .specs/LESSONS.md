# LESSONS - auto-maintained by scripts/lessons.py

> Machine-owned. Do NOT hand-edit. Changes are overwritten on the next `lessons.py` write.
> Canonical state lives in `.specs/lessons.json`. Edit lessons only via the script.
> promote_threshold=2 distinct features · window_days=45 · quarantine_threshold=2

## Confirmed (load these at Specify/Design)

Corroborated across multiple features. Safe to apply as guidance.

_none_

## Candidates (under observation - do NOT load as guidance yet)

Seen once or not yet corroborated. Tracked, not trusted.

### L-001 - When a task Done-when cites a numeric test-count floor (>=4/phase, >=6/boss), count @Test annotations per file before marking the task complete, not just per-world exercise counts.
- signal: `ac_gap` · recurrence: 1 feature(s) · scope: `test-coverage` · harmful: 0
- features: trilha-mundos
- evidence: MUN-04 (test-coverage)
- last seen: 2026-09-24T13:51:54Z

### L-002 - For a numeric boundary rule stated as '> N throws', add a test at exactly N (the allowed edge), not just above and below it.
- signal: `surviving_mutant` · recurrence: 1 feature(s) · scope: `test-coverage` · harmful: 0
- features: trilha-mundos
- evidence: src/main/java/challenges/m01/f26/PrecoComDesconto.java boundary >100 vs >=100 (test-coverage)
- last seen: 2026-09-24T13:51:55Z

## Quarantined (failed when applied - ignore)

A confirmed lesson that recurred alongside failure. Kept for the maintainer to review.

_none_
