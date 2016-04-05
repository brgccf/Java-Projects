package negocio;

import locadora.Produto;
import dados.RepositorioProduto;
import excecoes.ProdutoAlugadoException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

public class NegocioProdutos {
	
	private RepositorioProduto produtos;
	
	public NegocioProdutos(RepositorioProduto rep){
		this.produtos = rep;
	}
	//os metodos funcionam da mesma forma que nos repositorios, porem lançam exceçoes
	
	public void inserirProduto(Produto produto) throws ProdutoExistenteException, RepositorioException{
		boolean existe = this.produtos.existe(produto.getNome());
		if(existe){
			throw new ProdutoExistenteException();
		}
		this.produtos.inserir(produto);
		
	}
	
	public Produto procurarProduto(String nome) throws ProdutoNaoExistenteException{
		Produto produtoProcurado = this.produtos.procurar(nome);
		if(produtoProcurado == null){
			throw new ProdutoNaoExistenteException();
		}
		return produtoProcurado;
	}
	
	public void atualizar(Produto produto) throws ProdutoNaoExistenteException, RepositorioException{
		boolean existe = this.produtos.existe(produto.getNome());
		if(!existe){
			throw new ProdutoNaoExistenteException();
		}
		this.produtos.atualizar(produto);
	}
	
	public void remover(String nome) throws ProdutoNaoExistenteException, RepositorioException, ProdutoAlugadoException {
		if(!this.produtos.existe(nome)){
			throw new ProdutoNaoExistenteException();
		} else if (this.produtos.procurar(nome).getAlugado()) {
			throw new ProdutoAlugadoException();
		}
		this.produtos.remover(nome);
	}
	

}
