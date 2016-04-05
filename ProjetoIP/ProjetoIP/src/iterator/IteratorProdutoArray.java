package iterator;

import locadora.Produto;

public class IteratorProdutoArray implements IteratorProduto {
	private Produto[] produtos;
	private int indice=0;
	
	public IteratorProdutoArray(Produto[] produtos) {
		this.produtos = produtos;
	}
	
	public boolean hasNext() {
		return this.produtos[indice]!=null&&indice<this.produtos.length;
	}
	
	public Produto next() {
		Produto resposta = produtos[indice];
		this.indice = this.indice + 1;
		return resposta;
	}
}
