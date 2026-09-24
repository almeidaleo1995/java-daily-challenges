# 15.04 — Encurtador de URL

**Missão:** Gerar um código curto pra cada URL, reaproveitando o mesmo código se a URL já foi encurtada antes.

**Implemente:** `challenges.m15.f04.Encurtador`

```java
public String encurtar(String urlOriginal)
public Optional<String> resolver(String codigo)
```

**Regras**
- `urlOriginal` precisa começar com `http://` ou `https://`; senão, `IllegalArgumentException`. `urlOriginal` nula → `IllegalArgumentException`.
- `encurtar`: gera um código curto (`[0-9a-zA-Z]+`) para a URL. A **mesma** URL, encurtada de novo, devolve o **mesmo** código (não gera um novo). URLs diferentes geram códigos diferentes.
- `resolver(codigo)`: `Optional` com a URL original, ou `Optional.empty()` se o código não existir.
- Use um contador interno crescente (`0, 1, 2, ...`) convertido pra base 62 (dígitos + minúsculas + maiúsculas) como código — não precisa ser aleatório.

**Exemplos**

| Chamada | Resultado |
|---|---|
| `encurtar("https://exemplo.com/a")` duas vezes seguidas | o mesmo código nas duas vezes |
| `resolver(codigo)` do exemplo acima | `Optional["https://exemplo.com/a"]` |

<details><summary>Dica</summary>

Dois mapas: um `Map<String, String>` de URL → código (pra não gerar código novo pra URL repetida) e um `Map<String, String>` de código → URL (pra resolver). Para converter um `int` em base 62: divida repetidamente por 62, use o resto como índice num alfabeto `"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"`, e concatene os dígitos de trás pra frente — o mesmo raciocínio do desafio 002 (separar dígitos com `%` e `/`), só que na base 62 em vez de 10.

</details>

**Revisa:** `Map` (Mundo 2), `%`/`/` para separar dígitos numa base (Mundo 1), `Optional` (Mundo 6).
**Rodar:** `mvn test -Dtest=EncurtadorTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
