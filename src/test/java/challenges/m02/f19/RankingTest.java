package challenges.m02.f19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RankingTest {

  @Test
  void ordenaDoMaiorParaOMenor() {
    List<Jogador> jogadores =
        new ArrayList<>(List.of(new Jogador("Bia", 10), new Jogador("Duda", 30), new Jogador("Caio", 20)));

    Ranking.ordenarPorPontuacao(jogadores);

    assertEquals(
        List.of(new Jogador("Duda", 30), new Jogador("Caio", 20), new Jogador("Bia", 10)), jogadores);
  }

  @Test
  void empateNaPontuacaoDesempataPeloNomeAlfabetico() {
    List<Jogador> jogadores =
        new ArrayList<>(List.of(new Jogador("Bia", 10), new Jogador("Ana", 20), new Jogador("Caio", 20)));

    Ranking.ordenarPorPontuacao(jogadores);

    assertEquals(
        List.of(new Jogador("Ana", 20), new Jogador("Caio", 20), new Jogador("Bia", 10)), jogadores);
  }

  @Test
  void listaJaOrdenadaPermaneceIgual() {
    List<Jogador> jogadores = new ArrayList<>(List.of(new Jogador("Ana", 20), new Jogador("Bia", 10)));

    Ranking.ordenarPorPontuacao(jogadores);

    assertEquals(List.of(new Jogador("Ana", 20), new Jogador("Bia", 10)), jogadores);
  }

  @Test
  void listaComUmUnicoJogador() {
    List<Jogador> jogadores = new ArrayList<>(List.of(new Jogador("Ana", 5)));

    Ranking.ordenarPorPontuacao(jogadores);

    assertEquals(List.of(new Jogador("Ana", 5)), jogadores);
  }
}
