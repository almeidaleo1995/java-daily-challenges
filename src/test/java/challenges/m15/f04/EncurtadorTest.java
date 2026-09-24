package challenges.m15.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class EncurtadorTest {

  @Test
  void encurtarDevolveUmCodigoQueResolveDeVoltaParaAUrlOriginal() {
    Encurtador encurtador = new Encurtador();
    String codigo = encurtador.encurtar("https://exemplo.com/pagina");

    assertTrue(codigo.matches("[0-9a-zA-Z]+"));
    assertEquals(Optional.of("https://exemplo.com/pagina"), encurtador.resolver(codigo));
  }

  @Test
  void mesmaUrlEncurtadaDuasVezesDevolveOMesmoCodigo() {
    Encurtador encurtador = new Encurtador();
    String primeiro = encurtador.encurtar("https://exemplo.com/pagina");
    String segundo = encurtador.encurtar("https://exemplo.com/pagina");

    assertEquals(primeiro, segundo);
  }

  @Test
  void urlsDiferentesDevolvemCodigosDiferentes() {
    Encurtador encurtador = new Encurtador();
    String codigo1 = encurtador.encurtar("https://exemplo.com/um");
    String codigo2 = encurtador.encurtar("https://exemplo.com/dois");

    assertTrue(!codigo1.equals(codigo2));
  }

  @Test
  void codigoInexistenteDevolveOptionalVazio() {
    assertEquals(Optional.empty(), new Encurtador().resolver("naoexiste"));
  }

  @Test
  void urlSemHttpOuHttpsLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Encurtador().encurtar("exemplo.com"));
  }

  @Test
  void urlNulaLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Encurtador().encurtar(null));
  }
}
