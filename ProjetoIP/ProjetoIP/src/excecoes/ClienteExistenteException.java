package excecoes;

@SuppressWarnings("serial")
public class ClienteExistenteException extends Exception {
	public ClienteExistenteException() {
		super("Cliente j� existente!");
	}
}
