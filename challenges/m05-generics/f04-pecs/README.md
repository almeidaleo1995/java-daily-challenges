# 5.04 — PECS

**Missão:** Copiar números de uma lista de origem para uma lista de destino, aceitando o máximo de combinações de tipo possível — a origem pode ser mais específica que `Number`, o destino pode ser mais genérico.

**Implemente:** `challenges.m05.f04.Copiador`

```java
public static void copiar(List<? extends Number> origem, List<? super Number> destino)
```

**Regras**
- Adiciona, em `destino`, todos os elementos de `origem`, na mesma ordem.
- `origem` ou `destino` nulos lançam `IllegalArgumentException`.

**Exemplos**

```java
List<Integer> origem = List.of(1, 2, 3);
List<Object> destino = new ArrayList<>();
Copiador.copiar(origem, destino);
destino; // [1, 2, 3]
```

Repare que `origem` é `List<Integer>` e `destino` é `List<Object>` — nenhum dos dois é `List<Number>`, mas a assinatura aceita os dois mesmo assim.

<details><summary>Dica</summary>

**PECS** = *Producer Extends, Consumer Super*: quem só vai **fornecer** valores (`origem`, você só lê dela) usa `? extends`; quem só vai **receber** valores (`destino`, você só escreve nela) usa `? super`. Com `List<? extends Number>` você pode ler `Number` de `origem`, mas não pode adicionar nada nela — o compilador não sabe o tipo exato. Com `List<? super Number>` você pode adicionar `Number` em `destino`, mas ler dela só devolve `Object`.

</details>

**Revisa:** Tipo genérico limitado (fase 5.03) — aqui o limite é num wildcard (`?`), não no parâmetro de tipo da própria classe.
**Rodar:** `mvn test -Dtest=CopiadorTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
