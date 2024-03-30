package br.com.banco.domain.exception;

public class ContaNaoEncontrada extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ContaNaoEncontrada(String mensagem) {
    super(mensagem);
  }

  public ContaNaoEncontrada(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}
