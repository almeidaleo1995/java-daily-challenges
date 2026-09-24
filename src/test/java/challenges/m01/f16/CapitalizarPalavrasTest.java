package challenges.m01.f16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CapitalizarPalavrasTest {

  @Test
  void textoVazio() {
    assertEquals("", CapitalizarPalavras.capitalizar(""));
  }

  @Test
  void umaUnicaPalavra() {
    assertEquals("Ola", CapitalizarPalavras.capitalizar("ola"));
  }

  @Test
  void duasPalavras() {
    assertEquals("Ola Mundo", CapitalizarPalavras.capitalizar("ola mundo"));
  }

  @Test
  void variasPalavrasIncluindoUmaLetraSo() {
    assertEquals("Java E Demais", CapitalizarPalavras.capitalizar("java e demais"));
  }
}
