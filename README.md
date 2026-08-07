# java-daily-challenges

Repositório de desafios diários de Java. Cada desafio é pensado para ~20
minutos e serve para treinar raciocínio e domínio da linguagem — não para
decorar soluções.

As regras de como o Claude deve mentorar (o que pode/não pode fazer, níveis
de ajuda, progressão de fases) estão em [`CLAUDE.md`](CLAUDE.md).

## Requisitos

- JDK 21+ (`java -version`)
- Maven 3.9+ (`mvn -version`)
- VS Code com o [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) (sugerido automaticamente ao abrir a pasta)

## Estrutura

```
java-daily-challenges/
├── CLAUDE.md                    regras do mentor
├── pom.xml                      build Maven único para todo o repositório
├── src/
│   ├── main/java/challenges/    código de cada desafio (challenges.dayNNN)
│   └── test/java/challenges/    testes de cada desafio (challenges.dayNNN)
└── challenges/
    ├── NNN/README.md            enunciado do desafio NNN
    ├── templates/                modelos para criar um novo desafio
    └── archive/                  desafios descontinuados
```

Todos os desafios vivem num único projeto Maven (um `pom.xml`), organizados
por pacote (`challenges.day001`, `challenges.day002`, ...). Veja
[`challenges/README.md`](challenges/README.md) para o detalhe da convenção.

## Comandos

Rodar a partir da raiz do repositório.

| O que | Comando |
|---|---|
| Compilar | `mvn compile` |
| Rodar todos os testes | `mvn test` |
| Rodar o teste de um desafio | `mvn test -Dtest=NomeDaClasseTest` |
| Rodar uma classe com `main` | `mvn compile exec:java -Dexec.mainClass=challenges.dayNNN.NomeDaClasse` |
| Verificar formatação | `mvn spotless:check` |
| Aplicar formatação | `mvn spotless:apply` |

## Fluxo de um desafio novo

1. Peça um novo desafio.
2. É criada a pasta `challenges/NNN/README.md` com o enunciado (a partir de
   `challenges/templates/README.template.md`) e o esqueleto de código/teste
   em `src/main/java/challenges/dayNNN/` e `src/test/java/challenges/dayNNN/`.
3. Implemente em `src/main/java/challenges/dayNNN/`.
4. Rode `mvn test -Dtest=*dayNNN*` (ou o nome da classe de teste) até passar.
5. `mvn spotless:apply` antes de considerar concluído.

## Sanity check

`challenges.Welcome` e seu teste (`WelcomeTest`) existem só para confirmar
que compilação, testes, execução e formatação estão funcionando. Pode
apagá-los quando o primeiro desafio de verdade for criado.
