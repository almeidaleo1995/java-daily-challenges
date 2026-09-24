package challenges.m02.f08;

import java.util.ArrayDeque;
import java.util.Deque;

public final class ParentesesBalanceados {
  private ParentesesBalanceados() {}

  public static boolean balanceado(String expressao) {

    Deque<Character> pilhaAbrindo = new ArrayDeque<>();
    for (int i = 0; i < expressao.length(); i++) {
      char c = expressao.charAt(i);
      if (c == '(') {
        pilhaAbrindo.push(c);
      } else if (c == ')') {
        if (pilhaAbrindo.isEmpty()) {
          return false;
        }
        pilhaAbrindo.pop();
      }
    }

    return pilhaAbrindo.isEmpty();
  }
}
