package challenges.m14.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EstoqueObservavelTest {

  @Test
  void notificaTodosOsOuvintesQuandoEstoqueFicaNoLimiteOuAbaixo() {
    EstoqueObservavel estoque = new EstoqueObservavel(5);
    List<String> chamadas1 = new ArrayList<>();
    List<String> chamadas2 = new ArrayList<>();
    estoque.registrarOuvinte((produto, quantidade) -> chamadas1.add(produto + ":" + quantidade));
    estoque.registrarOuvinte((produto, quantidade) -> chamadas2.add(produto + ":" + quantidade));

    estoque.atualizarEstoque("Arroz", 5);

    assertEquals(List.of("Arroz:5"), chamadas1);
    assertEquals(List.of("Arroz:5"), chamadas2);
  }

  @Test
  void naoNotificaQuandoEstoqueEstaAcimaDoLimite() {
    EstoqueObservavel estoque = new EstoqueObservavel(5);
    List<String> chamadas = new ArrayList<>();
    estoque.registrarOuvinte((produto, quantidade) -> chamadas.add(produto));

    estoque.atualizarEstoque("Arroz", 6);

    assertTrue(chamadas.isEmpty());
  }

  @Test
  void limiteBaixoNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new EstoqueObservavel(-1));
  }

  @Test
  void ouvinteNuloLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> new EstoqueObservavel(5).registrarOuvinte(null));
  }
}
