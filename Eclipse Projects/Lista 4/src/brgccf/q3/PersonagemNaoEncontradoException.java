package brgccf.q3;

@SuppressWarnings("serial")
public class PersonagemNaoEncontradoException extends Exception{
	
	public PersonagemNaoEncontradoException(){
		super("O personagem que você escolheu não foi encontrado! Por favor, tente novamente:");
	}

}
