# 13.04 — Method Handle

**Missão:** Chamar um método usando `MethodHandles`, a alternativa mais moderna à reflection clássica para invocar métodos.

**Implemente:** `challenges.m13.f04.Invocador` (`Calculadora` já vem pronta no esqueleto — não altere)

```java
public static int somarViaMethodHandle(Calculadora calculadora, int a, int b) throws Throwable
```

**Regras**
- `Calculadora` tem um método `int soma(int a, int b)` de visibilidade padrão (sem modificador — acessível dentro do mesmo pacote).
- `somarViaMethodHandle` usa `MethodHandles.lookup()` para achar esse método e invocá-lo — não chama `calculadora.soma(a, b)` diretamente.
- `calculadora` nula → `IllegalArgumentException`.

**Exemplos**

| Chamada | Resultado |
|---|---|
| `somarViaMethodHandle(new Calculadora(), 3, 4)` | `7` |

<details><summary>Dica</summary>

`MethodHandles.lookup().findVirtual(Calculadora.class, "soma", MethodType.methodType(int.class, int.class, int.class))` devolve um `MethodHandle`. Para chamar, `handle.invoke(calculadora, a, b)` — o retorno é `Object`, então precisa converter para `int` (o método já declara `throws Throwable`, que é o que `invoke` exige).

</details>

**Revisa:** invocar método por reflection (fase 13.02) — `MethodHandles` é o jeito mais moderno de fazer a mesma coisa.
**Rodar:** `mvn test -Dtest=InvocadorTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
