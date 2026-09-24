package challenges.m12.f07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class TarefasVirtuaisTest {

  @Test
  void milTarefasLevesTodasExecutam() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(5),
        () -> {
          int total = TarefasVirtuais.executarTarefasVirtuais(1000);
          assertEquals(1000, total);
        });
  }

  @Test
  void numeroDeTarefasInvalidoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> TarefasVirtuais.executarTarefasVirtuais(0));
  }

  @Test
  void numeroDeTarefasNegativoTambemLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> TarefasVirtuais.executarTarefasVirtuais(-1));
  }

  @Test
  void umaUnicaTarefaDevolveUm() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(5),
        () -> {
          int total = TarefasVirtuais.executarTarefasVirtuais(1);
          assertEquals(1, total);
        });
  }
}
