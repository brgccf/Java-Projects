package brgccf.q1;

@SuppressWarnings("serial")
public class JogadorNaoEncontradoException extends Exception {
	
	public JogadorNaoEncontradoException(){
		super("O jogador digitado n�o foi encontrado! Tente novamente, digite o login do jogador:");
	}
}
