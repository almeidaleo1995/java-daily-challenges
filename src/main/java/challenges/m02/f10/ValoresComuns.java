package challenges.m02.f10;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class ValoresComuns {

  private ValoresComuns() {}

  public static List<Integer> comuns(List<Integer> a, List<Integer> b) {
    Set<Integer> setAuxilEncontrados = new LinkedHashSet<>();
    for (Integer numero : a) {
      if (b.contains(numero)) {
        setAuxilEncontrados.add(numero);
      }
    }
    return new ArrayList<>(setAuxilEncontrados);
  }
}
