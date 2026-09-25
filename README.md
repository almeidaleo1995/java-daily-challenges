# java-daily-challenges

Trilha de desafios diários de Java, pensados pra treinar raciocínio e domínio
da linguagem — não pra decorar soluções. O Claude atua como **mentor**: nunca
escreve a solução, guia com perguntas e dicas. As regras completas desse
mentorado estão em [`CLAUDE.md`](CLAUDE.md).

## Como a trilha funciona

```
Mundo 1 ──▶ Mundo 2 ──▶ Mundo 3 ──▶ ... ──▶ Mundo 15
(tema)      (tema)      (tema)              (Chefão Final)

dentro de cada mundo:

  fase 1 ─▶ fase 2 ─▶ fase 3 ─▶ ... ─▶ 👑 chefe do mundo
  (~20 min cada)                        (mistura o mundo atual com
                                         ≥2 mundos anteriores, a partir
                                         do Mundo 3)

  vencer o chefe 👑 desbloqueia o próximo mundo 🔒
```

O mapa completo, XP e título atual vivem em
[`challenges/PROGRESSO.md`](challenges/PROGRESSO.md).

| # | Mundo |
|---|---|
| 1 | Sintaxe, Strings e Arrays |
| 2 | Collections |
| 3 | POO |
| 4 | Exceções |
| 5 | Generics |
| 6 | Lambdas e Optional |
| 7 | Streams |
| 8 | Pattern Matching (Java 21) |
| 9 | Datas e Regex |
| 10 | I/O |
| 11 | Algoritmos |
| 12 | Concorrência |
| 13 | Reflection e Anotações |
| 14 | Design |
| 15 | Chefão Final |

## Como o Claude ajuda (escada de dicas)

Quando você trava, o Claude nunca pula direto pra resposta — sobe um nível
de ajuda por vez, só se o anterior não bastar:

| Nível | O que é | Exemplo |
|---|---|---|
| 1 | Pergunta | "O que essa variável representa?" |
| 2 | Dica conceitual | "Talvez uma Collection seja útil aqui." |
| 3 | Indicação de API | "Existe um método da classe String que faz isso." |
| 4 | Pseudocódigo (nunca Java completo) | passos em texto, sem sintaxe |
| 5 | Algoritmo em português (nunca implementado) | descreve o raciocínio, não escreve o código |

Detalhes completos (o que o Claude pode e não pode fazer, revisão com
perguntas, progressão de XP) em [`CLAUDE.md`](CLAUDE.md).

## Fluxo de uma fase

```
1. Você pede ajuda/revisão   ──▶   2. Claude só faz perguntas
   ("travei no X")                    e dá dicas — nunca a solução
                                              │
                                              ▼
4. mvn test -Dtest=Classe   ◀──   3. Você implementa e testa
   (só você roda, é parte           sozinho
   do exercício)
        │
        ▼
5. Testes verdes → Claude revisa com perguntas de confirmação
        │
        ▼
6. Fase aprovada → XP somado em PROGRESSO.md + conceitos
   registrados em GLOSSARIO.md
```

## Estrutura

```
code-challenges-java/
├── CLAUDE.md                        regras do mentor (Claude)
├── pom.xml                          build Maven único pra tudo
├── src/
│   ├── main/java/challenges/mNN/fNN/    código de cada fase
│   └── test/java/challenges/mNN/fNN/    testes de cada fase
└── challenges/
    ├── PROGRESSO.md                 mapa da trilha, XP, título
    ├── GLOSSARIO.md                 conceitos usados, por que, onde
    ├── templates/                   modelos pra criar mundo/fase novos
    └── mNN-slug/
        ├── README.md                 1 frase + o que o mundo cobre
        ├── fNN-slug/README.md        enunciado da fase
        └── chefe-slug/README.md      enunciado do chefe do mundo
```

Um chefe usa `mNN/chefe` no código em vez de `mNN/fNN`.

Exemplo real, a fase 1.22 (Mundo 1, fase 22):

```
challenges/m01-sintaxe-strings-arrays/f22-contador-de-digitos-de-texto/
└── README.md                                     enunciado da fase

src/main/java/challenges/m01/f22/
└── ContadorDeDigitos.java                        esqueleto (você implementa)

src/test/java/challenges/m01/f22/
└── ContadorDeDigitosTest.java                     testes prontos (JUnit 5)
```

Cada `README.md` de fase segue sempre a mesma seção:
Missão → Implemente → Regras → Exemplos → Dica (opcional, dentro de um
`<details>`) → Revisa → Rodar. Os testes validam **comportamento**
(entrada → saída esperada), nunca revelam o algoritmo.

## Requisitos

- JDK 21+ (`java -version`)
- Maven 3.9+ (`mvn -version`)
- VS Code com o [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (sugerido automaticamente ao abrir a pasta)

## Comandos

Rodar a partir da raiz do repositório.

| O que | Comando |
|---|---|
| Compilar | `mvn compile` |
| Rodar todos os testes | `mvn test` |
| Rodar o teste de uma fase | `mvn test -Dtest=NomeDaClasseTest` |
| Verificar formatação | `mvn spotless:check` |
| Aplicar formatação | `mvn spotless:apply` |
