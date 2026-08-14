package challenges.day006;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SemRepetidosTest {

  @Test
  void listaVazia() {
    assertEquals(List.of(), SemRepetidos.semRepetidos(List.of()));
  }

  @Test
  void semDuplicados() {
    assertEquals(List.of(1, 2, 3), SemRepetidos.semRepetidos(List.of(1, 2, 3)));
  }

  @Test
  void removeDuplicadosMantendoPrimeiraAparicao() {
    assertEquals(List.of(1, 2, 3), SemRepetidos.semRepetidos(List.of(1, 2, 2, 3, 1)));
  }

  @Test
  void todosIguais() {
    assertEquals(List.of(5), SemRepetidos.semRepetidos(List.of(5, 5, 5)));
  }

  @Test
  void aceitaNegativos() {
    assertEquals(List.of(-1, 2, 0), SemRepetidos.semRepetidos(List.of(-1, 2, -1, 0)));
  }

  @Test
  void naoModificaAListaOriginal() {
    List<Integer> original = new ArrayList<>(List.of(1, 2, 2, 3));

    SemRepetidos.semRepetidos(original);

    assertEquals(List.of(1, 2, 2, 3), original);
  }
}
