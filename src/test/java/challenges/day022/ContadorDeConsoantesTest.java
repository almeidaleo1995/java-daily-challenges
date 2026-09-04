package challenges.day022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContadorDeConsoantesTest {

  @Test
  void textoVazio() {
    assertEquals(0, ContadorDeConsoantes.contarConsoantes(""));
  }

  @Test
  void somenteVogais() {
    assertEquals(0, ContadorDeConsoantes.contarConsoantes("aeiou"));
  }

  @Test
  void misturaDeVogaisEConsoantes() {
    assertEquals(2, ContadorDeConsoantes.contarConsoantes("Java"));
  }

  @Test
  void ignoraCaixa() {
    assertEquals(3, ContadorDeConsoantes.contarConsoantes("banana"));
  }

  @Test
  void ignoraEspacosEPontuacao() {
    assertEquals(5, ContadorDeConsoantes.contarConsoantes("Ola Mundo!"));
  }
}
