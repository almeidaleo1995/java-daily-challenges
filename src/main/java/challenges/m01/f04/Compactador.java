package challenges.m01.f04;

public final class Compactador {

  private Compactador() {}

  public static String compactar(String texto) {
    StringBuilder resultado = new StringBuilder();
    int contador = 1;

    for (int i = 0; i < texto.length(); i++) {
      char current = texto.charAt(i);

      if (i == texto.length() - 1 || current != texto.charAt(i + 1)) {
        resultado.append(current);
        resultado.append(contador);
        contador = 1;
      } else {
        contador++;
      }
    }
    return resultado.toString();
  }
}
