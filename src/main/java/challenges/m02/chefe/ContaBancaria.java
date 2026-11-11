package challenges.m02.chefe;

import java.util.*;

public final class ContaBancaria {

  private final String titular;
  private double saldoAtual;
  private final Deque<Operacao> operacoes = new ArrayDeque<>();
  private final Map<String, Integer> contagemPorTipo = new HashMap<>();

  public ContaBancaria(String titular, double saldoInicial) {
    if (titular == null || titular.isBlank() || saldoInicial < 0) {
      throw new IllegalArgumentException("valores inválidos");
    }
    this.titular = titular;
    this.saldoAtual = saldoInicial;
  }

  public String getTitular() {
    return titular;
  }

  public double getSaldo() {
    return saldoAtual;
  }

  public void depositar(double valor) {
    if (valor <= 0) {
      throw new IllegalArgumentException("o valor para operação tem que ser um valor positivo");
    }
    operacoes.push(new Operacao("DEPOSITO", valor));
    contagemPorTipo.put("DEPOSITO", contagemPorTipo.getOrDefault("DEPOSITO", 0) + 1);
    saldoAtual += valor;
  }

  public void sacar(double valor) {
    if (valor <= 0) {
      throw new IllegalArgumentException("o valor para operação tem que ser um valor positivo");
    }
    if (valor > saldoAtual) {
      throw new IllegalArgumentException("saldo insuficiente");
    }
    operacoes.push(new Operacao("SAQUE", valor));
    contagemPorTipo.put("SAQUE", contagemPorTipo.getOrDefault("SAQUE", 0) + 1);
    saldoAtual -= valor;
  }

  public void desfazerUltimaOperacao() {
    if (getOperacoes().isEmpty()) {
      throw new IllegalStateException("Nenhuma operacao para desfazer.");
    }
    Operacao ultimaOperacao = getOperacoes().pop();
    if (ultimaOperacao.tipo.equalsIgnoreCase("DEPOSITO")) {
      saldoAtual -= ultimaOperacao.valor;
      contagemPorTipo.computeIfPresent("DEPOSITO", (k, valorAtual) -> Math.max(0, valorAtual - 1));

    } else if (ultimaOperacao.tipo.equalsIgnoreCase("SAQUE")) {
      saldoAtual += ultimaOperacao.valor;
      contagemPorTipo.computeIfPresent("SAQUE", (k, valorAtual) -> Math.max(0, valorAtual - 1));
    }
  }

  public String extrato() {
    StringBuilder sb = new StringBuilder();

    for (Operacao operacao : getOperacoes()) {
      sb.append(operacao.tipo());
      sb.append(" ");
      sb.append(operacao.valor());
      sb.append("\n");
    }

    return sb.toString().trim();
  }

  public int quantidadeDeOperacoes(String tipo) {
    if (tipo == null) {
      return getOperacoes().size();
    }
    return contagemPorTipo.getOrDefault(tipo, 0);
  }

  private Deque<Operacao> getOperacoes() {
    return this.operacoes;
  }

  public record Operacao(String tipo, double valor) {}
}
