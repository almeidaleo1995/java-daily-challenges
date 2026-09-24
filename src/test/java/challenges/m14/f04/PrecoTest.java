package challenges.m14.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PrecoTest {

  @Test
  void precoBaseDevolveOValorRecebido() {
    assertEquals(100.0, new PrecoBase(100.0).valor(), 0.0001);
  }

  @Test
  void comImpostoAdicionaOPercentual() {
    Preco preco = new ComImposto(new PrecoBase(100.0), 20.0);
    assertEquals(120.0, preco.valor(), 0.0001);
  }

  @Test
  void comDescontoSubtraiOPercentual() {
    Preco preco = new ComDesconto(new PrecoBase(100.0), 10.0);
    assertEquals(90.0, preco.valor(), 0.0001);
  }

  @Test
  void decoradoresEmpilhamNaOrdemAplicada() {
    Preco preco = new ComImposto(new ComDesconto(new PrecoBase(100.0), 10.0), 20.0);
    assertEquals(108.0, preco.valor(), 0.0001);
  }

  @Test
  void percentualNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new ComImposto(new PrecoBase(100.0), -5.0));
  }

  @Test
  void precoBaseNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new ComImposto(null, 10.0));
  }
}
