package challenges.day033;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RemoverElementos {

  private RemoverElementos() {}

  public static List<Integer> remover(List<Integer> numeros, Set<Integer> paraRemover) {
    List<Integer> listaFiltrada = new ArrayList<>();
    for (Integer numero : numeros) {
      if (!paraRemover.contains(numero)) {
        listaFiltrada.add(numero);
      }
    }
    return listaFiltrada;
  }
}
