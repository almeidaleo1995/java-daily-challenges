package challenges.m13.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaioXTest {

  @Test
  void listaOsNomesDosCamposNaOrdemDeclarada() {
    assertEquals(List.of("nome", "idade"), RaioX.nomesDosCampos(Pessoa.class));
  }

  @Test
  void identificaCampoPrivado() {
    assertTrue(RaioX.campoEhPrivado(Pessoa.class, "nome"));
  }

  @Test
  void identificaCampoNaoPrivado() {
    assertFalse(RaioX.campoEhPrivado(Pessoa.class, "idade"));
  }

  @Test
  void campoInexistenteLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> RaioX.campoEhPrivado(Pessoa.class, "inexistente"));
  }

  @Test
  void classeNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> RaioX.nomesDosCampos(null));
  }
}
