package challenges.day041;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContadorDeEspacosTest {

  @Test
  void textoVazio() {
    assertEquals(0, ContadorDeEspacos.contarEspacos(""));
  }

  @Test
  void semEspacos() {
    assertEquals(0, ContadorDeEspacos.contarEspacos("semespaco"));
  }

  @Test
  void umEspaco() {
    assertEquals(1, ContadorDeEspacos.contarEspacos("ola mundo"));
  }

  @Test
  void variosEspacos() {
    assertEquals(4, ContadorDeEspacos.contarEspacos("a  b   c"));
  }
}
