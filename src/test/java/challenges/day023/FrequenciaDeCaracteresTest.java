package challenges.day023;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class FrequenciaDeCaracteresTest {

  @Test
  void textoVazio() {
    assertEquals(Map.of(), FrequenciaDeCaracteres.frequencia(""));
  }

  @Test
  void contaRepeticoes() {
    assertEquals(Map.of('a', 2, 'b', 1), FrequenciaDeCaracteres.frequencia("aab"));
  }

  @Test
  void semRepeticoes() {
    assertEquals(Map.of('x', 1, 'y', 1, 'z', 1), FrequenciaDeCaracteres.frequencia("xyz"));
  }

  @Test
  void maiusculaEMinusculaSaoDiferentes() {
    assertEquals(Map.of('a', 1, 'A', 1), FrequenciaDeCaracteres.frequencia("aA"));
  }
}
