package challenges.m02.f15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ContagemPorTamanho {

  private ContagemPorTamanho() {}

  public static Map<Integer, Integer> contarPorTamanho(List<String> palavras) {
    Map<Integer, Integer> mapa = new HashMap<>();
    for (String palavra : palavras) {
      mapa.put(palavra.length(), mapa.getOrDefault(palavra.length(), 0) + 1);
    }
    return mapa;
  }
}
