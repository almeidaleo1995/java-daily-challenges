package challenges.m11.f04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ParComSomaTest {

  @Test
  void encontraParNasPontas() {
    assertArrayEquals(new int[] {0, 4}, ParComSoma.parComSoma(new int[] {1, 2, 3, 4, 9}, 10));
  }

  @Test
  void encontraParAdjacente() {
    assertArrayEquals(new int[] {1, 2}, ParComSoma.parComSoma(new int[] {1, 2, 3, 8, 9}, 5));
  }

  @Test
  void naoEncontradoDevolveArrayVazio() {
    assertArrayEquals(new int[0], ParComSoma.parComSoma(new int[] {1, 2, 3}, 100));
  }

  @Test
  void arrayNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ParComSoma.parComSoma(null, 5));
  }

  @Test
  void arrayComMenosDeDoisElementosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ParComSoma.parComSoma(new int[] {1}, 5));
  }
}
