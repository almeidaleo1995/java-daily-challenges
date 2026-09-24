package challenges.m05.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

record Produto(String codigo, String nome) implements Identificavel<String> {
  @Override
  public String getId() {
    return codigo;
  }
}

class RepositorioTest {

  @Test
  void salvarEBuscarPorId() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    Produto caneta = new Produto("P1", "Caneta");

    repositorio.salvar(caneta);

    assertEquals(caneta, repositorio.buscarPorId("P1"));
  }

  @Test
  void salvarComMesmoIdSubstituiOItem() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    repositorio.salvar(new Produto("P1", "Caneta"));
    repositorio.salvar(new Produto("P1", "Caneta Azul"));

    assertEquals("Caneta Azul", repositorio.buscarPorId("P1").nome());
  }

  @Test
  void buscarPorIdInexistenteLancaItemNaoEncontradoException() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    assertThrows(ItemNaoEncontradoException.class, () -> repositorio.buscarPorId("X"));
  }

  @Test
  void removerIdInexistenteLancaItemNaoEncontradoException() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    assertThrows(ItemNaoEncontradoException.class, () -> repositorio.remover("X"));
  }

  @Test
  void removerEliminaOItemDoRepositorio() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    repositorio.salvar(new Produto("P1", "Caneta"));

    repositorio.remover("P1");

    assertThrows(ItemNaoEncontradoException.class, () -> repositorio.buscarPorId("P1"));
  }

  @Test
  void listarTodosNaOrdemDeInsercao() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    repositorio.salvar(new Produto("P2", "Caderno"));
    repositorio.salvar(new Produto("P1", "Caneta"));

    assertEquals(
        java.util.List.of(new Produto("P2", "Caderno"), new Produto("P1", "Caneta")),
        repositorio.listarTodos());
  }

  @Test
  void itemNuloLancaIllegalArgumentException() {
    Repositorio<String, Produto> repositorio = new Repositorio<>();
    assertThrows(IllegalArgumentException.class, () -> repositorio.salvar(null));
  }
}
