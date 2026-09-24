package challenges.m02.f02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ContadorFrequencia {

  private ContadorFrequencia() {}

  public static Map<Integer, Integer> contarFrequencia(List<Integer> numeros) {
    Map<Integer, Integer> mapa = new HashMap<>();
    for (Integer numero : numeros) {
      mapa.put(numero, mapa.getOrDefault(numero, 0) + 1);
    }
    return mapa;
  }
}
