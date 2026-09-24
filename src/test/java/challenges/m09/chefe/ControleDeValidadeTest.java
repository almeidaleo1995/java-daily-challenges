package challenges.m09.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class ControleDeValidadeTest {

  private final List<LoteDeProduto> lotes =
      List.of(
          new LoteDeProduto("Leite", LocalDate.of(2024, 5, 10)),
          new LoteDeProduto("Arroz", LocalDate.of(2024, 6, 1)),
          new LoteDeProduto("Feijão", LocalDate.of(2024, 5, 20)));
  private final LocalDate hoje = LocalDate.of(2024, 5, 15);

  @Test
  void vencidosDevolveProdutosComValidadeAnteriorAHoje() {
    assertEquals(List.of("Leite"), ControleDeValidade.vencidos(lotes, hoje));
  }

  @Test
  void proximosDoVencimentoRespeitaAJanelaDeAlerta() {
    assertEquals(List.of("Feijão"), ControleDeValidade.proximosDoVencimento(lotes, hoje, 7));
  }

  @Test
  void janelaMaiorIncluiMaisProdutosOrdenadosPorValidade() {
    assertEquals(
        List.of("Feijão", "Arroz"), ControleDeValidade.proximosDoVencimento(lotes, hoje, 30));
  }

  @Test
  void diasDeAlertaNegativoLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ControleDeValidade.proximosDoVencimento(lotes, hoje, -1));
  }

  @Test
  void lotesOuHojeNulosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ControleDeValidade.vencidos(null, hoje));
    assertThrows(IllegalArgumentException.class, () -> ControleDeValidade.vencidos(lotes, null));
  }
}
