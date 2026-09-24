package challenges.m14.f05;

import java.time.LocalDate;

// Dado: não altere.
// Versão acoplada, só pra referência: LocalDate.now() sem parâmetro não dá pra
// controlar em teste, então esta classe não tem um teste determinístico possível.
public final class GeradorDeBoletoAcoplado {

  public String gerar(String cliente, double valor) {
    LocalDate hoje = LocalDate.now();
    LocalDate vencimento = hoje.plusDays(30);
    return cliente + "|" + valor + "|" + vencimento;
  }
}
