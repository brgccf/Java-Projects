package excecoes;

@SuppressWarnings("serial")
public class ProdutoAlugadoException extends Exception {

	public ProdutoAlugadoException() {
		super("Produto alugado no momento!");
	}
	
}
