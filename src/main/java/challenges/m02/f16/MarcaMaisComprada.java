package challenges.m02.f16;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MarcaMaisComprada {

  private MarcaMaisComprada() {}

  public static String maisComprada(List<String> marcas) {
    if (marcas.isEmpty()) {
      throw new IllegalArgumentException("A lista de marcas não pode ser nula ou vazia.");
    }

    Map<String, Integer> mapa = new LinkedHashMap<>();

    for (String marca : marcas) {
      Integer contador = mapa.getOrDefault(marca, 0) + 1;
      mapa.put(marca, contador);
    }

    Integer quantidadeMarcaMaisComprada = Integer.MIN_VALUE;
    String marcaMaisComprada = "";

    for (Map.Entry<String, Integer> valor : mapa.entrySet()) {
      String marcaAtual = valor.getKey();
      Integer quantidadeAtual = valor.getValue();

      if (quantidadeAtual > quantidadeMarcaMaisComprada) {
        quantidadeMarcaMaisComprada = quantidadeAtual;
        marcaMaisComprada = marcaAtual;
      }
    }

    return marcaMaisComprada;
  }
}
