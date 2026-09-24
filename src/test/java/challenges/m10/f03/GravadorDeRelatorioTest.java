package challenges.m10.f03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class GravadorDeRelatorioTest {

  @TempDir Path tempDir;

  @Test
  void gravaAsLinhasSeparadasPorQuebraDeLinha() throws IOException {
    Path arquivo = tempDir.resolve("relatorio.txt");

    GravadorDeRelatorio.gravar(arquivo, List.of("linha 1", "linha 2"));

    assertEquals("linha 1\nlinha 2", Files.readString(arquivo));
  }

  @Test
  void gravarDeNovoSubstituiOConteudoAnterior() throws IOException {
    Path arquivo = tempDir.resolve("relatorio.txt");

    GravadorDeRelatorio.gravar(arquivo, List.of("linha 1", "linha 2", "linha 3"));
    GravadorDeRelatorio.gravar(arquivo, List.of("nova linha"));

    assertEquals("nova linha", Files.readString(arquivo));
  }

  @Test
  void arquivoOuLinhasNulosLancaIllegalArgumentException() {
    Path arquivo = tempDir.resolve("relatorio.txt");
    assertThrows(
        IllegalArgumentException.class, () -> GravadorDeRelatorio.gravar(null, List.of()));
    assertThrows(
        IllegalArgumentException.class, () -> GravadorDeRelatorio.gravar(arquivo, null));
  }
}
