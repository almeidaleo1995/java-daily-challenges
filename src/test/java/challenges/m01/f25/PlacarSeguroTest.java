package challenges.m01.f25;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PlacarSeguroTest {

  @Test
  void somaDoisPontosNormalmente() {
    assertEquals(150, PlacarSeguro.somarPontos(100, 50));
  }

  @Test
  void somaZeroComZero() {
    assertEquals(0, PlacarSeguro.somarPontos(0, 0));
  }

  @Test
  void somaNoLimiteExatoNaoLancaExcecao() {
    assertEquals(Integer.MAX_VALUE, PlacarSeguro.somarPontos(Integer.MAX_VALUE - 5, 5));
  }

  @Test
  void somaQueEstouraLimiteLancaArithmeticException() {
    assertThrows(ArithmeticException.class, () -> PlacarSeguro.somarPontos(Integer.MAX_VALUE, 1));
  }
}
