# 13.03 — Campo Obrigatório

**Missão:** Ler uma anotação própria em tempo de execução pra descobrir quais campos de um objeto estão faltando.

**Implemente:** `challenges.m13.f03.Validador` (`Cadastro` já vem pronto no esqueleto — não altere; `@Obrigatorio` também está no esqueleto, mas pode **precisar de ajuste** — veja as Regras)

```java
public static List<String> camposFaltando(Object objeto)
```

**Regras**
- `Cadastro` marca `nome` e `email` com `@Obrigatorio`; `apelido` não é marcado.
- `camposFaltando`: para cada campo de `objeto` anotado com `@Obrigatorio`, se o valor dele for `null`, o nome do campo entra no resultado — na ordem em que os campos foram declarados na classe.
- `objeto` nulo → `IllegalArgumentException`.
- Os campos são `private`: acesse com `setAccessible(true)` antes de ler o valor.

**Exemplos**

| `Cadastro` | Resultado |
|---|---|
| `new Cadastro(null, "ana@x.com", null)` | `["nome"]` (`apelido` não é obrigatório) |
| `new Cadastro("Ana", "ana@x.com", null)` | `[]` |

<details><summary>Dica</summary>

`campo.getAnnotation(Obrigatorio.class)` devolve `null` se o campo não estiver marcado com `@Obrigatorio` **ou** se a anotação não sobreviver até a execução. Uma anotação só existe em tempo de execução se declarar `@Retention(RetentionPolicy.RUNTIME)` — sem isso, o compilador a descarta depois de compilar, e a reflection nunca a encontra. Se seus testes não estão achando `@Obrigatorio` mesmo com o `Validador` certo, o problema pode não estar no `Validador`.

</details>

**Revisa:** `getDeclaredFields` e `setAccessible` (fase 13.01).
**Rodar:** `mvn test -Dtest=ValidadorTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
