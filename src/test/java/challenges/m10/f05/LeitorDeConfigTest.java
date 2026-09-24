package challenges.m10.f05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class LeitorDeConfigTest {

  @TempDir Path tempDir;

  @Test
  void leChavesEValoresIgnorandoLinhasEmBranco() throws IOException {
    Path arquivo = tempDir.resolve("config.properties");
    Files.writeString(arquivo, "host=localhost\nport=8080\n\ntimeout=30");

    assertEquals(
        Map.of("host", "localhost", "port", "8080", "timeout", "30"), LeitorDeConfig.ler(arquivo));
  }

  @Test
  void linhaSemIgualLancaIllegalArgumentException() throws IOException {
    Path arquivo = tempDir.resolve("config.properties");
    Files.writeString(arquivo, "host=localhost\nlinha invalida");

    assertThrows(IllegalArgumentException.class, () -> LeitorDeConfig.ler(arquivo));
  }

  @Test
  void arquivoInexistenteLancaNoSuchFileException() {
    Path arquivo = tempDir.resolve("nao-existe.properties");
    assertThrows(NoSuchFileException.class, () -> LeitorDeConfig.ler(arquivo));
  }

  @Test
  void arquivoNuloLancaIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> LeitorDeConfig.ler(null));
  }
}
