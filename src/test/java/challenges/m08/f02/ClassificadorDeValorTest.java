package challenges.m08.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClassificadorDeValorTest {

  @Test
  void inteiroNegativoEClassificadoComoNegativo() {
    assertEquals("negativo", ClassificadorDeValor.classificar(-5));
  }

  @Test
  void inteiroZeroEClassificadoComoZero() {
    assertEquals("zero", ClassificadorDeValor.classificar(0));
  }

  @Test
  void inteiroPositivoEClassificadoComoPositivo() {
    assertEquals("positivo", ClassificadorDeValor.classificar(7));
  }

  @Test
  void stringEmBrancoEClassificadaComoVazia() {
    assertEquals("string vazia", ClassificadorDeValor.classificar(""));
  }

  @Test
  void stringNaoVaziaEClassificadaComOValor() {
    assertEquals("string: oi", ClassificadorDeValor.classificar("oi"));
  }

  @Test
  void valorNuloEClassificadoComoNulo() {
    assertEquals("nulo", ClassificadorDeValor.classificar(null));
  }

  @Test
  void tipoNaoCobertoEClassificadoComoOutro() {
    assertEquals("outro", ClassificadorDeValor.classificar(3.14));
  }
}
