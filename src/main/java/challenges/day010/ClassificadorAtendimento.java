package challenges.day010;

public final class ClassificadorAtendimento {

  public static String classificar(int idade, int horaAtual) {

    String faixaEtaria = idade >= 18 ? "adulto" : "menor";
    String turno = horaAtual >= 6 && horaAtual <= 18 ? "diurno" : "noturno";

    return faixaEtaria + " " + turno;
  }
}
