package challenges.m04.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CaixaEletronicoTest {

  @Test
  void saqueValidoReduzOSaldo() throws SaldoInsuficienteException {
    CaixaEletronico caixa = new CaixaEletronico(100);
    caixa.sacar(30);
    assertEquals(70, caixa.getSaldo(), 0.0001);
  }

  @Test
  void saqueMaiorQueOSaldoLancaSaldoInsuficienteExceptionESaldoNaoMuda() {
    CaixaEletronico caixa = new CaixaEletronico(70);
    assertThrows(SaldoInsuficienteException.class, () -> caixa.sacar(100));
    assertEquals(70, caixa.getSaldo(), 0.0001);
  }

  @Test
  void valorNaoPositivoLancaIllegalArgumentExceptionESaldoNaoMuda() {
    CaixaEletronico caixa = new CaixaEletronico(70);
    assertThrows(IllegalArgumentException.class, () -> caixa.sacar(-5));
    assertEquals(70, caixa.getSaldo(), 0.0001);
  }

  @Test
  void saldoInicialNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new CaixaEletronico(-10));
  }
}
