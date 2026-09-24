package challenges.m04.chefe;

// Dado: não altere.
public record ItemPedido(String produto, int quantidade) {

  public ItemPedido {
    if (produto == null || produto.isBlank()) {
      throw new IllegalArgumentException("produto é obrigatório");
    }
    if (quantidade <= 0) {
      throw new IllegalArgumentException("quantidade deve ser positiva");
    }
  }
}
