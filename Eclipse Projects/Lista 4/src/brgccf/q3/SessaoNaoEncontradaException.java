package brgccf.q3;

@SuppressWarnings("serial")
public class SessaoNaoEncontradaException extends Exception{
	
	public SessaoNaoEncontradaException(){
		super("A sessão não foi encontrada! ");
	}

}
