package challenges.m12.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProcessadorParaleloTest {

  @Test
  void elevaCadaValorAoQuadradoMantendoAOrdem() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(5),
        () -> {
          List<Integer> resultado =
              ProcessadorParalelo.processarEmParalelo(List.of(1, 2, 3, 4, 5), 3);
          assertEquals(List.of(1, 4, 9, 16, 25), resultado);
        });
  }

  @Test
  void listaVaziaDevolveListaVazia() throws Exception {
    assertEquals(List.of(), ProcessadorParalelo.processarEmParalelo(List.of(), 2));
  }

  @Test
  void valoresNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> ProcessadorParalelo.processarEmParalelo(null, 2));
  }

  @Test
  void numeroDeThreadsInvalidoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ProcessadorParalelo.processarEmParalelo(List.of(1, 2), 0));
  }
}
