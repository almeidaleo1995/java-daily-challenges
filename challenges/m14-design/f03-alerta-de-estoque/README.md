# 14.03 — Alerta de Estoque

**Missão:** Avisar todo mundo interessado quando o estoque de um produto fica baixo, sem o estoque conhecer quem está ouvindo.

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
