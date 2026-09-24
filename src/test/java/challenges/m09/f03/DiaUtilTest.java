package challenges.m09.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DiaUtilTest {

  @Test
  void pulaFinalDeSemana() {
    assertEquals(
        LocalDate.of(2024, 5, 20), DiaUtil.proximoDiaUtil(LocalDate.of(2024, 5, 17), Set.of()));
  }

  @Test
  void pulaFeriadoEFinalDeSemanaJuntos() {
    assertEquals(
        LocalDate.of(2024, 5, 20),
        DiaUtil.proximoDiaUtil(
            LocalDate.of(2024, 5, 16), Set.of(LocalDate.of(2024, 5, 17))));
  }

  @Test
  void diaSeguinteUtilSemObstaculos() {
    assertEquals(
        LocalDate.of(2024, 5, 14), DiaUtil.proximoDiaUtil(LocalDate.of(2024, 5, 13), Set.of()));
  }

  @Test
  void dataOuFeriadosNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> DiaUtil.proximoDiaUtil(null, Set.of()));
    assertThrows(
        IllegalArgumentException.class, () -> DiaUtil.proximoDiaUtil(LocalDate.now(), null));
  }
}
