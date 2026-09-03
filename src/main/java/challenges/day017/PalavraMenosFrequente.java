package challenges.day017;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class PalavraMenosFrequente {

  private PalavraMenosFrequente() {}

  public static String menosFrequente(List<String> palavras) {
    if (palavras.isEmpty()) {
      throw new IllegalArgumentException("A lista não pode ser nula ou vazia.");
    }

    Map<String, Integer> mapa = new LinkedHashMap<>();
    for (String palavra : palavras) {
      Integer contador = mapa.getOrDefault(palavra, 0) + 1;
      mapa.put(palavra, contador);
    }

    int quantidadeAtualPalavra = Integer.MAX_VALUE;
    String palavraMenosApareceu = null;

    for (Map.Entry<String, Integer> valor : mapa.entrySet()) {
      String palavraAtual = valor.getKey();
      int contadorPalavra = valor.getValue();
      if (contadorPalavra < quantidadeAtualPalavra) {
        palavraMenosApareceu = palavraAtual;
        quantidadeAtualPalavra = contadorPalavra;
      }
    }

    return palavraMenosApareceu;
  }
}
