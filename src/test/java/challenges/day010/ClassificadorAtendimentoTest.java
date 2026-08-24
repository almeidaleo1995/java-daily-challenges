package challenges.day010;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClassificadorAtendimentoTest {

  @Test
  void menorDeIdadeNoPeriodoDiurno() {
    assertEquals("menor diurno", ClassificadorAtendimento.classificar(17, 10));
  }

  @Test
  void menorDeIdadeNoPeriodoNoturno() {
    assertEquals("menor noturno", ClassificadorAtendimento.classificar(5, 3));
  }

  @Test
  void adultoNoPeriodoNoturno() {
    assertEquals("adulto noturno", ClassificadorAtendimento.classificar(30, 20));
  }

  @Test
  void adultoNoPeriodoDiurno() {
    assertEquals("adulto diurno", ClassificadorAtendimento.classificar(18, 10));
  }

  @Test
  void limiteInferiorDoTurnoDiurno() {
    assertEquals("adulto diurno", ClassificadorAtendimento.classificar(18, 6));
  }

  @Test
  void limiteSuperiorDoTurnoDiurno() {
    assertEquals("adulto diurno", ClassificadorAtendimento.classificar(18, 18));
  }

  @Test
  void logoAposOLimiteSuperiorViraNoturno() {
    assertEquals("adulto noturno", ClassificadorAtendimento.classificar(18, 19));
  }

  @Test
  void idadeNegativaContaComoMenor() {
    assertEquals("menor diurno", ClassificadorAtendimento.classificar(-5, 12));
  }
}
