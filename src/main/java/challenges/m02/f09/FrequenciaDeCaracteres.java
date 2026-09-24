package challenges.m02.f09;

import java.util.LinkedHashMap;
import java.util.Map;

public final class FrequenciaDeCaracteres {

  private FrequenciaDeCaracteres() {}

  public static Map<Character, Integer> frequencia(String texto) {
    Map<Character, Integer> mapa = new LinkedHashMap<>();
    for (char letra : texto.toCharArray()) {
      mapa.put(letra, mapa.getOrDefault(letra, 0) + 1);
    }
    return mapa;
  }
}
