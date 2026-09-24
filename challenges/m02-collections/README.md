# Mundo 2 — Collections
> Guardar dados certo é metade do trabalho de um sênior: a estrutura errada transforma O(1) em O(n) e um bug de igualdade em produção.

- **`Comparator`** — `comparing`, `reversed`, `thenComparing` para ordenar sem escrever a lógica de comparação à mão.
- **`TreeSet`** — coleção ordenada com busca por vizinhança (`ceiling`, `floor`).
- **`PriorityQueue`** — fila onde quem sai primeiro é definido por um `Comparator`, não pela ordem de chegada.
- **Contrato `equals`/`hashCode`** — por que dois objetos "iguais" que não sobrescrevem `hashCode` se perdem num `HashSet`.
- **Imutabilidade** — `List.copyOf` e por que uma cópia defensiva evita que quem recebe a lista a estrague.
- **`SequencedCollection`** (Java 21) — acessar/percorrer uma coleção ordenada do fim para o começo sem recriar nada.

**Chefe:** Conta Bancária com Extrato — `Deque` como pilha de "desfazer", `Map` para contagem por tipo, `StringBuilder` para o relatório.
**Fonte:** https://dev.java/learn/api/collections-and-streams/
