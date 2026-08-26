package challenges.day012;

public final class ContadorMaiusculas {

  private ContadorMaiusculas() {}

  public static int contarMaiusculas(String texto) {
    int contador = 0;
    for (int i = 0; i < texto.length(); i++) {
      char letra = texto.charAt(i);
      if (Character.isUpperCase(letra)) contador++;
    }
    return contador;
  }
}
