> Antigo desafio 019 · Mundo 1, fase 11

# Nome

Inverter Número

# Objetivo

Reforçar `while` e os operadores `%`/`/` pra separar dígitos, como no
desafio 002 — dessa vez remontando o número invertido, em vez de somar os
dígitos.

# Contexto

Você quer inverter a ordem dos dígitos de um número, tipo um espelho: 123
vira 321. É a mesma extração dígito por dígito do desafio 002, só que agora
cada dígito extraído entra num número novo em vez de entrar numa soma.

# Regras

Implemente o método:

```java
public static int inverter(int numero)
```

na classe `challenges.m01.f11.InverteNumero`.

- `numero` nunca é negativo.
- Devolva `numero` com os dígitos em ordem inversa.
- Zeros que ficam à esquerda do resultado (porque estavam à direita do
  número original) somem, como aconteceria se você escrevesse o número
  invertido à mão.

# Entrada

Um `int` não negativo.

# Saída esperada

Um `int` com os dígitos invertidos.

# Exemplos

| numero | retorno |
|---|---|
| `123` | `321` |
| `100` | `1` |
| `0` | `0` |
| `7` | `7` |
| `1203` | `3021` |

# Restrições

- Sem `String`, `StringBuilder` nem `Math.*` — só aritmética com `%` e `/`,
  igual ao desafio 002.
- Sem recursão.

# Dicas

- Mesma extração do desafio 002: `numero % 10` pega o último dígito,
  `numero / 10` descarta ele.
- Em vez de somar cada dígito extraído, o que você faria pra "empurrar" ele
  pra dentro de um número que está sendo remontado do zero? Pense em
  multiplicar por 10 antes de somar o próximo dígito.

# Critérios de avaliação

- Todos os testes de `InverteNumeroTest` passam
  (`mvn test -Dtest=InverteNumeroTest`).
- Uso de `while`, sem `String`/`StringBuilder`/`Math.*`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`while` e `%`/`/` pra extrair dígitos, remontando um número novo em vez de
acumular uma soma — mesma base do desafio 002, aplicada de outro jeito.

# Próximo desafio

Revisão de `do-while`, como no desafio 011.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `while`
- `%` e `/`
