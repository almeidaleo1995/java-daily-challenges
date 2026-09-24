package challenges.m01.f21;

public final class IndicePrimeiroDeclive {

  private IndicePrimeiroDeclive() {}

  public static int indicePrimeiroDeclive(int[] numeros) {

    int posicaoDeclive = Integer.MIN_VALUE;

    for (int i = 0; i < numeros.length; i++) {
      if (i < numeros.length - 1 && numeros[i] > numeros[i + 1]) {
        posicaoDeclive = i;
        break;
      }
    }
    if (posicaoDeclive >= 0) {
      return posicaoDeclive;
    } else {
      throw new IllegalArgumentException("nao foi encontrado um declive valido");
    }
  }
}
