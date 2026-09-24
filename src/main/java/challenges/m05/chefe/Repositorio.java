package challenges.m05.chefe;

import java.util.List;

public final class Repositorio<ID, T extends Identificavel<ID>> {

  public void salvar(T item) {
    throw new UnsupportedOperationException("TODO: implementar");
  }

  public T buscarPorId(ID id) {
    throw new UnsupportedOperationException("TODO: implementar");
  }

  public void remover(ID id) {
    throw new UnsupportedOperationException("TODO: implementar");
  }

  public List<T> listarTodos() {
    throw new UnsupportedOperationException("TODO: implementar");
  }
}
