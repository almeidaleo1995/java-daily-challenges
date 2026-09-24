package challenges.m03.f02;

import java.math.BigDecimal;

public record Produto(String nome, BigDecimal preco) {

  public Produto comPreco(BigDecimal novoPreco) {
    throw new UnsupportedOperationException("TODO: implementar");
  }
}
