package challenges.m06.chefe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class MotorDePromocoesTest {

  @Test
  void aplicaPromocaoDepoisCupomSobreOValorJaPromocionado() {
    BigDecimal resultado =
        MotorDePromocoes.aplicarPromocoes(
            new BigDecimal("100.00"),
            List.of(p -> p.multiply(new BigDecimal("0.9"))),
            Optional.of(new Cupom("PROMO10", new BigDecimal("0.10"))));

    assertEquals(0, new BigDecimal("81.00").compareTo(resultado));
  }

  @Test
  void semPromocoesNemCupomDevolveOPrecoOriginalComEscalaDois() {
    BigDecimal resultado =
        MotorDePromocoes.aplicarPromocoes(new BigDecimal("50.00"), List.of(), Optional.empty());

    assertEquals(0, new BigDecimal("50.00").compareTo(resultado));
  }

  @Test
  void resultadoNegativoEArredondadoParaZero() {
    BigDecimal resultado =
        MotorDePromocoes.aplicarPromocoes(
            new BigDecimal("10.00"),
            List.of(p -> p.subtract(new BigDecimal("15.00"))),
            Optional.empty());

    assertEquals(0, BigDecimal.ZERO.compareTo(resultado));
  }

  @Test
  void aplicaVariasPromocoesNaOrdemDaLista() {
    BigDecimal resultado =
        MotorDePromocoes.aplicarPromocoes(
            new BigDecimal("100.00"),
            List.of(
                p -> p.subtract(new BigDecimal("10.00")), p -> p.multiply(new BigDecimal("0.5"))),
            Optional.empty());

    assertEquals(0, new BigDecimal("45.00").compareTo(resultado));
  }

  @Test
  void cupomSozinhoSemNenhumaPromocaoDescontaSobreOPrecoOriginal() {
    BigDecimal resultado =
        MotorDePromocoes.aplicarPromocoes(
            new BigDecimal("100.00"),
            List.of(),
            Optional.of(new Cupom("SOZINHO", new BigDecimal("0.10"))));

    assertEquals(0, new BigDecimal("90.00").compareTo(resultado));
  }

  @Test
  void arredondamentoFinalUsaHalfEvenEmEmpateExato() {
    BigDecimal resultado =
        MotorDePromocoes.aplicarPromocoes(new BigDecimal("2.485"), List.of(), Optional.empty());

    assertEquals(0, new BigDecimal("2.48").compareTo(resultado));
  }

  @Test
  void argumentosNulosLancamIllegalArgumentException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> MotorDePromocoes.aplicarPromocoes(null, List.of(), Optional.empty()));
    assertThrows(
        IllegalArgumentException.class,
        () -> MotorDePromocoes.aplicarPromocoes(BigDecimal.TEN, null, Optional.empty()));
    assertThrows(
        IllegalArgumentException.class,
        () -> MotorDePromocoes.aplicarPromocoes(BigDecimal.TEN, List.of(), null));
  }
}
