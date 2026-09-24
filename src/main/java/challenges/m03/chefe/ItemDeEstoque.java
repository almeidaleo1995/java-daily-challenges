package challenges.m03.chefe;

import java.math.BigDecimal;

public record ItemDeEstoque(String nome, Categoria categoria, int quantidade, BigDecimal precoUnitario) {

  public ItemDeEstoque {
    if (nome == null || nome.isBlank()) {
      throw new IllegalArgumentException("nome é obrigatório");
    }
    if (categoria == null) {
      throw new IllegalArgumentException("categoria é obrigatória");
    }
    if (quantidade < 0) {
      throw new IllegalArgumentException("quantidade não pode ser negativa");
    }
    if (precoUnitario == null || precoUnitario.signum() < 0) {
      throw new IllegalArgumentException("preço não pode ser negativo");
    }
  }
}
