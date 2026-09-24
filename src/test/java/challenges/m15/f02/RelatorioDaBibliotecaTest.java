package challenges.m15.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class RelatorioDaBibliotecaTest {

  @Test
  void semAtrasoAMultaEZero() {
    assertEquals(
        0.0,
        RelatorioDaBiblioteca.calcularMulta(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 10)),
        0.0001);
  }

  @Test
  void comAtrasoAMultaEMeioRealPorDia() {
    // prazo de 14 dias: vence em 2024-01-15; 5 dias de atraso até 2024-01-20
    assertEquals(
        2.5,
        RelatorioDaBiblioteca.calcularMulta(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 20)),
        0.0001);
  }

  @Test
  void dataEmprestimoPosteriorAHojeLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            RelatorioDaBiblioteca.calcularMulta(LocalDate.of(2024, 2, 1), LocalDate.of(2024, 1, 1)));
  }

  @Test
  void listaOsAtrasadosDoMaisAtrasadoParaOMenos() {
    List<EmprestimoAtivo> emprestimos =
        List.of(
            new EmprestimoAtivo("Dom Casmurro", "Ana", LocalDate.of(2024, 1, 1)), // 5 dias
            new EmprestimoAtivo("1984", "Bruno", LocalDate.of(2024, 1, 10)), // não atrasado
            new EmprestimoAtivo("O Hobbit", "Caio", LocalDate.of(2023, 12, 20))); // 17 dias

    assertEquals(
        List.of("O Hobbit", "Dom Casmurro"),
        RelatorioDaBiblioteca.emprestimosAtrasados(emprestimos, LocalDate.of(2024, 1, 20)));
  }

  @Test
  void emprestimosNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> RelatorioDaBiblioteca.emprestimosAtrasados(null, LocalDate.now()));
  }
}
