package challenges.day029;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IndiceDoMaiorValorTest {

  @Test
  void maiorNoMeioDoArray() {
    assertEquals(3, IndiceDoMaiorValor.indiceDoMaior(new int[] {3, 7, 2, 9, 4}));
  }

  @Test
  void empateDevolvePrimeiroIndice() {
    assertEquals(0, IndiceDoMaiorValor.indiceDoMaior(new int[] {5, 5, 5}));
  }

  @Test
  void umUnicoElemento() {
    assertEquals(0, IndiceDoMaiorValor.indiceDoMaior(new int[] {1}));
  }

  @Test
  void maiorNoInicio() {
    assertEquals(0, IndiceDoMaiorValor.indiceDoMaior(new int[] {9, 1, 2}));
  }
}
