package challenges.m06.f05;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RegrasDeCreditoTest {

  @Test
  void clienteQueSatisfazTodasAsRegrasEAprovado() {
    assertTrue(RegrasDeCredito.aprovado(new Cliente(25, 3000, false)));
  }

  @Test
  void menorDeIdadeNaoEAprovado() {
    assertFalse(RegrasDeCredito.aprovado(new Cliente(17, 3000, false)));
  }

  @Test
  void rendaInsuficienteNaoEAprovado() {
    assertFalse(RegrasDeCredito.aprovado(new Cliente(25, 1000, false)));
  }

  @Test
  void clienteComRestricaoNaoEAprovado() {
    assertFalse(RegrasDeCredito.aprovado(new Cliente(25, 3000, true)));
  }

  @Test
  void clienteNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> RegrasDeCredito.aprovado(null));
  }
}
