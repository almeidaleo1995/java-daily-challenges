package challenges.m03.f01;

public final class Temperatura {

  private static final double absolutZero = -273.15;
  private final double celsius;

  private Temperatura(double celsius) {
    this.celsius = celsius;
  }

  public static Temperatura deCelsius(double valor) {
    if (valor < absolutZero) {
      throw new IllegalArgumentException("o valor nao pode ser menor que o absoluto zero");
    }
    return new Temperatura(valor);
  }

  public double celsius() {
    return celsius;
  }

  public double paraFahrenheit() {
    return (celsius * 9 / 5) + 32;
  }
}
