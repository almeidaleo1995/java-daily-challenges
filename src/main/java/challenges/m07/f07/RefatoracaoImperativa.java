package challenges.m07.f07;

import java.util.List;

// Dado: não altere. Código de referência a refatorar.
public final class RefatoracaoImperativa {

  private RefatoracaoImperativa() {}

  public static int somaDosQuadradosDosPares(List<Integer> numeros) {
    int soma = 0;
    for (int n : numeros) {
      if (n % 2 == 0) {
        soma += n * n;
      }
    }
    return soma;
  }
}
