package challenges.m11.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class TrocoTest {

  private static final int[] MOEDAS = {1, 5, 10, 25};

  @Test
  void valorZeroNaoPrecisaDeMoedas() {
    assertEquals(Optional.of(0), Troco.menorQuantidadeDeMoedas(MOEDAS, 0));
  }

  @Test
  void valorComTrocoExatoUsandoMenosMoedasPossivel() {
    assertEquals(Optional.of(6), Troco.menorQuantidadeDeMoedas(MOEDAS, 63));
  }

  @Test
  void valorImpossivelDevolveOptionalVazio() {
    assertEquals(Optional.empty(), Troco.menorQuantidadeDeMoedas(new int[] {5, 10}, 3));
  }

  @Test
  void moedasComValorNaoPositivoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> Troco.menorQuantidadeDeMoedas(new int[] {1, 0, 5}, 10));
  }

  @Test
  void moedasNulasOuVaziasLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Troco.menorQuantidadeDeMoedas(null, 10));
    assertThrows(
        IllegalArgumentException.class, () -> Troco.menorQuantidadeDeMoedas(new int[0], 10));
  }

  @Test
  void valorNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Troco.menorQuantidadeDeMoedas(MOEDAS, -1));
  }

  @Test
  void valorGrandeDentroDoTimeoutExigeProgramacaoDinamica() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(2),
        () -> {
          Optional<Integer> resultado = Troco.menorQuantidadeDeMoedas(MOEDAS, 9999);
          assertTrue(resultado.isPresent());
          assertEquals(405, resultado.get());
        });
  }
}
