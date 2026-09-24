# 4.01 — Saque Checado

**Missão:** Criar uma exceção *checked* própria — o compilador obriga quem chama `sacar` a lidar com a possibilidade de saldo insuficiente, em vez de descobrir isso só em produção.

**Implemente:** `challenges.m04.f01.SaldoInsuficienteException` e `challenges.m04.f01.CaixaEletronico`

```java
public class SaldoInsuficienteException extends Exception { ... }

public CaixaEletronico(double saldoInicial)
public void sacar(double valor) throws SaldoInsuficienteException
public double getSaldo()
```

**Regras**
- `saldoInicial` negativo lança `IllegalArgumentException` no construtor.
- `sacar`: `valor` menor ou igual a zero lança `IllegalArgumentException`. `valor` maior que o saldo atual lança `SaldoInsuficienteException` (**checked** — declarada com `throws`). Nesses dois casos o saldo não muda.
- Saque válido reduz o saldo em `valor`.

**Exemplos**

| Estado | Chamada | Resultado |
|---|---|---|
| saldo `100` | `sacar(30)` | saldo vira `70` |
| saldo `70` | `sacar(100)` | lança `SaldoInsuficienteException`; saldo continua `70` |
| saldo `70` | `sacar(-5)` | lança `IllegalArgumentException`; saldo continua `70` |

<details><summary>Dica</summary>

Uma exceção *checked* estende `Exception` diretamente (não `RuntimeException`). Isso obriga qualquer método que a lance a declarar `throws NomeDaExcecao` na assinatura — e obriga quem chama esse método a capturar ou repassar a exceção, o compilador não deixa ignorar.

</details>

**Revisa:** `IllegalArgumentException` para validar entrada (desafio 008) — aqui você distingue erro de argumento (`IllegalArgumentException`, não previsto pra ser tratado) de uma falha de negócio esperada (`SaldoInsuficienteException`, checked, que o chamador deve tratar).
**Rodar:** `mvn test -Dtest=CaixaEletronicoTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
