package challenges.m07.f06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EstatisticasTest {

  @Test
  void resumeMinimoMaximoMediaEQuantidade() {
    assertEquals("min=1 max=4 media=2.50 count=4", Estatisticas.resumo(new int[] {1, 2, 3, 4}));
  }

  @Test
  void arrayComUmValorTemMediaIgualAoValor() {
    assertEquals("min=5 max=5 media=5.00 count=1", Estatisticas.resumo(new int[] {5}));
  }

  @Test
  void mediaComDizimaEFormatadaComDuasCasas() {
    assertEquals("min=1 max=2 media=1.67 count=3", Estatisticas.resumo(new int[] {1, 2, 2}));
  }

  @Test
  void valoresNuloOuVazioLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Estatisticas.resumo(null));
    assertThrows(IllegalArgumentException.class, () -> Estatisticas.resumo(new int[] {}));
  }
}
