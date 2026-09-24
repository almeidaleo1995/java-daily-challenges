package challenges.m03.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class EstoqueTest {

  @Test
  void adicionarNovoItemGuardaQuantidadeEValor() {
    Estoque estoque = new Estoque();
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));

    assertEquals(10, estoque.quantidadeDe("Arroz"));
    assertEquals(new BigDecimal("250.00"), estoque.valorTotalEmEstoque());
  }

  @Test
  void adicionarItemExistenteSomaQuantidadeEAtualizaPreco() {
    Estoque estoque = new Estoque();
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 5, new BigDecimal("27.00")));

    assertEquals(15, estoque.quantidadeDe("Arroz"));
    assertEquals(new BigDecimal("405.00"), estoque.valorTotalEmEstoque());
  }

  @Test
  void removerParcialmenteMantemOItem() {
    Estoque estoque = new Estoque();
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));

    estoque.remover("Arroz", 4);

    assertEquals(6, estoque.quantidadeDe("Arroz"));
  }

  @Test
  void removerTudoFazItemDesaparecer() {
    Estoque estoque = new Estoque();
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));

    estoque.remover("Arroz", 10);

    assertEquals(0, estoque.quantidadeDe("Arroz"));
  }

  @Test
  void quantidadeDeProdutoInexistenteDevolveZero() {
    assertEquals(0, new Estoque().quantidadeDe("Feijão"));
  }

  @Test
  void removerMaisDoQueOEstoqueLancaIllegalArgumentException() {
    Estoque estoque = new Estoque();
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));

    assertThrows(IllegalArgumentException.class, () -> estoque.remover("Arroz", 20));
  }

  @Test
  void removerProdutoInexistenteLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Estoque().remover("Feijão", 1));
  }

  @Test
  void nomesPorCategoriaNaOrdemDeInsercao() {
    Estoque estoque = new Estoque();
    estoque.adicionar(new ItemDeEstoque("Sabão", Categoria.LIMPEZA, 3, new BigDecimal("5.00")));
    estoque.adicionar(new ItemDeEstoque("Arroz", Categoria.ALIMENTO, 10, new BigDecimal("25.00")));
    estoque.adicionar(new ItemDeEstoque("Detergente", Categoria.LIMPEZA, 2, new BigDecimal("3.00")));

    assertEquals(java.util.List.of("Sabão", "Detergente"), estoque.nomesPorCategoria(Categoria.LIMPEZA));
  }
}
