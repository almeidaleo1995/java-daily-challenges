package challenges.m01.f13;

public final class SomaAtePrimeiroNegativo {

  private SomaAtePrimeiroNegativo() {}

  public static int somarAtePrimeiroNegativo(int[] numeros) {
    int soma = 0;
    int i = 0;
    while (i < numeros.length && numeros[i] >= 0) {
      soma += numeros[i];
      i++;
    }
    return soma;
  }
}
