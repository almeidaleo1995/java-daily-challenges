package challenges.day024;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PrimeiroParConsecutivoTest {

  @Test
  void encontraOPrimeiroParNoInicio() {
    assertEquals('a', PrimeiroParConsecutivo.primeiroConsecutivoRepetido("aabbcc"));
  }

  @Test
  void encontraOPrimeiroParNoMeio() {
    assertEquals('d', PrimeiroParConsecutivo.primeiroConsecutivoRepetido("abcddef"));
  }

  @Test
  void semParConsecutivoLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PrimeiroParConsecutivo.primeiroConsecutivoRepetido("abcdef"));
  }

  @Test
  void textoVazioLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class,
        () -> PrimeiroParConsecutivo.primeiroConsecutivoRepetido(""));
  }
}
