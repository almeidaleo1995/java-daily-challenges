# 5.01 — Par

**Missão:** Guardar dois valores de tipos possivelmente diferentes numa única classe genérica, reutilizável para qualquer combinação de tipos.

**Implemente:** `challenges.m05.f01.Par<A, B>`

```java
public Par(A primeiro, B segundo)
public A getPrimeiro()
public B getSegundo()
public Par<B, A> trocar()
```

**Regras**
- `getPrimeiro`/`getSegundo` devolvem os valores passados no construtor, sem alteração.
- `trocar()` devolve um **novo** `Par`, com os dois valores de posição invertida (o que era `primeiro` vira `segundo`, e vice-versa). O `Par` original não muda.

**Exemplos**

```java
Par<String, Integer> par = new Par<>("idade", 30);
par.getPrimeiro();          // "idade"
par.trocar().getPrimeiro(); // 30
par.trocar().getSegundo();  // "idade"
```

<details><summary>Dica</summary>

`<A, B>` depois do nome da classe declara dois parâmetros de tipo — cada um pode ser qualquer tipo, decidido só quando alguém escreve `new Par<String, Integer>(...)`. O tipo de retorno de `trocar()` inverte a ordem dos parâmetros de tipo (`Par<B, A>`), não só dos valores.

</details>

**Revisa:** `record` com dois campos (fase 3.02) — aqui os dois campos têm tipos genéricos, e a classe é reutilizável para qualquer par de tipos.
**Rodar:** `mvn test -Dtest=ParTest`

⭐☆☆☆☆ · ~10 min · +10 XP
