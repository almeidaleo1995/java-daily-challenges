package challenges.m03.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OperacaoTest {

  @Test
  void cadaConstanteAplicaSuaPropriaConta() {
    assertEquals(5.0, Operacao.SOMA.aplicar(2, 3), 0.0001);
    assertEquals(-1.0, Operacao.SUBTRACAO.aplicar(2, 3), 0.0001);
    assertEquals(6.0, Operacao.MULTIPLICACAO.aplicar(2, 3), 0.0001);
    assertEquals(2.0, Operacao.DIVISAO.aplicar(6, 3), 0.0001);
  }

  @Test
  void divisaoPorZeroLancaArithmeticException() {
    assertThrows(ArithmeticException.class, () -> Operacao.DIVISAO.aplicar(1, 0));
  }

  @Test
  void porSimboloEncontraAOperacaoCorreta() {
    assertEquals(Operacao.MULTIPLICACAO, Operacao.porSimbolo("*"));
    assertEquals(Operacao.SOMA, Operacao.porSimbolo("+"));
  }

  @Test
  void simboloInvalidoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Operacao.porSimbolo("%"));
  }
}
