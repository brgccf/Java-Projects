package excecoes;

@SuppressWarnings("serial")
public class ProdutoExistenteException extends Exception{
	public ProdutoExistenteException() {
		super("Produto já existente!");
	}

}
