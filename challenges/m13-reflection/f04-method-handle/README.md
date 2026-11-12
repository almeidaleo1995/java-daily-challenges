# 13.04 — Method Handle

**Missão:** Chamar um método usando `MethodHandles`, a alternativa mais moderna à reflection clássica para invocar métodos.

**O que vamos trabalhar:** **`MethodHandles`** — a alternativa moderna à reflection clássica para chamar métodos; mais rápida (a JVM otimiza) e mais "tipada". Aqui: localizar o método e invocá-lo por um *handle*.

**Na prática:** o fluxo é: obter um `Lookup`, descrever o método (classe, nome e **tipo**: retorno + parâmetros) com `MethodType`, achar o `MethodHandle` e chamar `invoke`. Muito vocabulário novo, então comece lendo um exemplo mínimo na documentação e adapte.

**Glossário rápido**
- **`MethodHandles.lookup()`** — "porta de entrada"; só enxerga o que o código atual pode acessar.
- **`MethodType.methodType(retorno, params...)`** — descreve a assinatura (`int` e dois `int`).
- **`findVirtual(classe, nome, tipo)`** — acha método de instância.
- **`MethodHandle.invoke` / `invokeExact`** — executa; o handle de instância recebe o objeto como 1º argumento.
- **`Throwable`** — o `invoke` pode lançar qualquer coisa, daí o `throws Throwable`.

**Pesquise sobre:** `java MethodHandles lookup findVirtual` · `java MethodType exemplo` · `java MethodHandle vs reflection`

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
