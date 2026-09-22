package challenges.day030;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IndicePrimeiroDecliveTest {

  @Test
  void declivioNoMeio() {
    assertEquals(2, IndicePrimeiroDeclive.indicePrimeiroDeclive(new int[] {1, 2, 5, 3, 4}));
  }

  @Test
  void declivioLogoNoInicio() {
    assertEquals(0, IndicePrimeiroDeclive.indicePrimeiroDeclive(new int[] {5, 1, 2}));
  }

  @Test
  void sequenciaSempreCrescenteLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class,
        () -> IndicePrimeiroDeclive.indicePrimeiroDeclive(new int[] {1, 2, 3}));
  }

  @Test
  void sequenciaDeIguaisLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class,
        () -> IndicePrimeiroDeclive.indicePrimeiroDeclive(new int[] {1, 1, 1}));
  }

  @Test
  void devolvePrimeiroDeclive_naoOUltimo() {
    assertEquals(0, IndicePrimeiroDeclive.indicePrimeiroDeclive(new int[] {5, 1, 2, 4, 3}));
  }
}
