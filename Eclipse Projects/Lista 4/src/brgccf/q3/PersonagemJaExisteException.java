package brgccf.q3;

@SuppressWarnings("serial")
public class PersonagemJaExisteException extends Exception {
	
	public PersonagemJaExisteException(){
		super("Este personagem j� existe em seu reposit�rio! ");
	}
}
