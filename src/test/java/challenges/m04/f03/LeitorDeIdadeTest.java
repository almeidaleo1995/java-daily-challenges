package challenges.m04.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LeitorDeIdadeTest {

  @Test
  void textoValidoDevolveOInteiro() {
    assertEquals(25, LeitorDeIdade.ler("25"));
  }

  @Test
  void textoNaoNumericoLancaIdadeInvalidaExceptionComCausaOriginal() {
    IdadeInvalidaException excecao =
        assertThrows(IdadeInvalidaException.class, () -> LeitorDeIdade.ler("abc"));
    assertInstanceOf(NumberFormatException.class, excecao.getCause());
  }

  @Test
  void idadeForaDaFaixaLancaIdadeInvalidaExceptionSemCausa() {
    IdadeInvalidaException excecao =
        assertThrows(IdadeInvalidaException.class, () -> LeitorDeIdade.ler("200"));
    assertNull(excecao.getCause());
  }

  @Test
  void idadeNegativaLancaIdadeInvalidaException() {
    assertThrows(IdadeInvalidaException.class, () -> LeitorDeIdade.ler("-1"));
  }
}
