package challenges.m09.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class TempoDeLigacaoTest {

  @Test
  void somaVariasDuracoes() {
    assertEquals(4530, TempoDeLigacao.somar(List.of("00:10:00", "01:05:30")).toSeconds());
  }

  @Test
  void listaVaziaDevolveDuracaoZero() {
    assertEquals(0, TempoDeLigacao.somar(List.of()).toSeconds());
  }

  @Test
  void umaUnicaDuracao() {
    assertEquals(3661, TempoDeLigacao.somar(List.of("01:01:01")).toSeconds());
  }

  @Test
  void duracoesNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> TempoDeLigacao.somar(null));
  }

  @Test
  void formatoInvalidoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> TempoDeLigacao.somar(List.of("1h30m")));
  }
}
