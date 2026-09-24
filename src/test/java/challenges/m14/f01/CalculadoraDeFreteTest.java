package challenges.m14.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculadoraDeFreteTest {

  @Test
  void freteRodoviarioCalculaPeloPesoEDistancia() {
    assertEquals(15.0, new FreteRodoviario().calcular(10.0, 100.0), 0.0001);
  }

  @Test
  void freteAereoCalculaPeloPesoEDistancia() {
    assertEquals(50.0, new FreteAereo().calcular(10.0, 100.0), 0.0001);
  }

  @Test
  void pesoOuDistanciaNegativosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new FreteRodoviario().calcular(-1.0, 10.0));
    assertThrows(IllegalArgumentException.class, () -> new FreteRodoviario().calcular(1.0, -10.0));
  }

  @Test
  void calculadoraDelegaParaAEstrategiaEscolhida() {
    CalculadoraDeFrete calculadora = new CalculadoraDeFrete(new FreteAereo());
    assertEquals(50.0, calculadora.calcularFrete(10.0, 100.0), 0.0001);
  }

  @Test
  void trocarDeEstrategiaTrocaOResultadoSemMudarACalculadora() {
    CalculadoraDeFrete calculadora = new CalculadoraDeFrete(new FreteRodoviario());
    assertEquals(15.0, calculadora.calcularFrete(10.0, 100.0), 0.0001);
  }

  @Test
  void estrategiaNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new CalculadoraDeFrete(null));
  }
}
