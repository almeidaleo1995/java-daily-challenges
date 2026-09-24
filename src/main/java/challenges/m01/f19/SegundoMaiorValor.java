package challenges.m01.f19;

public final class SegundoMaiorValor {

  private SegundoMaiorValor() {}

  public static int segundoMaior(int[] numeros) {
    if (numeros.length > 0) {
      int segundoMaior = Integer.MIN_VALUE;
      int melhor = Integer.MIN_VALUE;

      for (int i = 0; i < numeros.length; i++) {
        int atual = numeros[i];
        if (atual > melhor) {
          segundoMaior = melhor;
          melhor = atual;
        } else if (atual > segundoMaior) {
          segundoMaior = atual;
        }
      }

      return segundoMaior;
    }

    return 0;
  }
}
