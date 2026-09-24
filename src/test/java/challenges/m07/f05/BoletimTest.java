package challenges.m07.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class BoletimTest {

  @Test
  void separaAprovadosEReprovadosNaOrdemOriginal() {
    List<Aluno> alunos = List.of(new Aluno("Ana", 8), new Aluno("Bia", 5), new Aluno("Caio", 9));
    assertEquals("Aprovados: Ana, Caio\nReprovados: Bia", Boletim.gerar(alunos, 6));
  }

  @Test
  void notaIgualAoCorteEAprovada() {
    List<Aluno> alunos = List.of(new Aluno("Ana", 6));
    assertEquals("Aprovados: Ana\nReprovados: ", Boletim.gerar(alunos, 6));
  }

  @Test
  void todosReprovadosDeixaAprovadosVazio() {
    List<Aluno> alunos = List.of(new Aluno("Bia", 2));
    assertEquals("Aprovados: \nReprovados: Bia", Boletim.gerar(alunos, 6));
  }

  @Test
  void alunosNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Boletim.gerar(null, 6));
  }
}
