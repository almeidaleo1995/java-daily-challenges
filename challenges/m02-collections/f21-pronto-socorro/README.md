# 2.21 — Pronto-Socorro

**Missão:** Montar uma fila de atendimento onde quem sai primeiro não é quem chegou primeiro — é quem está mais grave.

**Implemente:** `challenges.m02.f21.ProntoSocorro`

```java
public static PriorityQueue<Paciente> criarFila()
```

`Paciente` já vem pronto no esqueleto: `record Paciente(String nome, int gravidade, int ordemChegada)` (`gravidade` maior = mais urgente).

**Regras**
- Devolve uma `PriorityQueue<Paciente>` vazia, configurada para que `poll()` sempre devolva o paciente de maior `gravidade`.
- Em caso de empate na gravidade, quem tem o menor `ordemChegada` (chegou primeiro) sai primeiro.

**Exemplos**

Inserindo, em qualquer ordem, `("Ana", 3, 1)`, `("Bia", 5, 2)`, `("Caio", 5, 3)`: os `poll()` saem na ordem `Bia` (gravidade 5, chegou antes), `Caio` (gravidade 5, chegou depois), `Ana` (gravidade 3).

<details><summary>Dica</summary>

`PriorityQueue` tem um construtor que recebe um `Comparator` — é ele quem decide a ordem de saída, não a ordem de inserção. A mesma combinação de "ordenar por um campo, e desempatar por outro" da fase anterior se aplica aqui.

</details>

**Revisa:** `Comparator.comparing`/`thenComparing` (fase 2.19) — mesma técnica, aplicada à ordem de uma fila em vez de a uma lista.
**Rodar:** `mvn test -Dtest=ProntoSocorroTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
