package challenges.m06.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class DiretorioTest {

  private final Diretorio diretorio =
      new Diretorio(
          Map.of(
              "Ana", new Funcionario("Ana", "ana@x.com", "Bia"),
              "Bia", new Funcionario("Bia", "bia@x.com", null),
              "Carlos", new Funcionario("Carlos", "carlos@x.com", "Fantasma")));

  @Test
  void funcionarioComGerenteExistenteDevolveOEmailDoGerente() {
    assertEquals(Optional.of("bia@x.com"), diretorio.emailDoGerente("Ana"));
  }

  @Test
  void funcionarioSemGerenteDevolveOptionalVazio() {
    assertEquals(Optional.empty(), diretorio.emailDoGerente("Bia"));
  }

  @Test
  void funcionarioInexistenteDevolveOptionalVazio() {
    assertEquals(Optional.empty(), diretorio.emailDoGerente("Desconhecido"));
  }

  @Test
  void gerenteCitadoQueNaoEstaNoDiretorioDevolveOptionalVazio() {
    assertTrue(diretorio.emailDoGerente("Carlos").isEmpty());
  }

  @Test
  void funcionariosNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new Diretorio(null));
  }
}
