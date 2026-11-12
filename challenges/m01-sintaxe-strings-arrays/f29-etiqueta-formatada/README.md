# 1.29 — Etiqueta Formatada

**Missão:** Montar a linha de uma etiqueta de prateleira com nome alinhado à esquerda e preço alinhado à direita, sempre no mesmo formato de número (independente do idioma da máquina).

**O que vamos trabalhar:** **`String.format`** — montar texto com **largura** e **precisão** fixas (alinhamento à esquerda/direita, casas decimais) e `Locale` explícito para que o separador decimal seja sempre `.`.

**Na prática:** o "molde" do texto usa marcadores como `%-20s` (texto, 20 colunas, à esquerda) e `%8.2f` (número, 8 colunas, 2 decimais). Desafio: escrever o molde certo para a etiqueta. A linha separadora é só repetir um caractere.

**Glossário rápido**
- **`%s`, `%d`, `%f`** — marcadores para texto, inteiro e decimal.
- **`%-20s`** — alinhado à esquerda em 20 colunas; **`%8.2f`** — 8 colunas, 2 casas, alinhado à direita.
- **`Locale.ROOT`** — formato neutro (ponto decimal), independente do idioma do computador.
- **`"-".repeat(n)`** — repete um texto `n` vezes.

**Pesquise sobre:** `java String.format largura precisão` · `java Locale.ROOT String.format` · `java String repeat`

**Implemente:** `challenges.m01.f29.EtiquetaFormatada`

```java
public static String etiqueta(String nomeProduto, BigDecimal preco)
public static String linhaSeparadora(int largura)
```

**Regras**
- `etiqueta`: `nomeProduto` alinhado à esquerda em 20 colunas, seguido de `" R$ "`, seguido do preço com 2 casas decimais alinhado à direita em 8 colunas. `nomeProduto` nulo ou em branco lança `IllegalArgumentException`.
- Use `Locale.ROOT` no formato — o separador decimal do preço deve ser sempre `.`, nunca `,`, não importa a configuração regional da máquina.
- `linhaSeparadora`: devolve o caractere `-` repetido `largura` vezes. `largura` menor ou igual a zero lança `IllegalArgumentException`.

**Exemplos**

| Entrada | Saída |
|---|---|
| `linhaSeparadora(10)` | `"----------"` |
| `linhaSeparadora(0)` | lança `IllegalArgumentException` |

<details><summary>Dica</summary>

`String.format` usa `%-20s` para alinhar uma `String` à esquerda em 20 colunas, e `%8.2f` para alinhar um número à direita em 8 colunas com 2 casas decimais. Sem passar um `Locale`, o formato do número decimal muda de máquina para máquina — passe `Locale.ROOT` como primeiro argumento de `String.format` para travar o resultado. Para repetir um caractere, `String` tem um método pronto — não precisa de laço.

</details>

**Revisa:** `StringBuilder` (desafio 004) para montar texto aos poucos — aqui o texto inteiro sai pronto de uma chamada só.
**Rodar:** `mvn test -Dtest=EtiquetaFormatadaTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
