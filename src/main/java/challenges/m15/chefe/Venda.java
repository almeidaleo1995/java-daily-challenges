package challenges.m15.chefe;

import java.math.BigDecimal;

// Dado: não altere.
public record Venda(String produto, int quantidade, BigDecimal valorUnitario)
    implements EventoDeEstoque {}
