package brgccf.q3;

@SuppressWarnings("serial")
public class SessaoAbertaException extends Exception{
	
	public SessaoAbertaException (){
		super("Esta sess�o est� aberta! N�o � poss�vel realizar esta fun��o.");
	}

}
