package challenges.m02.f21;

import java.util.Comparator;
import java.util.PriorityQueue;

public final class ProntoSocorro {

  private ProntoSocorro() {}

  public static PriorityQueue<Paciente> criarFila() {
    Comparator<Paciente> regraPrioridade =
        Comparator.comparing(Paciente::gravidade).reversed().thenComparing(Paciente::ordemChegada);
    return new PriorityQueue<>(regraPrioridade);
  }
}
