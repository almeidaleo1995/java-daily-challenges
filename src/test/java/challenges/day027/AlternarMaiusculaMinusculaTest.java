package challenges.day027;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AlternarMaiusculaMinusculaTest {

  @Test
  void textoVazio() {
    assertEquals("", AlternarMaiusculaMinuscula.alternarCaso(""));
  }

  @Test
  void palavraSimples() {
    assertEquals("OlA", AlternarMaiusculaMinuscula.alternarCaso("ola"));
  }

  @Test
  void espacoNaoContaParaAlternancia() {
    assertEquals("HeLlO WoRlD", AlternarMaiusculaMinuscula.alternarCaso("hello world"));
  }

  @Test
  void digitosNaoContamParaAlternancia() {
    assertEquals("A1B2C", AlternarMaiusculaMinuscula.alternarCaso("a1b2c"));
  }
}
