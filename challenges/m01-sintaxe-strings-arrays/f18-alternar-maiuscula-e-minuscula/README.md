> Antigo desafio 027 · Mundo 1, fase 18

# Nome

Alternar Maiúscula e Minúscula

# Objetivo

Reforçar `StringBuilder` e estado entre iterações, como no desafio 004 —
dessa vez o estado é um `boolean` que alterna a cada letra processada, sem
depender do valor do caractere anterior.

# Contexto

Você quer aplicar um efeito visual tipo "zombeiro" (aMiGoS vIRam AmIgOs) num
texto: cada letra alterna entre maiúscula e minúscula, começando em
maiúscula. Caracteres que não são letra (espaço, pontuação) aparecem sem
alteração e **não contam** pra alternância.

# Regras

Implemente o método:

```java
public static String alternarCaso(String texto)
```

na classe `challenges.m01.f18.AlternarMaiusculaMinuscula`.

- `texto` nunca é `null`, mas pode ser vazio.
- Percorra `texto` e, pra cada **letra**, alterne entre maiúscula e
  minúscula, começando pela primeira letra em maiúscula.
- Espaços e pontuação passam pro resultado sem mudar, e não contam como
  uma "vez" na alternância.

# Entrada

Uma `String` não nula.

# Saída esperada

Uma nova `String` com as letras alternando entre maiúscula e minúscula.

# Exemplos

| texto | retorno |
|---|---|
| `""` | `""` |
| `"ola"` | `"OlA"` |
| `"hello world"` | `"HeLlO WoRlD"` |
| `"a1b2c"` | `"A1B2C"` |

# Restrições

- Sem regex.
- Use `StringBuilder` pra montar o resultado.
- Um único laço sobre o texto.

# Dicas

- O estado aqui não é "qual foi o caractere anterior", é só um `boolean`
  que começa `true` (próxima letra é maiúscula) e vira o oposto **toda vez
  que você processa uma letra** — não em cada posição do laço.
- Espaço e pontuação entram no `StringBuilder` do jeito que vieram, sem
  tocar no `boolean`.

# Critérios de avaliação

- Todos os testes de `AlternarMaiusculaMinusculaTest` passam
  (`mvn test -Dtest=AlternarMaiusculaMinusculaTest`).
- Uso de `StringBuilder`, sem regex.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

`StringBuilder` construindo uma `String` nova com um `boolean` de controle
que alterna a cada iteração relevante — uma terceira variação de "estado
entre iterações", ao lado dos desafios 004 e 025/026.

# Próximo desafio

Revisão de percorrer um array acumulando os dois melhores valores, como no
desafio 005.

---

Dificuldade:
⭐⭐☆☆☆

Tempo:
20 minutos

Conceitos:

- `StringBuilder`
- Estado entre iterações do laço (`boolean` alternado)
