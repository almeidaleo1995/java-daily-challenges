package challenges.m01.f08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContadorMaiusculasTest {

  @Test
  void textoVazio() {
    assertEquals(0, ContadorMaiusculas.contarMaiusculas(""));
  }

  @Test
  void semMaiusculas() {
    assertEquals(0, ContadorMaiusculas.contarMaiusculas("abc"));
  }

  @Test
  void tudoMaiusculo() {
    assertEquals(3, ContadorMaiusculas.contarMaiusculas("ABC"));
  }

  @Test
  void misturaDeMaiusculasEMinusculas() {
    assertEquals(2, ContadorMaiusculas.contarMaiusculas("Java Challenges"));
  }

  @Test
  void ignoraNumerosEDigitos() {
    assertEquals(2, ContadorMaiusculas.contarMaiusculas("AbC123"));
  }

  @Test
  void ignoraEspacosEPontuacao() {
    assertEquals(1, ContadorMaiusculas.contarMaiusculas("Ola, mundo!"));
  }
}
