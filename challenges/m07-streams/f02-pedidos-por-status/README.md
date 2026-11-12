# 7.02 — Pedidos por Status

**Missão:** Contar quantos pedidos existem em cada status, sem montar o `Map` na mão.

**O que vamos trabalhar:** **`Collectors.groupingBy`** — agrupar elementos por uma chave e já aplicar uma "contagem" em cada grupo, sem montar o `Map` na mão.

**Na prática:** a chave é o `status` do pedido; o que cada grupo vira é a **quantidade** de pedidos. Dois collectors se encaixam: um agrupa, o outro (`counting`) decide o que guardar em cada grupo.

**Glossário rápido**
- **`collect(...)`** — operação terminal que reúne os elementos do stream num resultado (lista, mapa...).
- **`Collectors.groupingBy(chave)`** — devolve `Map<chave, List<elementos>>`.
- **Downstream collector** — segundo argumento do `groupingBy`; define o que fazer com cada grupo (`counting`, `summing`, ...).
- **`Collectors.counting()`** — conta elementos; devolve `Long` (por isso o `Map<String, Long>`).

**Pesquise sobre:** `java Collectors groupingBy counting` · `java stream collect Map` · `java downstream collector`

**Implemente:** `challenges.m07.f02.PainelDePedidos` (`Pedido` já vem pronto no esqueleto — não altere)

```java
public static Map<String, Long> contarPorStatus(List<Pedido> pedidos)
```

**Regras**
- `Pedido(String id, String status)`.
- Devolve um mapa de `status` → quantidade de pedidos com aquele status.
- `pedidos` vazia → mapa vazio.
- `pedidos` nulo → `IllegalArgumentException`.
- Implemente com `Collectors.groupingBy` + `Collectors.counting`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `[("1","ABERTO"), ("2","ABERTO"), ("3","FECHADO")]` | `{"ABERTO": 2, "FECHADO": 1}` |
| `[]` | `{}` |

<details><summary>Dica</summary>

`pedidos.stream().collect(Collectors.groupingBy(Pedido::status, Collectors.counting()))` — o segundo argumento de `groupingBy` é o "coletor de cada grupo"; `counting()` conta quantos itens caíram em cada chave.

</details>

**Revisa:** `Map`/contagem por chave (Mundo 2, fase 2.02) — aqui o mesmo resultado vem de um `Collector` em vez de um laço com `getOrDefault`.
**Rodar:** `mvn test -Dtest=PainelDePedidosTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
