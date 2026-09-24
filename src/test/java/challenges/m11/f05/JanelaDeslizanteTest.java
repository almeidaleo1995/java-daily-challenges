package challenges.m11.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class JanelaDeslizanteTest {

  private static final int[] VENDAS = {2, 1, 5, 1, 3, 2};

  @Test
  void maiorJanelaDeTres() {
    assertEquals(9, JanelaDeslizante.maiorSomaJanela(VENDAS, 3));
  }

  @Test
  void janelaDeUmDevolveOMaiorElemento() {
    assertEquals(5, JanelaDeslizante.maiorSomaJanela(VENDAS, 1));
  }

  @Test
  void janelaDoTamanhoDoArrayDevolveASomaTotal() {
    assertEquals(14, JanelaDeslizante.maiorSomaJanela(VENDAS, VENDAS.length));
  }

  @Test
  void tamanhoDeJanelaZeroLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> JanelaDeslizante.maiorSomaJanela(VENDAS, 0));
  }

  @Test
  void tamanhoDeJanelaMaiorQueArrayLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> JanelaDeslizante.maiorSomaJanela(VENDAS, 7));
  }

  @Test
  void vendasNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> JanelaDeslizante.maiorSomaJanela(null, 2));
  }
}
