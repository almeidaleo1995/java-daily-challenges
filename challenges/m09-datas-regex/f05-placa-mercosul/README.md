# 9.05 — Placa Mercosul

**Missão:** Validar se um texto tem exatamente o formato de uma placa Mercosul.

**Implemente:** `challenges.m09.f05.ValidadorDePlaca`

```java
public static boolean valida(String placa)
```

**Regras**
- Formato Mercosul: 3 letras maiúsculas, 1 dígito, 1 letra maiúscula, 2 dígitos — sem espaços, sem hífen (ex.: `"ABC1D23"`).
- Letras minúsculas, formato antigo (`"ABC1234"`), tamanho errado ou qualquer caractere fora do padrão → `false`.
- `placa` nula → `IllegalArgumentException`.
- Implemente com uma única expressão regular e `String.matches` (ou `Pattern.matches`).

**Exemplos**

| Entrada | Resultado |
|---|---|
| `"ABC1D23"` | `true` |
| `"abc1d23"` | `false` (minúsculas) |
| `"ABC1234"` | `false` (formato antigo) |
| `"ABC1D2"` | `false` (faltando um dígito) |

<details><summary>Dica</summary>

`^[A-Z]{3}\d[A-Z]\d{2}$` — três blocos: `[A-Z]{3}` (3 letras), `\d` (1 dígito), `[A-Z]` (1 letra), `\d{2}` (2 dígitos). O `^` e `$` garantem que a `String` inteira precisa casar, não só um pedaço dela.

</details>

**Revisa:** `Character.isUpperCase()`/`isDigit()` (Mundo 1) — aqui a mesma verificação, caractere por caractere, vira uma regra só em regex.
**Rodar:** `mvn test -Dtest=ValidadorDePlacaTest`

⭐☆☆☆☆ · ~10 min · +10 XP
