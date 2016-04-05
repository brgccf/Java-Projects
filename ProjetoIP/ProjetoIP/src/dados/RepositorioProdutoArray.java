package dados;

import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import locadora.Produto;

public class RepositorioProdutoArray implements RepositorioProduto {
	private Produto[] produtos;
	private int indice;

	public RepositorioProdutoArray() {
		this.produtos=new Produto[10];
		this.indice=0;
	}
	//inserindo produto no repositorio
	public void inserir(Produto produto) throws ProdutoExistenteException {
		//se n�o, verificamos se o array est� cheio. se sim, duplica-se seu tamanho.
		if(this.produtos[this.produtos.length-1] != null){
			Produto[] aux = new Produto [this.produtos.length*2];
			for (int i = 0; i < this.produtos.length; i++) {
				aux[i] = this.produtos[i];
			}
			this.produtos = aux;
		}
		this.produtos[this.indice]=produto;
		this.indice++;
	}

	//metodo para verificar se j� existe produto no repositorio
	public boolean existe(String nome) {

		boolean achou = false;

		for (int i = 0 ; !achou && i < this.produtos.length ; i++) {
			if (this.produtos[i]!=null) {
				if (this.produtos[i].getNome().equalsIgnoreCase(nome)) {
					achou = true;
				}
			}
		}

		return achou;
	}

	//metodo para procurar um produto espec�fico e retornar o objeto
	public Produto procurar(String nome) throws ProdutoNaoExistenteException {
		boolean achou = false;
		Produto produtoProcurado = null;
		//varre o array de objetos produtos e armazena na variavel que ser� retornada
		for (int i = 0;!achou && i < this.produtos.length; i++) {
			if (this.produtos[i]!=null) {
				if(this.produtos[i].getNome().equalsIgnoreCase(nome)){
					achou = true;
					produtoProcurado = this.produtos[i];
				}
			}
		}
		return produtoProcurado;
	}

	//metodo para atualizar informa�oes/ dados de um produto
	public void atualizar(Produto produto) throws ProdutoNaoExistenteException {
		if (this.existe(produto.getNome())) {
			for (int i = 0 ; i < this.produtos.length ; i++) {
				if (this.produtos[i]!=null) {
					if (this.produtos[i].getNome().equals(produto.getNome())) {
						this.produtos[i] = produto;
					}
				}
			}

		}
	}

	//metodo para remover produto do repositorio
	public void remover(String nome) throws ProdutoNaoExistenteException {
		boolean achou = false;
		//percorre o array de produtos, e ao encontrar, removemos
		for (int i = 0;!achou&&i < this.produtos.length; i++) {
			if (this.produtos[i]!=null) {
				if(this.produtos[i].getNome().equalsIgnoreCase(nome)){
					achou = true;
					this.produtos[i] = null;
					while (this.produtos[i+1]!=null&&this.produtos.length>i) {
						this.produtos[i]=this.produtos[i+1];
						i++;
					}
					this.indice--;
				}
			}
		}
	}
	public Produto[] getIterator() {
		return this.produtos;
	}
	public int getQnt() {
		int aux=0;
		for (int i=0;i<this.produtos.length;i++) {
			if (this.produtos[i]!=null) {
				aux++;
			}
		}
		return aux;
	}
}
