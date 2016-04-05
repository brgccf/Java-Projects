package brgccf.q3;

@SuppressWarnings("serial")
public class SessaoAbertaException extends Exception{
	
	public SessaoAbertaException (){
		super("Esta sessão está aberta! Não é possível realizar esta função.");
	}

}
