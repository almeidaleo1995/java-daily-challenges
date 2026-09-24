package challenges.m05.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CacheLruTest {

  @Test
  void descartaOElementoNaoAcessadoHaMaisTempo() {
    CacheLru<Integer, String> cache = new CacheLru<>(2);
    cache.put(1, "a");
    cache.put(2, "b");
    cache.get(1);
    cache.put(3, "c");

    assertTrue(cache.containsKey(1));
    assertFalse(cache.containsKey(2));
    assertTrue(cache.containsKey(3));
  }

  @Test
  void naoDescartaEnquantoNaoAtingeACapacidade() {
    CacheLru<Integer, String> cache = new CacheLru<>(3);
    cache.put(1, "a");
    cache.put(2, "b");

    assertTrue(cache.containsKey(1));
    assertTrue(cache.containsKey(2));
  }

  @Test
  void capacidadeNaoPositivaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new CacheLru<Integer, String>(0));
  }

  @Test
  void capacidadeNegativaTambemLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new CacheLru<Integer, String>(-1));
  }

  @Test
  void valorDaChaveMantidaContinuaCorretoAposODescarte() {
    CacheLru<Integer, String> cache = new CacheLru<>(2);
    cache.put(1, "a");
    cache.put(2, "b");
    cache.get(1);
    cache.put(3, "c");

    assertEquals("a", cache.get(1));
    assertEquals("c", cache.get(3));
  }
}
