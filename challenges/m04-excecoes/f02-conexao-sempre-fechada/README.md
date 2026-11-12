# 4.02 — Conexão Sempre Fechada

**Missão:** Garantir que um recurso (aqui, uma conexão simulada) é sempre fechado, mesmo quando o código que a usa lança uma exceção no meio.

**O que vamos trabalhar:** garantir a **limpeza de recursos** (fechar conexão, arquivo, etc.) mesmo quando algo dá errado no meio do caminho.

**Na prática:** `Conexao` já existe. Você abre uma, manda executar o comando e precisa que `fechar` seja chamado **sempre** — com sucesso ou com exceção — sem engolir a exceção. Existem duas formas clássicas em Java; pesquise as duas e escolha qual usar.

**Glossário rápido**
- **`try / finally`** — o bloco `finally` roda sempre, dando certo ou errado.
- **`try-with-resources`** — `try (var r = ...) { }`: o Java chama `close()` sozinho no fim, mesmo com erro.
- **`AutoCloseable`** — interface que um tipo precisa implementar para ser usado em `try-with-resources`.
- **Propagar exceção** — deixar o erro seguir para quem chamou, em vez de capturá-lo.

**Pesquise sobre:** `java try-with-resources` · `java AutoCloseable close` · `java try finally ordem de execução`

**Implemente:** `challenges.m04.f02.Executor` (`Conexao` já vem pronta no esqueleto — não altere)

```java
public static void executarComLog(List<String> log, String comando)
```

**Regras**
- Abre uma `Conexao` passando `log`, executa `comando` nela, e garante que a conexão é fechada ao final — inclusive se `executar` lançar uma exceção.
- Não capture a exceção que `executar` lança — ela deve continuar se propagando depois que a conexão for fechada.

**Exemplos**

Com `comando = "OK"`: ao final, `log` contém `["aberta", "executado:OK", "fechada"]`.

Com `comando = "FALHA"`: `executarComLog` lança `RuntimeException`, mas `log` termina contendo `"fechada"` mesmo assim (a conexão foi fechada antes da exceção escapar).

<details><summary>Dica</summary>

`Conexao` implementa `AutoCloseable`. Um bloco `try (Conexao c = new Conexao(log)) { ... }` fecha `c` automaticamente ao sair do bloco — seja porque terminou normalmente, seja porque uma exceção foi lançada dentro dele. Não é preciso (nem deve) usar `finally` manual.

</details>

**Revisa:** `IllegalStateException` para operação inválida no estado atual (desafio 043) — `Conexao` usa a mesma ideia para recusar `executar` numa conexão já fechada.
**Rodar:** `mvn test -Dtest=ExecutorTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
