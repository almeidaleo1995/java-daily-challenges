package challenges.day019;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContaBancariaTest {

  @Test
  void construtorGuardaTitularESaldoSemRegistrarOperacao() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    assertEquals("Ana", conta.getTitular());
    assertEquals(100.0, conta.getSaldo());
    assertEquals("", conta.extrato());
    assertEquals(0, conta.quantidadeDeOperacoes("DEPOSITO"));
  }

  @Test
  void depositarAtualizaSaldoExtratoEContagem() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.depositar(50.0);
    assertEquals(150.0, conta.getSaldo());
    assertEquals("DEPOSITO 50.0", conta.extrato());
    assertEquals(1, conta.quantidadeDeOperacoes("DEPOSITO"));
  }

  @Test
  void sacarAtualizaSaldoExtratoEContagem() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.sacar(30.0);
    assertEquals(70.0, conta.getSaldo());
    assertEquals("SAQUE 30.0", conta.extrato());
    assertEquals(1, conta.quantidadeDeOperacoes("SAQUE"));
  }

  @Test
  void extratoListaDaMaisRecenteParaAMaisAntiga() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.depositar(50.0);
    conta.sacar(30.0);
    assertEquals("SAQUE 30.0\nDEPOSITO 50.0", conta.extrato());
  }

  @Test
  void desfazerDepositoRevertaSaldoExtratoEContagem() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.depositar(50.0);
    conta.desfazerUltimaOperacao();
    assertEquals(100.0, conta.getSaldo());
    assertEquals("", conta.extrato());
    assertEquals(0, conta.quantidadeDeOperacoes("DEPOSITO"));
  }

  @Test
  void desfazerSaqueRevertaSaldoExtratoEContagem() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.sacar(30.0);
    conta.desfazerUltimaOperacao();
    assertEquals(100.0, conta.getSaldo());
    assertEquals("", conta.extrato());
    assertEquals(0, conta.quantidadeDeOperacoes("SAQUE"));
  }

  @Test
  void desfazerSoAfetaAOperacaoMaisRecente() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.depositar(50.0);
    conta.sacar(30.0);
    conta.desfazerUltimaOperacao();
    assertEquals(150.0, conta.getSaldo());
    assertEquals("DEPOSITO 50.0", conta.extrato());
    assertEquals(0, conta.quantidadeDeOperacoes("SAQUE"));
    assertEquals(1, conta.quantidadeDeOperacoes("DEPOSITO"));
  }

  @Test
  void desfazerSemOperacoesLancaExcecaoDeEstado() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    assertThrows(IllegalStateException.class, conta::desfazerUltimaOperacao);
  }

  @Test
  void desfazerDuasVezesSeguidasEsvaziaOHistorico() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    conta.depositar(50.0);
    conta.sacar(30.0);
    conta.desfazerUltimaOperacao();
    conta.desfazerUltimaOperacao();
    assertEquals(100.0, conta.getSaldo());
    assertEquals("", conta.extrato());
    assertThrows(IllegalStateException.class, conta::desfazerUltimaOperacao);
  }

  @Test
  void sacarMaisQueOSaldoNaoAlteraNada() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    assertThrows(IllegalArgumentException.class, () -> conta.sacar(1000.0));
    assertEquals(100.0, conta.getSaldo());
    assertEquals("", conta.extrato());
  }

  @Test
  void valoresInvalidosLancamExcecaoSemAlterarNada() {
    ContaBancaria conta = new ContaBancaria("Ana", 100.0);
    assertThrows(IllegalArgumentException.class, () -> conta.depositar(0.0));
    assertThrows(IllegalArgumentException.class, () -> conta.depositar(-10.0));
    assertThrows(IllegalArgumentException.class, () -> conta.sacar(0.0));
    assertThrows(IllegalArgumentException.class, () -> conta.sacar(-10.0));
    assertEquals(100.0, conta.getSaldo());
    assertEquals("", conta.extrato());
  }

  @Test
  void titularNuloOuEmBrancoLancaExcecao() {
    assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null, 100.0));
    assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("   ", 100.0));
  }

  @Test
  void saldoInicialNegativoLancaExcecao() {
    assertThrows(IllegalArgumentException.class, () -> new ContaBancaria("Ana", -10.0));
  }
}
