package challenges.m06.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PreguicosoTest {

  @Test
  void fornecedorNaoEChamadoAteAPrimeiraChamadaDeObter() {
    int[] chamadas = {0};
    Preguicoso<String> preguicoso =
        new Preguicoso<>(
            () -> {
              chamadas[0]++;
              return "resultado";
            });

    assertEquals(0, chamadas[0]);
    preguicoso.obter();
    assertEquals(1, chamadas[0]);
  }

  @Test
  void chamadasSeguintesDevolvemOValorCacheadoSemChamarDeNovo() {
    int[] chamadas = {0};
    Preguicoso<String> preguicoso =
        new Preguicoso<>(
            () -> {
              chamadas[0]++;
              return "resultado";
            });

    assertEquals("resultado", preguicoso.obter());
    assertEquals("resultado", preguicoso.obter());
    assertEquals("resultado", preguicoso.obter());
    assertEquals(1, chamadas[0]);
  }

  @Test
  void valorCalculadoNuloTambemECacheado() {
    int[] chamadas = {0};
    Preguicoso<String> preguicoso =
        new Preguicoso<>(
            () -> {
              chamadas[0]++;
              return null;
            });

    assertNull(preguicoso.obter());
    assertNull(preguicoso.obter());
    assertEquals(1, chamadas[0]);
  }

  @Test
  void fornecedorNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Preguicoso<String>(null));
  }
}
