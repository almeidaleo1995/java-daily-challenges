# 4.04 — Retentativa

**Missão:** Tentar executar uma tarefa várias vezes antes de desistir, sem perder o registro de nenhuma das falhas anteriores.

**Implemente:** `challenges.m04.f04.Retentativa` (`Tarefa` já vem pronta no esqueleto — não altere)

```java
public static void executarComRetentativa(Tarefa tarefa, int maximoDeTentativas) throws Exception
```

**Regras**
- Chama `tarefa.executar()` até `maximoDeTentativas` vezes. Se alguma chamada não lançar exceção, o método retorna normalmente (sem tentar de novo).
- Se todas as tentativas falharem, lança a **primeira** exceção capturada — mas com todas as exceções das tentativas seguintes anexadas como suprimidas nela.
- `maximoDeTentativas` menor ou igual a zero lança `IllegalArgumentException`.

**Exemplos**

Com uma tarefa que sempre lança e `maximoDeTentativas = 3`: `executarComRetentativa` lança a exceção da 1ª tentativa, com `getSuppressed().length == 2` (as exceções da 2ª e 3ª tentativa).

Com uma tarefa que falha na 1ª chamada e funciona na 2ª, e `maximoDeTentativas = 3`: `executarComRetentativa` retorna normalmente, sem lançar nada (a tarefa nunca é chamada uma 3ª vez).

<details><summary>Dica</summary>

Toda exceção tem um método `addSuppressed(Throwable)` — ele não muda o tipo nem a mensagem da exceção, só anexa outra exceção à lista de "suprimidas" que `getSuppressed()` devolve depois. Guarde a primeira exceção capturada numa variável fora do laço; nas tentativas seguintes, anexe a nova exceção nela em vez de substituí-la.

</details>

**Revisa:** `IllegalStateException`/`IllegalArgumentException` para validar estado (fase 4.01) — aqui a validação é do próprio parâmetro `maximoDeTentativas`.
**Rodar:** `mvn test -Dtest=RetentativaTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
