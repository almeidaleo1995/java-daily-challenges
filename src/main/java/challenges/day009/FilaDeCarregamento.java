package challenges.day009;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class FilaDeCarregamento {

  private FilaDeCarregamento() {}

  public static List<String> reordenar(List<String> pacotes, int primeiros) {

    if (primeiros < 0 || primeiros > pacotes.size()) {
      throw new IllegalArgumentException("primeiros deve estar entre 0 e o tamanho da lista");
    }

    Deque<String> pilhaInvertida = new ArrayDeque<>();
    Deque<String> filaOrdenada = new ArrayDeque<>();

    int posicao = 0;
    for (String pacote : pacotes) {
      if (posicao < primeiros) {
        pilhaInvertida.push(pacote);
      } else {
        filaOrdenada.offer(pacote);
      }
      posicao++;
    }

    List<String> resultado = new ArrayList<>();

    while (!pilhaInvertida.isEmpty()) {
      resultado.add(pilhaInvertida.pop());
    }

    while (!filaOrdenada.isEmpty()) {
      resultado.add(filaOrdenada.poll());
    }

    return resultado;
  }
}
