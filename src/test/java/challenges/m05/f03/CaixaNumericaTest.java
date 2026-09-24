package challenges.m05.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CaixaNumericaTest {

  @Test
  void getValorDevolveOValorNoTipoOriginal() {
    CaixaNumerica<Integer> caixa = new CaixaNumerica<>(5);
    assertEquals(5, caixa.getValor());
  }

  @Test
  void dobroComInteiro() {
    assertEquals(10.0, new CaixaNumerica<>(5).dobro(), 0.0001);
  }

  @Test
  void dobroComDouble() {
    assertEquals(5.0, new CaixaNumerica<>(2.5).dobro(), 0.0001);
  }

  @Test
  void valorNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new CaixaNumerica<Integer>(null));
  }
}
