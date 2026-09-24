package challenges.m15.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class AgendadorTest {

  private static final Clock RELOGIO_FIXO =
      Clock.fixed(Instant.parse("2024-01-10T12:00:00Z"), ZoneId.of("UTC"));

  @Test
  void proximoEventoDevolveOMaisCedoSemRemoverDaFila() {
    Agendador agendador = new Agendador(RELOGIO_FIXO);
    agendador.agendar("Reunião", LocalDateTime.of(2024, 1, 15, 10, 0));
    agendador.agendar("Dentista", LocalDateTime.of(2024, 1, 12, 9, 0));

    assertEquals(Optional.of(new Evento("Dentista", LocalDateTime.of(2024, 1, 12, 9, 0))), agendador.proximoEvento());
    assertEquals(Optional.of(new Evento("Dentista", LocalDateTime.of(2024, 1, 12, 9, 0))), agendador.proximoEvento());
  }

  @Test
  void semEventosProximoEventoDevolveOptionalVazio() {
    assertEquals(Optional.empty(), new Agendador(RELOGIO_FIXO).proximoEvento());
  }

  @Test
  void eventosVencidosDevolveEOsRemoveOrdenadosPeloHorario() {
    Agendador agendador = new Agendador(RELOGIO_FIXO);
    agendador.agendar("Passado 1", LocalDateTime.of(2024, 1, 5, 8, 0));
    agendador.agendar("Futuro", LocalDateTime.of(2024, 2, 1, 8, 0));
    agendador.agendar("Passado 2", LocalDateTime.of(2024, 1, 8, 8, 0));

    List<Evento> vencidos = agendador.eventosVencidos();

    assertEquals(
        List.of(
            new Evento("Passado 1", LocalDateTime.of(2024, 1, 5, 8, 0)),
            new Evento("Passado 2", LocalDateTime.of(2024, 1, 8, 8, 0))),
        vencidos);
    assertTrue(agendador.proximoEvento().isPresent());
    assertEquals("Futuro", agendador.proximoEvento().get().titulo());
  }

  @Test
  void relogioNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Agendador(null));
  }

  @Test
  void tituloOuHorarioInvalidoLancaIllegalArgumentException() {
    Agendador agendador = new Agendador(RELOGIO_FIXO);
    assertThrows(
        IllegalArgumentException.class,
        () -> agendador.agendar(" ", LocalDateTime.of(2024, 1, 1, 0, 0)));
    assertThrows(IllegalArgumentException.class, () -> agendador.agendar("Reunião", null));
  }
}
