package challenges.m12.f08;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class LimitadorDeChamadasTest {

  @Test
  void picoDeChamadasSimultaneasNuncaPassaDoLimite() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          LimitadorDeChamadas limitador = new LimitadorDeChamadas(3);
          int pico = limitador.chamadasSimultaneasMaximasObservadas(20);
          assertTrue(pico >= 1 && pico <= 3, "pico observado foi " + pico);
        });
  }

  @Test
  void maximoSimultaneoNaoPositivoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new LimitadorDeChamadas(0));
  }
}
