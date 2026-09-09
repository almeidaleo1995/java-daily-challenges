package challenges.day020;

public final class DivisoesPorDois {

  private DivisoesPorDois() {}

  public static int contarDivisoesAteZero(int numero) {
    int contador = 0;
    do {
      numero /= 2;
      contador++;
    } while (numero != 0);
    return contador;
  }
}
