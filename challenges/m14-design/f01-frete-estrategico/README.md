# 14.01 — Frete Estratégico

**Missão:** Trocar o jeito de calcular frete sem `if (tipo.equals("aereo"))` — cada forma de calcular é uma classe que implementa o mesmo contrato.

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
