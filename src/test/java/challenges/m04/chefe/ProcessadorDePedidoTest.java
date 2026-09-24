package challenges.m04.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ProcessadorDePedidoTest {

  @Test
  void pedidoValidoSubtraiDeTodosOsItens() {
    Map<String, Integer> estoque = new LinkedHashMap<>(Map.of("Arroz", 10, "Feijão", 5));

    ProcessadorDePedido.processar(
        estoque, List.of(new ItemPedido("Arroz", 3), new ItemPedido("Feijão", 2)));

    assertEquals(7, estoque.get("Arroz"));
    assertEquals(3, estoque.get("Feijão"));
  }

  @Test
  void umItemSemEstoqueSuficienteImpedeTodoOPedido() {
    Map<String, Integer> estoque = new LinkedHashMap<>(Map.of("Arroz", 10, "Feijão", 5));

    assertThrows(
        EstoqueInsuficienteException.class,
        () ->
            ProcessadorDePedido.processar(
                estoque, List.of(new ItemPedido("Arroz", 3), new ItemPedido("Feijão", 10))));

    assertEquals(10, estoque.get("Arroz"));
    assertEquals(5, estoque.get("Feijão"));
  }

  @Test
  void produtoInexistenteNoEstoqueLancaEstoqueInsuficienteException() {
    Map<String, Integer> estoque = new LinkedHashMap<>(Map.of("Arroz", 10));

    assertThrows(
        EstoqueInsuficienteException.class,
        () -> ProcessadorDePedido.processar(estoque, List.of(new ItemPedido("Feijão", 1))));

    assertEquals(10, estoque.get("Arroz"));
  }

  @Test
  void estoqueOuItensNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> ProcessadorDePedido.processar(null, List.of()));
    assertThrows(
        IllegalArgumentException.class,
        () -> ProcessadorDePedido.processar(new LinkedHashMap<>(), null));
  }
}
