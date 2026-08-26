# Glossário

O que foi usado em cada desafio e por quê. Uma linha por conceito, nunca por
desafio — se o conceito reaparecer com o mesmo motivo, não duplica.

| Conceito | Exemplo | Por que usamos | Desafio | Teste |
|---|---|---|---|---|
| Ternário (`?:`) | `n % 2 == 0 ? "par" : "ímpar"` | Decidir sinal/paridade em uma linha em vez de if/else | [001](001/README.md) | [ClassificadorTest](../src/test/java/challenges/day001/ClassificadorTest.java) |
| `%` e `/` | `numero % 10`, `numero / 10` | Separar dígitos de um número, um por vez | [002](002/README.md) | [SomaDigitosTest](../src/test/java/challenges/day002/SomaDigitosTest.java) |
| `while` | `while (numero != 0) { ... }` | Repetir enquanto o número ainda tem dígito | [002](002/README.md) | [SomaDigitosTest](../src/test/java/challenges/day002/SomaDigitosTest.java) |
| `charAt()` / `length()` | `texto.charAt(i)` | Percorrer uma `String` caractere a caractere | [003](003/README.md) | [ContadorVogaisTest](../src/test/java/challenges/day003/ContadorVogaisTest.java) |
| `StringBuilder` | `new StringBuilder().append(c)` | Concatenar `String` em loop recria o objeto a cada vez; `StringBuilder` muta em memória | [004](004/README.md) | [CompactadorTest](../src/test/java/challenges/day004/CompactadorTest.java) |
| Estado entre iterações | `anterior = atual` a cada volta do laço | Guardar caractere anterior e contagem pra comparar com o atual | [004](004/README.md) | [CompactadorTest](../src/test/java/challenges/day004/CompactadorTest.java) |
| Array (`length`, índice) | `numeros[i - 1]` | Comparar cada posição com a anterior sem método pronto | [005](005/README.md) | [SequenciaCrescenteTest](../src/test/java/challenges/day005/SequenciaCrescenteTest.java) |
| Acumular máximo durante o laço | `if (atual > melhor) melhor = atual;` | Manter "atual" e "melhor", atualizando os dois a cada passo | [005](005/README.md) | [SequenciaCrescenteTest](../src/test/java/challenges/day005/SequenciaCrescenteTest.java) |
| `List` | `new ArrayList<>()` | Guardar o resultado na ordem de inserção, sem índice fixo | [006](006/README.md) | [SemRepetidosTest](../src/test/java/challenges/day006/SemRepetidosTest.java) |
| `LinkedHashSet` | `new LinkedHashSet<>()` | Em vez de `HashSet`, manter a ordem de inserção pra saber quem apareceu primeiro | [006](006/README.md) | [SemRepetidosTest](../src/test/java/challenges/day006/SemRepetidosTest.java) |
| for-each | `for (int n : lista) { ... }` | Percorrer a `List` sem `.get(i)` nem índice | [006](006/README.md) | [SemRepetidosTest](../src/test/java/challenges/day006/SemRepetidosTest.java) |
| `Map` / `HashMap` | `new HashMap<>()` | Guardar cada valor como chave e a contagem de ocorrências como valor associado | [007](007/README.md) | [ContadorFrequenciaTest](../src/test/java/challenges/day007/ContadorFrequenciaTest.java) |
| `getOrDefault` | `mapa.getOrDefault(numero, 0)` | Buscar a contagem atual sem precisar testar `containsKey` antes de somar | [007](007/README.md) | [ContadorFrequenciaTest](../src/test/java/challenges/day007/ContadorFrequenciaTest.java) |
| `LinkedHashMap` | `new LinkedHashMap<>()` | Percorrer as chaves na ordem de primeira aparição, pra que o empate caia no que veio primeiro | [008](008/README.md) | [MaisFrequenteTest](../src/test/java/challenges/day008/MaisFrequenteTest.java) |
| `entrySet()` / `Map.Entry` | `for (Map.Entry<Integer, Integer> e : mapa.entrySet())` | Ler chave e valor juntos numa passada só, sem buscar o valor de novo pela chave | [008](008/README.md) | [MaisFrequenteTest](../src/test/java/challenges/day008/MaisFrequenteTest.java) |
| Desempate com `>` estrito | `if (quantidadeAtual > maximoRepeticoes)` | Empate não troca o campeão, então o primeiro encontrado se mantém; `>=` devolveria o último | [008](008/README.md) | [MaisFrequenteTest](../src/test/java/challenges/day008/MaisFrequenteTest.java) |
| `IllegalArgumentException` | `throw new IllegalArgumentException("...")` | Rejeitar entrada inválida (lista vazia) em vez de devolver um valor inventado | [008](008/README.md) | [MaisFrequenteTest](../src/test/java/challenges/day008/MaisFrequenteTest.java) |
| `ArrayDeque` | `new ArrayDeque<>()` | Fila e pilha eficientes na mesma estrutura: `offer`/`poll` para FIFO, `push`/`pop` para LIFO, sem sincronização desnecessária | [009](009/README.md) | [FilaDeCarregamentoTest](../src/test/java/challenges/day009/FilaDeCarregamentoTest.java) |
| `offer()` / `poll()` | `deque.offer(x); deque.poll()` | Adicionar no final e remover do início — fila FIFO | [009](009/README.md) | [FilaDeCarregamentoTest](../src/test/java/challenges/day009/FilaDeCarregamentoTest.java) |
| `push()` / `pop()` | `deque.push(x); deque.pop()` | Adicionar no topo e remover do topo — pilha LIFO — mesma estrutura, lados opostos | [009](009/README.md) | [FilaDeCarregamentoTest](../src/test/java/challenges/day009/FilaDeCarregamentoTest.java) |
| Validar parâmetro contra intervalo | `if (primeiros < 0 || primeiros > pacotes.size())` | Rejeitar um `int` fora dos limites válidos de índice/contagem antes de usá-lo | [009](009/README.md) | [FilaDeCarregamentoTest](../src/test/java/challenges/day009/FilaDeCarregamentoTest.java) |
| `do-while` | `do { numero /= 10; } while (numero != 0);` | Garantir que o laço rode pelo menos uma vez, cobrindo o caso de borda em que a condição já começa falsa (`numero == 0`) | [011](011/README.md) | [ContadorDigitosTest](../src/test/java/challenges/day011/ContadorDigitosTest.java) |
| `Character.isUpperCase()` | `Character.isUpperCase(letra)` | Testar se um `char` é maiúsculo sem comparar manualmente com `'A'` e `'Z'` | [012](012/README.md) | [ContadorMaiusculasTest](../src/test/java/challenges/day012/ContadorMaiusculasTest.java) |
| Construtor privado em classe utilitária | `private ContadorMaiusculas() {}` | `final` impede herança, mas não instanciação; o construtor privado fecha a classe que só tem métodos `static` | [012](012/README.md) | [ContadorMaiusculasTest](../src/test/java/challenges/day012/ContadorMaiusculasTest.java) |
