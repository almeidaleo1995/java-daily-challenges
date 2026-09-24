# 1.25 — Placar Seguro

**Missão:** Somar a pontuação de um jogador sem deixar o placar dar a volta silenciosamente quando passar do limite de `int`.

**Implemente:** `challenges.m01.f25.PlacarSeguro`

```java
public static int somarPontos(int pontosAtuais, int pontosGanhos)
```

**Regras**
- Devolve `pontosAtuais + pontosGanhos`.
- Se a soma estourar o limite de `int` (`Integer.MAX_VALUE`), lança `ArithmeticException` em vez de devolver um número errado por overflow.

**Exemplos**

| Entrada | Saída |
|---|---|
| `somarPontos(100, 50)` | `150` |
| `somarPontos(Integer.MAX_VALUE - 5, 5)` | `Integer.MAX_VALUE` |
| `somarPontos(Integer.MAX_VALUE, 1)` | lança `ArithmeticException` |

<details><summary>Dica</summary>

`int + int` nunca lança exceção sozinho — ele estoura e vira negativo sem avisar. Existe um método em `Math` que faz a mesma soma, mas verifica o overflow antes de devolver.

</details>

**Revisa:** `IllegalArgumentException` para validar entrada (desafio 008) — aqui a exceção é outra, porque o problema não é o argumento em si, é o resultado da operação.
**Rodar:** `mvn test -Dtest=PlacarSeguroTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
