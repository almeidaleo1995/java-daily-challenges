package challenges.m15.chefe;

// Dado: não altere.
public sealed interface EventoDeEstoque permits Venda, Devolucao, Ajuste {
  String produto();
}
