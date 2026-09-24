package challenges.m01.f07;

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
