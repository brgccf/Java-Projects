package excecoes;

@SuppressWarnings("serial")
public class ProdutoNaoExistenteException extends Exception {
	public ProdutoNaoExistenteException() {
		super("Produto n�o encontrado!");
	}	
}
