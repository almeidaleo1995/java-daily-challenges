package challenges.m02.f11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApenasUnicosTest {

  @Test
  void listaVazia() {
    assertEquals(List.of(), ApenasUnicos.apenasUnicos(List.of()));
  }

  @Test
  void misturaDeUnicosERepetidos() {
    assertEquals(List.of(1, 3, 5), ApenasUnicos.apenasUnicos(List.of(1, 2, 2, 3, 4, 4, 5)));
  }

  @Test
  void todosRepetidos() {
    assertEquals(List.of(), ApenasUnicos.apenasUnicos(List.of(1, 1, 1)));
  }

  @Test
  void umUnicoElemento() {
    assertEquals(List.of(5), ApenasUnicos.apenasUnicos(List.of(5)));
  }

  @Test
  void naoModificaAListaOriginal() {
    List<Integer> original = new ArrayList<>(List.of(1, 2, 2, 3));

    ApenasUnicos.apenasUnicos(original);

    assertEquals(List.of(1, 2, 2, 3), original);
  }
}
