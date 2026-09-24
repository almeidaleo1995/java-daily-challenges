package challenges.m10.f01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ContadorDeLinhasTest {

  @TempDir Path tempDir;

  @Test
  void contaAsLinhasDeUmArquivoComTexto() throws IOException {
    Path arquivo = tempDir.resolve("linhas.txt");
    Files.writeString(arquivo, "a\nb\nc");

    assertEquals(3, ContadorDeLinhas.contar(arquivo));
  }

  @Test
  void arquivoVazioTemZeroLinhas() throws IOException {
    Path arquivo = tempDir.resolve("vazio.txt");
    Files.writeString(arquivo, "");

    assertEquals(0, ContadorDeLinhas.contar(arquivo));
  }

  @Test
  void arquivoInexistenteLancaNoSuchFileException() {
    Path arquivo = tempDir.resolve("nao-existe.txt");
    assertThrows(NoSuchFileException.class, () -> ContadorDeLinhas.contar(arquivo));
  }

  @Test
  void arquivoNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> ContadorDeLinhas.contar(null));
  }
}
