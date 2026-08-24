package challenges.day015;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ElementosRepetidosTest {

  @Test
  void devolveNaOrdemDaSegundaAparicao() {
    assertEquals(List.of(2, 1), ElementosRepetidos.repetidos(List.of(1, 2, 3, 2, 1, 4)));
  }

  @Test
  void semRepeticoesDevolveListaVazia() {
    assertEquals(List.of(), ElementosRepetidos.repetidos(List.of(1, 2, 3)));
  }

  @Test
  void listaVazia() {
    assertEquals(List.of(), ElementosRepetidos.repetidos(List.of()));
  }

  @Test
  void valorRepetidoTresVezesEntraUmaSoVez() {
    assertEquals(List.of(5), ElementosRepetidos.repetidos(List.of(5, 5, 5)));
  }

  @Test
  void doisValoresRepetidos() {
    assertEquals(List.of(1, 2), ElementosRepetidos.repetidos(List.of(1, 1, 2, 2)));
  }

  @Test
  void naoModificaAListaRecebida() {
    List<Integer> entrada = new ArrayList<>(List.of(1, 2, 2, 3));
    ElementosRepetidos.repetidos(entrada);
    assertEquals(List.of(1, 2, 2, 3), entrada);
  }
}
