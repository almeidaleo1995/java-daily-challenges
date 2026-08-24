package challenges.day014;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class IndiceDoMenorTest {

  @Test
  void encontraOIndiceDoMenorValor() {
    assertEquals(3, IndiceDoMenor.indiceDoMenor(new int[] {5, 3, 8, 1, 1}));
  }

  @Test
  void arrayComUmUnicoElemento() {
    assertEquals(0, IndiceDoMenor.indiceDoMenor(new int[] {4}));
  }

  @Test
  void funcionaComNegativos() {
    assertEquals(1, IndiceDoMenor.indiceDoMenor(new int[] {-2, -5, -5, 0}));
  }

  @Test
  void empateDevolveAPrimeiraOcorrencia() {
    assertEquals(0, IndiceDoMenor.indiceDoMenor(new int[] {7, 7, 7}));
  }

  @Test
  void arrayVazioLancaExcecao() {
    assertThrows(IllegalArgumentException.class, () -> IndiceDoMenor.indiceDoMenor(new int[] {}));
  }
}
