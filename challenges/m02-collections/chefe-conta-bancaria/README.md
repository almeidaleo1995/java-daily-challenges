> Antigo desafio 043 · Mundo 2, chefe

# Nome

Conta Bancária com Extrato

# Objetivo

Fechar esta rodada de revisão reunindo, num único tipo de POO, quase tudo
que você já praticou separado: `Deque` como pilha, `Map` com
`getOrDefault`, `StringBuilder` e validação com exceções — agora dentro de
uma classe com estado próprio, em vez de métodos estáticos isolados.

# Contexto

A conta bancária do desafio anterior evolui: agora ela guarda um histórico
das operações (depósitos e saques), sabe dizer quantas operações de cada
tipo já aconteceram, consegue montar um extrato, e — a parte nova — consegue
**desfazer a última operação**, exatamente como um "Ctrl+Z": a mais recente
é a primeira a ser desfeita.

# Regras

Implemente a classe `challenges.m02.chefe.ContaBancaria`, com:

```java
public ContaBancaria(String titular, double saldoInicial)
public String getTitular()
public double getSaldo()
public void depositar(double valor)
public void sacar(double valor)
public void desfazerUltimaOperacao()
public String extrato()
public int quantidadeDeOperacoes(String tipo)
```

- `titular` não pode ser `null` nem uma `String` em branco; `saldoInicial`
  não pode ser negativo. Qualquer um dos dois inválido lança
  `IllegalArgumentException` no construtor. O saldo inicial **não** conta
  como uma operação (não aparece no extrato nem na contagem).
- `depositar(valor)` / `sacar(valor)`: `valor` menor ou igual a zero lança
  `IllegalArgumentException`. `sacar` com `valor` maior que o saldo atual
  também lança `IllegalArgumentException` (saldo insuficiente). Em nenhum
  desses casos o estado da conta muda. Caso contrário, a operação altera o
  saldo, entra no histórico e soma na contagem daquele tipo.
- `desfazerUltimaOperacao()`: desfaz o efeito da operação mais recente ainda
  no histórico (se foi depósito, subtrai o valor do saldo; se foi saque,
  devolve o valor ao saldo), remove essa operação do histórico e da
  contagem. Se não houver nenhuma operação para desfazer, lança
  `IllegalStateException`.
- `extrato()`: uma linha por operação ainda no histórico, da **mais
  recente para a mais antiga**, no formato `"TIPO valor"` (ex.:
  `"DEPOSITO 50.0"`, `"SAQUE 30.0"`), separadas por `"\n"`. Sem operações no
  histórico, devolve `""`.
- `quantidadeDeOperacoes(tipo)`: quantos depósitos (`"DEPOSITO"`) ou saques
  (`"SAQUE"`) ainda estão no histórico — uma operação desfeita não conta
  mais.

# Entrada

Chamadas de construtor e de método em qualquer ordem, com `String` e
`double`.

# Saída esperada

Saldo, extrato e contagens corretos após cada sequência de chamadas, ou a
exceção apropriada quando a chamada for inválida para o estado atual.

# Exemplos

Partindo de `new ContaBancaria("Ana", 100.0)`:

| Chamada | Efeito |
|---|---|
| `depositar(50.0)` | saldo `150.0`; `extrato()` → `"DEPOSITO 50.0"` |
| `sacar(30.0)` | saldo `120.0`; `extrato()` → `"SAQUE 30.0\nDEPOSITO 50.0"` |
| `desfazerUltimaOperacao()` | desfaz o saque; saldo volta a `150.0`; `extrato()` → `"DEPOSITO 50.0"` |
| `desfazerUltimaOperacao()` | desfaz o depósito; saldo volta a `100.0`; `extrato()` → `""` |
| `desfazerUltimaOperacao()` | histórico vazio → lança `IllegalStateException` |
| `sacar(1000.0)` | saldo insuficiente → lança `IllegalArgumentException`; nada muda |
| `new ContaBancaria("", 100.0)` | lança `IllegalArgumentException` (titular inválido) |

# Restrições

- Campos privados. Nada de campo público.
- O histórico é um `Deque` (`ArrayDeque`) usado como pilha — não `List`,
  não `java.util.Stack`.
- A contagem por tipo é um `Map`, lida/atualizada com `getOrDefault`.
- `extrato()` é construído com `StringBuilder`.
- Sem Streams.
- Nenhuma validação que falhar pode alterar saldo, histórico ou contagem.

# Dicas

- `desfazerUltimaOperacao` é o `pop` de uma pilha: o que entrou por último é
  o primeiro a sair. Isso é exatamente o desafio 009, só que agora dentro
  de um objeto.
- Cada entrada do histórico precisa carregar dois dados (tipo e valor) numa
  única `String`. Como você guarda os dois juntos de um jeito que dê pra
  separar de volta na hora de desfazer?
- `getOrDefault` evita testar `containsKey` antes de somar 1 ao contador —
  mesma ideia do desafio 007, agora somando e subtraindo.
- `IllegalStateException` não é `IllegalArgumentException`: aqui não há
  argumento errado, o problema é o **estado** do objeto no momento da
  chamada (não há operação para desfazer).

# Critérios de avaliação

- Todos os testes de `ContaBancariaTest` passam
  (`mvn test -Dtest=ContaBancariaTest`).
- Histórico em `ArrayDeque`, contagem em `Map` com `getOrDefault`, extrato
  em `StringBuilder`.
- `desfazerUltimaOperacao` reverte saldo, histórico e contagem juntos.
- Exceção correta em cada caso: `IllegalArgumentException` para argumento
  inválido, `IllegalStateException` para nada a desfazer.
- Código formatado (`mvn spotless:apply` sem alterações pendentes).

# O que estou praticando

Juntar, dentro de uma classe com estado, o que antes era treinado
separado: `Deque` como pilha, `Map`/`getOrDefault`, `StringBuilder` e a
diferença entre validar um argumento e validar um estado.

# Próximo desafio

Uma conta é sempre igual à outra. O próximo desafio traz uma segunda
variação com uma regra própria — é aí que entra herança.

---

Dificuldade:
⭐⭐⭐⭐⭐

Tempo:
50 minutos

Conceitos:

- POO: encapsulamento, construtor validando estado, métodos de instância
- `ArrayDeque` como pilha (revisão do desafio 009), agora modelando "desfazer"
- `Map`/`getOrDefault` (revisão do desafio 007), incrementando e decrementando
- `StringBuilder` (revisão do desafio 004) para montar um relatório
- `IllegalStateException` vs `IllegalArgumentException`
