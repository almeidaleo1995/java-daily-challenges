package challenges.m02.f18;

import java.util.List;

public final class ProdutoMaisCaro {

  private ProdutoMaisCaro() {}

  public static String maisCaro(List<String> produtos, List<Double> precos) {
    if (produtos.isEmpty() || precos.isEmpty()) {
      throw new IllegalArgumentException("As listas nao podem estar vazias");
    }

    String produtoMaisCaro = null;
    Double precoMaisAlto = Double.MIN_VALUE;
    int tamanho = Math.min(produtos.size(), precos.size());

    for (int i = 0; i < tamanho; i++) {
      String produtoAtual = produtos.get(i);
      Double precoAtual = precos.get(i);

      if (precoAtual > precoMaisAlto) {
        precoMaisAlto = precoAtual;
        produtoMaisCaro = produtoAtual;
      }
    }

    return produtoMaisCaro;
  }
}
