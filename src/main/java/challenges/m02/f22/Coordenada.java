package challenges.m02.f22;

import java.util.Objects;

public final class Coordenada {
  private final int x;
  private final int y;

  public Coordenada(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object outro) {
    if (outro instanceof Coordenada coordenada) {
      return coordenada.getX() == x && coordenada.getY() == y;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getX(), getY());
  }
}
