package challenges.m02.f13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ContadorDePalavras {

  private ContadorDePalavras() {}

  public static Map<String, Integer> contarPalavras(List<String> palavras) {
    Map<String, Integer> mapa = new HashMap<>();
    for (String palavra : palavras) {
      mapa.put(palavra, mapa.getOrDefault(palavra, 0) + 1);
    }
    return mapa;
  }
}
