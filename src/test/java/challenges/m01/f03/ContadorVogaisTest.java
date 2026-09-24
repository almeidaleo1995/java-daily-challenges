package challenges.m01.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContadorVogaisTest {

  @Test
  void textoVazio() {
    assertEquals(0, ContadorVogais.contarVogais(""));
  }

  @Test
  void semVogais() {
    assertEquals(0, ContadorVogais.contarVogais("xyz"));
  }

  @Test
  void palavraSimples() {
    assertEquals(3, ContadorVogais.contarVogais("banana"));
  }

  @Test
  void todasMaiusculas() {
    assertEquals(5, ContadorVogais.contarVogais("AEIOU"));
  }

  @Test
  void fraseComEspacosENumeros() {
    assertEquals(5, ContadorVogais.contarVogais("Java e legal 123"));
  }

  @Test
  void ignoraPontuacao() {
    assertEquals(2, ContadorVogais.contarVogais("!@#o?u."));
  }
}
