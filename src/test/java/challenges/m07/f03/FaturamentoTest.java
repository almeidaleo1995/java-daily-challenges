package challenges.m07.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class FaturamentoTest {

  @Test
  void somaOValorDeCadaCategoria() {
    List<Venda> vendas =
        List.of(
            new Venda("Bebidas", new BigDecimal("10")),
            new Venda("Bebidas", new BigDecimal("5")),
            new Venda("Comida", new BigDecimal("20")));

    Map<String, BigDecimal> resultado = Faturamento.faturamentoPorCategoria(vendas);

    assertEquals(0, new BigDecimal("15").compareTo(resultado.get("Bebidas")));
    assertEquals(0, new BigDecimal("20").compareTo(resultado.get("Comida")));
  }

  @Test
  void listaVaziaDevolveMapaVazio() {
    assertTrue(Faturamento.faturamentoPorCategoria(List.of()).isEmpty());
  }

  @Test
  void categoriaUnicaSomaTodasAsVendas() {
    List<Venda> vendas =
        List.of(
            new Venda("Bebidas", new BigDecimal("1")), new Venda("Bebidas", new BigDecimal("2")));

    assertEquals(
        0,
        new BigDecimal("3").compareTo(Faturamento.faturamentoPorCategoria(vendas).get("Bebidas")));
  }

  @Test
  void vendasNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Faturamento.faturamentoPorCategoria(null));
  }
}
