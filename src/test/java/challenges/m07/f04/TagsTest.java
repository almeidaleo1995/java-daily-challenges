package challenges.m07.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class TagsTest {

  @Test
  void juntaTagsDeVariasListasSemRepetirMantendoPrimeiraAparicao() {
    assertEquals(
        List.of("java", "spring", "sql"),
        Tags.tagsUnicas(List.of(List.of("java", "spring"), List.of("java", "sql"))));
  }

  @Test
  void ignoraListasInternasVazias() {
    assertEquals(List.of("x"), Tags.tagsUnicas(List.of(List.of(), List.of("x"))));
  }

  @Test
  void listaExternaVaziaDevolveListaVazia() {
    assertEquals(List.of(), Tags.tagsUnicas(List.of()));
  }

  @Test
  void listasDeTagsNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Tags.tagsUnicas(null));
  }
}
