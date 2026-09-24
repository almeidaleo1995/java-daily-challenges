package challenges.m03.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class FormasTest {

  @Test
  void areaEPerimetroDoCirculo() {
    Circulo circulo = new Circulo(2);
    assertEquals(Math.PI * 4, circulo.area(), 0.0001);
    assertEquals(Math.PI * 4, circulo.perimetro(), 0.0001);
  }

  @Test
  void areaEPerimetroDoRetangulo() {
    Retangulo retangulo = new Retangulo(3, 4);
    assertEquals(12.0, retangulo.area(), 0.0001);
    assertEquals(14.0, retangulo.perimetro(), 0.0001);
  }

  @Test
  void raioNaoPositivoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Circulo(0));
  }

  @Test
  void ladoNaoPositivoLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Retangulo(3, 0));
  }

  @Test
  void polimorfismoPercorreListaDeFormasDistintas() {
    List<Forma> formas = List.of(new Circulo(1), new Retangulo(2, 2));
    double somaDeAreas = 0;
    for (Forma forma : formas) {
      somaDeAreas += forma.area();
    }
    assertEquals(Math.PI + 4.0, somaDeAreas, 0.0001);
  }
}
