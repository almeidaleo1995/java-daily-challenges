package challenges.m02.f18;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProdutoMaisCaroTest {

  @Test
  void encontraOProdutoMaisCaro() {
    assertEquals(
        "caderno", ProdutoMaisCaro.maisCaro(List.of("caneta", "caderno"), List.of(2.5, 15.0)));
  }

  @Test
  void empateDevolveOPrimeiro() {
    assertEquals("a", ProdutoMaisCaro.maisCaro(List.of("a", "b"), List.of(10.0, 10.0)));
  }

  @Test
  void umUnicoProduto() {
    assertEquals("x", ProdutoMaisCaro.maisCaro(List.of("x"), List.of(5.0)));
  }

  @Test
  void listasVaziasLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class, () -> ProdutoMaisCaro.maisCaro(List.of(), List.of()));
  }
}
