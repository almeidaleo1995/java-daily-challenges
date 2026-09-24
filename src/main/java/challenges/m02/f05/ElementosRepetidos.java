package challenges.m02.f05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class ElementosRepetidos {
  private ElementosRepetidos() {}

  public static List<Integer> repetidos(List<Integer> numeros) {

    Set<Integer> vistos = new HashSet<>();
    Set<Integer> duplicados = new LinkedHashSet<>();
    for (Integer numero : numeros) {
      boolean adicionou = vistos.add(numero);
      if (!adicionou) {
        duplicados.add(numero);
      }
    }

    List<Integer> numerosResultado = new ArrayList<>(duplicados);
    return numerosResultado;
  }
}
