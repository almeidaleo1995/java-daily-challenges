package challenges.m06.chefe;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public final class MotorDePromocoes {

  private MotorDePromocoes() {}

  public static BigDecimal aplicarPromocoes(
      BigDecimal precoOriginal,
      List<Function<BigDecimal, BigDecimal>> promocoes,
      Optional<Cupom> cupom) {
    throw new UnsupportedOperationException("TODO: implementar");
  }
}
