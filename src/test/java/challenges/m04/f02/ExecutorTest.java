package challenges.m04.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ExecutorTest {

  @Test
  void comandoOkAbreExecutaEFecha() {
    List<String> log = new ArrayList<>();
    Executor.executarComLog(log, "OK");
    assertEquals(List.of("aberta", "executado:OK", "fechada"), log);
  }

  @Test
  void comandoQueFalhaAindaAssimFechaAConexao() {
    List<String> log = new ArrayList<>();
    assertThrows(RuntimeException.class, () -> Executor.executarComLog(log, "FALHA"));
    assertEquals(List.of("aberta", "fechada"), log);
  }

  @Test
  void excecaoQuePropagaNaoEEmbrulhadaNemTemMensagemAlterada() {
    List<String> log = new ArrayList<>();
    RuntimeException excecao =
        assertThrows(RuntimeException.class, () -> Executor.executarComLog(log, "FALHA"));
    assertEquals("comando falhou", excecao.getMessage());
  }

  @Test
  void comandoDiferenteDeOkOuFalhaTambemEExecutadoERegistrado() {
    List<String> log = new ArrayList<>();
    Executor.executarComLog(log, "PING");
    assertEquals(List.of("aberta", "executado:PING", "fechada"), log);
  }
}
