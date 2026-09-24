package challenges.m13.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class InvocadorTest {

  @Test
  void somaOsDoisNumerosViaMethodHandle() throws Throwable {
    assertEquals(7, Invocador.somarViaMethodHandle(new Calculadora(), 3, 4));
  }

  @Test
  void somaComNumerosNegativos() throws Throwable {
    assertEquals(-1, Invocador.somarViaMethodHandle(new Calculadora(), 4, -5));
  }

  @Test
  void somaComZerosDevolveZero() throws Throwable {
    assertEquals(0, Invocador.somarViaMethodHandle(new Calculadora(), 0, 0));
  }

  @Test
  void calculadoraNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Invocador.somarViaMethodHandle(null, 1, 2));
  }
}
