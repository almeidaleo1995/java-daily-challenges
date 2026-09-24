package challenges.m10.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class SomaCsvTest {

  @TempDir Path tempDir;

  @Test
  void somaOsValoresDaColunaIndicada() throws IOException {
    Path arquivo = tempDir.resolve("estoque.csv");
    Files.writeString(arquivo, "Arroz,10\nFeijão,5\nSabão,20");

    assertEquals(35, SomaCsv.somarColuna(arquivo, 1));
  }

  @Test
  void somaAPrimeiraColunaQuandoIndiceEZero() throws IOException {
    Path arquivo = tempDir.resolve("numeros.csv");
    Files.writeString(arquivo, "1,x\n2,y\n3,z");

    assertEquals(6, SomaCsv.somarColuna(arquivo, 0));
  }

  @Test
  void arquivoQueNaoExisteDeixaAIOExceptionSubir() {
    Path inexistente = tempDir.resolve("nao-existe.csv");
    assertThrows(IOException.class, () -> SomaCsv.somarColuna(inexistente, 0));
  }

  @Test
  void arquivoNuloOuIndiceNegativoLancaIllegalArgumentException() {
    Path arquivo = tempDir.resolve("qualquer.csv");
    assertThrows(IllegalArgumentException.class, () -> SomaCsv.somarColuna(null, 0));
    assertThrows(IllegalArgumentException.class, () -> SomaCsv.somarColuna(arquivo, -1));
  }
}
