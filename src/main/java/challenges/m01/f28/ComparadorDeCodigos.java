package challenges.m01.f28;

import java.util.Objects;

public final class ComparadorDeCodigos {

  private ComparadorDeCodigos() {}

  public static boolean saoEquivalentes(String codigoA, String codigoB) {
    if (codigoA != null && codigoB != null) {
      codigoA = codigoA.trim();
      codigoB = codigoB.trim();
      return codigoA.equalsIgnoreCase(codigoB);
    }

    return Objects.equals(codigoA, codigoB);
  }
}
