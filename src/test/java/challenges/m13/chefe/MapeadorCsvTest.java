package challenges.m13.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class MapeadorCsvTest {

  @Test
  void mapeiaCadaLinhaParaUmObjetoUsandoAsColunasAnotadas() throws Exception {
    List<ProdutoCsv> produtos =
        MapeadorCsv.mapear(List.of("Arroz,10", "Feijão,5"), ProdutoCsv.class);

    assertEquals(2, produtos.size());
    assertEquals("Arroz", produtos.get(0).nome);
    assertEquals(10, produtos.get(0).quantidade);
    assertEquals("Feijão", produtos.get(1).nome);
    assertEquals(5, produtos.get(1).quantidade);
  }

  @Test
  void listaDeLinhasVaziaDevolveListaVazia() throws Exception {
    assertEquals(List.of(), MapeadorCsv.mapear(List.of(), ProdutoCsv.class));
  }

  @Test
  void mantemAOrdemDasLinhasMesmoQuandoNaoEAlfabetica() throws Exception {
    List<ProdutoCsv> produtos =
        MapeadorCsv.mapear(List.of("Sabão,3", "Arroz,10", "Feijão,5"), ProdutoCsv.class);

    assertEquals("Sabão", produtos.get(0).nome);
    assertEquals("Arroz", produtos.get(1).nome);
    assertEquals("Feijão", produtos.get(2).nome);
  }

  @Test
  void umaUnicaLinhaMapeiaParaUmaListaComUmItem() throws Exception {
    List<ProdutoCsv> produtos = MapeadorCsv.mapear(List.of("Sabão,3"), ProdutoCsv.class);

    assertEquals(1, produtos.size());
    assertEquals("Sabão", produtos.get(0).nome);
    assertEquals(3, produtos.get(0).quantidade);
  }

  @Test
  void linhasNulasLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> MapeadorCsv.mapear(null, ProdutoCsv.class));
  }

  @Test
  void classeAlvoNulaLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> MapeadorCsv.mapear(List.of("a,1"), null));
  }
}
