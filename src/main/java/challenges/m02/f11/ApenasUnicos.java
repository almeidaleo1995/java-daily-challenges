package challenges.m02.f11;

import java.util.*;

public final class ApenasUnicos {

  private ApenasUnicos() {}

  public static List<Integer> apenasUnicos(List<Integer> numeros) {
    Set<Integer> vistos = new HashSet<>();
    Set<Integer> duplicados = new LinkedHashSet<>();
    List<Integer> unicos = new ArrayList<>();
    for (Integer numero : numeros) {
      boolean adicionou = vistos.add(numero);
      if (!adicionou) {
        duplicados.add(numero);
      }
    }

    for (Integer numero : numeros) {
      if (!duplicados.contains(numero)) {
        unicos.add(numero);
      }
    }

    return unicos;
  }
}
