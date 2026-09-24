package challenges.m03.f05;

public interface Veiculo {
  int eixos();

  default double valorPedagio() {
    return eixos() * 5.0;
  }
}
