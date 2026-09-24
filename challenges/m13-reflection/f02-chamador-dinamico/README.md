# 13.02 — Chamar por Nome

**Missão:** Chamar um método de um objeto sabendo só o nome dele, como texto.

**Implemente:** `challenges.m13.f02.ChamadorDinamico` (`Saudador` já vem pronto no esqueleto — não altere)

```java
public static Object chamar(Object alvo, String nomeDoMetodo, Object... argumentos)
```

**Regras**
- Acha o método público de `alvo` cujo nome é `nomeDoMetodo` e cujos parâmetros batem com o tipo de cada item de `argumentos`, e o invoca.
- Devolve o que o método devolveu.
- Se o método invocado lançar uma exceção, `chamar` relança a **causa original** — não a `InvocationTargetException` que a reflection usa para embrulhar (isso esconderia o tipo real do erro de quem chamou).
- `alvo` nulo, ou `nomeDoMetodo` que não existe em `alvo` → `IllegalArgumentException`.

**Exemplos**

Com `Saudador { public String saudar(String nome) { return "Olá, " + nome; } }`:

| Chamada | Resultado |
|---|---|
| `chamar(new Saudador(), "saudar", "Ana")` | `"Olá, Ana"` |

<details><summary>Dica</summary>

`alvo.getClass().getMethod(nomeDoMetodo, tiposDosArgumentos)` acha o método (os tipos vêm de `argumentos[i].getClass()` para cada argumento). `metodo.invoke(alvo, argumentos)` chama e devolve o resultado — mas se o método invocado lançar, `invoke` embrulha numa `InvocationTargetException`; `.getCause()` nela é a exceção original.

</details>

**Revisa:** tradução de exceção (fase 13.01, Mundo 4).
**Rodar:** `mvn test -Dtest=ChamadorDinamicoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
