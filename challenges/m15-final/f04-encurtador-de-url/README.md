# 15.04 — Encurtador de URL

**Missão:** Gerar um código curto pra cada URL, reaproveitando o mesmo código se a URL já foi encurtada antes.

**O que vamos trabalhar:** um sistema **bidirecional** (URL → código e código → URL), um **contador** e a conversão de número para **base 62** — o mesmo truque usado pelos encurtadores de verdade.

**Na prática:** três perguntas. (1) Como achar rápido "esta URL já foi encurtada?" e "que URL é este código?" (dois `Map`s, um em cada direção). (2) Como transformar o número `0, 1, 2, ...` em texto usando 62 símbolos (`0-9`, `a-z`, `A-Z`)? Pense em como se converte para base 2 ou 16: divisão e resto. (3) Onde validar o `http://`/`https://`?

**Glossário rápido**
- **Base 62** — sistema numérico com 62 símbolos (10 dígitos + 26 minúsculas + 26 maiúsculas).
- **Conversão de base** — dividir repetidamente pela base e juntar os restos (de trás para frente).
- **Mapa bidirecional** — dois `Map` espelhados para buscar nos dois sentidos.
- **`StringBuilder`** — monta texto aos poucos; tem `reverse()` e `insert(0, ...)`.

**Pesquise sobre:** `converter número para base 62 java` · `como funciona encurtador de url` · `java StringBuilder reverse`

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
