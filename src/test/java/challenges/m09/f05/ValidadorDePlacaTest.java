package challenges.m09.f05;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidadorDePlacaTest {

  @Test
  void placaNoFormatoMercosulEValida() {
    assertTrue(ValidadorDePlaca.valida("ABC1D23"));
  }

  @Test
  void letrasMinusculasNaoEValida() {
    assertFalse(ValidadorDePlaca.valida("abc1d23"));
  }

  @Test
  void formatoAntigoNaoEValida() {
    assertFalse(ValidadorDePlaca.valida("ABC1234"));
  }

  @Test
  void tamanhoErradoNaoEValida() {
    assertFalse(ValidadorDePlaca.valida("ABC1D2"));
  }

  @Test
  void placaNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ValidadorDePlaca.valida(null));
  }
}
