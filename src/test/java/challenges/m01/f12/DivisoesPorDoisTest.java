package challenges.m01.f12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DivisoesPorDoisTest {

  @Test
  void zeroContaUmaDivisao() {
    assertEquals(1, DivisoesPorDois.contarDivisoesAteZero(0));
  }

  @Test
  void umContaUmaDivisao() {
    assertEquals(1, DivisoesPorDois.contarDivisoesAteZero(1));
  }

  @Test
  void cincoContaTresDivisoes() {
    assertEquals(3, DivisoesPorDois.contarDivisoesAteZero(5));
  }

  @Test
  void oitoContaQuatroDivisoes() {
    assertEquals(4, DivisoesPorDois.contarDivisoesAteZero(8));
  }
}
