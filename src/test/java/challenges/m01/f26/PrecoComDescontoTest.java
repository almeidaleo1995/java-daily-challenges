package challenges.m01.f26;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class PrecoComDescontoTest {

  @Test
  void aplicaDescontoSimples() {
    assertEquals(
        new BigDecimal("90.00"),
        PrecoComDesconto.aplicarDesconto(new BigDecimal("100.00"), new BigDecimal("10")));
  }

  @Test
  void arredondamentoBancarioEmEmpateExatoVaiParaOParMaisProximo() {
    assertEquals(
        new BigDecimal("2.48"),
        PrecoComDesconto.aplicarDesconto(new BigDecimal("2.84"), new BigDecimal("12.5")));
  }

  @Test
  void semDescontoDevolveOMesmoPrecoComDuasCasas() {
    assertEquals(
        new BigDecimal("50.00"),
        PrecoComDesconto.aplicarDesconto(new BigDecimal("50"), BigDecimal.ZERO));
  }

  @Test
  void percentualExatamenteCemEValidoEDevolveZero() {
    assertEquals(
        new BigDecimal("0.00"),
        PrecoComDesconto.aplicarDesconto(new BigDecimal("100.00"), new BigDecimal("100")));
  }

  @Test
  void precoNegativoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PrecoComDesconto.aplicarDesconto(new BigDecimal("-1"), new BigDecimal("10")));
  }

  @Test
  void percentualAcimaDeCemLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PrecoComDesconto.aplicarDesconto(new BigDecimal("100"), new BigDecimal("150")));
  }
}
