package challenges.m09.f06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class LeitorDeLogTest {

  @Test
  void linhaNoFormatoEInterpretadaComTodosOsCampos() {
    Optional<LinhaDeLog> resultado =
        LeitorDeLog.interpretar("2024-05-15 10:23:45 ERROR Falha ao conectar");

    assertEquals(
        Optional.of(new LinhaDeLog("2024-05-15", "10:23:45", "ERROR", "Falha ao conectar")),
        resultado);
  }

  @Test
  void linhaForaDoFormatoDevolveOptionalVazio() {
    assertTrue(LeitorDeLog.interpretar("linha sem formato nenhum").isEmpty());
  }

  @Test
  void mensagemComEspacosEPreservadaInteira() {
    Optional<LinhaDeLog> resultado =
        LeitorDeLog.interpretar("2024-01-01 00:00:00 INFO tudo certo por aqui");

    assertEquals("tudo certo por aqui", resultado.orElseThrow().mensagem());
  }

  @Test
  void linhaNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> LeitorDeLog.interpretar(null));
  }
}
