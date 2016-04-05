package brgccf.q3;

@SuppressWarnings("serial")
public class PersonagemSendoUtilizadoException extends Exception{
	
	public PersonagemSendoUtilizadoException(){
		super("Este personagem já está sendo utilizado! Por favor, selecione outro. Digite um nome de personagem: ");
		
	}

}
