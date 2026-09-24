package challenges.m05.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class MaiorTest {

  @Test
  void encontraOMaiorEmUmaListaDeInteiros() {
    assertEquals(7, Maior.encontrar(List.of(3, 7, 2)));
  }

  @Test
  void encontraOMaiorEmUmaListaDeStrings() {
    assertEquals("c", Maior.encontrar(List.of("b", "a", "c")));
  }

  @Test
  void listaComUmUnicoElemento() {
    assertEquals(5, Maior.encontrar(List.of(5)));
  }

  @Test
  void listaVaziaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Maior.encontrar(List.<Integer>of()));
  }

  @Test
  void listaNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Maior.encontrar(null));
  }
}
