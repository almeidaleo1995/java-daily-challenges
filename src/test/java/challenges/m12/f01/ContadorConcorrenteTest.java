package challenges.m12.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class ContadorConcorrenteTest {

  @Test
  void dezThreadsMilIncrementosCadaSomaExata() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(5),
        () -> {
          int total = ContadorConcorrente.incrementarConcorrentemente(10, 1000);
          assertEquals(10_000, total);
        });
  }

  @Test
  void numeroDeThreadsInvalidoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ContadorConcorrente.incrementarConcorrentemente(0, 10));
  }

  @Test
  void incrementosPorThreadNegativoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ContadorConcorrente.incrementarConcorrentemente(4, -1));
  }
}
