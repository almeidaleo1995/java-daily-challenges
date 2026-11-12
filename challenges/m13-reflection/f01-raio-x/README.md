# 13.01 — Raio-X

**Missão:** Examinar os campos de uma classe qualquer sem conhecê-la em tempo de compilação.

**O que vamos trabalhar:** **Reflection** — o programa **inspeciona a si mesmo em tempo de execução**: descobrir os campos, métodos e modificadores de uma classe sem conhecê-la na hora de compilar. É como frameworks (Spring, JPA, Jackson) funcionam por baixo.

**Na prática:** tudo parte de um objeto `Class<?>`. Dele você pede os campos declarados e, de cada campo, o nome e os modificadores (`private`, `public`...). Campo inexistente: o Java lança uma exceção checked, que você traduz (fase 4.03).

**Glossário rápido**
- **`Class<?>`** — objeto que representa uma classe em tempo de execução (`Pessoa.class`).
- **`Field`** — representa um campo; `getName()`, `getModifiers()`.
- **`getDeclaredFields()`** — todos os campos da classe (inclusive `private`), mas não os herdados.
- **`Modifier.isPrivate(int)`** — testa os modificadores.
- **`NoSuchFieldException`** — exceção checked de campo inexistente.

**Pesquise sobre:** `java reflection getDeclaredFields` · `java Modifier isPrivate` · `java reflection o que é e para que serve`

**Implemente:** `challenges.m13.f01.RaioX` (`Pessoa` já vem pronta no esqueleto — não altere)

```java
public static List<String> nomesDosCampos(Class<?> classe)
public static boolean campoEhPrivado(Class<?> classe, String nomeDoCampo)
```

**Regras**
- `nomesDosCampos`: nomes de todos os campos declarados em `classe` (`getDeclaredFields`), na ordem em que foram declarados.
- `campoEhPrivado`: `true` se o campo tem o modificador `private`, `false` caso contrário.
- `nomeDoCampo` que não existe na classe → `IllegalArgumentException` (traduzida da `NoSuchFieldException`, com a causa original preservada).
- `classe` nula → `IllegalArgumentException`.

**Exemplos**

Com `Pessoa { private String nome; public int idade; }`:

| Chamada | Resultado |
|---|---|
| `nomesDosCampos(Pessoa.class)` | `["nome", "idade"]` |
| `campoEhPrivado(Pessoa.class, "nome")` | `true` |
| `campoEhPrivado(Pessoa.class, "idade")` | `false` |

<details><summary>Dica</summary>

`classe.getDeclaredFields()` devolve um `Field[]` com todos os campos, na ordem declarada. Cada `Field` tem `.getName()` e `.getModifiers()` — `Modifier.isPrivate(campo.getModifiers())` responde se é `private`. Para achar um campo específico pelo nome, `classe.getDeclaredField(nome)` lança `NoSuchFieldException` (checked) se não existir — capture e relance como `IllegalArgumentException`.

</details>

**Revisa:** tradução de exceção (Mundo 4).
**Rodar:** `mvn test -Dtest=RaioXTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
