package challenges.m01.f27;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import org.junit.jupiter.api.Test;

class TipoDoDiaTest {

  @Test
  void sabadoEDomingoSaoFimDeSemana() {
    assertEquals("Fim de semana", TipoDoDia.classificar(DayOfWeek.SATURDAY));
    assertEquals("Fim de semana", TipoDoDia.classificar(DayOfWeek.SUNDAY));
  }

  @Test
  void segundaEInicioDeSemana() {
    assertEquals("Início de semana", TipoDoDia.classificar(DayOfWeek.MONDAY));
  }

  @Test
  void sextaTemRotuloProprio() {
    assertEquals("Sexta", TipoDoDia.classificar(DayOfWeek.FRIDAY));
  }

  @Test
  void tercaQuartaEQuintaSaoMeioDeSemana() {
    assertEquals("Meio de semana", TipoDoDia.classificar(DayOfWeek.TUESDAY));
    assertEquals("Meio de semana", TipoDoDia.classificar(DayOfWeek.WEDNESDAY));
    assertEquals("Meio de semana", TipoDoDia.classificar(DayOfWeek.THURSDAY));
  }
}
