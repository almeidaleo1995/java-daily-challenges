# 2.23 — Lista Congelada

**Missão:** Devolver uma cópia de uma lista que ninguém mais consegue alterar — nem quem recebeu, nem quem mexer na lista original depois.

**O que vamos trabalhar:** **imutabilidade** e **cópia defensiva** — devolver uma lista que ninguém consegue alterar e que **não é afetada** por mudanças na lista original.

**Na prática:** o cuidado é com duas coisas diferentes: (1) quem recebe **não pode** alterar a lista; (2) mudanças posteriores na **original** não podem vazar para a cópia. Existe um método estático em `List` que faz as duas. Pergunte-se: qual a diferença entre `List.of(...)`, `List.copyOf(...)` e `Collections.unmodifiableList(...)`?

**Glossário rápido**
- **Imutável** — não aceita `add`/`remove`/`set` (lança `UnsupportedOperationException`).
- **Cópia defensiva** — cópia feita para isolar o estado interno.
- **`List.copyOf(c)`** — cópia imutável.
- **`unmodifiableList`** — apenas uma **visão** protegida; se a original muda, ela muda junto.

**Pesquise sobre:** `java List copyOf vs unmodifiableList` · `java cópia defensiva` · `java UnsupportedOperationException lista imutável`

**Implemente:** `challenges.m02.f23.Congelador`

```java
public static List<Integer> congelar(List<Integer> original)
```

**Regras**
- Devolve uma lista **imutável** com os mesmos elementos de `original`, na mesma ordem.
- Alterar `original` depois de chamar `congelar` **não** pode mudar o conteúdo da lista devolvida (é uma cópia, não a mesma lista).
- `original` nulo lança `IllegalArgumentException`.

**Exemplos**

```java
List<Integer> original = new ArrayList<>(List.of(1, 2, 3));
List<Integer> congelada = Congelador.congelar(original);

original.add(4);          // não afeta "congelada"
congelada.add(5);         // lança UnsupportedOperationException
```

<details><summary>Dica</summary>

`List.of(...)` cria uma lista imutável, mas a partir de elementos individuais. Existe um método de `List` parecido que cria uma lista imutável **a partir de outra lista já existente** — e faz a cópia por dentro, sem precisar copiar manualmente antes.

</details>

**Revisa:** `List` (desafio 006) — até aqui toda `List` era mutável (`ArrayList`); aqui o exercício é devolver uma que não é.
**Rodar:** `mvn test -Dtest=CongeladorTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
