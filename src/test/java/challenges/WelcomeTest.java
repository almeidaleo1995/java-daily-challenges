package challenges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WelcomeTest {

  @Test
  void printsWelcomeMessage() {
    assertEquals("Ambiente pronto. Bons desafios!", Welcome.message());
  }
}
