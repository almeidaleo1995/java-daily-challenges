package challenges.m02.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ContadorFrequenciaTest {

  @Test
  void listaVazia() {
    assertEquals(Map.of(), ContadorFrequencia.contarFrequencia(List.of()));
  }

  @Test
  void semRepetidos() {
    assertEquals(Map.of(1, 1, 2, 1, 3, 1), ContadorFrequencia.contarFrequencia(List.of(1, 2, 3)));
  }

  @Test
  void contaRepeticoes() {
    assertEquals(
        Map.of(1, 3, 2, 2, 3, 1), ContadorFrequencia.contarFrequencia(List.of(1, 2, 2, 3, 1, 1)));
  }

  @Test
  void todosIguais() {
    assertEquals(Map.of(5, 3), ContadorFrequencia.contarFrequencia(List.of(5, 5, 5)));
  }

  @Test
  void aceitaNegativos() {
    assertEquals(
        Map.of(-1, 2, 2, 1, 0, 1), ContadorFrequencia.contarFrequencia(List.of(-1, 2, -1, 0)));
  }

  @Test
  void naoModificaAListaOriginal() {
    List<Integer> original = new ArrayList<>(List.of(1, 2, 2, 3));

    ContadorFrequencia.contarFrequencia(original);

    assertEquals(List.of(1, 2, 2, 3), original);
  }
}
