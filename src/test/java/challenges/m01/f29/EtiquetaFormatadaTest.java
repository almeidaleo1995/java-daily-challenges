package challenges.m01.f29;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class EtiquetaFormatadaTest {

  @Test
  void formataNomeCurtoEPrecoComDuasCasas() {
    assertEquals(
        "Caneta               R$     3.50",
        EtiquetaFormatada.etiqueta("Caneta", new BigDecimal("3.5")));
  }

  @Test
  void nomeMaiorQue20ColunasNaoEhTruncado() {
    assertEquals(
        "Caderno Universitário R$   125.00",
        EtiquetaFormatada.etiqueta("Caderno Universitário", new BigDecimal("125")));
  }

  @Test
  void nomeNuloOuEmBrancoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> EtiquetaFormatada.etiqueta(null, BigDecimal.TEN));
    assertThrows(
        IllegalArgumentException.class, () -> EtiquetaFormatada.etiqueta("  ", BigDecimal.TEN));
  }

  @Test
  void linhaSeparadoraRepeteOTraco() {
    assertEquals("----------", EtiquetaFormatada.linhaSeparadora(10));
  }

  @Test
  void larguraNaoPositivaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> EtiquetaFormatada.linhaSeparadora(0));
  }
}
