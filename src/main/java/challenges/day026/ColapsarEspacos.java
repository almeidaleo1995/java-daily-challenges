package challenges.day026;

public final class ColapsarEspacos {

  private ColapsarEspacos() {}

  public static String colapsar(String texto) {
    StringBuilder resultado = new StringBuilder();

    for (int i = 0; i < texto.length(); i++) {
      char atual = texto.charAt(i);
      char anterior = (i > 0) ? texto.charAt(i - 1) : '\0';
      if ((Character.isWhitespace(atual) && !Character.isWhitespace(anterior)
          || !Character.isWhitespace(atual))) {
        resultado.append(atual);
      }
    }

    return resultado.toString();
  }
}
