# 2.20 — Próximo Ônibus

**Missão:** Achar o próximo horário de ônibus a partir de agora, e o último que já passou, numa lista sempre ordenada.

**Implemente:** `challenges.m02.f20.ProximoOnibus`

```java
public static Integer proximoAPartirDe(TreeSet<Integer> horarios, int agora)
public static Integer ultimoAntesDe(TreeSet<Integer> horarios, int agora)
```

**Regras**
- `horarios` guarda minutos desde a meia-noite (ex.: 8h00 = `480`).
- `proximoAPartirDe`: o menor horário maior ou igual a `agora`. Se não houver nenhum, devolve `null`.
- `ultimoAntesDe`: o maior horário menor ou igual a `agora`. Se não houver nenhum, devolve `null`.
- `horarios` nulo lança `IllegalArgumentException`.

**Exemplos**

Com `horarios = {480, 540, 600}` (8h00, 9h00, 10h00):

| Chamada | Resultado |
|---|---|
| `proximoAPartirDe(horarios, 500)` | `540` |
| `proximoAPartirDe(horarios, 600)` | `600` |
| `proximoAPartirDe(horarios, 700)` | `null` |
| `ultimoAntesDe(horarios, 500)` | `480` |

<details><summary>Dica</summary>

`TreeSet` mantém os elementos sempre ordenados e tem métodos para buscar "o mais próximo pra cima" e "o mais próximo pra baixo" sem percorrer a coleção com um laço. Um deles inclui o próprio valor se ele existir no conjunto, o outro também — são dois métodos distintos de `NavigableSet`.

</details>

**Revisa:** `Set` (desafio 006) — `TreeSet` é um `Set` que também mantém ordem e permite essas buscas por vizinhança.
**Rodar:** `mvn test -Dtest=ProximoOnibusTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
