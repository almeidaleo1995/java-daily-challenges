package challenges.day017;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class PalavraMenosFrequenteTest {

  @Test
  void encontraAPalavraMenosFrequente() {
    assertEquals("c", PalavraMenosFrequente.menosFrequente(List.of("a", "b", "a", "c", "b", "a")));
  }

  @Test
  void empateDevolveAPrimeiraQueApareceu() {
    assertEquals("x", PalavraMenosFrequente.menosFrequente(List.of("x", "y")));
  }

  @Test
  void umaUnicaPalavra() {
    assertEquals("z", PalavraMenosFrequente.menosFrequente(List.of("z")));
  }

  @Test
  void listaVaziaLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class, () -> PalavraMenosFrequente.menosFrequente(List.of()));
  }
}
