# 5.05 — Cache LRU

**Missão:** Construir um cache com tamanho fixo que descarta automaticamente o item usado há mais tempo (*Least Recently Used*) quando fica cheio — reaproveitando uma classe do próprio JDK.

**Implemente:** `challenges.m05.f05.CacheLru<K, V>`

```java
public CacheLru(int capacidade)
```

**Regras**
- `CacheLru<K, V>` estende `LinkedHashMap<K, V>`.
- `capacidade` menor ou igual a zero lança `IllegalArgumentException`.
- Quando o cache atinge `capacidade` e um novo elemento é inserido, o elemento **usado há mais tempo** (contando leituras, não só inserções) é removido automaticamente.

**Exemplos**

```java
CacheLru<Integer, String> cache = new CacheLru<>(2);
cache.put(1, "a");
cache.put(2, "b");
cache.get(1);          // acessa a chave 1 — ela deixa de ser "a mais antiga"
cache.put(3, "c");      // cache cheio: remove a chave 2 (não usada desde a inserção)

cache.containsKey(1);  // true
cache.containsKey(2);  // false — foi descartada
cache.containsKey(3);  // true
```

<details><summary>Dica</summary>

`LinkedHashMap` tem um construtor `LinkedHashMap(capacidadeInicial, fatorDeCarga, accessOrder)` — com `accessOrder = true`, a ordem de iteração interna passa a refletir o **acesso** (leitura ou escrita), não só a inserção. `LinkedHashMap` também tem um método protegido, `removeEldestEntry(Map.Entry)`, chamado automaticamente depois de cada `put` — sobrescrevê-lo para devolver `true` quando o mapa passa do tamanho permitido é a única coisa que falta para virar um LRU completo.

</details>

**Revisa:** `LinkedHashMap` mantendo ordem (Mundo 2) — aqui a ordem que ele mantém não é mais a de inserção, e sim a de acesso.
**Rodar:** `mvn test -Dtest=CacheLruTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
