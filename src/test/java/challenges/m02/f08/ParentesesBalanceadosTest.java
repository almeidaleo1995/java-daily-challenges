package challenges.m02.f08;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ParentesesBalanceadosTest {

  @Test
  void expressaoVaziaEBalanceada() {
    assertTrue(ParentesesBalanceados.balanceado(""));
  }

  @Test
  void parOnicoDeParenteses() {
    assertTrue(ParentesesBalanceados.balanceado("()"));
  }

  @Test
  void parentesesAninhados() {
    assertTrue(ParentesesBalanceados.balanceado("(())"));
  }

  @Test
  void variosNiveisDeAninhamento() {
    assertTrue(ParentesesBalanceados.balanceado("((()))"));
  }

  @Test
  void abreSemFechar() {
    assertFalse(ParentesesBalanceados.balanceado("(()"));
  }

  @Test
  void fechaAntesDeAbrir() {
    assertFalse(ParentesesBalanceados.balanceado(")("));
  }

  @Test
  void mesmaContagemMasOrdemErrada() {
    assertFalse(ParentesesBalanceados.balanceado("())("));
  }
}
