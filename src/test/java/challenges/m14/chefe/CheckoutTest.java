package challenges.m14.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CheckoutTest {

  private static final EstrategiaDeFrete FRETE_RODOVIARIO =
      (pesoKg, distanciaKm) -> pesoKg * 0.5 + distanciaKm * 0.1;

  @Test
  void somaSubtotalCalculaFreteSoPeloPesoDosItensFisicosENotificaOuvintes() {
    Checkout checkout = new Checkout(FRETE_RODOVIARIO);
    List<Double> totaisNotificados = new ArrayList<>();
    checkout.registrarOuvinte(totaisNotificados::add);

    List<ItemCheckout> itens =
        List.of(
            new ItemFisico("Livro", 50.0, 1.0),
            new ItemDigital("E-book", 20.0),
            new ItemFisico("Fone", 100.0, 0.5));

    ResultadoCheckout resultado = checkout.finalizar(itens, 100.0);

    assertEquals(170.0, resultado.subtotal(), 0.0001);
    assertEquals(10.75, resultado.frete(), 0.0001);
    assertEquals(180.75, resultado.total(), 0.0001);
    assertEquals(List.of(180.75), totaisNotificados);
  }

  @Test
  void semItensFisicosOFreteSoConsideraADistancia() {
    Checkout checkout = new Checkout(FRETE_RODOVIARIO);
    ResultadoCheckout resultado = checkout.finalizar(List.of(new ItemDigital("E-book", 20.0)), 100.0);
    assertEquals(20.0, resultado.subtotal(), 0.0001);
    assertEquals(10.0, resultado.frete(), 0.0001);
    assertEquals(30.0, resultado.total(), 0.0001);
  }

  @Test
  void notificaTodosOsOuvintesRegistradosNaoSoOPrimeiro() {
    Checkout checkout = new Checkout(FRETE_RODOVIARIO);
    List<Double> ouvinte1 = new ArrayList<>();
    List<Double> ouvinte2 = new ArrayList<>();
    checkout.registrarOuvinte(ouvinte1::add);
    checkout.registrarOuvinte(ouvinte2::add);

    checkout.finalizar(List.of(new ItemDigital("E-book", 20.0)), 0.0);

    assertEquals(List.of(20.0), ouvinte1);
    assertEquals(List.of(20.0), ouvinte2);
  }

  @Test
  void itensNulosOuVaziosLancaIllegalArgumentException() {
    Checkout checkout = new Checkout(FRETE_RODOVIARIO);
    assertThrows(IllegalArgumentException.class, () -> checkout.finalizar(null, 10.0));
    assertThrows(IllegalArgumentException.class, () -> checkout.finalizar(List.of(), 10.0));
  }

  @Test
  void distanciaNegativaLancaIllegalArgumentException() {
    Checkout checkout = new Checkout(FRETE_RODOVIARIO);
    assertThrows(
        IllegalArgumentException.class,
        () -> checkout.finalizar(List.of(new ItemDigital("E-book", 20.0)), -1.0));
  }

  @Test
  void estrategiaDeFreteNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Checkout(null));
  }
}
