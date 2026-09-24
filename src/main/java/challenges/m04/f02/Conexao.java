package challenges.m04.f02;

import java.util.List;

// Dado: não altere.
public final class Conexao implements AutoCloseable {

  private final List<String> log;
  private boolean aberta = true;

  public Conexao(List<String> log) {
    this.log = log;
    log.add("aberta");
  }

  public void executar(String comando) {
    if (!aberta) {
      throw new IllegalStateException("conexão fechada");
    }
    if ("FALHA".equals(comando)) {
      throw new RuntimeException("comando falhou");
    }
    log.add("executado:" + comando);
  }

  @Override
  public void close() {
    aberta = false;
    log.add("fechada");
  }
}
