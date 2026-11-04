package challenges.m02.f23;

import java.util.List;

public final class Congelador {

  private Congelador() {}

  public static List<Integer> congelar(List<Integer> original) {

    if (original == null) {
      throw new IllegalArgumentException("A lista original nao pode ser nula");
    }

    return List.copyOf(original);
  }
}
