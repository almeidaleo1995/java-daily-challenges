package challenges.m01.f29;

import java.math.BigDecimal;
import java.util.Locale;

public final class EtiquetaFormatada {

  private EtiquetaFormatada() {}

  public static String etiqueta(String nomeProduto, BigDecimal preco) {
    if (nomeProduto == null || nomeProduto.isBlank()) {
      throw new IllegalArgumentException(
          "o nome do produto precisa ser diferente de null ou branco");
    }

    StringBuilder etiqueta = new StringBuilder();
    String espacoEmBranco = String.valueOf(' ');
    String precoFormatado = String.format(Locale.ROOT, "%8.2f", preco);
    int quantidade = Math.max(0, 20 - nomeProduto.length());

    etiqueta.append(nomeProduto);
    etiqueta.append(espacoEmBranco.repeat(quantidade));
    etiqueta.append(" R$ ");
    etiqueta.append(precoFormatado);

    return etiqueta.toString();
  }

  public static String linhaSeparadora(int largura) {
    StringBuilder linha = new StringBuilder();
    String traco = "-";

    if (largura <= 0) {
      throw new IllegalArgumentException("A largura tem que ser maior que 0");
    }

    return linha.append(traco.repeat(largura)).toString();
  }
}
