package challenges.m01.f17;

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

  @Test
  void digitos() {
    assertEquals("a1 2b", ColapsarEspacos.colapsar("a1  2b"));
  }

  @Test
  void pontuacao() {
    assertEquals("oi! tudo bem?", ColapsarEspacos.colapsar("oi!  tudo bem?"));
  }
}
