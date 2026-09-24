package challenges.m14.chefe;

// Dado: não altere.
public sealed interface ItemCheckout permits ItemFisico, ItemDigital {
  double preco();
}
