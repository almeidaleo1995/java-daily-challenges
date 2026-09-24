package challenges.m02.f03;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MaisFrequente {

  private MaisFrequente() {}

  public static int maisFrequente(List<Integer> numeros) {

    if (numeros.isEmpty()) {
      throw new IllegalArgumentException("A lista não pode ser nula ou vazia.");
    }

    Map<Integer, Integer> mapa = new LinkedHashMap<>();
    for (Integer numero : numeros) {
      Integer contador = mapa.getOrDefault(numero, 0) + 1;
      mapa.put(numero, contador);
    }

    int numeroMaisApareceu = -1;
    int maximoRepeticoes = Integer.MIN_VALUE;

    for (Map.Entry<Integer, Integer> valor : mapa.entrySet()) {
      int numeroAtual = valor.getKey();
      int quantidadeAtual = valor.getValue();

      if (quantidadeAtual > maximoRepeticoes) {
        maximoRepeticoes = quantidadeAtual;
        numeroMaisApareceu = numeroAtual;
      }
    }

    return numeroMaisApareceu;
  }
}
