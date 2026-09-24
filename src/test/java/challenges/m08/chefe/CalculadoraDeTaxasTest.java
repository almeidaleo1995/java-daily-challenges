package challenges.m08.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class CalculadoraDeTaxasTest {

  @Test
  void pixNaoTemTaxa() {
    assertEquals(
        0, new BigDecimal("0.00").compareTo(CalculadoraDeTaxas.taxa(new Pix(new BigDecimal("100.00")))));
  }

  @Test
  void cartaoCobraTresPorCentoPorParcela() {
    BigDecimal taxa = CalculadoraDeTaxas.taxa(new Cartao(new BigDecimal("100.00"), 3));
    assertEquals(0, new BigDecimal("9.00").compareTo(taxa));
  }

  @Test
  void boletoComMaisDeTrintaDiasCobraDoisPorCento() {
    BigDecimal taxa = CalculadoraDeTaxas.taxa(new Boleto(new BigDecimal("100.00"), 45));
    assertEquals(0, new BigDecimal("2.00").compareTo(taxa));
  }

  @Test
  void boletoComAteTrintaDiasCobraUmPorCento() {
    BigDecimal taxa = CalculadoraDeTaxas.taxa(new Boleto(new BigDecimal("100.00"), 10));
    assertEquals(0, new BigDecimal("1.00").compareTo(taxa));
  }

  @Test
  void taxaTotalSomaATaxaDeTodosOsPagamentos() {
    List<Pagamento> pagamentos =
        List.of(
            new Pix(new BigDecimal("50.00")),
            new Cartao(new BigDecimal("100.00"), 1),
            new Boleto(new BigDecimal("200.00"), 45));

    assertEquals(0, new BigDecimal("7.00").compareTo(CalculadoraDeTaxas.taxaTotal(pagamentos)));
  }

  @Test
  void pagamentoOuPagamentosNulosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> CalculadoraDeTaxas.taxa(null));
    assertThrows(IllegalArgumentException.class, () -> CalculadoraDeTaxas.taxaTotal(null));
  }
}
