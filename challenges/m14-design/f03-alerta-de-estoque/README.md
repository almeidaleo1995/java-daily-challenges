# 14.03 — Alerta de Estoque

**Missão:** Avisar todo mundo interessado quando o estoque de um produto fica baixo, sem o estoque conhecer quem está ouvindo.

**O que vamos trabalhar:** padrão **Observer** — o estoque **não conhece** quem quer ser avisado; só mantém uma lista de "ouvintes" e chama todos quando algo importante acontece. Desacopla quem produz o evento de quem reage.

**Na prática:** `OuvinteDeEstoque` é uma interface de um método (dá para passar lambda!). O estoque guarda uma `List` deles, na ordem de registro, e quando o estoque cai a `limiteBaixo` **ou menos**, percorre a lista chamando `aoFicarBaixo`. Perguntas-guia: o limite é inclusivo? E se não houver ouvintes?

**Glossário rápido**
- **Observer (publish/subscribe)** — objetos se "inscrevem" para receber notificações.
- **Ouvinte / listener** — quem reage ao evento.
- **Acoplamento** — quanto uma classe depende de outra; o Observer o reduz.
- **Lambda como ouvinte** — como a interface tem um método só (mundo 6), basta `(produto, qtd) -> ...`.

**Pesquise sobre:** `padrão observer java` · `java listener interface funcional` · `publish subscribe vs observer`

**Implemente:** `challenges.m14.f03.EstoqueObservavel` (`OuvinteDeEstoque` já vem pronto no esqueleto — não altere)

```java
public EstoqueObservavel(int limiteBaixo)
public void registrarOuvinte(OuvinteDeEstoque ouvinte)
public void atualizarEstoque(String produto, int quantidade)
```

**Regras**
- `limiteBaixo` negativo no construtor → `IllegalArgumentException`.
- `registrarOuvinte` guarda o `ouvinte` numa lista interna; pode registrar quantos quiser. `ouvinte` nulo → `IllegalArgumentException`.
- `atualizarEstoque(produto, quantidade)`: se `quantidade` for menor ou igual a `limiteBaixo`, chama `aoFicarBaixo(produto, quantidade)` em **todos** os ouvintes registrados, na ordem em que foram registrados. Acima do limite, não chama ninguém.

**Exemplos**

Com `limiteBaixo = 5`:

| Chamada | Efeito |
|---|---|
| `atualizarEstoque("Arroz", 5)` | todos os ouvintes recebem `aoFicarBaixo("Arroz", 5)` |
| `atualizarEstoque("Arroz", 6)` | ninguém é chamado |

<details><summary>Dica</summary>

Uma `List<OuvinteDeEstoque>` guarda os registrados. Em `atualizarEstoque`, se a condição bater, percorra a lista chamando `ouvinte.aoFicarBaixo(produto, quantidade)` em cada um — o estoque não sabe (nem precisa saber) o que cada ouvinte faz com o aviso.

</details>

**Revisa:** `List` (Mundo 2), interface funcional / lambda (Mundo 6) — `OuvinteDeEstoque` pode ser implementado como lambda no teste.
**Rodar:** `mvn test -Dtest=EstoqueObservavelTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
