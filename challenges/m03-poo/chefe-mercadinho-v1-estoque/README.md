# 👑 Chefe do Mundo 3 — Mercadinho v1: Estoque

**Missão:** Primeira versão do Mercadinho — controlar o estoque de uma loja, com dados imutáveis (`record`), categorias (`enum`) e valores acumulados com `BigDecimal` guardados num `Map`.

**Implemente:** `challenges.m03.chefe.Estoque` (`Categoria` e `ItemDeEstoque` já vêm prontos no esqueleto)

```java
public void adicionar(ItemDeEstoque item)
public void remover(String nome, int quantidade)
public int quantidadeDe(String nome)
public BigDecimal valorTotalEmEstoque()
public List<String> nomesPorCategoria(Categoria categoria)
```

**Regras**
- `adicionar`: se já existir um item com o mesmo `nome`, **soma** a quantidade nova à existente e atualiza o preço unitário para o do item novo (preços mudam; a categoria não). Se não existir, apenas guarda o item. `item` nulo lança `IllegalArgumentException`.
- `remover`: `quantidade` deve ser positiva, senão `IllegalArgumentException`. Produto inexistente, ou `quantidade` maior que o estoque atual, também lançam `IllegalArgumentException`. Se a remoção esvaziar o item, ele desaparece do estoque.
- `quantidadeDe`: devolve a quantidade atual do produto, ou `0` se ele não existe no estoque (não lança exceção).
- `valorTotalEmEstoque`: soma de `quantidade × precoUnitario` de todos os itens.
- `nomesPorCategoria`: nomes dos itens daquela categoria, **na ordem em que foram adicionados** ao estoque.

**Exemplos**

```java
Estoque estoque = new Estoque();
estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));
estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 5, new BigDecimal("27.00")));

estoque.quantidadeDe("Arroz");        // 15
estoque.valorTotalEmEstoque();        // 405.00 (15 × 27.00, preço atualizado)

estoque.remover("Arroz", 15);
estoque.quantidadeDe("Arroz");        // 0
```

<details><summary>Dica</summary>

`Map.merge(chave, valorNovo, funcaoDeCombinacao)` resolve o "se já existe, combina; senão, insere" numa chamada só, sem precisar de `containsKey` + `if`/`else`. Guardar os itens num `LinkedHashMap` em vez de `HashMap` preserva a ordem de inserção — necessário para `nomesPorCategoria` devolver sempre a mesma ordem.

</details>

**Revisa:** `record` (fase 3.02), `enum` (fase 3.04), `Map`/`getOrDefault` (desafio 007), `BigDecimal` (fase 1.26).
**Rodar:** `mvn test -Dtest=EstoqueTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 4 — Exceções**.
