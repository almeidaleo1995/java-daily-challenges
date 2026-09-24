package challenges.m14.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.junit.jupiter.api.Test;

class GeradorDeBoletoTest {

  private static final Clock RELOGIO_FIXO =
      Clock.fixed(Instant.parse("2024-01-01T00:00:00Z"), ZoneId.of("UTC"));

  @Test
  void geraBoletoComVencimentoTrintaDiasAPartirDoRelogioInjetado() {
    GeradorDeBoleto gerador = new GeradorDeBoleto(RELOGIO_FIXO);
    assertEquals("Ana|100.0|2024-01-31", gerador.gerar("Ana", 100.0));
  }

  @Test
  void relogioFixoDevolveSempreOMesmoResultado() {
    GeradorDeBoleto gerador = new GeradorDeBoleto(RELOGIO_FIXO);
    String primeiraChamada = gerador.gerar("Bruno", 50.0);
    String segundaChamada = gerador.gerar("Bruno", 50.0);
    assertEquals(primeiraChamada, segundaChamada);
  }

  @Test
  void relogioNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new GeradorDeBoleto(null));
  }

  @Test
  void clienteEmBrancoLancaIllegalArgumentException() {
    GeradorDeBoleto gerador = new GeradorDeBoleto(RELOGIO_FIXO);
    assertThrows(IllegalArgumentException.class, () -> gerador.gerar("  ", 100.0));
  }

  @Test
  void valorNaoPositivoLancaIllegalArgumentException() {
    GeradorDeBoleto gerador = new GeradorDeBoleto(RELOGIO_FIXO);
    assertThrows(IllegalArgumentException.class, () -> gerador.gerar("Ana", 0.0));
  }
}
