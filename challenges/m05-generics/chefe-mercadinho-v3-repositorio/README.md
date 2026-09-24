# 👑 Chefe do Mundo 5 — Mercadinho v3: Repositório

**Missão:** Construir um repositório genérico que guarda **qualquer** tipo que saiba se identificar — reaproveitando exceção própria (Mundo 4), `Map` (Mundo 2) e a ideia de `record` (Mundo 3).

**Implemente:** `challenges.m05.chefe.Repositorio<ID, T extends Identificavel<ID>>` (`Identificavel` e `ItemNaoEncontradoException` já vêm prontos no esqueleto)

```java
public void salvar(T item)
public T buscarPorId(ID id)
public void remover(ID id)
public List<T> listarTodos()
```

**Regras**
- `T` é restrito a tipos que implementam `Identificavel<ID>` (têm um `getId()` que devolve `ID`).
- `salvar`: guarda `item`, usando `item.getId()` como chave. Se já existir um item com o mesmo id, substitui. `item` nulo lança `IllegalArgumentException`.
- `buscarPorId`/`remover`: `id` que não existe no repositório lança `ItemNaoEncontradoException`.
- `listarTodos`: devolve todos os itens guardados, **na ordem em que foram salvos pela primeira vez**.

**Exemplos**

Com um tipo de teste `Produto(String codigo, String nome)` que implementa `Identificavel<String>` devolvendo `codigo` como id:

```java
Repositorio<String, Produto> repositorio = new Repositorio<>();
repositorio.salvar(new Produto("P1", "Caneta"));
repositorio.buscarPorId("P1");     // Produto("P1", "Caneta")
repositorio.buscarPorId("P2");     // lança ItemNaoEncontradoException
```

<details><summary>Dica</summary>

`<ID, T extends Identificavel<ID>>` na declaração da classe diz: "`T` pode ser qualquer tipo, desde que implemente `Identificavel` parametrizado com o mesmo `ID`". Isso permite chamar `item.getId()` dentro da classe genérica sem *cast* nenhum — o compilador já sabe que todo `T` tem esse método. Um `LinkedHashMap<ID, T>` guarda a ordem de inserção para `listarTodos`, igual você já fez no chefe do Mundo 3.

</details>

**Revisa:** Exceção própria (Mundo 4), `Map`/`LinkedHashMap` (Mundo 2), tipo limitado (fase 5.03).
**Rodar:** `mvn test -Dtest=RepositorioTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 6 — Lambdas e Optional**.
