package challenges.m06.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class FiltroTest {

  @Test
  void mantemApenasOsElementosQueSatisfazemOPredicado() {
    assertEquals(List.of(2, 4, 6), Filtro.filtrar(List.of(1, 2, 3, 4, 5, 6), n -> n % 2 == 0));
  }

  @Test
  void predicadoQueSempreFalhaDevolveListaVazia() {
    assertEquals(List.of(), Filtro.filtrar(List.of("ana", "bob"), s -> s.isEmpty()));
  }

  @Test
  void mantemDuplicadosQueSatisfazemOPredicado() {
    assertEquals(
        List.of("ana", "ana"),
        Filtro.filtrar(List.of("ana", "bob", "ana"), s -> s.equals("ana")));
  }

  @Test
  void listaVaziaDevolveListaVazia() {
    assertEquals(List.of(), Filtro.filtrar(List.of(), n -> true));
  }

  @Test
  void listaOuPredicadoNulosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Filtro.filtrar(null, n -> true));
    assertThrows(IllegalArgumentException.class, () -> Filtro.filtrar(List.of(1), null));
  }
}
