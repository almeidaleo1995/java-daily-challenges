package challenges.m13.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class ValidadorTest {

  @Test
  void devolveOsCamposObrigatoriosNulos() {
    Cadastro cadastro = new Cadastro(null, "ana@exemplo.com", null);
    assertEquals(List.of("nome"), Validador.camposFaltando(cadastro));
  }

  @Test
  void todosOsObrigatoriosPreenchidosDevolveListaVazia() {
    Cadastro cadastro = new Cadastro("Ana", "ana@exemplo.com", null);
    assertEquals(List.of(), Validador.camposFaltando(cadastro));
  }

  @Test
  void doisCamposObrigatoriosFaltandoNaOrdemDeclarada() {
    Cadastro cadastro = new Cadastro(null, null, "apelido");
    assertEquals(List.of("nome", "email"), Validador.camposFaltando(cadastro));
  }

  @Test
  void objetoNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> Validador.camposFaltando(null));
  }
}
