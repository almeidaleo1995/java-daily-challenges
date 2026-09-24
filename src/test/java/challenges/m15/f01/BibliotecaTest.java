package challenges.m15.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class BibliotecaTest {

  @Test
  void emprestarMarcaLivroComoEmprestadoParaOUsuario() {
    Biblioteca biblioteca = new Biblioteca(List.of("Dom Casmurro"));
    biblioteca.emprestar("Dom Casmurro", "Ana", LocalDate.of(2024, 1, 1));

    assertTrue(biblioteca.estaEmprestado("Dom Casmurro"));
    assertEquals("Ana", biblioteca.usuarioComLivro("Dom Casmurro"));
  }

  @Test
  void devolverLiberaOLivro() {
    Biblioteca biblioteca = new Biblioteca(List.of("Dom Casmurro"));
    biblioteca.emprestar("Dom Casmurro", "Ana", LocalDate.of(2024, 1, 1));
    biblioteca.devolver("Dom Casmurro");

    assertFalse(biblioteca.estaEmprestado("Dom Casmurro"));
  }

  @Test
  void emprestarLivroJaEmprestadoLancaIllegalStateException() {
    Biblioteca biblioteca = new Biblioteca(List.of("Dom Casmurro"));
    biblioteca.emprestar("Dom Casmurro", "Ana", LocalDate.of(2024, 1, 1));

    assertThrows(
        IllegalStateException.class,
        () -> biblioteca.emprestar("Dom Casmurro", "Bruno", LocalDate.of(2024, 1, 2)));
  }

  @Test
  void devolverLivroNaoEmprestadoLancaIllegalStateException() {
    Biblioteca biblioteca = new Biblioteca(List.of("Dom Casmurro"));
    assertThrows(IllegalStateException.class, () -> biblioteca.devolver("Dom Casmurro"));
  }

  @Test
  void tituloForaDoCatalogoLancaIllegalArgumentException() {
    Biblioteca biblioteca = new Biblioteca(List.of("Dom Casmurro"));
    assertThrows(
        IllegalArgumentException.class,
        () -> biblioteca.emprestar("Livro Inexistente", "Ana", LocalDate.of(2024, 1, 1)));
  }

  @Test
  void usuarioEmBrancoLancaIllegalArgumentException() {
    Biblioteca biblioteca = new Biblioteca(List.of("Dom Casmurro"));
    assertThrows(
        IllegalArgumentException.class,
        () -> biblioteca.emprestar("Dom Casmurro", " ", LocalDate.of(2024, 1, 1)));
  }
}
