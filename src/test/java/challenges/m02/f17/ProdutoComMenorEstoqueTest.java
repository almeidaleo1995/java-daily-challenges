package challenges.m02.f17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class ProdutoComMenorEstoqueTest {

  @Test
  void encontraOProdutoComMenorEstoque() {
    LinkedHashMap<String, Integer> estoque = new LinkedHashMap<>();
    estoque.put("A", 5);
    estoque.put("B", 2);
    estoque.put("C", 8);

    assertEquals("B", ProdutoComMenorEstoque.menorEstoque(estoque));
  }

  @Test
  void empateDevolveOPrimeiroDoMapa() {
    LinkedHashMap<String, Integer> estoque = new LinkedHashMap<>();
    estoque.put("A", 5);
    estoque.put("B", 2);
    estoque.put("C", 2);

    assertEquals("B", ProdutoComMenorEstoque.menorEstoque(estoque));
  }

  @Test
  void umUnicoProduto() {
    LinkedHashMap<String, Integer> estoque = new LinkedHashMap<>();
    estoque.put("X", 10);

    assertEquals("X", ProdutoComMenorEstoque.menorEstoque(estoque));
  }

  @Test
  void mapaVazioLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ProdutoComMenorEstoque.menorEstoque(new LinkedHashMap<>()));
  }
}
