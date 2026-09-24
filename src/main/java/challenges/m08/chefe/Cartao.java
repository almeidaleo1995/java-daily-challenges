package challenges.m08.chefe;

import java.math.BigDecimal;

// Dado: não altere.
public record Cartao(BigDecimal valor, int parcelas) implements Pagamento {}
