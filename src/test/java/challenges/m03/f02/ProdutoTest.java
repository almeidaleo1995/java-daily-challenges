package challenges.m03.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProdutoTest {

  @Test
  void criaProdutoValido() {
    Produto caneta = new Produto("Caneta", new BigDecimal("3.50"));
    assertEquals("Caneta", caneta.nome());
    assertEquals(new BigDecimal("3.50"), caneta.preco());
  }

  @Test
  void comPrecoDevolveNovaInstanciaSemAlterarAOriginal() {
    Produto caneta = new Produto("Caneta", new BigDecimal("3.50"));
    Produto reajustada = caneta.comPreco(new BigDecimal("4.00"));

    assertEquals(new BigDecimal("3.50"), caneta.preco());
    assertEquals(new BigDecimal("4.00"), reajustada.preco());
    assertEquals("Caneta", reajustada.nome());
  }

  @Test
  void nomeEmBrancoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Produto("", new BigDecimal("1")));
  }

  @Test
  void precoNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Produto("Caneta", new BigDecimal("-1")));
  }
}
