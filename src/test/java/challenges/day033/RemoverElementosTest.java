package challenges.day033;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RemoverElementosTest {

  @Test
  void removeElementosDoConjunto() {
    assertEquals(List.of(1, 3), RemoverElementos.remover(List.of(1, 2, 3, 2, 4), Set.of(2, 4)));
  }

  @Test
  void listaVazia() {
    assertEquals(List.of(), RemoverElementos.remover(List.of(), Set.of(1)));
  }

  @Test
  void conjuntoVazioMantemTudo() {
    assertEquals(List.of(1, 2), RemoverElementos.remover(List.of(1, 2), Set.of()));
  }

  @Test
  void mantemRepeticoesQueNaoForamRemovidas() {
    assertEquals(List.of(5, 5), RemoverElementos.remover(List.of(5, 5, 6), Set.of(6)));
  }

  @Test
  void naoModificaListaNemConjuntoOriginais() {
    List<Integer> numeros = new ArrayList<>(List.of(1, 2, 3));
    Set<Integer> paraRemover = Set.of(2);

    RemoverElementos.remover(numeros, paraRemover);

    assertEquals(List.of(1, 2, 3), numeros);
    assertEquals(Set.of(2), paraRemover);
  }
}
