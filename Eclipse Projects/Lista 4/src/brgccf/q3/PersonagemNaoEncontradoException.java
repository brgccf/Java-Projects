package brgccf.q3;

@SuppressWarnings("serial")
public class PersonagemNaoEncontradoException extends Exception{
	
	public PersonagemNaoEncontradoException(){
		super("O personagem que voc� escolheu n�o foi encontrado! Por favor, tente novamente:");
	}

}
