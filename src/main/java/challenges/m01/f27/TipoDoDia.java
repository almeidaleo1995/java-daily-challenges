package challenges.m01.f27;

import java.time.DayOfWeek;

public final class TipoDoDia {

  private TipoDoDia() {}

  public static String classificar(DayOfWeek dia) {
    return switch (dia) {
      case MONDAY -> "Início de semana";
      case FRIDAY -> "Sexta";
      case SATURDAY, SUNDAY -> "Fim de semana";
      default -> "Meio de semana";
    };
  }
}
