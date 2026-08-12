package challenges.day003;

import java.util.List;

public final class ContadorVogais {

  private ContadorVogais() {}

  public static int contarVogais(String texto) {
    List<Character> vogais = List.of('a', 'e', 'i', 'o', 'u');
    int contador = 0;
    for (char c : texto.toLowerCase().toCharArray()) {
      if (vogais.contains(c)) {
        contador++;
      }
    }
    return contador;
  }
}
