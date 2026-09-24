package challenges.m01.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CompactadorTest {

  @Test
  void textoVazio() {
    assertEquals("", Compactador.compactar(""));
  }

  @Test
  void umCaractere() {
    assertEquals("a1", Compactador.compactar("a"));
  }

  @Test
  void semRepeticao() {
    assertEquals("a1b1c1", Compactador.compactar("abc"));
  }

  @Test
  void comRepeticoes() {
    assertEquals("a3b2c1", Compactador.compactar("aaabbc"));
  }

  @Test
  void repeticaoNaoConsecutivaNaoAgrupa() {
    assertEquals("a2b2a2", Compactador.compactar("aabbaa"));
  }

  @Test
  void diferenciaMaiusculaDeMinuscula() {
    assertEquals("a1A1", Compactador.compactar("aA"));
  }

  @Test
  void blocoFinalLongo() {
    assertEquals("x1y5", Compactador.compactar("xyyyyy"));
  }

  @Test
  void espacosTambemContam() {
    assertEquals("a1 2b1", Compactador.compactar("a  b"));
  }
}
