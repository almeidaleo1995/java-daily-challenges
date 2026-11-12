# 3.03 — Formas

**Missão:** Calcular área e perímetro de formas diferentes através do mesmo contrato — quem chama não precisa saber se é um círculo ou um retângulo.

**O que vamos trabalhar:** **interface** e **polimorfismo** — vários tipos diferentes (`Circulo`, `Retangulo`) respondendo ao mesmo contrato (`Forma`), e quem usa não precisa saber qual é qual.

**Na prática:** a interface `Forma` já está pronta. Você cria duas classes que a `implements` e escrevem `area()` e `perimetro()` cada uma do seu jeito. Os testes chamam `forma.area()` sem saber o tipo concreto.

**Glossário rápido**
- **Interface** — contrato: lista de métodos que uma classe se compromete a ter.
- **`implements`** — a classe declara que cumpre o contrato (e é obrigada a escrever os métodos).
- **Polimorfismo** — mesma chamada (`forma.area()`), comportamento diferente conforme o objeto real.
- **`Math.PI`** — constante de π da biblioteca padrão.

**Pesquise sobre:** `java interface implements exemplo` · `java polimorfismo` · `java Math.PI`

**Implemente:** `challenges.m03.f03.Forma` (interface, já pronta no esqueleto), `Circulo` e `Retangulo`

```java
public interface Forma {
  double area();
  double perimetro();
}
```

**Regras**
- `Circulo(double raio)`: `area = π × raio²`, `perimetro = 2 × π × raio`. `raio` menor ou igual a zero lança `IllegalArgumentException`.
- `Retangulo(double largura, double altura)`: `area = largura × altura`, `perimetro = 2 × (largura + altura)`. `largura` ou `altura` menor ou igual a zero lança `IllegalArgumentException`.
- Ambas as classes implementam `Forma`.

**Exemplos**

| Forma | `area()` | `perimetro()` |
|---|---|---|
| `new Circulo(2)` | `≈12.566` | `≈12.566` |
| `new Retangulo(3, 4)` | `12.0` | `14.0` |

<details><summary>Dica</summary>

`Math.PI` é a constante para π. Uma `List<Forma>` pode guardar tanto `Circulo` quanto `Retangulo` na mesma coleção — cada `.area()` chamado nela executa o código da classe concreta certa, sem precisar de `if (forma instanceof Circulo)`.

</details>

**Revisa:** Interface e `default` (fase 3.05, na sequência) — aqui a interface só declara o contrato, sem implementação compartilhada.
**Rodar:** `mvn test -Dtest=FormasTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
