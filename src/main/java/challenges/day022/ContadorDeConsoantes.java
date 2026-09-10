package challenges.day022;

public final class ContadorDeConsoantes {

  private ContadorDeConsoantes() {}

  public static int contarConsoantes(String texto) {
    String vogais = "aeiou";
    int contador = 0;
    for (int i = 0; i < texto.length(); i++) {
      char letra = texto.charAt(i);
      letra = Character.toLowerCase(letra);
      if ((vogais.indexOf(letra) == -1) && Character.isLetter(letra)) {
        contador++;
      }
    }
    return contador;
  }
}
