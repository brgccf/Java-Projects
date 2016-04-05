package dados;

import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;
import locadora.Produto;

public interface RepositorioProduto {
	void inserir(Produto produto) throws ProdutoExistenteException, RepositorioException;
	Produto procurar(String nome) throws ProdutoNaoExistenteException;
	void atualizar(Produto produto) throws ProdutoNaoExistenteException, RepositorioException;
	void remover(String nome) throws ProdutoNaoExistenteException, RepositorioException;
	boolean existe(String nome);
}
