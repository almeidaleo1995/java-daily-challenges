package challenges.m12.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class CheckoutConcorrenteTest {

  @Test
  void maisCompradoresQueEstoqueVendeExatamenteOEstoque() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          CheckoutConcorrente checkout = new CheckoutConcorrente(50);
          int vendas = checkout.comprarConcorrentemente(200);
          assertEquals(50, vendas);
          assertEquals(0, checkout.estoqueRestante());
        });
  }

  @Test
  void compradoresDentroDoEstoqueCompramTodos() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          CheckoutConcorrente checkout = new CheckoutConcorrente(10);
          int vendas = checkout.comprarConcorrentemente(5);
          assertEquals(5, vendas);
          assertEquals(5, checkout.estoqueRestante());
        });
  }

  @Test
  void estoqueInicialNegativoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new CheckoutConcorrente(-1));
  }

  @Test
  void numeroDeCompradoresInvalidoLancaIllegalArgumentException() {
    CheckoutConcorrente checkout = new CheckoutConcorrente(10);
    assertThrows(IllegalArgumentException.class, () -> checkout.comprarConcorrentemente(0));
  }

  @Test
  void estoqueInicialZeroEValidoENenhumaCompraEBemSucedida() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          CheckoutConcorrente checkout = new CheckoutConcorrente(0);
          int vendas = checkout.comprarConcorrentemente(20);
          assertEquals(0, vendas);
          assertEquals(0, checkout.estoqueRestante());
        });
  }

  @Test
  void estoqueRestanteNuncaFicaNegativoSobDisputaIntensa() {
    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          CheckoutConcorrente checkout = new CheckoutConcorrente(1);
          checkout.comprarConcorrentemente(500);
          assertEquals(0, checkout.estoqueRestante());
        });
  }
}
