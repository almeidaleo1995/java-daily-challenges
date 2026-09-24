package challenges.m03.f04;

public enum Operacao {
  SOMA("+") {
    @Override
    public double aplicar(double a, double b) {
      throw new UnsupportedOperationException("TODO: implementar");
    }
  },
  SUBTRACAO("-") {
    @Override
    public double aplicar(double a, double b) {
      throw new UnsupportedOperationException("TODO: implementar");
    }
  },
  MULTIPLICACAO("*") {
    @Override
    public double aplicar(double a, double b) {
      throw new UnsupportedOperationException("TODO: implementar");
    }
  },
  DIVISAO("/") {
    @Override
    public double aplicar(double a, double b) {
      throw new UnsupportedOperationException("TODO: implementar");
    }
  };

  private final String simbolo;

  Operacao(String simbolo) {
    this.simbolo = simbolo;
  }

  public abstract double aplicar(double a, double b);

  public static Operacao porSimbolo(String simbolo) {
    throw new UnsupportedOperationException("TODO: implementar");
  }
}
