package challenges.m08.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DescritorTest {

  @Test
  void inteiroEDescritoComOValor() {
    assertEquals("inteiro: 42", Descritor.descrever(42));
  }

  @Test
  void booleanoEDescritoComOValor() {
    assertEquals("booleano: true", Descritor.descrever(true));
  }

  @Test
  void textoNaoVazioEDescritoComOValor() {
    assertEquals("texto: oi", Descritor.descrever("oi"));
  }

  @Test
  void textoSoComEspacosEDescritoComoVazio() {
    assertEquals("texto vazio", Descritor.descrever("   "));
  }

  @Test
  void tipoNaoCobertoEDesconhecido() {
    assertEquals("desconhecido", Descritor.descrever(3.14));
  }

  @Test
  void valorNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Descritor.descrever(null));
  }
}
