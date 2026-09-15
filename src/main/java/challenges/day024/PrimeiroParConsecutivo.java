package challenges.day024;

public final class PrimeiroParConsecutivo {

  private PrimeiroParConsecutivo() {}

  public static char primeiroConsecutivoRepetido(String texto) {
    if (texto.length() < 2) {
      throw new IllegalArgumentException("não existe resposta válida");
    }
    for (int i = 1; i < texto.length(); i++) {
      char atual = texto.charAt(i);
      if (atual == texto.charAt(i - 1)) {
        return atual;
      }
    }
    throw new IllegalArgumentException("não existe resposta válida");
  }
}
