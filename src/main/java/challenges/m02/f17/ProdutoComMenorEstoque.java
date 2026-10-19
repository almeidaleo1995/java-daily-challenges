package challenges.m02.f17;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ProdutoComMenorEstoque {

  private ProdutoComMenorEstoque() {}

  public static String menorEstoque(LinkedHashMap<String, Integer> estoque) {
    if (estoque.isEmpty()) {
      throw new IllegalArgumentException("O estoque nao pode estar vazio");
    }

    int menorQtdItem = Integer.MAX_VALUE;
    String produtoMenorEstoque = null;

    for (Map.Entry<String, Integer> item : estoque.entrySet()) {
      String produto = item.getKey();
      int quantidade = item.getValue();

      if (quantidade < menorQtdItem) {
        menorQtdItem = quantidade;
        produtoMenorEstoque = produto;
      }
    }
    return produtoMenorEstoque;
  }
}
