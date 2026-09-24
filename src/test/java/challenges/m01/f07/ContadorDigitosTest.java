package challenges.m01.f07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContadorDigitosTest {

  @Test
  void zeroTemUmDigito() {
    assertEquals(1, ContadorDigitos.contarDigitos(0));
  }

  @Test
  void numeroDeUmDigito() {
    assertEquals(1, ContadorDigitos.contarDigitos(5));
  }

  @Test
  void numeroDeDoisDigitos() {
    assertEquals(2, ContadorDigitos.contarDigitos(42));
  }

  @Test
  void numeroDeTresDigitos() {
    assertEquals(3, ContadorDigitos.contarDigitos(205));
  }

  @Test
  void numeroComZerosNoMeio() {
    assertEquals(4, ContadorDigitos.contarDigitos(1000));
  }

  @Test
  void numeroGrande() {
    assertEquals(9, ContadorDigitos.contarDigitos(987654321));
  }
}
