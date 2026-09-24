# 3.05 — Pedágio

**Missão:** Cobrar pedágio por eixo, com uma regra padrão compartilhada e casos que fogem dela.

**Implemente:** `challenges.m03.f05.Veiculo` (interface, já pronta), `Carro`, `Moto` e `Caminhao`

```java
public interface Veiculo {
  int eixos();
  default double valorPedagio() {
    return eixos() * 5.0;
  }
}
```

**Regras**
- `Carro`: sempre 2 eixos. Usa o `valorPedagio()` padrão da interface (`10.0`).
- `Moto`: sempre 2 eixos, mas é **isenta** — sobrescreve `valorPedagio()` para devolver `0.0`.
- `Caminhao(int eixosExtras)`: tem `2 + eixosExtras` eixos, e usa o `valorPedagio()` padrão (nenhuma sobrescrita). `eixosExtras` negativo lança `IllegalArgumentException`.

**Exemplos**

| Veículo | `eixos()` | `valorPedagio()` |
|---|---|---|
| `new Carro()` | `2` | `10.0` |
| `new Moto()` | `2` | `0.0` |
| `new Caminhao(1)` | `3` | `15.0` |

<details><summary>Dica</summary>

Um método `default` numa interface já vem com implementação — quem implementa a interface herda esse comportamento de graça, e só precisa sobrescrever se quiser um comportamento diferente (como a `Moto`). Repare que `valorPedagio()` chama `eixos()` — e `eixos()` é abstrato, cada classe concreta decide o valor; o método `default` não precisa saber qual.

</details>

**Revisa:** Interface e polimorfismo (fase 3.03) — aqui a interface também compartilha implementação, não só o contrato.
**Rodar:** `mvn test -Dtest=PedagioTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
