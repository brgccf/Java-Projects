package brgccf.q3;

@SuppressWarnings("serial")
public class SessaoJaExisteException extends Exception{
	
	public SessaoJaExisteException(){
		super("Esta sessão já existe em seu repositório! ");
	}

}
