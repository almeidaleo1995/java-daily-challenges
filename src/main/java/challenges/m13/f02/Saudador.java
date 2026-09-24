package challenges.m13.f02;

// Dado: não altere.
public final class Saudador {
  public String saudar(String nome) {
    return "Olá, " + nome;
  }

  public String falhar() {
    throw new IllegalStateException("propositalmente quebrado");
  }
}
