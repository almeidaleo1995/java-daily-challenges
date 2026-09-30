package challenges.m01.f25;

public final class PlacarSeguro {

  private PlacarSeguro() {}

  public static int somarPontos(int pontosAtuais, int pontosGanhos) {

    int resultado = Math.addExact(pontosAtuais, pontosGanhos);

    return resultado;
  }
}
