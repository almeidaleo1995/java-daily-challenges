package challenges.day006;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class SemRepetidos {

  private SemRepetidos() {
  }

  public static List<Integer> semRepetidos(List<Integer> numeros) {
    Set<Integer> setAuxilEncontrados = new LinkedHashSet<>();
    for (Integer numero : numeros) {
      setAuxilEncontrados.add(numero);
    }

    List<Integer> numerosResultado = new ArrayList<>(setAuxilEncontrados);
    return numerosResultado;
  }

}
