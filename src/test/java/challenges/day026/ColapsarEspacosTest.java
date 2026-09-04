package challenges.day026;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ColapsarEspacosTest {

  @Test
  void textoVazio() {
    assertEquals("", ColapsarEspacos.colapsar(""));
  }

  @Test
  void semEspacosDuplicados() {
    assertEquals("sem espaco", ColapsarEspacos.colapsar("sem espaco"));
  }

  @Test
  void variosEspacosSeguidos() {
    assertEquals("a b c", ColapsarEspacos.colapsar("a   b  c"));
  }

  @Test
  void doisEspacosViramUm() {
    assertEquals("a b", ColapsarEspacos.colapsar("a  b"));
  }
}
