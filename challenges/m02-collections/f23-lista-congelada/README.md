# 2.23 — Lista Congelada

**Missão:** Devolver uma cópia de uma lista que ninguém mais consegue alterar — nem quem recebeu, nem quem mexer na lista original depois.

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
