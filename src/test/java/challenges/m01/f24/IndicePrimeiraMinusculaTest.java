package challenges.m01.f24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IndicePrimeiraMinusculaTest {

  @Test
  void minusculaNoMeio() {
    assertEquals(3, IndicePrimeiraMinuscula.indicePrimeiraMinuscula("ABCdEF"));
  }

  @Test
  void minusculaNoInicio() {
    assertEquals(0, IndicePrimeiraMinuscula.indicePrimeiraMinuscula("aBC"));
  }

  @Test
  void semMinusculaLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class,
        () -> IndicePrimeiraMinuscula.indicePrimeiraMinuscula("ABC"));
  }

  @Test
  void textoVazioLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class, () -> IndicePrimeiraMinuscula.indicePrimeiraMinuscula(""));
  }
}
