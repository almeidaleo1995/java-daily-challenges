# Nome

Classificador de Atendimento

# Objetivo

Reforçar o operador ternário (`?:`) combinando duas condições
independentes numa única `String`, como no desafio 001.

# Contexto

Uma recepção quer, para cada pessoa que chega, uma etiqueta com duas
informações: a faixa etária e o turno do atendimento.

# Regras

Implemente o método:

```java
public static String classificar(int idade, int horaAtual)
```

na classe `challenges.day010.ClassificadorAtendimento`.

- `idade` pode ser qualquer `int`, inclusive negativo.
- Se `idade` for menor que `18`, a faixa é `"menor"`; caso contrário,
  `"adulto"`.
- `horaAtual` está sempre entre `0` e `23`.
- Se `horaAtual` estiver entre `6` e `18` (incluindo os dois extremos), o
  turno é `"diurno"`; caso contrário, `"noturno"`.
- Retorne a faixa etária, um espaço, e o turno.

# Entrada

Dois números inteiros (`int idade`, `int horaAtual`).

# Saída esperada

Uma `String` no formato `"<faixa> <turno>"`.

# Exemplos

| idade | horaAtual | retorno |
|---|---|---|
| 17 | 10 | `"menor diurno"` |
| 5 | 3 | `"menor noturno"` |
| 30 | 20 | `"adulto noturno"` |
| 18 | 10 | `"adulto diurno"` |
| 18 | 6 | `"adulto diurno"` |
| 18 | 18 | `"adulto diurno"` |
| 18 | 19 | `"adulto noturno"` |

# Restrições

- Use `?:`, não `if`/`else`, para as duas decisões.
- Sem Streams.

# Dicas

- São duas perguntas independentes, cada uma com duas respostas — isso é
  exatamente a forma de um ternário.
- Resolva cada pergunta separada numa variável antes de juntar as duas na
  `String` final.

# Critérios de avaliação

- Todos os testes de `ClassificadorAtendimentoTest` passam
  (`mvn test -Dtest=ClassificadorAtendimentoTest`).
- Uso de `?:` para as duas decisões.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Operador ternário com duas condições independentes combinadas numa mesma
`String` — mesma ideia do desafio 001, em outro contexto.

# Próximo desafio

Revisão de laço com `%`/`/`, como no desafio 002.

---

Dificuldade:
⭐☆☆☆☆

Tempo:
15 minutos

Conceitos:

- Ternário (`?:`)
- Combinar duas decisões independentes numa `String`
