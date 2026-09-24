package challenges.m08.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

  @Test
  void areaDoCirculo() {
    assertEquals(Math.PI * 4, Calculadora.area(new Circulo(2)), 0.0001);
  }

  @Test
  void areaDoRetangulo() {
    assertEquals(12.0, Calculadora.area(new Retangulo(3, 4)), 0.0001);
  }

  @Test
  void areaDoTriangulo() {
    assertEquals(12.0, Calculadora.area(new Triangulo(6, 4)), 0.0001);
  }

  @Test
  void formaNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Calculadora.area(null));
  }
}
