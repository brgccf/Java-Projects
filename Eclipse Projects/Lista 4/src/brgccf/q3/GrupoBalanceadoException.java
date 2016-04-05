package brgccf.q3;

@SuppressWarnings("serial")
public class GrupoBalanceadoException extends Exception {
	
	public GrupoBalanceadoException(){
		super("O grupo desta sessão é balanceado! Não há personagem de maior nível.");
		
	}

}
