package challenges.m03.f02;

import java.math.BigDecimal;

public record Produto(String nome, BigDecimal preco) {

  public Produto {
    if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Preço inválido");
    }
    if (nome == null ||nome.isBlank()) {
      throw new IllegalArgumentException("Nome inválido");
    }
  }

  public Produto comPreco(BigDecimal novoPreco) {
    return new Produto(this.nome, novoPreco);
  }
}
