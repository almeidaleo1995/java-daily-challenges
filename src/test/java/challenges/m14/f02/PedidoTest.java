package challenges.m14.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class PedidoTest {

  @Test
  void montaPedidoComClienteEItens() {
    Pedido pedido =
        Pedido.builder()
            .cliente("Ana")
            .adicionarItem("Arroz", 20.0)
            .adicionarItem("Feijão", 8.5)
            .build();

    assertEquals("Ana", pedido.cliente());
    assertEquals(List.of("Arroz", "Feijão"), pedido.itens());
    assertEquals(28.5, pedido.valorTotal(), 0.0001);
  }

  @Test
  void buildSemClienteLancaIllegalStateException() {
    assertThrows(
        IllegalStateException.class,
        () -> Pedido.builder().adicionarItem("Arroz", 20.0).build());
  }

  @Test
  void buildSemItensLancaIllegalStateException() {
    assertThrows(IllegalStateException.class, () -> Pedido.builder().cliente("Ana").build());
  }

  @Test
  void adicionarItemComValorNaoPositivoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Pedido.builder().cliente("Ana").adicionarItem("Arroz", 0.0));
  }
}
