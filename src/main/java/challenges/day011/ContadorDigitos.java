package challenges.day011;

public final class ContadorDigitos {

  public static int contarDigitos(int numero) {
    int contador = 0;

    do {
      numero /= 10;
      contador++;
    } while (numero != 0);

    return contador;
  }
}
