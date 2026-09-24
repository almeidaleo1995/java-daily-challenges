package challenges.m04.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RetentativaTest {

  @Test
  void tarefaQueSempreFalhaLancaAPrimeiraExcecaoComAsDemaisSuprimidas() {
    int[] chamadas = {0};
    Tarefa tarefa =
        () -> {
          chamadas[0]++;
          throw new RuntimeException("falha " + chamadas[0]);
        };

    RuntimeException excecao =
        assertThrows(
            RuntimeException.class, () -> Retentativa.executarComRetentativa(tarefa, 3));

    assertEquals("falha 1", excecao.getMessage());
    assertEquals(2, excecao.getSuppressed().length);
    assertEquals(3, chamadas[0]);
  }

  @Test
  void tarefaQueFuncionaNaSegundaTentativaNaoTentaUmaTerceiraVez() throws Exception {
    int[] chamadas = {0};
    Tarefa tarefa =
        () -> {
          chamadas[0]++;
          if (chamadas[0] == 1) {
            throw new RuntimeException("falhou na primeira");
          }
        };

    Retentativa.executarComRetentativa(tarefa, 3);

    assertEquals(2, chamadas[0]);
  }

  @Test
  void maximoDeTentativasNaoPositivoLancaIllegalArgumentException() {
    Tarefa tarefa = () -> {};
    assertThrows(
        IllegalArgumentException.class, () -> Retentativa.executarComRetentativa(tarefa, 0));
  }

  @Test
  void maximoDeTentativasNegativoTambemLancaIllegalArgumentException() {
    Tarefa tarefa = () -> {};
    assertThrows(
        IllegalArgumentException.class, () -> Retentativa.executarComRetentativa(tarefa, -1));
  }

  @Test
  void excecoesSuprimidasSaoExatamenteAsDasTentativasSeguintes() {
    int[] chamadas = {0};
    Tarefa tarefa =
        () -> {
          chamadas[0]++;
          throw new RuntimeException("falha " + chamadas[0]);
        };

    RuntimeException excecao =
        assertThrows(
            RuntimeException.class, () -> Retentativa.executarComRetentativa(tarefa, 3));

    assertEquals("falha 2", excecao.getSuppressed()[0].getMessage());
    assertEquals("falha 3", excecao.getSuppressed()[1].getMessage());
  }
}
