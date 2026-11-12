# 👑 Chefe do Mundo 13 — Mercadinho v11: Mapeador CSV

**Missão:** Transformar linhas de texto separadas por vírgula em objetos, usando anotação pra dizer qual coluna vai em qual campo.

**O que vamos trabalhar:** juntar **anotação + reflection** num mini-framework: uma classe qualquer descreve seu formato com `@Coluna`, e o seu mapeador a preenche a partir de uma linha CSV. É a ideia básica por trás de bibliotecas como Jackson e Hibernate.

**Na prática:** para cada linha: (1) crie uma instância da classe pedida **sem saber qual é** (construtor sem argumentos por reflection); (2) percorra os campos, ache os que têm `@Coluna`, leia o `indice`; (3) pegue o texto daquela posição, converta para o tipo do campo (`String` ou `int`) e atribua com `field.set`. Perguntas-guia: como obter o `indice` da anotação? Como decidir entre `String` e `int` para um `Field`?

**Glossário rápido**
- **`getDeclaredConstructor().newInstance()`** — cria objeto de uma `Class<T>`.
- **`field.getAnnotation(Coluna.class).indice()`** — lê um atributo da anotação.
- **`field.getType()`** — tipo do campo (`int.class`, `String.class`).
- **`field.set(objeto, valor)`** — grava o valor no campo.
- **`Class<T>` como parâmetro** — "me diga qual tipo você quer", mantendo o retorno `List<T>` tipado (Mundo 5).

**Pesquise sobre:** `java reflection newInstance construtor` · `java getAnnotation valor do atributo` · `java Field set int String`

**Implemente:** `challenges.m13.chefe.MapeadorCsv` (`@Coluna` e `ProdutoCsv` já vêm prontos no esqueleto — não altere)

```java
public static <T> List<T> mapear(List<String> linhasCsv, Class<T> classeAlvo) throws Exception
```

**Regras**
- `classeAlvo` tem um construtor público sem argumentos e campos públicos anotados com `@Coluna(indice = N)`.
- Para cada linha de `linhasCsv` (`separada por vírgula`, sem espaços), cria uma instância nova de `classeAlvo` e preenche cada campo anotado com o valor da posição `N` da linha, convertido para o tipo do campo (`String` ou `int` — só esses dois tipos aparecem nos campos anotados).
- Devolve a lista de objetos, na mesma ordem das linhas.
- `linhasCsv` ou `classeAlvo` nulos → `IllegalArgumentException`.

**Exemplos**

Com `ProdutoCsv { @Coluna(indice=0) String nome; @Coluna(indice=1) int quantidade; }`:

| `linhasCsv` | Resultado |
|---|---|
| `["Arroz,10", "Feijão,5"]` | dois `ProdutoCsv`: `("Arroz", 10)` e `("Feijão", 5)` |

<details><summary>Dica</summary>

`classeAlvo.getDeclaredConstructor().newInstance()` cria a instância. Para cada `campo` de `classeAlvo.getDeclaredFields()` com `campo.getAnnotation(Coluna.class) != null`, pegue `indice()` da anotação, leia `partes[indice]` da linha (`linha.split(",")`), e atribua: se `campo.getType() == int.class`, converta com `Integer.parseInt`; senão, atribua a `String` direto.

</details>

**Revisa:** anotação própria (fase 13.03), generics (Mundo 5), `getDeclaredFields`/`setAccessible` (fase 13.01).
**Rodar:** `mvn test -Dtest=MapeadorCsvTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 14 — Design**.
