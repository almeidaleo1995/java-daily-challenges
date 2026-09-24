package challenges.m09.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class CalculadoraDeIdadeTest {

  @Test
  void aniversarioAindaNaoChegouNoAnoAtual() {
    assertEquals(
        33, CalculadoraDeIdade.idadeEmAnos(LocalDate.of(1990, 5, 15), LocalDate.of(2024, 5, 14)));
  }

  @Test
  void aniversarioEHoje() {
    assertEquals(
        34, CalculadoraDeIdade.idadeEmAnos(LocalDate.of(1990, 5, 15), LocalDate.of(2024, 5, 15)));
  }

  @Test
  void nascimentoPosteriorAHojeLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> CalculadoraDeIdade.idadeEmAnos(LocalDate.of(2030, 1, 1), LocalDate.of(2024, 1, 1)));
  }

  @Test
  void datasNulasLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> CalculadoraDeIdade.idadeEmAnos(null, LocalDate.now()));
    assertThrows(
        IllegalArgumentException.class,
        () -> CalculadoraDeIdade.idadeEmAnos(LocalDate.now(), null));
  }
}
