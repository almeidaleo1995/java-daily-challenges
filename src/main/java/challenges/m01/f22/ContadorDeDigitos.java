package challenges.m01.f22;

public final class ContadorDeDigitos {

  private ContadorDeDigitos() {}

  public static int contarDigitos(String texto) {
    int contador = 0;
    for (int i = 0; i < texto.length(); i++) {
      char current = texto.charAt(i);
      if (Character.isDigit(current)){
        contador++;
      }
    }
    return  contador;
  }
}
