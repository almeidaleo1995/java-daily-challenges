# 4.03 — Leitor de Idade

**Missão:** Trocar uma exceção técnica e genérica (`NumberFormatException`) por uma exceção que faz sentido no seu domínio — sem perder o rastro do erro original.

**O que vamos trabalhar:** **traduzir exceções** — capturar uma exceção técnica (`NumberFormatException`) e relançar uma do seu domínio (`IdadeInvalidaException`), guardando a original como "causa" para não perder o rastro.

**Na prática:** converter texto em número pode falhar por formato ("abc"). Depois, mesmo sendo número, pode falhar por regra de negócio (fora de 0–130). Cada falha lança a **mesma** exceção sua, mas só a primeira leva uma `cause`.

**Glossário rápido**
- **`cause`** — exceção original embutida na nova; lida com `getCause()`.
- **`Integer.parseInt`** — converte `String` em `int`; lança `NumberFormatException` se não der.
- **Exceção de domínio** — exceção com nome que faz sentido no problema (`IdadeInvalida`, não `NumberFormat`).
- **Construtor `(String, Throwable)`** — jeito padrão de passar mensagem e causa à superclasse (`super(msg, causa)`).

**Pesquise sobre:** `java exception chaining getCause` · `java Integer.parseInt NumberFormatException` · `java super construtor exceção causa`

**Implemente:** `challenges.m04.f03.IdadeInvalidaException` e `challenges.m04.f03.LeitorDeIdade`

```java
public class IdadeInvalidaException extends RuntimeException { ... }

public static int ler(String texto)
```

**Regras**
- `texto` que não é um número inteiro válido lança `IdadeInvalidaException`, cuja `getCause()` é a `NumberFormatException` original.
- `texto` que é um número, mas fora da faixa `[0, 130]`, lança `IdadeInvalidaException` sem `cause` (a falha é de regra de negócio, não de formato).
- `texto` dentro da faixa devolve o valor como `int`.

**Exemplos**

| Entrada | Resultado |
|---|---|
| `ler("25")` | `25` |
| `ler("abc")` | lança `IdadeInvalidaException`; `getCause()` é uma `NumberFormatException` |
| `ler("200")` | lança `IdadeInvalidaException`; `getCause()` é `null` |

<details><summary>Dica</summary>

`Integer.parseInt` lança `NumberFormatException` (que é *unchecked*) quando o texto não é um número. Um construtor de exceção que recebe `(String mensagem, Throwable cause)` guarda a causa original — é isso que permite rastrear, mais tarde, qual foi o erro técnico por trás do erro de negócio.

</details>

**Revisa:** `try`/`catch` (desafio 043 tratava exceções de argumento; aqui você também **captura** uma exceção, não só lança).
**Rodar:** `mvn test -Dtest=LeitorDeIdadeTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
