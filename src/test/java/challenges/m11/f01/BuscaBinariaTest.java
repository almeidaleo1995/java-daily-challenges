package challenges.m11.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BuscaBinariaTest {

  private static final int[] ORDENADO = {1, 3, 5, 7, 9, 11, 13};

  @Test
  void encontraNoMeio() {
    assertEquals(3, BuscaBinaria.indiceDe(ORDENADO, 7));
  }

  @Test
  void encontraNoPrimeiro() {
    assertEquals(0, BuscaBinaria.indiceDe(ORDENADO, 1));
  }

  @Test
  void encontraNoUltimo() {
    assertEquals(6, BuscaBinaria.indiceDe(ORDENADO, 13));
  }

  @Test
  void naoEncontradoDevolveMenosUm() {
    assertEquals(-1, BuscaBinaria.indiceDe(ORDENADO, 6));
  }

  @Test
  void arrayVazioDevolveMenosUm() {
    assertEquals(-1, BuscaBinaria.indiceDe(new int[0], 5));
  }

  @Test
  void arrayNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> BuscaBinaria.indiceDe(null, 5));
  }
}
