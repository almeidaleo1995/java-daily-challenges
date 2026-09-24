package challenges.m01.f18;

public final class AlternarMaiusculaMinuscula {

  private AlternarMaiusculaMinuscula() {}

  public static String alternarCaso(String texto) {
    StringBuilder resultado = new StringBuilder();
    boolean letraMaiscula = true;
    for (int i = 0; i < texto.length(); i++) {
      char atual = texto.charAt(i);
      if (Character.isLetter(atual)) {
        if (Character.isLowerCase(atual) && letraMaiscula) {
          atual = Character.toUpperCase(atual);
          letraMaiscula = false;
        } else {
          atual = Character.toLowerCase(atual);
          letraMaiscula = true;
        }

      } else {
        letraMaiscula = true;
      }
      resultado.append(atual);
    }
    return resultado.toString();
  }
}
