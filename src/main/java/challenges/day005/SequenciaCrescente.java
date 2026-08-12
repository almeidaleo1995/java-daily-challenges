package challenges.day005;

public final class SequenciaCrescente {

  private SequenciaCrescente() {}

  public static int maiorSequencia(int[] numeros) {

    if (numeros.length > 0) {
      int atual = 1;
      int melhor = 1;

      for (int i = 1; i < numeros.length; i++) {
        if (numeros[i] > numeros[i - 1]) {
          atual++;
        } else {
          atual = 1;
        }

        if (atual > melhor) {
          melhor = atual;
        }
      }

      return melhor;
    }

    return 0;
  }
}
