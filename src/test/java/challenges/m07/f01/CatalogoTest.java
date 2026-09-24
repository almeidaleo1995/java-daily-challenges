package challenges.m07.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class CatalogoTest {

  @Test
  void devolveNomesAcimaDoMinimoOrdenadosPorPrecoDecrescente() {
    List<Produto> produtos =
        List.of(
            new Produto("A", new BigDecimal("10")),
            new Produto("B", new BigDecimal("30")),
            new Produto("C", new BigDecimal("20")));

    assertEquals(List.of("B", "C"), Catalogo.nomesAcimaDe(produtos, new BigDecimal("15")));
  }

  @Test
  void precoIgualAoMinimoNaoEIncluido() {
    List<Produto> produtos = List.of(new Produto("A", new BigDecimal("10")));
    assertEquals(List.of(), Catalogo.nomesAcimaDe(produtos, new BigDecimal("10")));
  }

  @Test
  void listaVaziaDevolveListaVazia() {
    assertEquals(List.of(), Catalogo.nomesAcimaDe(List.of(), new BigDecimal("0")));
  }

  @Test
  void produtosOuMinimoNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> Catalogo.nomesAcimaDe(null, BigDecimal.ZERO));
    assertThrows(
        IllegalArgumentException.class, () -> Catalogo.nomesAcimaDe(List.of(), null));
  }
}
