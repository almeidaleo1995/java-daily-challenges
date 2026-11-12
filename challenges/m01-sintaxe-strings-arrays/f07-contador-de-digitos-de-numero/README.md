> Antigo desafio 011 · Mundo 1, fase 07

# Nome

Contador de Dígitos

# Objetivo

Reforçar `%`, `/` e laço, como no desafio 002 — mas agora contando dígitos
em vez de somá-los.

# Contexto

Você precisa saber quantos dígitos um número tem, sem transformá-lo em
`String`.

# O que vamos trabalhar

A mesma técnica de `%` e `/` da fase 1.02, mas agora **contando** dígitos em vez de somá-los. Atenção ao caso do `0`, que tem 1 dígito.

# Na prática

Pergunte-se: quantas vezes você consegue dividir o número por 10 até ele zerar? Esse raciocínio funciona para o `0`? Se não, que tipo de laço executa **pelo menos uma vez**?

# Glossário rápido

- **`do-while`** — como o `while`, mas executa o corpo antes de testar a condição.
- **Caso de borda** — o `0` quebra a lógica "enquanto > 0".

# Pesquise sobre

`java do while` · `java contar dígitos de um número` · `java while vs do while`

# Regras

Implemente o método:

```java
public static int contarDigitos(int numero)
```

na classe `challenges.m01.f07.ContadorDigitos`.

- `numero` é sempre maior ou igual a zero.
- Devolva a quantidade de dígitos de `numero`.
- `0` tem `1` dígito.

# Entrada

Um número inteiro não negativo (`int >= 0`).

# Saída esperada

Um `int` com a quantidade de dígitos.

# Exemplos

| numero | retorno |
|---|---|
| `0` | `1` |
| `5` | `1` |
| `42` | `2` |
| `205` | `3` |
| `1000` | `4` |
| `987654321` | `9` |

# Restrições

- Sem `String.valueOf`, sem `Integer.toString`, sem `Math.log10`.
- Só `%` e `/`, com laço.

# Dicas

- O mesmo laço de "dividir até chegar a zero" do desafio 002, só que agora
  você conta quantas vezes dividiu em vez de somar o resto.
- `numero = 0` é um caso especial: o laço `while (numero != 0)` nunca roda
  pra ele. Que tipo de laço garante rodar **pelo menos uma vez**, mesmo
  quando a condição já começa falsa?

# Critérios de avaliação

- Todos os testes de `ContadorDigitosTest` passam
  (`mvn test -Dtest=ContadorDigitosTest`).
- Sem conversão para `String` nem `Math.log10`.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`%`/`/` num laço para processar um número dígito a dígito, e o caso de
borda de um valor que zera o laço antes da primeira volta.

# Próximo desafio

Revisão de percorrer `String` caractere a caractere, como no desafio 003.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
15 minutos

Conceitos:

- `%` e `/`
- Laço (`while` ou `do-while`)
- Caso de borda que zera a condição do laço antes da primeira volta
