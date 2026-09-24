package challenges.m01.f19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SegundoMaiorValorTest {

  @Test
  void segundoMaiorNoMeioDoArray() {
    assertEquals(7, SegundoMaiorValor.segundoMaior(new int[] {3, 7, 2, 9, 4}));
  }

  @Test
  void doisElementosOMenorEOSegundo() {
    assertEquals(1, SegundoMaiorValor.segundoMaior(new int[] {5, 1}));
  }

  @Test
  void arrayCrescente() {
    assertEquals(20, SegundoMaiorValor.segundoMaior(new int[] {10, 20, 30}));
  }

  @Test
  void doisElementosCrescentes() {
    assertEquals(1, SegundoMaiorValor.segundoMaior(new int[] {1, 2}));
  }
}
