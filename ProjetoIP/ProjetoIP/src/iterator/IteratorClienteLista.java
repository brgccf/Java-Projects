package iterator;

import locadora.Cliente;
import dados.RepositorioClienteLista;

public class IteratorClienteLista implements IteratorCliente {
	private RepositorioClienteLista rep;
	
	public IteratorClienteLista(RepositorioClienteLista rep) {
		this.rep = rep;
	}

	public boolean hasNext() {
		boolean aux = false;
		if (this.rep.getProx()!=null) {
			aux=true;
		}
		return aux;
	}

	public Cliente next() {
		Cliente aux = this.rep.getCliente();
		this.rep=this.rep.getProx();
		return aux;
	}

}
