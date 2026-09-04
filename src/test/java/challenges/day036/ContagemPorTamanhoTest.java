package challenges.day036;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ContagemPorTamanhoTest {

  @Test
  void listaVazia() {
    assertEquals(Map.of(), ContagemPorTamanho.contarPorTamanho(List.of()));
  }

  @Test
  void variosTamanhos() {
    assertEquals(
        Map.of(1, 1, 2, 2, 3, 1),
        ContagemPorTamanho.contarPorTamanho(List.of("a", "bb", "cc", "ddd")));
  }

  @Test
  void tamanhosSemRepeticao() {
    assertEquals(Map.of(2, 1, 3, 1), ContagemPorTamanho.contarPorTamanho(List.of("oi", "ola")));
  }
}
