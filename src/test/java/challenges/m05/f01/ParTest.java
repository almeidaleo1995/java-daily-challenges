package challenges.m05.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParTest {

  @Test
  void getPrimeiroEGetSegundoDevolvemOsValoresDoConstrutor() {
    Par<String, Integer> par = new Par<>("idade", 30);
    assertEquals("idade", par.getPrimeiro());
    assertEquals(30, par.getSegundo());
  }

  @Test
  void trocarInverteAsPosicoesNumNovoPar() {
    Par<String, Integer> par = new Par<>("idade", 30);
    Par<Integer, String> trocado = par.trocar();

    assertEquals(30, trocado.getPrimeiro());
    assertEquals("idade", trocado.getSegundo());
  }

  @Test
  void trocarNaoAlteraOParOriginal() {
    Par<String, Integer> par = new Par<>("idade", 30);
    par.trocar();

    assertEquals("idade", par.getPrimeiro());
    assertEquals(30, par.getSegundo());
  }

  @Test
  void trocarDuasVezesDevolveOsMesmosValoresDeOrigem() {
    Par<String, Integer> par = new Par<>("idade", 30);
    Par<String, Integer> voltaAoNormal = par.trocar().trocar();

    assertEquals("idade", voltaAoNormal.getPrimeiro());
    assertEquals(30, voltaAoNormal.getSegundo());
  }
}
