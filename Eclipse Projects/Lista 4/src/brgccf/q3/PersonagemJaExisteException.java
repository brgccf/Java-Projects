package brgccf.q3;

@SuppressWarnings("serial")
public class PersonagemJaExisteException extends Exception {
	
	public PersonagemJaExisteException(){
		super("Este personagem já existe em seu repositório! ");
	}
}
