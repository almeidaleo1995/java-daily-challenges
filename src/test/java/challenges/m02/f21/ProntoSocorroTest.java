package challenges.m02.f21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class ProntoSocorroTest {

  @Test
  void poliRetornaPacienteDeMaiorGravidadePrimeiro() {
    PriorityQueue<Paciente> fila = ProntoSocorro.criarFila();
    fila.add(new Paciente("Ana", 3, 1));
    fila.add(new Paciente("Bia", 5, 2));

    assertEquals("Bia", fila.poll().nome());
    assertEquals("Ana", fila.poll().nome());
  }

  @Test
  void empateNaGravidadeDesempataPorOrdemDeChegada() {
    PriorityQueue<Paciente> fila = ProntoSocorro.criarFila();
    fila.add(new Paciente("Caio", 5, 3));
    fila.add(new Paciente("Bia", 5, 2));

    assertEquals("Bia", fila.poll().nome());
    assertEquals("Caio", fila.poll().nome());
  }

  @Test
  void insercaoForaDeOrdemNaoAfetaAOrdemDeSaida() {
    PriorityQueue<Paciente> fila = ProntoSocorro.criarFila();
    fila.add(new Paciente("Ana", 3, 1));
    fila.add(new Paciente("Bia", 5, 2));
    fila.add(new Paciente("Caio", 5, 3));

    assertEquals("Bia", fila.poll().nome());
    assertEquals("Caio", fila.poll().nome());
    assertEquals("Ana", fila.poll().nome());
  }

  @Test
  void filaVaziaDevolveNuloAoRetirar() {
    PriorityQueue<Paciente> fila = ProntoSocorro.criarFila();
    assertNull(fila.poll());
  }
}
