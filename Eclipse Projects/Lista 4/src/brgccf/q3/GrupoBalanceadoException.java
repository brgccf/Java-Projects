package brgccf.q3;

@SuppressWarnings("serial")
public class GrupoBalanceadoException extends Exception {
	
	public GrupoBalanceadoException(){
		super("O grupo desta sess�o � balanceado! N�o h� personagem de maior n�vel.");
		
	}

}
