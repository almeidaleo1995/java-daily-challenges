# Nome

Marca Mais Comprada

# Objetivo

Reforçar `LinkedHashMap`, `entrySet` e desempate estrito, como no desafio
008 — mesma técnica, com chave `String` em vez de `Integer`.

# Contexto

Você tem a lista de marcas compradas por um cliente ao longo do tempo, na
ordem das compras, e quer saber qual marca ele mais comprou.

# Regras

Implemente o método:

```java
public static String maisComprada(List<String> marcas)
```

na classe `challenges.day037.MarcaMaisComprada`.

- `marcas` nunca é `null`.
- Se `marcas` estiver vazia, lance `IllegalArgumentException`.
- Devolva a marca que aparece **mais vezes** em `marcas`.
- Em caso de empate, devolva a que apareceu **primeiro** em `marcas`.

# Entrada

Uma `List<String>` não nula.

# Saída esperada

Uma `String` com a marca mais comprada, ou uma `IllegalArgumentException`
se a lista estiver vazia.

# Exemplos

| marcas | retorno |
|---|---|
| `["nike", "adidas", "nike"]` | `"nike"` |
| `["a", "b"]` | `"a"` |
| `["x"]` | `"x"` |
| `[]` | lança `IllegalArgumentException` |

# Restrições

- Sem Streams.
- Use `LinkedHashMap` e `entrySet`, igual ao desafio 008.

# Dicas

- Mesmo raciocínio do desafio 008: primeiro conte as ocorrências num
  `LinkedHashMap` (preserva a ordem de primeira aparição), depois percorra
  o `entrySet` procurando o campeão com comparação estrita (`>`).

# Critérios de avaliação

- Todos os testes de `MarcaMaisCompradaTest` passam
  (`mvn test -Dtest=MarcaMaisCompradaTest`).
- Uso de `LinkedHashMap` e `entrySet`, sem Streams.
- Lança `IllegalArgumentException` para lista vazia.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`LinkedHashMap`/`entrySet` buscando um máximo com desempate pela primeira
aparição — mesma base do desafio 008, com chave `String`.

# Próximo desafio

Revisão de valor sentinela e desempate estrito buscando um mínimo dentro de
um `Map` já pronto, como no desafio 017.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `LinkedHashMap`
- `entrySet()` / `Map.Entry`
- Desempate com comparação estrita
- `IllegalArgumentException`
