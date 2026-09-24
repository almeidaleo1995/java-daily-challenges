package challenges.m10.f04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class BuscadorDeArquivosTest {

  @TempDir Path tempDir;

  @Test
  void encontraArquivosComAExtensaoEmQualquerProfundidade() throws IOException {
    Files.writeString(tempDir.resolve("a.txt"), "a");
    Files.writeString(tempDir.resolve("b.csv"), "b");
    Path sub = Files.createDirectory(tempDir.resolve("sub"));
    Files.writeString(sub.resolve("c.txt"), "c");

    List<Path> resultado = BuscadorDeArquivos.buscarPorExtensao(tempDir, "txt");

    assertEquals(List.of(tempDir.resolve("a.txt"), sub.resolve("c.txt")), resultado);
  }

  @Test
  void semArquivosComAExtensaoDevolveListaVazia() throws IOException {
    Files.writeString(tempDir.resolve("b.csv"), "b");

    assertEquals(List.of(), BuscadorDeArquivos.buscarPorExtensao(tempDir, "txt"));
  }

  @Test
  void ignoraDiretorioCujoNomeTerminaComAExtensao() throws IOException {
    Files.createDirectory(tempDir.resolve("pasta.txt"));
    Files.writeString(tempDir.resolve("a.txt"), "a");

    List<Path> resultado = BuscadorDeArquivos.buscarPorExtensao(tempDir, "txt");

    assertEquals(List.of(tempDir.resolve("a.txt")), resultado);
  }

  @Test
  void diretorioOuExtensaoNulosLancaIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class, () -> BuscadorDeArquivos.buscarPorExtensao(null, "txt"));
    assertThrows(
        IllegalArgumentException.class, () -> BuscadorDeArquivos.buscarPorExtensao(tempDir, null));
  }
}
