package challenges.m07.f07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefatoracaoTest {

  @Test
  void resultadoIgualAVersaoImperativaParaListaMista() {
    List<Integer> numeros = List.of(1, 2, 3, 4);
    assertEquals(
        RefatoracaoImperativa.somaDosQuadradosDosPares(numeros),
        Refatoracao.somaDosQuadradosDosPares(numeros));
    assertEquals(20, Refatoracao.somaDosQuadradosDosPares(numeros));
  }

  @Test
  void listaSemParesDevolveZero() {
    List<Integer> numeros = List.of(1, 3, 5);
    assertEquals(
        RefatoracaoImperativa.somaDosQuadradosDosPares(numeros),
        Refatoracao.somaDosQuadradosDosPares(numeros));
    assertEquals(0, Refatoracao.somaDosQuadradosDosPares(numeros));
  }

  @Test
  void numerosNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Refatoracao.somaDosQuadradosDosPares(null));
  }
}
