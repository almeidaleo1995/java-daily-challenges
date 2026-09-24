package challenges.m02.f24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class HistoricoNavegacaoTest {

  @Test
  void devolveNaOrdemInversaDeInsercao() {
    LinkedHashSet<String> historico = new LinkedHashSet<>(List.of("a.com", "b.com", "c.com"));
    assertEquals(
        List.of("c.com", "b.com", "a.com"), HistoricoNavegacao.maisRecentePrimeiro(historico));
  }

  @Test
  void historicoComUmUnicoSite() {
    LinkedHashSet<String> historico = new LinkedHashSet<>(List.of("a.com"));
    assertEquals(List.of("a.com"), HistoricoNavegacao.maisRecentePrimeiro(historico));
  }

  @Test
  void historicoVazioDevolveListaVazia() {
    assertTrue(HistoricoNavegacao.maisRecentePrimeiro(new LinkedHashSet<>()).isEmpty());
  }

  @Test
  void historicoNuloLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> HistoricoNavegacao.maisRecentePrimeiro(null));
  }
}
