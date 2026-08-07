# Desafios

Cada desafio vive em duas partes:

- `challenges/NNN/README.md` — o enunciado (gerado a partir de `templates/README.template.md`).
- `src/main/java/challenges/dayNNN/` e `src/test/java/challenges/dayNNN/` — o código e os testes daquele desafio, no projeto Maven principal.

`NNN` é o número do desafio com três dígitos (`001`, `002`, ...). Pacotes Java não podem começar com dígito, por isso o código usa `dayNNN` (ex.: `challenges.day001`) enquanto a pasta de enunciados usa só o número (`challenges/001/`).

- `templates/` — modelos para criar um novo desafio (enunciado + esqueleto de classe/teste, sem lógica).
- `archive/` — desafios descontinuados ou substituídos, fora da rotação ativa.
