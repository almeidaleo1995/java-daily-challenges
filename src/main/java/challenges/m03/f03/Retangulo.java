package challenges.m03.f03;

public final class Retangulo implements Forma {

  private final double largura;
  private final double altura;

  public Retangulo(double largura, double altura) {
    if (largura <= 0.0 || altura <= 0.0) {
      throw new IllegalArgumentException("A largura ou a altura não podem serem menor/igual que zero.");
    }
    this.altura = altura;
    this.largura = largura;
  }

  @Override
  public double area() {
    return largura * altura;
  }

  @Override
  public double perimetro() {
    return 2 * (largura + altura);
  }
}
