# 14.02 — Pedido Builder

**Missão:** Montar um `Pedido` passo a passo, e só checar se ele está completo no final.

**Implemente:** `challenges.m14.f02.Pedido` (e sua classe interna `Pedido.Builder`)

```java
public static Pedido.Builder builder()
public String cliente()
public List<String> itens()
public double valorTotal()
// em Builder:
public Builder cliente(String cliente)
public Builder adicionarItem(String item, double valor)
public Pedido build()
```

**Regras**
- `Pedido.builder()` devolve um `Builder` novo, vazio.
- `cliente(...)` e `adicionarItem(...)` devolvem o próprio `Builder` (encadeáveis: `.cliente(...).adicionarItem(...).adicionarItem(...)`).
- `adicionarItem(item, valor)` com `valor` menor ou igual a zero → `IllegalArgumentException` **na hora de adicionar**, não espera o `build()`.
- `build()`: sem `cliente` definido, ou sem nenhum item adicionado → `IllegalStateException`. Só então cria o `Pedido`.
- `valorTotal()` do `Pedido` pronto é a soma dos valores de todos os itens adicionados.

**Exemplos**

| Chamadas | Resultado |
|---|---|
| `.cliente("Ana").adicionarItem("Arroz", 20).adicionarItem("Feijão", 8.5).build()` | cliente `"Ana"`, itens `["Arroz","Feijão"]`, total `28.5` |
| `.adicionarItem("Arroz", 20).build()` (sem `cliente`) | `IllegalStateException` |

<details><summary>Dica</summary>

O `Builder` acumula o estado (cliente, lista de itens, soma) em campos privados próprios, mutáveis — cada método `return this;` depois de atualizar o campo. `build()` só monta o `Pedido` (imutável) depois de validar que o essencial está preenchido.

</details>

**Revisa:** classe imutável e validação no construtor (Mundo 3), `IllegalStateException` (Mundo 4).
**Rodar:** `mvn test -Dtest=PedidoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
