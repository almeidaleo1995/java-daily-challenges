package challenges.m02.f16;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class MarcaMaisCompradaTest {

  @Test
  void encontraAMarcaMaisComprada() {
    assertEquals("nike", MarcaMaisComprada.maisComprada(List.of("nike", "adidas", "nike")));
  }

  @Test
  void empateDevolveAPrimeiraQueApareceu() {
    assertEquals("a", MarcaMaisComprada.maisComprada(List.of("a", "b")));
  }

  @Test
  void umaUnicaMarca() {
    assertEquals("x", MarcaMaisComprada.maisComprada(List.of("x")));
  }

  @Test
  void listaVaziaLancaExcecao() {
    assertThrows(IllegalArgumentException.class, () -> MarcaMaisComprada.maisComprada(List.of()));
  }
}
