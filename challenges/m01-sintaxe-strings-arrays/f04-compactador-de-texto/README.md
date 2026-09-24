> Antigo desafio 004 · Mundo 1, fase 04

# Nome

Compactador de Texto

# Objetivo

Praticar a construção de uma nova `String` a partir de outra, mantendo estado
entre as iterações do laço (o caractere anterior e quantas vezes ele repetiu).

# Contexto

Você está escrevendo um compactador simples de texto. Sequências de caracteres
iguais e consecutivos viram o caractere seguido da quantidade de repetições.
É a ideia por trás do RLE (run-length encoding), usado em formatos de imagem
antigos como o BMP e o PCX.

# Regras

Implemente o método:

```java
public static String compactar(String texto)
```

na classe `challenges.m01.f04.Compactador`.

- `texto` nunca é `null`, mas pode ser vazio.
- Cada sequência de caracteres iguais e **consecutivos** vira o caractere
  seguido do número de repetições.
- A contagem aparece **sempre**, mesmo quando for 1 (`"abc"` vira `"a1b1c1"`).
- Só sequências consecutivas contam: `"aabbaa"` vira `"a2b2a2"`, não `"a4b2"`.
- Maiúscula e minúscula são caracteres diferentes: `"aA"` vira `"a1A1"`.
- Texto vazio devolve texto vazio.

# Entrada

Uma `String` não nula.

# Saída esperada

Uma `String` com o texto compactado.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `""` |
| `"a"` | `"a1"` |
| `"abc"` | `"a1b1c1"` |
| `"aaabbc"` | `"a3b2c1"` |
| `"aabbaa"` | `"a2b2a2"` |
| `"aA"` | `"a1A1"` |

# Restrições

- Sem regex, sem Streams, sem `Map`, sem arrays.
- Sem recursão.
- Não use `String.repeat`, `replace` nem métodos que já resolvam o agrupamento.

# Dicas

- Você já sabe percorrer a `String` com `length()` e `charAt()`. A diferença
  aqui é que uma iteração precisa saber algo sobre a iteração anterior.
- Duas variáveis de estado bastam: qual caractere você está contando agora e
  quantas vezes ele apareceu até agora.
- Quando o caractere atual for diferente do que você está contando, é hora de
  "fechar" o bloco. E quando o laço termina, sobra sempre um bloco em aberto —
  cuidado com esse último.
- Concatenar `String` com `+` dentro de laço cria um objeto novo a cada volta.
  Existe uma classe do `java.lang` feita exatamente pra montar texto aos
  poucos — procure por `StringBuilder`.
- Texto vazio é o caso que costuma quebrar essa lógica. Teste ele primeiro.

# Critérios de avaliação

- Todos os testes de `CompactadorTest` passam (`mvn test -Dtest=CompactadorTest`).
- Um único laço sobre o texto, sem regex nem Streams.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Construção de `String` com `StringBuilder`, estado entre iterações,
comparação com o elemento anterior, tratamento do último bloco e do caso
vazio.

# Próximo desafio

Último desafio da fase de sintaxe: arrays — percorrer, acumular e comparar
elementos sem o apoio dos métodos de `String`.

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
30 minutos

Conceitos:

- `StringBuilder`
- Estado entre iterações do laço
- Tratamento de casos de borda (vazio, último bloco)
