package challenges.m02.f20;

import java.util.TreeSet;

public final class ProximoOnibus {

  private ProximoOnibus() {}

  public static Integer proximoAPartirDe(TreeSet<Integer> horarios, int agora) {
    if (horarios == null) {
      throw new IllegalArgumentException("As listas de horários nao podem ser nulas");
    }
    return horarios.ceiling(agora);
  }

  public static Integer ultimoAntesDe(TreeSet<Integer> horarios, int agora) {
    if (horarios == null) {
      throw new IllegalArgumentException("As listas de horários nao podem ser nulas");
    }
    return horarios.floor(agora);
  }
}
