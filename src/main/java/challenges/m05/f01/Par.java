package challenges.m05.f01;

public final class Par<A, B> {

  private final A primeiro;
  private final B segundo;

  public Par(A primeiro, B segundo) {
    this.primeiro = primeiro;
    this.segundo = segundo;
  }

  public A getPrimeiro() {
    throw new UnsupportedOperationException("TODO: implementar");
  }

  public B getSegundo() {
    throw new UnsupportedOperationException("TODO: implementar");
  }

  public Par<B, A> trocar() {
    throw new UnsupportedOperationException("TODO: implementar");
  }
}
