package challenges.m15.chefe;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

// Dado: não altere.
public record RelatorioDeAuditoria(
    Map<String, Integer> saldoPorProduto, BigDecimal totalVendido, List<String> inconsistencias) {}
