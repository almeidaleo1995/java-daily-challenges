package challenges.day031;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValoresComunsTest {

  @Test
  void interseccaoSimples() {
    assertEquals(List.of(3, 4), ValoresComuns.comuns(List.of(1, 2, 3, 4), List.of(3, 4, 5)));
  }

  @Test
  void naoRepeteValorDuplicadoEmA() {
    assertEquals(List.of(1), ValoresComuns.comuns(List.of(1, 1, 2), List.of(1, 3)));
  }

  @Test
  void primeiraListaVazia() {
    assertEquals(List.of(), ValoresComuns.comuns(List.of(), List.of(1, 2)));
  }

  @Test
  void segundaListaVazia() {
    assertEquals(List.of(), ValoresComuns.comuns(List.of(1, 2), List.of()));
  }

  @Test
  void naoModificaAsListasOriginais() {
    List<Integer> a = new ArrayList<>(List.of(1, 2, 3));
    List<Integer> b = new ArrayList<>(List.of(2, 3, 4));

    ValoresComuns.comuns(a, b);

    assertEquals(List.of(1, 2, 3), a);
    assertEquals(List.of(2, 3, 4), b);
  }
}
