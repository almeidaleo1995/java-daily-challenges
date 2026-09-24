package challenges.m12.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ContagemParaleloTest {

  @Test
  void contaOcorrenciasDivididoEntreThreads() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(5),
        () -> {
          Map<String, Integer> contagem =
              ContagemParalela.contarPalavras(List.of("a", "b", "a", "c", "b", "a"), 3);
          assertEquals(Map.of("a", 3, "b", 2, "c", 1), contagem);
        });
  }

  @Test
  void listaVaziaDevolveMapaVazio() throws InterruptedException {
    assertEquals(Map.of(), ContagemParalela.contarPalavras(List.of(), 2));
  }

  @Test
  void palavrasNulasLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ContagemParalela.contarPalavras(null, 2));
  }

  @Test
  void numeroDeThreadsInvalidoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> ContagemParalela.contarPalavras(List.of("a"), 0));
  }
}
