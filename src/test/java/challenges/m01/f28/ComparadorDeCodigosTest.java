package challenges.m01.f28;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ComparadorDeCodigosTest {

  @Test
  void ignoraEspacosNasPontasECaixa() {
    assertTrue(ComparadorDeCodigos.saoEquivalentes(" ABC123 ", "abc123"));
  }

  @Test
  void codigosDiferentesNaoSaoEquivalentes() {
    assertFalse(ComparadorDeCodigos.saoEquivalentes("ABC123", "XYZ999"));
  }

  @Test
  void doisNulosSaoEquivalentes() {
    assertTrue(ComparadorDeCodigos.saoEquivalentes(null, null));
  }

  @Test
  void nuloComStringNaoSaoEquivalentes() {
    assertFalse(ComparadorDeCodigos.saoEquivalentes(null, "ABC"));
    assertFalse(ComparadorDeCodigos.saoEquivalentes("ABC", null));
  }

  @Test
  void espacosInternosNaoSaoRemovidos() {
    assertFalse(ComparadorDeCodigos.saoEquivalentes("AB C", "ABC"));
  }
}
