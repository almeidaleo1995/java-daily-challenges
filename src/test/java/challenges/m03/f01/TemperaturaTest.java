package challenges.m03.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TemperaturaTest {

  @Test
  void zeroCelsiusEhTrintaEDoisFahrenheit() {
    assertEquals(32.0, Temperatura.deCelsius(0).paraFahrenheit(), 0.0001);
  }

  @Test
  void cemCelsiusEhDuzentosEDozeFahrenheit() {
    assertEquals(212.0, Temperatura.deCelsius(100).paraFahrenheit(), 0.0001);
  }

  @Test
  void zeroAbsolutoExatoEhValido() {
    assertEquals(-273.15, Temperatura.deCelsius(-273.15).celsius(), 0.0001);
  }

  @Test
  void abaixoDoZeroAbsolutoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Temperatura.deCelsius(-300));
  }
}
