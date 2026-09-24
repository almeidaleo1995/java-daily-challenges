package challenges.m10.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ImportadorDeEstoqueTest {

  @TempDir Path tempDir;

  @Test
  void separaLinhasValidasDasInvalidas() throws IOException {
    Path csv = tempDir.resolve("estoque.csv");
    Path erros = tempDir.resolve("erros.txt");
    Files.writeString(csv, "Arroz,10\nFeijão,-5\nSabão,vinte\n,20\nFeijão,3");

    List<LinhaDeEstoque> resultado = ImportadorDeEstoque.importar(csv, erros);

    assertEquals(
        List.of(new LinhaDeEstoque("Arroz", 10), new LinhaDeEstoque("Feijão", 3)), resultado);
    assertEquals("Feijão,-5\nSabão,vinte\n,20", Files.readString(erros));
  }

  @Test
  void todasAsLinhasValidasDeixaArquivoDeErrosVazio() throws IOException {
    Path csv = tempDir.resolve("estoque.csv");
    Path erros = tempDir.resolve("erros.txt");
    Files.writeString(csv, "Arroz,10\nFeijão,5");

    List<LinhaDeEstoque> resultado = ImportadorDeEstoque.importar(csv, erros);

    assertEquals(
        List.of(new LinhaDeEstoque("Arroz", 10), new LinhaDeEstoque("Feijão", 5)), resultado);
    assertTrue(Files.readString(erros).isEmpty());
  }

  @Test
  void quantidadeZeroEValida() throws IOException {
    Path csv = tempDir.resolve("estoque.csv");
    Path erros = tempDir.resolve("erros.txt");
    Files.writeString(csv, "Arroz,0");

    List<LinhaDeEstoque> resultado = ImportadorDeEstoque.importar(csv, erros);

    assertEquals(List.of(new LinhaDeEstoque("Arroz", 0)), resultado);
  }

  @Test
  void linhaComFormatoErradoVaiParaOArquivoDeErros() throws IOException {
    Path csv = tempDir.resolve("estoque.csv");
    Path erros = tempDir.resolve("erros.txt");
    Files.writeString(csv, "Arroz,10\nSoUmCampo");

    List<LinhaDeEstoque> resultado = ImportadorDeEstoque.importar(csv, erros);

    assertEquals(List.of(new LinhaDeEstoque("Arroz", 10)), resultado);
    assertEquals("SoUmCampo", Files.readString(erros));
  }

  @Test
  void arquivoCsvQueNaoExisteDeixaAIOExceptionSubir() {
    Path csv = tempDir.resolve("nao-existe.csv");
    Path erros = tempDir.resolve("erros.txt");
    assertThrows(IOException.class, () -> ImportadorDeEstoque.importar(csv, erros));
  }

  @Test
  void arquivoCsvOuDeErrosNulosLancaIllegalArgumentException() {
    Path csv = tempDir.resolve("estoque.csv");
    Path erros = tempDir.resolve("erros.txt");
    assertThrows(
        IllegalArgumentException.class, () -> ImportadorDeEstoque.importar(null, erros));
    assertThrows(
        IllegalArgumentException.class, () -> ImportadorDeEstoque.importar(csv, null));
  }
}
