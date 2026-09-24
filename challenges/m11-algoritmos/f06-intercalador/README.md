# 11.06 — Juntar Ordenadas

**Missão:** Juntar duas listas já ordenadas numa única lista ordenada, sem reordenar tudo no final.

**Implemente:** `challenges.m11.f06.Intercalador`

```java
public static List<Integer> intercalar(List<Integer> a, List<Integer> b)
```

**Regras**
- `a` e `b` já vêm em ordem crescente (podem ter tamanhos diferentes, podem ter repetidos).
- Devolve uma lista nova com todos os elementos de `a` e `b`, ordenada, mantendo duplicados.
- `a` ou `b` nulos → `IllegalArgumentException`.
- Sem `Collections.sort`, sem Stream `sorted`: percorra as duas listas com um ponteiro em cada, comparando os elementos atuais e avançando o ponteiro do menor. Esse é o passo de "merge" do merge sort.

**Exemplos**

| `a` | `b` | Resultado |
|---|---|---|
| `[1,3,5]` | `[2,4,6]` | `[1,2,3,4,5,6]` |
| `[1,3]` | `[1,2]` | `[1,1,2,3]` |

<details><summary>Dica</summary>

Dois índices, `i` em `a` e `j` em `b`, começando em `0`. A cada passo, compare `a.get(i)` com `b.get(j)`: o menor entra no resultado e o índice dele avança. Quando uma lista acabar, jogue o resto da outra direto no resultado.

</details>

**Revisa:** `List` (Mundo 2), dois ponteiros (fase 11.04).
**Rodar:** `mvn test -Dtest=IntercaladorTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
