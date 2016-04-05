package dados;

import locadora.Cliente;
import locadora.Produto;
import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

public interface RepositorioCliente {
	void inserir(Cliente cliente) throws ClienteExistenteException, RepositorioException;
	Cliente procurar(String cpf) throws ClienteNaoExistenteException;
	void atualizar(Cliente cliente) throws ClienteNaoExistenteException, RepositorioException;
	void remover(String cpf) throws ClienteNaoExistenteException, RepositorioException;
	void inserirProduto(String cpf, Produto produto) throws ProdutoExistenteException, RepositorioException;
	void removerProduto(String cpf, String nomeProduto) throws ProdutoNaoExistenteException, RepositorioException;
	boolean existe(String cpf);
}
