package challenges.m02.f14;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class SomaPorCategoria {

  private SomaPorCategoria() {}

  public static Map<String, Integer> somarPorCategoria(
      List<String> categorias, List<Integer> valores) {
    int tamanho = Math.min(categorias.size(), valores.size());

    Map<String, Integer> mapa = new LinkedHashMap<>();
    for (int i = 0; i < tamanho; i++) {
      String categoria = categorias.get(i);
      Integer valor = valores.get(i);
      mapa.put(categoria, mapa.getOrDefault(categoria, 0) + valor);
    }
    return mapa;
  }
}
