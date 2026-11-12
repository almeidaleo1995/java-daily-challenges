# 15.01 — Biblioteca 1: Empréstimos

**Missão:** Controlar quais livros de um catálogo estão emprestados, pra quem, e desde quando.

**O que vamos trabalhar:** **modelar um domínio do zero** — decidir quais dados guardar, em qual estrutura, e quais regras cada método impõe. Aqui não há técnica nova: é escolher bem entre o que você já aprendeu.

**Na prática:** antes de escrever código, responda no papel: *que informação preciso lembrar sobre cada livro emprestado?* (quem pegou, quando). *Que estrutura me dá "dado o título, ache essa informação" rápido?* E liste as regras de erro (livro fora do catálogo, já emprestado, devolver sem estar emprestado) com a exceção certa para cada uma.

**Glossário rápido**
- **Modelagem** — escolher como representar o problema em classes/estruturas.
- **Estado do objeto** — o que a classe "lembra" entre uma chamada e outra.
- **`Map<K, V>`** — a estrutura natural para "associar título → empréstimo".
- **`IllegalArgumentException` vs `IllegalStateException`** — argumento inválido vs operação inválida no estado atual (fase 14.02).

**Pesquise sobre:** `java modelagem de domínio orientado a objetos` · `java Map put remove containsKey` · `IllegalStateException quando usar`

**Implemente:** `challenges.m15.f01.Biblioteca`

```java
public Biblioteca(List<String> titulosDisponiveis)
public void emprestar(String titulo, String usuario, LocalDate data)
public void devolver(String titulo)
public boolean estaEmprestado(String titulo)
public String usuarioComLivro(String titulo)
```

**Regras**
- `titulosDisponiveis` é o catálogo completo da biblioteca; todo livro começa disponível (não emprestado).
- `emprestar`: `titulo` fora do catálogo → `IllegalArgumentException`. Livro já emprestado → `IllegalStateException`. `usuario` nulo ou em branco → `IllegalArgumentException`.
- `devolver`: livro que não está emprestado → `IllegalStateException`.
- `estaEmprestado`/`usuarioComLivro` refletem o estado atual.

**Exemplos**

| Chamadas | Resultado |
|---|---|
| `emprestar("Dom Casmurro", "Ana", ...)` → `estaEmprestado("Dom Casmurro")` | `true` |
| depois `devolver("Dom Casmurro")` → `estaEmprestado(...)` | `false` |

<details><summary>Dica</summary>

Um `Map<String, algumaCoisa>` guarda, por título emprestado, quem pegou e quando — um `record` privado (`Emprestimo(String usuario, LocalDate data)`) é uma forma limpa de carregar os dois dados juntos como valor do mapa.

</details>

**Revisa:** `Map`/`getOrDefault` (Mundo 2), `record` (Mundo 3), `IllegalStateException` vs `IllegalArgumentException` (Mundo 4).
**Rodar:** `mvn test -Dtest=BibliotecaTest`

⭐⭐⭐☆☆ · ~20 min · +30 XP
