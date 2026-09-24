package challenges.m03.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PedagioTest {

  @Test
  void carroUsaValorPadraoDaInterface() {
    assertEquals(2, new Carro().eixos());
    assertEquals(10.0, new Carro().valorPedagio(), 0.0001);
  }

  @Test
  void motoEIsentaMesmoTendoDoisEixos() {
    assertEquals(2, new Moto().eixos());
    assertEquals(0.0, new Moto().valorPedagio(), 0.0001);
  }

  @Test
  void caminhaoSomaEixosExtrasEUsaValorPadrao() {
    Caminhao caminhao = new Caminhao(1);
    assertEquals(3, caminhao.eixos());
    assertEquals(15.0, caminhao.valorPedagio(), 0.0001);
  }

  @Test
  void eixosExtrasNegativosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Caminhao(-1));
  }
}
