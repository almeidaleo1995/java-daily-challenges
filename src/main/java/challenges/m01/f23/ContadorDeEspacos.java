package challenges.m01.f23;

public final class ContadorDeEspacos {

  private ContadorDeEspacos() {}

  public static int contarEspacos(String texto) {
    int contador = 0;

    for (int i = 0; i < texto.length(); i++) {
      char letraAtual = texto.charAt(i);
      if (Character.isWhitespace(letraAtual)) {
        contador++;
      }
    }
    return contador;
  }
}
