package challenges.m02.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FilaDeCarregamentoTest {

  @Test
  void inverteApenasOComeco() {
    assertEquals(
        List.of("B", "A", "C", "D"), FilaDeCarregamento.reordenar(List.of("A", "B", "C", "D"), 2));
  }

  @Test
  void inverteAFilaInteira() {
    assertEquals(
        List.of("D", "C", "B", "A"), FilaDeCarregamento.reordenar(List.of("A", "B", "C", "D"), 4));
  }

  @Test
  void zeroMantemAOrdemDeChegada() {
    assertEquals(List.of("A", "B", "C"), FilaDeCarregamento.reordenar(List.of("A", "B", "C"), 0));
  }

  @Test
  void umUnicoPacote() {
    assertEquals(List.of("A"), FilaDeCarregamento.reordenar(List.of("A"), 1));
  }

  @Test
  void aceitaCodigosRepetidos() {
    assertEquals(List.of("A", "A", "B"), FilaDeCarregamento.reordenar(List.of("A", "A", "B"), 2));
  }

  @Test
  void filaVazia() {
    assertEquals(List.of(), FilaDeCarregamento.reordenar(List.of(), 0));
  }

  @Test
  void maiorQueAFilaLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class, () -> FilaDeCarregamento.reordenar(List.of("A", "B"), 3));
  }

  @Test
  void negativoLancaExcecao() {
    assertThrows(
        IllegalArgumentException.class, () -> FilaDeCarregamento.reordenar(List.of("A", "B"), -1));
  }

  @Test
  void naoModificaAListaRecebida() {
    List<String> entrada = new ArrayList<>(List.of("A", "B", "C"));
    FilaDeCarregamento.reordenar(entrada, 2);
    assertEquals(List.of("A", "B", "C"), entrada);
  }
}
