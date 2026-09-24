package challenges.m01.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class CupomFiscalTest {

  @Test
  void geraRecibocomDoisItensETotalCorreto() {
    String recibo = CupomFiscal.gerar(List.of("Caneta;2;3.50;A", "Caderno;1;20.00;B"));
    assertTrue(recibo.contains("R$     7.00"));
    assertTrue(recibo.contains("R$    19.00"));
    assertTrue(recibo.endsWith("TOTAL: R$ 26.00"));
  }

  @Test
  void tipoASemDesconto() {
    String recibo = CupomFiscal.gerar(List.of("Item;1;10.00;A"));
    assertEquals("Item           x1   R$    10.00\nTOTAL: R$ 10.00", recibo);
  }

  @Test
  void tipoCComDezPorCentoDeDesconto() {
    String recibo = CupomFiscal.gerar(List.of("Item;1;10.00;C"));
    assertEquals("Item           x1   R$     9.00\nTOTAL: R$ 9.00", recibo);
  }

  @Test
  void listaNulaOuVaziaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> CupomFiscal.gerar(null));
    assertThrows(IllegalArgumentException.class, () -> CupomFiscal.gerar(List.of()));
  }

  @Test
  void linhaComNumeroDeCamposErradoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> CupomFiscal.gerar(List.of("Caneta;2;3.50")));
  }

  @Test
  void quantidadeZeroLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> CupomFiscal.gerar(List.of("Caneta;0;3.50;A")));
  }

  @Test
  void tipoInvalidoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> CupomFiscal.gerar(List.of("Caneta;1;3.50;Z")));
  }

  @Test
  void precoNegativoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> CupomFiscal.gerar(List.of("Caneta;1;-3.50;A")));
  }
}
