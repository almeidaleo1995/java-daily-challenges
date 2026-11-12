# 2.22 — Coordenada no Mapa

**Missão:** Fazer duas coordenadas com os mesmos valores serem reconhecidas como "a mesma coordenada" dentro de um `HashSet`/`HashMap` — isso não acontece de graça.

**O que vamos trabalhar:** o **contrato `equals`/`hashCode`**. Coleções de hash (`HashSet`, `HashMap`) só reconhecem dois objetos como "o mesmo" se `equals` **e** `hashCode` forem coerentes. Sem sobrescrever, cada instância é única.

**Na prática:** escreva `equals` (compara `x` e `y`) e `hashCode` (derivado dos mesmos campos). Regra de ouro: **objetos iguais precisam ter o mesmo `hashCode`**. Pergunte-se: o que acontece com `equals` certo e `hashCode` herdado de `Object`?

**Glossário rápido**
- **`equals(Object)`** — define quando dois objetos são "iguais".
- **`hashCode()`** — número que o `HashSet`/`HashMap` usa para achar o "balde" do objeto.
- **`Objects.hash(...)`** / **`Objects.equals(...)`** — utilitários para escrever os dois.
- **Contrato** — igual ⇒ mesmo `hashCode` (o contrário não é obrigatório).

**Pesquise sobre:** `java equals e hashCode contrato` · `java Objects.hash` · `java HashSet objeto personalizado não encontra`

**Implemente:** `challenges.m02.f22.Coordenada`

```java
public Coordenada(int x, int y)
public int getX()
public int getY()
// + equals(Object) e hashCode()
```

**Regras**
- Duas `Coordenada` são iguais quando têm o mesmo `x` e o mesmo `y` — mesmo sendo instâncias (objetos) diferentes.
- Duas `Coordenada` iguais **precisam** ter o mesmo `hashCode()`. Sem isso, um `HashSet`/`HashMap` não encontra o valor mesmo que `equals` esteja certo.

**Exemplos**

```java
Coordenada a = new Coordenada(1, 2);
Coordenada b = new Coordenada(1, 2);
a.equals(b);          // true — mesmos valores
new HashSet<>(List.of(a)).contains(b);  // true — só funciona se hashCode também bater
```

<details><summary>Dica</summary>

Por padrão, `equals` de qualquer classe compara se são o mesmo objeto na memória (igual o `==`) — para comparar por valor, é preciso sobrescrever. O contrato de Java é: se `a.equals(b)` é `true`, então `a.hashCode() == b.hashCode()` é obrigatório. `Objects.hash(campo1, campo2, ...)` calcula um `hashCode` consistente com vários campos de uma vez.

</details>

**Revisa:** `HashSet` (desafio 006) — até aqui você usou `HashSet<Integer>`/`HashSet<String>`, que já vêm com `equals`/`hashCode` prontos; aqui é a sua classe que precisa fornecer isso.
**Rodar:** `mvn test -Dtest=CoordenadaTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
