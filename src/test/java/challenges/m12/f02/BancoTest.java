package challenges.m12.f02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class BancoTest {

  @Test
  void transferenciaUnicaMoveOValor() {
    Banco banco = new Banco(1000.0, 500.0);
    banco.transferirAparaB(200.0);
    assertEquals(800.0, banco.saldoA());
    assertEquals(700.0, banco.saldoB());
  }

  @Test
  void saldoInsuficienteLancaIllegalStateExceptionSemAlterarSaldos() {
    Banco banco = new Banco(100.0, 100.0);
    assertThrows(IllegalStateException.class, () -> banco.transferirAparaB(200.0));
    assertEquals(100.0, banco.saldoA());
    assertEquals(100.0, banco.saldoB());
  }

  @Test
  void transferenciasSimultaneasNosDoisSentidosPreservamOTotalSemDeadlock()
      throws InterruptedException {
    assertTimeoutPreemptively(
        Duration.ofSeconds(10),
        () -> {
          Banco banco = new Banco(10_000.0, 10_000.0);
          ExecutorService executor = Executors.newFixedThreadPool(20);
          for (int i = 0; i < 200; i++) {
            executor.submit(
                () -> {
                  try {
                    banco.transferirAparaB(1.0);
                  } catch (IllegalStateException ignorado) {
                    // saldo insuficiente no instante: não é o alvo deste teste
                  }
                });
            executor.submit(
                () -> {
                  try {
                    banco.transferirBparaA(1.0);
                  } catch (IllegalStateException ignorado) {
                    // saldo insuficiente no instante: não é o alvo deste teste
                  }
                });
          }
          executor.shutdown();
          executor.awaitTermination(9, TimeUnit.SECONDS);
          assertEquals(20_000.0, banco.saldoA() + banco.saldoB());
        });
  }
}
