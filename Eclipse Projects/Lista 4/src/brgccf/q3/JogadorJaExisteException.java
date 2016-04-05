package brgccf.q3;

@SuppressWarnings("serial")
public class JogadorJaExisteException extends Exception{
	
	public JogadorJaExisteException(){
		super("Este jogador/Mestre já existe em seu programa! ");
	}

}
