# 14.01 — Frete Estratégico

**Missão:** Trocar o jeito de calcular frete sem `if (tipo.equals("aereo"))` — cada forma de calcular é uma classe que implementa o mesmo contrato.

**O que vamos trabalhar:** padrão **Strategy** — em vez de um `if/else` escolhendo o algoritmo, cada algoritmo vira uma classe que implementa a mesma interface, e quem usa recebe a que quiser.

**Na prática:** `EstrategiaDeFrete` já existe. Você escreve duas implementações (rodoviário, aéreo) e a `CalculadoraDeFrete`, que **guarda** a estratégia recebida no construtor e só **delega**. Se amanhã surgir frete marítimo, é uma classe nova, e nada do que já existe muda.

**Glossário rápido**
- **Design pattern** — solução reutilizável para um problema recorrente de projeto.
- **Strategy** — encapsular "como calcular" atrás de uma interface, trocável em tempo de execução.
- **Delegar** — repassar a chamada para outro objeto em vez de fazer o trabalho.
- **Injeção por construtor** — a dependência chega pelo construtor, não é criada dentro da classe.

**Pesquise sobre:** `padrão strategy java` · `design patterns strategy exemplo` · `injeção de dependência por construtor`

**Implemente:** `challenges.m14.f01.FreteRodoviario`, `FreteAereo` e `CalculadoraDeFrete` (`EstrategiaDeFrete` já vem pronta no esqueleto — não altere)

```java
public double calcular(double pesoKg, double distanciaKm) // em FreteRodoviario e FreteAereo
public CalculadoraDeFrete(EstrategiaDeFrete estrategia)
public double calcularFrete(double pesoKg, double distanciaKm)
```

**Regras**
- `FreteRodoviario.calcular`: `pesoKg * 0.5 + distanciaKm * 0.1`.
- `FreteAereo.calcular`: `pesoKg * 2.0 + distanciaKm * 0.3`.
- `pesoKg` ou `distanciaKm` negativos → `IllegalArgumentException`, nas duas estratégias.
- `CalculadoraDeFrete` guarda a `EstrategiaDeFrete` recebida no construtor e `calcularFrete` só delega pra ela — a calculadora não sabe (nem precisa saber) qual estratégia está usando.
- `estrategia` nula no construtor → `IllegalArgumentException`.

**Exemplos**

| Estratégia | `pesoKg` | `distanciaKm` | Resultado |
|---|---|---|---|
| `FreteRodoviario` | `10` | `100` | `15.0` |
| `FreteAereo` | `10` | `100` | `50.0` |

<details><summary>Dica</summary>

Sem essa interface, `CalculadoraDeFrete` teria um `if (tipo == RODOVIARIO) ... else if (tipo == AEREO) ...` — toda vez que aparecesse um novo tipo de frete, essa classe precisaria mudar. Com `EstrategiaDeFrete`, criar `FreteMaritimo` amanhã não toca em `CalculadoraDeFrete` nem em `FreteRodoviario`/`FreteAereo` — é assim que o padrão Strategy evita o `if/else` crescente.

</details>

**Revisa:** interface e polimorfismo (Mundo 3).
**Rodar:** `mvn test -Dtest=CalculadoraDeFreteTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
