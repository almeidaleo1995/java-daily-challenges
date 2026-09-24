package challenges.m02.f06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ContadorDeCaracteresTest {

  @Test
  void textoVazio() {
    assertEquals(Map.of(), ContadorDeCaracteres.contarCaracteres(""));
  }

  @Test
  void contaRepeticoesSimples() {
    assertEquals(Map.of('a', 2, 'b', 1), ContadorDeCaracteres.contarCaracteres("aab"));
  }

  @Test
  void diferenciaMaiusculaDeMinuscula() {
    assertEquals(Map.of('J', 1, 'a', 2, 'v', 1), ContadorDeCaracteres.contarCaracteres("Java"));
  }

  @Test
  void contaEspacos() {
    assertEquals(Map.of('a', 2, ' ', 1), ContadorDeCaracteres.contarCaracteres("a a"));
  }
}
