package challenges.m13.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ChamadorDinamicoTest {

  @Test
  void chamaMetodoComUmArgumentoPeloNome() {
    Object resultado = ChamadorDinamico.chamar(new Saudador(), "saudar", "Ana");
    assertEquals("Olá, Ana", resultado);
  }

  @Test
  void metodoQueLancaExcecaoPropagaACausaOriginalNaoAInvocationTargetException() {
    assertThrows(
        IllegalStateException.class, () -> ChamadorDinamico.chamar(new Saudador(), "falhar"));
  }

  @Test
  void metodoInexistenteLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> ChamadorDinamico.chamar(new Saudador(), "naoExiste"));
  }

  @Test
  void alvoNuloLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> ChamadorDinamico.chamar(null, "saudar", "Ana"));
  }
}
