package challenges;

public final class Welcome {

  private Welcome() {}

  public static String message() {
    return "Ambiente pronto. Bons desafios!";
  }

  public static void main(String[] args) {
    System.out.println(message());
  }
}
