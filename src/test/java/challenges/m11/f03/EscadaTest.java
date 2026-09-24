package challenges.m11.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class EscadaTest {

  @Test
  void semDegrauEUmaFormaDeJaEstarNoTopo() {
    assertEquals(1L, Escada.formasDeSubir(0));
  }

  @Test
  void umDegrauEUmaForma() {
    assertEquals(1L, Escada.formasDeSubir(1));
  }

  @Test
  void doisDegrausEDuasFormas() {
    assertEquals(2L, Escada.formasDeSubir(2));
  }

  @Test
  void cincoDegraus() {
    assertEquals(8L, Escada.formasDeSubir(5));
  }

  @Test
  void quarentaDegrausDentroDoTimeoutExigeMemoizacao() {
    assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
      assertEquals(165580141L, Escada.formasDeSubir(40));
    });
  }

  @Test
  void degrausNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Escada.formasDeSubir(-1));
  }
}
