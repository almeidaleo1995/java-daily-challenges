# 10.05 — Config com Padrão

**Missão:** Ler um arquivo de configuração `chave=valor`, linha por linha, num `Map`.

**O que vamos trabalhar:** **parsear** um arquivo `chave=valor` para um `Map`, ignorando linhas em branco e tratando linha malformada como erro.

**Na prática:** para cada linha: em branco? ignore. Sem `=`? lance `IllegalArgumentException`. Senão, parta **na primeira** ocorrência de `=` (o valor pode, em tese, conter `=`) e guarde no `Map`. Pense em `split` com limite.

**Glossário rápido**
- **`String.isBlank()`** — verdadeiro para vazio ou só com espaços.
- **`split(regex, limite)`** — limita o número de partes (`split("=", 2)`).
- **`indexOf`** — alternativa: achar a posição do `=` e usar `substring`.
- **`Map<String, String>`** — estrutura natural para configuração.

**Pesquise sobre:** `java String split limite` · `java String isBlank` · `java ler arquivo properties chave valor`

**Implemente:** `challenges.m10.f05.LeitorDeConfig`

```java
public static Map<String, String> ler(Path arquivo) throws IOException
```

**Regras**
- Cada linha não vazia de `arquivo` está no formato `chave=valor`.
- Linhas em branco são ignoradas.
- Uma linha não vazia sem `=` → `IllegalArgumentException`.
- `arquivo` nulo → `IllegalArgumentException`.
- `arquivo` que não existe → deixe a `NoSuchFileException` subir.

**Exemplos**

Com o arquivo:
```
host=localhost
port=8080

timeout=30
```
`ler(arquivo)` → `{"host": "localhost", "port": "8080", "timeout": "30"}` (a linha em branco foi ignorada).

<details><summary>Dica</summary>

`linha.split("=", 2)` separa só no primeiro `=`, então um valor que também contém `=` (uma URL, por exemplo) não quebra a leitura. Se o resultado do `split` não tiver 2 partes, a linha (não vazia) está fora do formato.

</details>

**Revisa:** `Map` (Mundo 2); `Files.readAllLines` (fase 10.01) para ler o arquivo inteiro de uma vez.
**Rodar:** `mvn test -Dtest=LeitorDeConfigTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
