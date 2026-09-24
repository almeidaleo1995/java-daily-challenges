package challenges.m01.f02;

public final class SomaDigitos {

  private SomaDigitos() {}

  public static int somarDigitos(int numero) {
    int soma = 0;
    while (numero != 0) {
      soma += numero % 10;
      numero /= 10;
    }
    return soma;
  }
}
