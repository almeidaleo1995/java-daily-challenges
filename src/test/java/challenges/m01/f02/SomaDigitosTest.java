package challenges.m01.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomaDigitosTest {

  @Test
  void zero() {
    assertEquals(0, SomaDigitos.somarDigitos(0));
  }

  @Test
  void umDigito() {
    assertEquals(5, SomaDigitos.somarDigitos(5));
  }

  @Test
  void tresDigitos() {
    assertEquals(6, SomaDigitos.somarDigitos(123));
  }

  @Test
  void digitosRepetidos() {
    assertEquals(36, SomaDigitos.somarDigitos(9999));
  }

  @Test
  void comZerosNoMeio() {
    assertEquals(3, SomaDigitos.somarDigitos(1020));
  }
}
