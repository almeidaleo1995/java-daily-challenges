package challenges.m01.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SequenciaCrescenteTest {

  @Test
  void arrayVazio() {
    assertEquals(0, SequenciaCrescente.maiorSequencia(new int[] {}));
  }

  @Test
  void umElemento() {
    assertEquals(1, SequenciaCrescente.maiorSequencia(new int[] {5}));
  }

  @Test
  void tudoCrescente() {
    assertEquals(4, SequenciaCrescente.maiorSequencia(new int[] {1, 2, 3, 4}));
  }

  @Test
  void tudoDecrescente() {
    assertEquals(1, SequenciaCrescente.maiorSequencia(new int[] {4, 3, 2, 1}));
  }

  @Test
  void sequenciaNoMeio() {
    assertEquals(3, SequenciaCrescente.maiorSequencia(new int[] {1, 2, 1, 2, 3, 1}));
  }

  @Test
  void valoresIguaisQuebramASequencia() {
    assertEquals(2, SequenciaCrescente.maiorSequencia(new int[] {1, 1, 2}));
  }

  @Test
  void aceitaNegativos() {
    assertEquals(3, SequenciaCrescente.maiorSequencia(new int[] {-3, -1, 0, -5, 7}));
  }

  @Test
  void maiorSequenciaTerminaNoFim() {
    assertEquals(3, SequenciaCrescente.maiorSequencia(new int[] {9, 8, 1, 2, 3}));
  }

  @Test
  void maiorSequenciaComecaNoInicio() {
    assertEquals(3, SequenciaCrescente.maiorSequencia(new int[] {1, 2, 3, 0, 1}));
  }

  @Test
  void todosIguais() {
    assertEquals(1, SequenciaCrescente.maiorSequencia(new int[] {7, 7, 7}));
  }
}
