package brgccf.q3;

@SuppressWarnings("serial")
public class MestreNaoEncontradoException extends Exception{
	
	public MestreNaoEncontradoException(){
		super("O mestre digitado n�o foi encontrado! Tente novamente. Digite o login do mestre da sess�o:");
	}

}
