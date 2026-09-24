package challenges.m02.f20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.TreeSet;
import org.junit.jupiter.api.Test;

class ProximoOnibusTest {

  private final TreeSet<Integer> horarios = new TreeSet<>(java.util.List.of(480, 540, 600));

  @Test
  void proximoAPartirDeEntreDoisHorarios() {
    assertEquals(540, ProximoOnibus.proximoAPartirDe(horarios, 500));
  }

  @Test
  void proximoAPartirDeExatamenteNoHorario() {
    assertEquals(600, ProximoOnibus.proximoAPartirDe(horarios, 600));
  }

  @Test
  void proximoAPartirDeDepoisDoUltimoDevolveNulo() {
    assertNull(ProximoOnibus.proximoAPartirDe(horarios, 700));
  }

  @Test
  void ultimoAntesDeEntreDoisHorarios() {
    assertEquals(480, ProximoOnibus.ultimoAntesDe(horarios, 500));
  }

  @Test
  void ultimoAntesDeAntesDoPrimeiroDevolveNulo() {
    assertNull(ProximoOnibus.ultimoAntesDe(horarios, 100));
  }

  @Test
  void horariosNulosLancamIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ProximoOnibus.proximoAPartirDe(null, 500));
    assertThrows(IllegalArgumentException.class, () -> ProximoOnibus.ultimoAntesDe(null, 500));
  }
}
