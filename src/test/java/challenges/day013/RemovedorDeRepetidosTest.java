package challenges.day013;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RemovedorDeRepetidosTest {

  @Test
  void textoVazio() {
    assertEquals("", RemovedorDeRepetidos.removerConsecutivosRepetidos(""));
  }

  @Test
  void semRepeticoes() {
    assertEquals("abc", RemovedorDeRepetidos.removerConsecutivosRepetidos("abc"));
  }

  @Test
  void sequenciasConsecutivasDiferentes() {
    assertEquals("abca", RemovedorDeRepetidos.removerConsecutivosRepetidos("aaabccca"));
  }

  @Test
  void repeticoesNaoConsecutivasNaoSeFundem() {
    assertEquals("aba", RemovedorDeRepetidos.removerConsecutivosRepetidos("aabbaa"));
  }

  @Test
  void maiusculaEMinusculaSaoDiferentes() {
    assertEquals("aA", RemovedorDeRepetidos.removerConsecutivosRepetidos("aA"));
  }

  @Test
  void todoOTextoEUmaUnicaSequencia() {
    assertEquals("a", RemovedorDeRepetidos.removerConsecutivosRepetidos("aaaa"));
  }
}
