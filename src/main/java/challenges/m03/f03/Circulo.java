package challenges.m03.f03;

public final class Circulo implements Forma {

  private final double raio;

  public Circulo(double raio) {
    if (raio <= 0.0) {
      throw new IllegalArgumentException("O raio não pode ser menor/igual que zero.");
    }
    this.raio = raio;
  }

  @Override
  public double area() {
    return Math.PI * Math.pow(raio, 2);
  }

  @Override
  public double perimetro() {
    return 2 * Math.PI * raio;
  }
}
