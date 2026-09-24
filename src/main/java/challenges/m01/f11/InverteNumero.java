package challenges.m01.f11;

public final class InverteNumero {

  private InverteNumero() {}

  public static int inverter(int numero) {
    int numeroInvertido = 0;

    while (numero != 0) {
      numeroInvertido = (numeroInvertido * 10) + (numero % 10);
      numero /= 10;
    }
    return numeroInvertido;
  }
}
