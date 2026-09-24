package challenges.m01.f16;

public final class CapitalizarPalavras {

  private CapitalizarPalavras() {}

  public static String capitalizar(String texto) {
    StringBuilder resultado = new StringBuilder();
    boolean primeiraLetra = true;
    for (int i = 0; i < texto.length(); i++) {
      char current = texto.charAt(i);
      if (primeiraLetra) {
        current = Character.toUpperCase(current);
        resultado.append(current);
        primeiraLetra = false;
      } else {
        current = Character.toLowerCase(current);
        resultado.append(current);
      }

      if (Character.isWhitespace(current)) {
        primeiraLetra = true;
      }
    }
    return resultado.toString();
  }
}
