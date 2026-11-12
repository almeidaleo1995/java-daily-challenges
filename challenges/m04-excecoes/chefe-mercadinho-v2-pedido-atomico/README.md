# 👑 Chefe do Mundo 4 — Mercadinho v2: Pedido Atômico

**Missão:** Processar um pedido com várias linhas de forma **atômica**: ou o pedido inteiro é aplicado ao estoque, ou nenhuma linha é — nunca um resultado pela metade.

**O que vamos trabalhar:** **atomicidade** — "tudo ou nada". Ou o pedido inteiro é aplicado ao estoque, ou nada muda. Junta exceção própria (f01/f03) e `Map` (Mundo 2).

**Na prática:** a ordem importa. **Primeiro** percorra *todas* as linhas só **verificando**; se alguma falhar, lance a exceção sem ter alterado nada. **Depois** (só se tudo passou) percorra de novo subtraindo. Duas passadas: uma para checar, outra para aplicar.

**Glossário rápido**
- **Atômico** — operação indivisível: não existe resultado "pela metade".
- **Validar antes de aplicar** — padrão que evita ter que "desfazer" alterações.
- **`Map.getOrDefault`** — lê o valor ou devolve um padrão (útil para produto que não existe).
- **`Map` mutável** — o `estoque` vem de fora e é alterado no lugar; não crie uma cópia.

**Pesquise sobre:** `java operação atômica tudo ou nada validar antes` · `java Map getOrDefault` · `java Map merge subtrair`

**Implemente:** `challenges.m04.chefe.EstoqueInsuficienteException` e `challenges.m04.chefe.ProcessadorDePedido` (`ItemPedido` já vem pronto no esqueleto)

```java
public static void processar(Map<String, Integer> estoque, List<ItemPedido> itensPedido)
```

**Regras**
- `estoque` mapeia nome do produto → quantidade disponível. `itensPedido` é a lista de `ItemPedido(String produto, int quantidade)` do pedido.
- Antes de alterar qualquer coisa, verifica se **todos** os itens do pedido têm estoque suficiente. Se **qualquer** item não tiver (produto não existe no estoque, ou quantidade pedida maior que a disponível), lança `EstoqueInsuficienteException` nomeando o produto — e o `estoque` não é alterado em nenhum item, nem os que tinham quantidade suficiente.
- Se todos os itens passarem na verificação, subtrai a quantidade de cada um do `estoque`.
- `estoque` ou `itensPedido` nulos lançam `IllegalArgumentException`.

**Exemplos**

Com `estoque = {"Arroz": 10, "Feijão": 5}` e pedido `[("Arroz", 3), ("Feijão", 10)]`: o Feijão não tem estoque suficiente, então `processar` lança `EstoqueInsuficienteException` — e o Arroz continua em `10` no estoque (a linha do Arroz, que seria válida sozinha, não foi aplicada).

Com pedido `[("Arroz", 3), ("Feijão", 2)]`: `estoque` vira `{"Arroz": 7, "Feijão": 3}`.

<details><summary>Dica</summary>

"Verificar tudo antes de alterar qualquer coisa" é a técnica mais simples de conseguir atomicidade sem precisar desfazer nada depois: dois laços separados sobre `itensPedido` — um só valida, o outro só aplica — em vez de um laço único que valida e aplica item por item.

</details>

**Revisa:** Exceção própria (fases 4.01 e 4.03), `record` (fase 3.02), `Map`/`getOrDefault` (desafio 007).
**Rodar:** `mvn test -Dtest=ProcessadorDePedidoTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 5 — Generics**.
