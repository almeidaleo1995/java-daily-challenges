package challenges.day013;

public final class RemovedorDeRepetidos {

  private RemovedorDeRepetidos() {}

  public static String removerConsecutivosRepetidos(String texto) {
    StringBuilder resultado = new StringBuilder();

    for (int i = 0; i < texto.length(); i++) {
      char atual = texto.charAt(i);

      if (i == texto.length() - 1 || atual != texto.charAt(i + 1)) {
        resultado.append(atual);
      }
    }
    return resultado.toString();
  }
}
