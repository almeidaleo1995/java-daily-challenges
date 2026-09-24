package challenges.m08.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GeometriaTest {

  @Test
  void doisPontosIguaisEPontoUnico() {
    assertEquals("ponto único", Geometria.classificar(new Linha(new Ponto(1, 1), new Ponto(1, 1))));
  }

  @Test
  void mesmoXEVertical() {
    assertEquals("vertical", Geometria.classificar(new Linha(new Ponto(1, 0), new Ponto(1, 5))));
  }

  @Test
  void mesmoYEHorizontal() {
    assertEquals("horizontal", Geometria.classificar(new Linha(new Ponto(0, 2), new Ponto(5, 2))));
  }

  @Test
  void xEYDiferentesEInclinada() {
    assertEquals("inclinada", Geometria.classificar(new Linha(new Ponto(0, 0), new Ponto(3, 4))));
  }

  @Test
  void objetoQueNaoELinhaDevolveMensagemPropria() {
    assertEquals("não é uma linha", Geometria.classificar("não sou uma linha"));
  }

  @Test
  void objetoNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Geometria.classificar(null));
  }
}
