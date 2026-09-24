# 10.02 — Soma de Coluna

**Missão:** Somar os valores de uma coluna específica de um CSV, lendo o arquivo linha a linha em vez de carregar tudo de uma vez.

**Implemente:** `challenges.m10.f02.SomaCsv`

```java
public static int somarColuna(Path arquivo, int indiceColuna) throws IOException
```

**Regras**
- `arquivo` é um CSV sem cabeçalho, colunas separadas por vírgula.
- Soma os valores inteiros da coluna de índice `indiceColuna` (0 é a primeira) em todas as linhas.
- `arquivo` nulo ou `indiceColuna` negativo → `IllegalArgumentException`.
- `arquivo` que não existe → deixe a `IOException` subir.
- Implemente com `Files.lines(arquivo)` dentro de um `try`-with-resources — o `Stream` de `Files.lines` precisa ser fechado explicitamente, diferente de `Files.readAllLines`.

**Exemplos**

Com o arquivo:
```
Arroz,10
Feijão,5
Sabão,20
```
`somarColuna(arquivo, 1)` → `35`.

<details><summary>Dica</summary>

```java
try (Stream<String> linhas = Files.lines(arquivo)) {
  return linhas.mapToInt(linha -> Integer.parseInt(linha.split(",")[indiceColuna])).sum();
}
```

O `try`-with-resources aqui não é opcional como nos desafios de arquivo anteriores: `Files.lines` abre o arquivo e mantém aberto enquanto o `Stream` existe — sem fechar, o descritor do arquivo vaza.

</details>

**Revisa:** `try`-with-resources (fase 4.02); `mapToInt`/`sum` (Mundo 7, fase 7.06).
**Rodar:** `mvn test -Dtest=SomaCsvTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
