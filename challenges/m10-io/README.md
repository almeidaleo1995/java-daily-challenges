# Mundo 10 — I/O
> Todo arquivo pode não existir, estar vazio ou estar corrompido — a API de I/O torna esses três casos explícitos em vez de um `null` silencioso.

- **`Path`** — o endereço de um arquivo, sem tocar o disco.
- **`Files.readAllLines`/`Files.lines`** — ler um arquivo inteiro numa `List<String>`, ou linha a linha com Stream.
- **`try`-with-resources em I/O** — um `Stream` de `Files.lines` precisa ser fechado, igual um `Scanner` ou uma conexão.
- **`Files.write`/`writeString`** — gravar em disco, escolhendo se sobrescreve ou cria.
- **`Files.walk`** — percorrer uma árvore de diretórios sem recursão manual.
- **`@TempDir`** — o teste cria e destrói seus próprios arquivos, sem sujar o disco real.

**Chefe:** Mercadinho v8: Importar Estoque — ler um CSV de produtos, separando as linhas válidas das que vão para um arquivo de erros.
**Fonte:** https://dev.java/learn/api/io/
