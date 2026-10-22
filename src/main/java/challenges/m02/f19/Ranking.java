package challenges.m02.f19;

import java.util.Comparator;
import java.util.List;

public final class Ranking {

  private Ranking() {}

  public static void ordenarPorPontuacao(List<Jogador> jogadores) {
    jogadores.sort(
        Comparator.comparing(Jogador::pontuacao).reversed().thenComparing(Jogador::nome));
  }
}
