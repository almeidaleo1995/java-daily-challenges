package challenges.m01.f22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContadorDeDigitosTest {

  @Test
  void textoVazio() {
    assertEquals(0, ContadorDeDigitos.contarDigitos(""));
  }

  @Test
  void semDigitos() {
    assertEquals(0, ContadorDeDigitos.contarDigitos("abc"));
  }

  @Test
  void digitosNoFinal() {
    assertEquals(3, ContadorDeDigitos.contarDigitos("abc123"));
  }

  @Test
  void digitosIntercalados() {
    assertEquals(3, ContadorDeDigitos.contarDigitos("1a2b3c"));
  }

  @Test
  void digitosForaDaEscala0_9() {
    assertEquals(4, ContadorDeDigitos.contarDigitos("1234abc:/"));
  }
}
