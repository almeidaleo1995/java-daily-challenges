package challenges.m01.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClassificadorTest {

  @Test
  void positivoEPar() {
    assertEquals("positivo par", Classificador.classificar(4));
  }

  @Test
  void positivoEImpar() {
    assertEquals("positivo ímpar", Classificador.classificar(3));
  }

  @Test
  void negativoEPar() {
    assertEquals("negativo par", Classificador.classificar(-10));
  }

  @Test
  void negativoEImpar() {
    assertEquals("negativo ímpar", Classificador.classificar(-7));
  }

  @Test
  void zero() {
    assertEquals("zero", Classificador.classificar(0));
  }
}
