package brgccf.q3;

@SuppressWarnings("serial")
public class SessaoJaExisteException extends Exception{
	
	public SessaoJaExisteException(){
		super("Esta sess�o j� existe em seu reposit�rio! ");
	}

}
