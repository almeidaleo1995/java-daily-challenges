package challenges.m02.f14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SomaPorCategoriaTest {

  @Test
  void listasVazias() {
    assertEquals(Map.of(), SomaPorCategoria.somarPorCategoria(List.of(), List.of()));
  }

  @Test
  void somaValoresDaMesmaCategoria() {
    assertEquals(
        Map.of("A", 13, "B", 5),
        SomaPorCategoria.somarPorCategoria(List.of("A", "B", "A"), List.of(10, 5, 3)));
  }

  @Test
  void umaUnicaCategoria() {
    assertEquals(Map.of("X", 7), SomaPorCategoria.somarPorCategoria(List.of("X"), List.of(7)));
  }
}
