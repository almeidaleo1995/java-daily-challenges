# 1.28 — Mesmo Código

**Missão:** Comparar dois códigos de produto ignorando espaços nas pontas e diferença de maiúsculas/minúsculas — e nunca comparar `String` com `==`.

**Implemente:** `challenges.m01.f28.ComparadorDeCodigos`

```java
public static boolean saoEquivalentes(String codigoA, String codigoB)
```

**Regras**
- Remove espaços do início/fim de cada código antes de comparar.
- A comparação ignora maiúsculas/minúsculas.
- `null` só é equivalente a `null` (não lança exceção, não trata `null` como igual a uma `String` vazia).

**Exemplos**

| Entrada | Saída |
|---|---|
| `saoEquivalentes(" ABC123 ", "abc123")` | `true` |
| `saoEquivalentes("ABC123", "XYZ999")` | `false` |
| `saoEquivalentes(null, null)` | `true` |
| `saoEquivalentes(null, "ABC")` | `false` |

<details><summary>Dica</summary>

`==` em `String` compara se são o mesmo objeto na memória, não se têm o mesmo conteúdo — funciona "por acaso" com literais por causa do *string pool*, mas quebra com qualquer `String` construída em runtime. Existe um método de `String` que remove espaços das pontas, outro que compara ignorando caixa, e um método utilitário em `Objects` que compara dois valores que podem ser `null` sem lançar `NullPointerException`.

</details>

**Revisa:** `charAt`/`length` (desafio 003) — aqui a comparação é da `String` inteira, não caractere a caractere.
**Rodar:** `mvn test -Dtest=ComparadorDeCodigosTest`

⭐⭐☆☆☆ · ~10 min · +20 XP
