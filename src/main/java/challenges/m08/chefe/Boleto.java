package challenges.m08.chefe;

import java.math.BigDecimal;

// Dado: não altere.
public record Boleto(BigDecimal valor, int diasParaVencer) implements Pagamento {}
