package challenges.m02.f24;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedSet;

public final class HistoricoNavegacao {

  private HistoricoNavegacao() {}

  public static List<String> maisRecentePrimeiro(LinkedHashSet<String> historico) {
    if (historico == null) {
      throw new IllegalArgumentException("O historico nao pode ser nulo");
    }
    SequencedSet<String> maisRecente = historico.reversed();
    return maisRecente.stream().toList();
  }
}
