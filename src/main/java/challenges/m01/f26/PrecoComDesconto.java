package challenges.m01.f26;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class PrecoComDesconto {

  private PrecoComDesconto() {}

  public static BigDecimal aplicarDesconto(BigDecimal preco, BigDecimal percentualDesconto) {
    BigDecimal cem = new BigDecimal("100");
    if (preco == null || percentualDesconto == null) {
      throw new IllegalArgumentException("os valores nao podem ser nulos");
    }

    if (preco.signum() < 0
        || (percentualDesconto.compareTo(BigDecimal.ZERO) < 0
            || percentualDesconto.compareTo(cem) > 0)) {
      throw new IllegalArgumentException(
          "o preço nao pode ser negativo ou o percentual é invalido quando ele é que 0% ou maior que 100%");
    }

    BigDecimal percentual = percentualDesconto.divide(cem);
    BigDecimal desconto = preco.multiply(percentual);

    return preco.subtract(desconto).setScale(2, RoundingMode.HALF_EVEN);
  }
}
