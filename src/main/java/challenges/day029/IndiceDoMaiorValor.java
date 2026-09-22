package challenges.day029;

public final class IndiceDoMaiorValor {

  private IndiceDoMaiorValor() {}

  public static int indiceDoMaior(int[] numeros) {
    int posicaoMaior = 0;

    for (int i = 0; i < numeros.length; i++) {
      int atualValor = numeros[i];
      int maiorValor = numeros[posicaoMaior];
      if (atualValor > maiorValor) {
        posicaoMaior = i;
      }
    }
    return posicaoMaior;
  }
}
