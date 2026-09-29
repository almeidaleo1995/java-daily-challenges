package challenges.m01.f24;

public final class IndicePrimeiraMinuscula {

  private IndicePrimeiraMinuscula() {}

  public static int indicePrimeiraMinuscula(String texto) {
    int posicaoPrimeiraMinuscula = Integer.MIN_VALUE;
    for (int i = 0; i < texto.length(); i++) {
      char letraAtual = texto.charAt(i);
      if (Character.isLowerCase(letraAtual)) {
        posicaoPrimeiraMinuscula = i;
        break;
      }
    }
    if (posicaoPrimeiraMinuscula >= 0) {
      return posicaoPrimeiraMinuscula;
    } else {
      throw new IllegalArgumentException("nao foi encontrado uma letra minuscula");
    }
  }
}
