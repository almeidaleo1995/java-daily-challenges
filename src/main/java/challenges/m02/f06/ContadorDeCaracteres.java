package challenges.m02.f06;

import java.util.HashMap;
import java.util.Map;

public final class ContadorDeCaracteres {

  private ContadorDeCaracteres() {}

  public static Map<Character, Integer> contarCaracteres(String texto) {
    Map<Character, Integer> mapa = new HashMap<>();
    for (char c : texto.toCharArray()) {
      mapa.put(c, mapa.getOrDefault(c, 0) + 1);
    }

    return mapa;
  }
}
