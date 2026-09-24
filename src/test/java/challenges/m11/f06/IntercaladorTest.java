package challenges.m11.f06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class IntercaladorTest {

  @Test
  void intercalaDuasListasEntrelacadas() {
    assertEquals(
        List.of(1, 2, 3, 4, 5, 6), Intercalador.intercalar(List.of(1, 3, 5), List.of(2, 4, 6)));
  }

  @Test
  void umaListaVaziaDevolveAOutra() {
    assertEquals(List.of(1, 2, 3), Intercalador.intercalar(List.of(), List.of(1, 2, 3)));
  }

  @Test
  void mantemDuplicados() {
    assertEquals(List.of(1, 1, 2, 3), Intercalador.intercalar(List.of(1, 3), List.of(1, 2)));
  }

  @Test
  void duasListasVaziasDevolveListaVazia() {
    assertEquals(List.of(), Intercalador.intercalar(List.of(), List.of()));
  }

  @Test
  void listaNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Intercalador.intercalar(null, List.of(1)));
    assertThrows(IllegalArgumentException.class, () -> Intercalador.intercalar(List.of(1), null));
  }
}
