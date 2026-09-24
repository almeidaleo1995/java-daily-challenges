# 8.04 — Geometria

**Missão:** Classificar uma linha (vertical, horizontal, inclinada ou um único ponto) desestruturando os dois pontos que a formam direto no `case`.

**Implemente:** `challenges.m08.f04.Geometria` (`Ponto` e `Linha` já vêm prontos no esqueleto — não altere)

```java
public static String classificar(Object objeto)
```

**Regras**
- `Ponto(double x, double y)`, `Linha(Ponto inicio, Ponto fim)`.
- `objeto` é uma `Linha` cujos dois pontos são iguais → `"ponto único"`.
- `objeto` é uma `Linha` com o mesmo `x` nos dois pontos (e pontos diferentes) → `"vertical"`.
- `objeto` é uma `Linha` com o mesmo `y` nos dois pontos (e pontos diferentes) → `"horizontal"`.
- `objeto` é uma `Linha` em qualquer outro caso → `"inclinada"`.
- `objeto` não é uma `Linha` → `"não é uma linha"`.
- `objeto` nulo → `IllegalArgumentException`.
- Implemente com **record pattern**: desestruture `Linha(Ponto(...), Ponto(...))` direto no `instanceof` ou no `switch`, sem chamar `.inicio()`/`.fim()`/`.x()`/`.y()` manualmente.

**Exemplos**

| Entrada | Saída |
|---|---|
| `new Linha(new Ponto(1,1), new Ponto(1,1))` | `"ponto único"` |
| `new Linha(new Ponto(1,0), new Ponto(1,5))` | `"vertical"` |
| `new Linha(new Ponto(0,2), new Ponto(5,2))` | `"horizontal"` |
| `new Linha(new Ponto(0,0), new Ponto(3,4))` | `"inclinada"` |
| `"não sou uma linha"` | `"não é uma linha"` |

<details><summary>Dica</summary>

```java
if (objeto instanceof Linha(Ponto(var x1, var y1), Ponto(var x2, var y2))) {
  ...
}
```

Isso já te dá `x1`, `y1`, `x2`, `y2` prontos, sem nenhuma chamada de método — o pattern desce dois níveis: de `Linha` para os dois `Ponto`, e de cada `Ponto` para `x`/`y`.

</details>

**Revisa:** `switch`/`instanceof` com pattern (fases 8.01–8.03) — aqui o pattern desestrutura um `record` dentro de outro, em vez de só testar o tipo.
**Rodar:** `mvn test -Dtest=GeometriaTest`

⭐⭐⭐☆☆ · ~15 min · +30 XP
