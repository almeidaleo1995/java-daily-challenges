package challenges.day001;

public final class Classificador {

  private Classificador() {}

  public static String classificar(int numero) {

    String sinal = numero > 0 ? "positivo" : "negativo";
    String paridade = numero % 2 == 0 ? "par" : "ímpar";

    return numero == 0 ? "zero" : sinal + " " + paridade;
  }
}
