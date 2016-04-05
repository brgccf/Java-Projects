package iterator;

import locadora.Produto;
import dados.RepositorioProdutoLista;

public class IteratorProdutoLista implements IteratorProduto {
	private RepositorioProdutoLista rep;	
	
	public IteratorProdutoLista(RepositorioProdutoLista rep) {
		this.rep = rep;
	}
	public boolean hasNext() {
		boolean aux = false;
		if (this.rep.getProx()!=null) {
			aux=true;
		}
		return aux;
	}

	public Produto next() {
		Produto aux = this.rep.getProduto();
		this.rep=this.rep.getProx();
		return aux;
	}

}
