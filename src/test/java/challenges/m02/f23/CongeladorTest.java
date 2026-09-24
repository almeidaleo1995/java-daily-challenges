package challenges.m02.f23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CongeladorTest {

  @Test
  void devolveListaComMesmosElementosNaMesmaOrdem() {
    List<Integer> congelada = Congelador.congelar(new ArrayList<>(List.of(1, 2, 3)));
    assertEquals(List.of(1, 2, 3), congelada);
  }

  @Test
  void alterarOriginalDepoisNaoAfetaAListaCongelada() {
    ArrayList<Integer> original = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> congelada = Congelador.congelar(original);

    original.add(4);

    assertEquals(List.of(1, 2, 3), congelada);
  }

  @Test
  void tentarAlterarAListaCongeladaLancaUnsupportedOperationException() {
    List<Integer> congelada = Congelador.congelar(new ArrayList<>(List.of(1, 2)));
    assertThrows(UnsupportedOperationException.class, () -> congelada.add(3));
  }

  @Test
  void listaOriginalNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Congelador.congelar(null));
  }
}
