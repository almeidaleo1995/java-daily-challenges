package challenges.m15.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AuditoriaTest {

  @Test
  void apuraSaldoPorProdutoTotalVendidoEInconsistencias() {
    List<EventoDeEstoque> eventos =
        List.of(
            new Venda("Arroz", 5, new BigDecimal("10.00")),
            new Devolucao("Arroz", 2),
            new Ajuste("Arroz", -1),
            new Venda("Feijão", 100, new BigDecimal("5.00")),
            new Ajuste("Trigo", 50));

    RelatorioDeAuditoria relatorio = Auditoria.apurar(eventos);

    assertEquals(Map.of("Arroz", -4, "Feijão", -100, "Trigo", 50), relatorio.saldoPorProduto());
    assertEquals(0, new BigDecimal("550.00").compareTo(relatorio.totalVendido()));
    assertEquals(List.of("Arroz: -4", "Feijão: -100"), relatorio.inconsistencias());
  }

  @Test
  void semInconsistenciasDevolveListaVazia() {
    RelatorioDeAuditoria relatorio =
        Auditoria.apurar(
            List.of(new Ajuste("Arroz", 10), new Venda("Arroz", 5, new BigDecimal("2.00"))));

    assertEquals(Map.of("Arroz", 5), relatorio.saldoPorProduto());
    assertEquals(List.of(), relatorio.inconsistencias());
  }

  @Test
  void vendaComQuantidadeNaoPositivaLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Auditoria.apurar(List.of(new Venda("Arroz", 0, new BigDecimal("1.00")))));
  }

  @Test
  void vendaComValorUnitarioInvalidoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Auditoria.apurar(List.of(new Venda("Arroz", 1, new BigDecimal("-1.00")))));
    assertThrows(
        IllegalArgumentException.class,
        () -> Auditoria.apurar(List.of(new Venda("Arroz", 1, null))));
  }

  @Test
  void devolucaoComQuantidadeNaoPositivaLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> Auditoria.apurar(List.of(new Devolucao("Arroz", 0))));
  }

  @Test
  void eventosNulosOuVaziosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Auditoria.apurar(null));
    assertThrows(IllegalArgumentException.class, () -> Auditoria.apurar(List.of()));
  }
}
