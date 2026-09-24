# 10.04 — Caçador de .txt

**Missão:** Encontrar todos os arquivos de uma extensão específica dentro de uma árvore de pastas, sem escrever a recursão na mão.

**Implemente:** `challenges.m10.f04.BuscadorDeArquivos`

```java
public static List<Path> buscarPorExtensao(Path diretorio, String extensao) throws IOException
```

**Regras**
- Percorre `diretorio` e todas as subpastas, em qualquer profundidade.
- Devolve os **arquivos** (nunca diretórios) cujo nome termina em `"." + extensao`, ordenados pelo nome do arquivo.
- `diretorio` ou `extensao` nulos → `IllegalArgumentException`.
- Implemente com `Files.walk(diretorio)` dentro de um `try`-with-resources (o `Stream` de `Files.walk` também precisa ser fechado).

**Exemplos**

Com a árvore:
```
raiz/
├── a.txt
├── b.csv
└── sub/
    └── c.txt
```
`buscarPorExtensao(raiz, "txt")` → `[raiz/a.txt, raiz/sub/c.txt]` (ordenados por nome: `a.txt` antes de `c.txt`).

<details><summary>Dica</summary>

```java
try (Stream<Path> caminhos = Files.walk(diretorio)) {
  return caminhos
      .filter(Files::isRegularFile)
      .filter(p -> p.getFileName().toString().endsWith("." + extensao))
      .sorted(Comparator.comparing(p -> p.getFileName().toString()))
      .toList();
}
```

`Files.walk` devolve **todo mundo** na árvore, pastas incluídas — `Files.isRegularFile` é o filtro que descarta as pastas.

</details>

**Revisa:** `try`-with-resources em I/O (fase 10.02); `filter`/`sorted` (Mundo 7).
**Rodar:** `mvn test -Dtest=BuscadorDeArquivosTest`

⭐⭐☆☆☆ · ~15 min · +20 XP
