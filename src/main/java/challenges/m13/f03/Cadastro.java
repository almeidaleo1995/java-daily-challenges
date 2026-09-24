package challenges.m13.f03;

// Dado: não altere.
public final class Cadastro {
  @Obrigatorio private String nome;
  @Obrigatorio private String email;
  private String apelido;

  public Cadastro(String nome, String email, String apelido) {
    this.nome = nome;
    this.email = email;
    this.apelido = apelido;
  }
}
