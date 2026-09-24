package challenges.m12.f06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;

class LargadaTest {

  @Test
  void todosOsCorredoresLargamESaoContados() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(5),
        () -> {
          List<Integer> chegada = Largada.largadaSimultanea(5);
          assertEquals(5, chegada.size());
          for (int corredor = 0; corredor < 5; corredor++) {
            assertTrue(chegada.contains(corredor), "corredor " + corredor + " não largou");
          }
        });
  }

  @Test
  void numeroDeCorredoresInvalidoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Largada.largadaSimultanea(0));
  }
}
