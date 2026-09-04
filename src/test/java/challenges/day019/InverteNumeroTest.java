package challenges.day019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InverteNumeroTest {

  @Test
  void inverteNumeroSimples() {
    assertEquals(321, InverteNumero.inverter(123));
  }

  @Test
  void zerosNoFinalSomemNoResultado() {
    assertEquals(1, InverteNumero.inverter(100));
  }

  @Test
  void zeroPermaneceZero() {
    assertEquals(0, InverteNumero.inverter(0));
  }

  @Test
  void numeroDeUmDigito() {
    assertEquals(7, InverteNumero.inverter(7));
  }

  @Test
  void zeroNoMeioDoNumero() {
    assertEquals(3021, InverteNumero.inverter(1203));
  }
}
