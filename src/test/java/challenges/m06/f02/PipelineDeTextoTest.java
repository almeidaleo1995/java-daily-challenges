package challenges.m06.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class PipelineDeTextoTest {

  @Test
  void aplicaStripDepoisToLowerCaseNaOrdem() {
    assertEquals(
        "ola mundo",
        PipelineDeTexto.aplicar("  Ola Mundo  ", List.of(String::strip, String::toLowerCase)));
  }

  @Test
  void listaDeTransformacoesVaziaDevolveTextoOriginal() {
    assertEquals("abc", PipelineDeTexto.aplicar("abc", List.of()));
  }

  @Test
  void ordemDasTransformacoesAlteraOResultado() {
    Function<String, String> maiuscula = String::toUpperCase;
    Function<String, String> primeiraLetra = s -> s.substring(0, 1);
    assertEquals("A", PipelineDeTexto.aplicar("abc", List.of(maiuscula, primeiraLetra)));
    assertEquals("A", PipelineDeTexto.aplicar("abc", List.of(primeiraLetra, maiuscula)));
  }

  @Test
  void textoOuTransformacoesNulosLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> PipelineDeTexto.aplicar(null, List.of()));
    assertThrows(
        IllegalArgumentException.class, () -> PipelineDeTexto.aplicar("abc", null));
  }
}
