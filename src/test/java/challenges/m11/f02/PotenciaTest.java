package challenges.m11.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PotenciaTest {

  @Test
  void expoenteParDobrandoBase() {
    assertEquals(1024L, Potencia.potencia(2, 10));
  }

  @Test
  void expoenteZeroDevolveUm() {
    assertEquals(1L, Potencia.potencia(5, 0));
  }

  @Test
  void baseNegativaExpoenteImpar() {
    assertEquals(-8L, Potencia.potencia(-2, 3));
  }

  @Test
  void baseNegativaExpoentePar() {
    assertEquals(16L, Potencia.potencia(-2, 4));
  }

  @Test
  void expoenteNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Potencia.potencia(2, -1));
  }
}
