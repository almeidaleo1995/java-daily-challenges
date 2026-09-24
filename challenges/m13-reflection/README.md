# Mundo 13 — Reflection e Anotações
> Um framework que lê `@Entity` ou `@Test` sem você nunca ter escrito o `if` que reconhece a anotação está fazendo isso: código que examina outro código em tempo de execução.

- **`getDeclaredFields`/`getDeclaredMethods`** — listar a estrutura de uma classe sem conhecê-la em tempo de compilação.
- **`Modifier`** — perguntar se um campo é `private`, `static`, `final`, a partir de um `int` de flags.
- **`Method.invoke`** — chamar um método pelo nome, descoberto em tempo de execução.
- **Anotação própria** — `@interface`, e por que `@Retention(RUNTIME)` decide se ela sobrevive até a reflection conseguir lê-la.
- **`MethodHandles`** — uma alternativa mais rápida e tipada à reflection clássica para invocar métodos.

**Chefe:** Mercadinho v11: Mapeador CSV — preencher objetos a partir de linhas de texto, usando anotação pra dizer qual coluna vai em qual campo.
**Fonte:** https://dev.java/learn/api/reflection-method-handles/
