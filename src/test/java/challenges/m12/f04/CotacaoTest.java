package challenges.m12.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CotacaoTest {

  @Test
  void somaAsDuasCotacoesObtidasDeFormaAssincrona() {
    assertEquals(30.8, Cotacao.cotacaoTotal(() -> 10.5, () -> 20.3), 0.0001);
  }

  @Test
  void fornecedorAFalhaDevolveMenosUm() {
    assertEquals(
        -1.0,
        Cotacao.cotacaoTotal(
            () -> {
              throw new RuntimeException("indisponível");
            },
            () -> 20.3));
  }

  @Test
  void fornecedorBFalhaDevolveMenosUm() {
    assertEquals(
        -1.0,
        Cotacao.cotacaoTotal(
            () -> 10.5,
            () -> {
              throw new RuntimeException("indisponível");
            }));
  }

  @Test
  void fornecedoresNulosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Cotacao.cotacaoTotal(null, () -> 1.0));
    assertThrows(IllegalArgumentException.class, () -> Cotacao.cotacaoTotal(() -> 1.0, null));
  }
}
