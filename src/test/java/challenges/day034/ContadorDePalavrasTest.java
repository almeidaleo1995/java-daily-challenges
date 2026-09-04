package challenges.day034;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ContadorDePalavrasTest {

  @Test
  void listaVazia() {
    assertEquals(Map.of(), ContadorDePalavras.contarPalavras(List.of()));
  }

  @Test
  void contaRepeticoes() {
    assertEquals(
        Map.of("java", 2, "python", 1),
        ContadorDePalavras.contarPalavras(List.of("java", "python", "java")));
  }

  @Test
  void todasIguais() {
    assertEquals(Map.of("a", 3), ContadorDePalavras.contarPalavras(List.of("a", "a", "a")));
  }
}
