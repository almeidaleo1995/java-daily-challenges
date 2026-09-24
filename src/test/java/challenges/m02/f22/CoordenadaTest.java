package challenges.m02.f22;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class CoordenadaTest {

  @Test
  void duasCoordenadasComMesmosValoresSaoIguais() {
    assertEquals(new Coordenada(1, 2), new Coordenada(1, 2));
  }

  @Test
  void coordenadasComValoresDiferentesNaoSaoIguais() {
    assertFalse(new Coordenada(1, 2).equals(new Coordenada(2, 1)));
  }

  @Test
  void coordenadasIguaisTemMesmoHashCode() {
    assertEquals(new Coordenada(5, 7).hashCode(), new Coordenada(5, 7).hashCode());
  }

  @Test
  void hashSetReconheceCoordenadaEquivalenteDeInstanciaDiferente() {
    HashSet<Coordenada> visitadas = new HashSet<>(List.of(new Coordenada(1, 2)));
    assertTrue(visitadas.contains(new Coordenada(1, 2)));
  }

  @Test
  void hashMapEncontraValorComChaveEquivalenteDeInstanciaDiferente() {
    HashMap<Coordenada, String> mapa = new HashMap<>();
    mapa.put(new Coordenada(3, 4), "Base");
    assertEquals("Base", mapa.get(new Coordenada(3, 4)));
  }
}
