package challenges.m02.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class MaisFrequenteTest {

  @Test
  void umUnicoElemento() {
    assertEquals(7, MaisFrequente.maisFrequente(List.of(7)));
  }

  @Test
  void repeticaoClara() {
    assertEquals(1, MaisFrequente.maisFrequente(List.of(1, 2, 2, 3, 1, 1)));
  }

  @Test
  void todosIguais() {
    assertEquals(5, MaisFrequente.maisFrequente(List.of(5, 5, 5)));
  }

  @Test
  void empateTotalDevolvePrimeiro() {
    assertEquals(1, MaisFrequente.maisFrequente(List.of(1, 2, 3)));
  }

  @Test
  void empateParcialDevolvePrimeiro() {
    assertEquals(2, MaisFrequente.maisFrequente(List.of(2, 1, 1, 2)));
  }

  @Test
  void aceitaNegativos() {
    assertEquals(-1, MaisFrequente.maisFrequente(List.of(-1, 2, -1, 0)));
  }

  @Test
  void listaVaziaLancaExcecao() {
    assertThrows(IllegalArgumentException.class, () -> MaisFrequente.maisFrequente(List.of()));
  }
}
