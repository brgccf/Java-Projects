package brgccf.q1;

@SuppressWarnings("serial")
public class PersonagemSendoUtilizadoException extends Exception{
	
	public PersonagemSendoUtilizadoException(){
		super("Este personagem j� est� sendo utilizado! Por favor, selecione outro. Digite um nome de personagem: ");
		
	}

}
