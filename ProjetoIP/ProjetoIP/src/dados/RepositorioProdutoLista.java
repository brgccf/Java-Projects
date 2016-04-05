package dados;

import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import locadora.Produto;

public class RepositorioProdutoLista implements RepositorioProduto {
	private Produto produto;
	private RepositorioProdutoLista prox;

	public RepositorioProdutoLista() {
		this.produto=null;
		this.prox=null;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public RepositorioProdutoLista getProx() {
		return prox;
	}
	public void setProx(RepositorioProdutoLista prox) {
		this.prox = prox;
	}
	public void inserir(Produto produto) throws ProdutoExistenteException {
		if (this.produto==null) {
			this.produto=produto;
			this.prox=new RepositorioProdutoLista();
		} else {
			this.prox.inserir(produto);
		}
	}
	public boolean existe(String nome) {
		boolean aux = false;
		if (this.produto!=null) {
			if (this.produto.getNome().equals(nome)) {
				aux=true;
			} else {
				aux=this.prox.existe(nome);
			}
		}
		return aux;
	}
	public Produto procurar(String nome) throws ProdutoNaoExistenteException {
		Produto aux = null;
		if (this.produto!=null) {
			if (this.produto.getNome().equalsIgnoreCase(nome)) {
				aux=this.produto;
			} else {
				aux=this.prox.procurar(nome);
			}
		}
		return aux;
	}
	public void atualizar(Produto produto) throws ProdutoNaoExistenteException {
		if (this.produto!=null) {
			if (this.produto.getNome().equals(produto.getNome())) {
				this.produto=produto;
			} else {
				this.prox.atualizar(produto);
			}
		}
	}
	public void remover(String nome) throws ProdutoNaoExistenteException {
		if (this.produto!=null) {
			if (this.produto.getNome().equalsIgnoreCase(nome)) {
				this.produto=this.prox.produto;
				this.prox=this.prox.prox;
			} else {
				this.prox.remover(nome);
			}
		}
	}
	
	public RepositorioProdutoLista getIterator() {
		return this;
	}

}
