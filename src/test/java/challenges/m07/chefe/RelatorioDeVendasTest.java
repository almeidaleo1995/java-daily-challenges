package challenges.m07.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class RelatorioDeVendasTest {

  private final List<LinhaDeVenda> vendas =
      List.of(
          new LinhaDeVenda("Arroz", "Alimentos", new BigDecimal("30")),
          new LinhaDeVenda("Feijão", "Alimentos", new BigDecimal("20")),
          new LinhaDeVenda("Arroz", "Alimentos", new BigDecimal("10")),
          new LinhaDeVenda("Sabão", "Limpeza", new BigDecimal("50")));

  @Test
  void top3ProdutosOrdenaPorFaturamentoDecrescente() {
    assertEquals(List.of("Sabão", "Arroz", "Feijão"), RelatorioDeVendas.top3Produtos(vendas));
  }

  @Test
  void top3ProdutosDevolveTodosSeHouverMenosDeTres() {
    List<LinhaDeVenda> duasVendas =
        List.of(
            new LinhaDeVenda("Arroz", "Alimentos", new BigDecimal("10")),
            new LinhaDeVenda("Sabão", "Limpeza", new BigDecimal("5")));
    assertEquals(List.of("Arroz", "Sabão"), RelatorioDeVendas.top3Produtos(duasVendas));
  }

  @Test
  void faturamentoPorCategoriaSomaTodasAsLinhasDaCategoria() {
    var resultado = RelatorioDeVendas.faturamentoPorCategoria(vendas);
    assertEquals(0, new BigDecimal("60").compareTo(resultado.get("Alimentos")));
    assertEquals(0, new BigDecimal("50").compareTo(resultado.get("Limpeza")));
  }

  @Test
  void ticketMedioEAMediaPorLinhaDeVenda() {
    assertEquals(0, new BigDecimal("27.50").compareTo(RelatorioDeVendas.ticketMedio(vendas)));
  }

  @Test
  void ticketMedioDeListaVaziaEZeroComEscalaDois() {
    assertEquals(0, BigDecimal.ZERO.compareTo(RelatorioDeVendas.ticketMedio(List.of())));
  }

  @Test
  void produtoMaisVendidoEOComMaiorFaturamentoTotal() {
    assertEquals(Optional.of("Sabão"), RelatorioDeVendas.produtoMaisVendido(vendas));
  }

  @Test
  void produtoMaisVendidoDeListaVaziaEOptionalVazio() {
    assertTrue(RelatorioDeVendas.produtoMaisVendido(List.of()).isEmpty());
  }

  @Test
  void vendasNulaLancaIllegalArgumentExceptionEmTodosOsMetodos() {
    assertThrows(IllegalArgumentException.class, () -> RelatorioDeVendas.top3Produtos(null));
    assertThrows(
        IllegalArgumentException.class, () -> RelatorioDeVendas.faturamentoPorCategoria(null));
    assertThrows(IllegalArgumentException.class, () -> RelatorioDeVendas.ticketMedio(null));
    assertThrows(
        IllegalArgumentException.class, () -> RelatorioDeVendas.produtoMaisVendido(null));
  }
}
