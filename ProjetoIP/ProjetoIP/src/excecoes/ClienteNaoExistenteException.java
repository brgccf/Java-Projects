package excecoes;

@SuppressWarnings("serial")
public class ClienteNaoExistenteException extends Exception {
	public ClienteNaoExistenteException() {
		super("Cliente n�o existente!");
	}
}
