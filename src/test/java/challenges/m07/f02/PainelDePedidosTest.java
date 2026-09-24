package challenges.m07.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class PainelDePedidosTest {

  @Test
  void contaQuantosPedidosExistemEmCadaStatus() {
    List<Pedido> pedidos =
        List.of(
            new Pedido("1", "ABERTO"), new Pedido("2", "ABERTO"), new Pedido("3", "FECHADO"));

    assertEquals(Map.of("ABERTO", 2L, "FECHADO", 1L), PainelDePedidos.contarPorStatus(pedidos));
  }

  @Test
  void listaVaziaDevolveMapaVazio() {
    assertTrue(PainelDePedidos.contarPorStatus(List.of()).isEmpty());
  }

  @Test
  void statusUnicoContaTodosOsPedidos() {
    List<Pedido> pedidos = List.of(new Pedido("1", "ABERTO"), new Pedido("2", "ABERTO"));
    assertEquals(Map.of("ABERTO", 2L), PainelDePedidos.contarPorStatus(pedidos));
  }

  @Test
  void pedidosNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> PainelDePedidos.contarPorStatus(null));
  }
}
