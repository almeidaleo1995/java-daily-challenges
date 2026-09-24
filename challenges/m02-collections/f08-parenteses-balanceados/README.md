> Antigo desafio 018 · Mundo 2, fase 08

# Nome

Parênteses Balanceados

# Objetivo

Reforçar `ArrayDeque` usado como pilha (LIFO), como no lado "pilha" do
desafio 009 — o exemplo clássico de uso de pilha em validação de texto.

# Contexto

Você recebe uma expressão só com `(` e `)` e precisa saber se os parênteses
estão corretamente balanceados: todo `(` tem um `)` correspondente depois
dele, na ordem certa.

# Regras

Implemente o método:

```java
public static boolean balanceado(String expressao)
```

na classe `challenges.m02.f08.ParentesesBalanceados`.

- `expressao` nunca é `null`, mas pode ser vazia.
- `expressao` contém apenas os caracteres `(` e `)`.
- Devolva `true` se todo `(` tiver um `)` correspondente na ordem correta;
  `false` caso contrário.
- `expressao` vazia é balanceada (`true`).

# Entrada

Uma `String` não nula, só com `(` e `)`.

# Saída esperada

Um `boolean`.

# Exemplos

| expressao | retorno |
|---|---|
| `""` | `true` |
| `"()"` | `true` |
| `"(())"` | `true` |
| `"((()))"` | `true` |
| `"(()"` | `false` |
| `")("` | `false` |
| `"())("` | `false` |

# Restrições

- Use `ArrayDeque` como pilha (`push`/`pop`), não `java.util.Stack`.
- Não vale só contar quantos `(` e `)` existem — `")("` tem a mesma
  contagem de `"()"`, mas não está balanceado. A ordem importa.

# Dicas

- Empilhe algo a cada `(`. Quando encontrar um `)`, o que precisa acontecer
  com o topo da pilha?
- Dois jeitos de dar errado: um `)` aparece sem ter `(` correspondente
  aberto (pilha vazia na hora de desempilhar), ou sobra `(` sem fechar no
  final (pilha não vazia ao terminar). Você precisa cobrir os dois.

# Critérios de avaliação

- Todos os testes de `ParentesesBalanceadosTest` passam
  (`mvn test -Dtest=ParentesesBalanceadosTest`).
- Uso de `ArrayDeque` como pilha.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`ArrayDeque` como pilha (`push`/`pop`) resolvendo um problema onde a ordem
de abertura e fechamento importa — mesma base do lado "pilha" do desafio
009.

# Próximo desafio

Uma rodada de revisão (desafios 019 a 042), reforçando loopings, arrays,
`String`, `List`/`Set` e `Map` antes do desafio de classe com estado
(`ContaBancaria`, agora no 043).

---

Dificuldade:
⭐⭐⭐☆☆

Tempo:
20 minutos

Conceitos:

- `ArrayDeque` como pilha (`push`, `pop`)
- Validar ordem de abertura/fechamento com uma pilha
