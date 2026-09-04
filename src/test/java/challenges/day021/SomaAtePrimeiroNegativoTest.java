package challenges.day021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomaAtePrimeiroNegativoTest {

  @Test
  void paraAntesDoNegativo() {
    assertEquals(6, SomaAtePrimeiroNegativo.somarAtePrimeiroNegativo(new int[] {1, 2, 3, -1, 5}));
  }

  @Test
  void semNegativoSomaTudo() {
    assertEquals(15, SomaAtePrimeiroNegativo.somarAtePrimeiroNegativo(new int[] {4, 5, 6}));
  }

  @Test
  void arrayVazio() {
    assertEquals(0, SomaAtePrimeiroNegativo.somarAtePrimeiroNegativo(new int[] {}));
  }

  @Test
  void negativoLogoNoInicio() {
    assertEquals(0, SomaAtePrimeiroNegativo.somarAtePrimeiroNegativo(new int[] {-1, 2, 3}));
  }
}
