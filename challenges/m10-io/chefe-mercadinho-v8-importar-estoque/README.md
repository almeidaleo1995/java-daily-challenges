# 👑 Chefe do Mundo 10 — Mercadinho v8: Importar Estoque

**Missão:** Importar um CSV de produtos para o estoque, separando as linhas válidas das inválidas — sem que uma linha ruim derrube a importação inteira.

**Implemente:** `challenges.m10.chefe.ImportadorDeEstoque` (`LinhaDeEstoque` já vem pronto no esqueleto — não altere)

```java
public static List<LinhaDeEstoque> importar(Path arquivoCsv, Path arquivoDeErros) throws IOException
```

**Regras**
- `arquivoCsv` tem uma linha por produto, no formato `produto,quantidade` (sem cabeçalho).
- Linha **válida**: `produto` não vazio e `quantidade` é um inteiro maior ou igual a zero. Vira `LinhaDeEstoque(produto, quantidade)` no retorno, na ordem em que aparece no arquivo.
- Linha **inválida** (formato errado, `produto` vazio, `quantidade` não numérica ou negativa): não entra no retorno; a linha original (texto exato) é gravada em `arquivoDeErros`, uma por linha, na mesma ordem em que apareceu no CSV.
- Se todas as linhas forem válidas, `arquivoDeErros` ainda é criado — só que vazio.
- `arquivoCsv` ou `arquivoDeErros` nulos → `IllegalArgumentException`.
- `arquivoCsv` que não existe → deixe a `IOException` subir.

**Exemplos**

Com `arquivoCsv`:
```
Arroz,10
Feijão,-5
Sabão,vinte
,20
Feijão,3
```

`importar` devolve `[LinhaDeEstoque("Arroz", 10), LinhaDeEstoque("Feijão", 3)]`, e `arquivoDeErros` fica com:
```
Feijão,-5
Sabão,vinte
,20
```

<details><summary>Dica</summary>

Leia todas as linhas com `Files.readAllLines` (fase 10.01), depois separe em duas listas — uma de `LinhaDeEstoque` válidas, outra com o texto original das inválidas — para no final gravar a segunda lista com o `GravadorDeRelatorio` da fase 10.03 (ou o mesmo `Files.writeString`). Validar cada linha é uma combinação de `split(",")` (Mundo 1) e `try`/`catch` de `NumberFormatException` para a quantidade.

</details>

**Revisa:** `Files.readAllLines` (fase 10.01), gravar arquivo (fase 10.03), exceção própria/validação (Mundo 4), `record` (Mundo 3).
**Rodar:** `mvn test -Dtest=ImportadorDeEstoqueTest`

⭐⭐⭐⭐☆ · ~20 min · +40 XP

---

Concluir este chefe libera o **Mundo 11 — Algoritmos**.
