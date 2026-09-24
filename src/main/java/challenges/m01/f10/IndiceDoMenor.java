package challenges.m01.f10;

public final class IndiceDoMenor {

  private IndiceDoMenor() {}

  public static int indiceDoMenor(int[] numeros) {

    if (numeros.length == 0) {
      throw new IllegalArgumentException("A lista não pode ser vazia.");
    }

    int posicaoMenor = 0;

    for (int i = 0; i < numeros.length; i++) {
      int atualValor = numeros[i];
      int menorValor = numeros[posicaoMenor];
      if (atualValor < menorValor) {
        posicaoMenor = i;
      }
    }
    return posicaoMenor;
  }
}
