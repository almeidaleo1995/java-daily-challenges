package challenges.m01.chefe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Locale;

public final class CupomFiscal {

  private CupomFiscal() {}

  public static String gerar(List<String> linhasDeItens) {
    if (linhasDeItens == null || linhasDeItens.isEmpty()) {
      throw new IllegalArgumentException("A lista nunca pode ser vazia ou nula");
    }

    StringBuilder recibo = new StringBuilder();

    String etiquetaFormatada = null;
    BigDecimal total = new BigDecimal("0.00");
    for (String linha : linhasDeItens) {
      String[] dadosDoItem = linha.split(";");
      if (dadosDoItem.length < 4) {
        throw new IllegalArgumentException("A lista  tem que conter no mínimo 4 campos");
      }
      String nome = dadosDoItem[0];
      BigDecimal percentualDesconto = percentualDesconto(dadosDoItem[3]);
      Integer quantidade = Integer.valueOf(dadosDoItem[1]);
      if (quantidade <= 0)
        throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
      BigDecimal preco = new BigDecimal(dadosDoItem[2]);
      BigDecimal subTotal = precoDoProduto(quantidade, preco, percentualDesconto);
      total = total.add(subTotal);
      etiquetaFormatada = etiqueta(nome, quantidade, subTotal);
      recibo.append(etiquetaFormatada);
    }

    recibo.append("\n");
    recibo.append("TOTAL: R$ ");
    recibo.append(total);

    return recibo.toString();
  }

  public static String etiqueta(String nome, Integer quantidade, BigDecimal subTotal) {
    StringBuilder etiqueta = new StringBuilder();
    String espacoEmBranco = String.valueOf(' ');
    String precoFormatado = String.format(Locale.ROOT, "%8.2f", subTotal);
    int quantidadeColunas = Math.max(0, 15 - nome.length());

    etiqueta.append(nome);
    etiqueta.append(espacoEmBranco.repeat(quantidadeColunas));
    etiqueta.append("x");
    etiqueta.append(quantidade);
    etiqueta.append(espacoEmBranco.repeat(2));
    etiqueta.append(" R$ ");
    etiqueta.append(precoFormatado);

    return etiqueta.toString();
  }

  public static BigDecimal percentualDesconto(String tipoDoDesconto) {
    return switch (tipoDoDesconto) {
      case "A" -> new BigDecimal("0.00");
      case "B" -> new BigDecimal("0.05");
      case "C" -> new BigDecimal("0.10");
      default ->
          throw new IllegalArgumentException("O tipo de desconto tem que ser um valor valido");
    };
  }

  public static BigDecimal precoDoProduto(
      Integer quantidade, BigDecimal preco, BigDecimal percentualDesconto) {
    if (!(preco.compareTo(BigDecimal.ZERO) > 0)) {
      throw new IllegalArgumentException("o preço tem que ser maior que zero");
    }

    BigDecimal totalBruto = preco.multiply(BigDecimal.valueOf(quantidade));
    BigDecimal desconto = totalBruto.multiply(percentualDesconto);

    return totalBruto.subtract(desconto).setScale(2, RoundingMode.HALF_EVEN);
  }
}
