# 2.24 — Histórico de Navegação

**Missão:** Devolver o histórico de sites visitados do mais recente para o mais antigo, sem duplicatas — usando um recurso novo do Java 21 para inverter uma coleção ordenada.

**Implemente:** `challenges.m02.f24.HistoricoNavegacao`

```java
public static List<String> maisRecentePrimeiro(LinkedHashSet<String> historico)
```

**Regras**
- `historico` guarda os sites na ordem em que foram visitados (o primeiro elemento é o mais antigo).
- Devolve uma nova `List` com os mesmos sites, na ordem inversa (do mais recente para o mais antigo).
- `historico` nulo lança `IllegalArgumentException`.

**Exemplos**

Com `historico` inserido na ordem `"a.com"`, `"b.com"`, `"c.com"`, `maisRecentePrimeiro` devolve `["c.com", "b.com", "a.com"]`.

<details><summary>Dica</summary>

Desde o Java 21, coleções que mantêm ordem de inserção (como `LinkedHashSet` e `LinkedHashMap`) implementam `SequencedCollection`, que tem um método para obter uma **visão invertida** da coleção sem copiar nada — é só percorrer essa visão com um for-each normal.

</details>

**Revisa:** `LinkedHashSet` (desafio 006) — mantém ordem de inserção; aqui você percorre essa ordem ao contrário.
**Rodar:** `mvn test -Dtest=HistoricoNavegacaoTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
