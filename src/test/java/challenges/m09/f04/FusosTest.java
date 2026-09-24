package challenges.m09.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

class FusosTest {

  @Test
  void convertePreservandoOInstante() {
    ZonedDateTime referencia =
        ZonedDateTime.of(2024, 5, 15, 10, 0, 0, 0, ZoneId.of("America/Sao_Paulo"));

    assertEquals("15/05/2024 14:00", Fusos.horarioEm(referencia, "Europe/London"));
  }

  @Test
  void mesmoFusoDevolveOMesmoHorario() {
    ZonedDateTime referencia =
        ZonedDateTime.of(2024, 5, 15, 10, 0, 0, 0, ZoneId.of("America/Sao_Paulo"));

    assertEquals("15/05/2024 10:00", Fusos.horarioEm(referencia, "America/Sao_Paulo"));
  }

  @Test
  void argumentosNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> Fusos.horarioEm(null, "Europe/London"));
    assertThrows(
        IllegalArgumentException.class,
        () -> Fusos.horarioEm(ZonedDateTime.now(), null));
  }

  @Test
  void zonaInvalidaLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Fusos.horarioEm(ZonedDateTime.now(), "Nao/Existe"));
  }
}
