package challenges.m05.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CopiadorTest {

  @Test
  void copiaDeListaDeIntegerParaListaDeObject() {
    List<Integer> origem = List.of(1, 2, 3);
    List<Object> destino = new ArrayList<>();

    Copiador.copiar(origem, destino);

    assertEquals(List.of(1, 2, 3), destino);
  }

  @Test
  void copiaDeListaDeDoubleParaListaDeNumber() {
    List<Double> origem = List.of(1.5, 2.5);
    List<Number> destino = new ArrayList<>();

    Copiador.copiar(origem, destino);

    assertEquals(List.of(1.5, 2.5), destino);
  }

  @Test
  void adicionaAoFinalDoDestinoExistente() {
    List<Integer> origem = List.of(2);
    List<Number> destino = new ArrayList<>(List.of(1));

    Copiador.copiar(origem, destino);

    assertEquals(List.of(1, 2), destino);
  }

  @Test
  void origemOuDestinoNulosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Copiador.copiar(null, new ArrayList<>()));
    assertThrows(IllegalArgumentException.class, () -> Copiador.copiar(List.of(1), null));
  }
}
