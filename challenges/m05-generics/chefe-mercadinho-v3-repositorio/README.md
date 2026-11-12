# 👑 Chefe do Mundo 5 — Mercadinho v3: Repositório

**Missão:** Construir um repositório genérico que guarda **qualquer** tipo que saiba se identificar — reaproveitando exceção própria (Mundo 4), `Map` (Mundo 2) e a ideia de `record` (Mundo 3).

**O que vamos trabalhar:** uma classe genérica com **duas** variáveis de tipo ligadas entre si (`ID` e `T extends Identificavel<ID>`), funcionando como um mini "banco de dados em memória" para qualquer tipo.

**Na prática:** o repositório guarda os itens num `Map<ID, T>`. A chave vem de `item.getId()`. Perguntas-guia: qual `Map` preserva a ordem de inserção? E o que acontece com a ordem quando você salva de novo um id que já existe?

**Glossário rápido**
- **Repositório** — objeto responsável por guardar e buscar entidades (padrão muito usado em sistemas reais).
- **`T extends Identificavel<ID>`** — `T` precisa ter `getId()` devolvendo o `ID`; é o que permite usar `item.getId()` com segurança.
- **Exceção de "não encontrado"** — melhor que devolver `null`: o erro fica explícito.
- **`LinkedHashMap`** — mantém ordem de inserção; `put` numa chave existente **não** muda a posição dela.

**Pesquise sobre:** `java generics múltiplos parâmetros de tipo` · `java padrão repository` · `java LinkedHashMap put chave existente ordem`

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
