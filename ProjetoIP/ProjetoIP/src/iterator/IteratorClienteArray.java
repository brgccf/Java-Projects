package iterator;

import locadora.Cliente;

public class IteratorClienteArray implements IteratorCliente {
	private Cliente[] clientes;
	private int indice=0;
	
	public IteratorClienteArray(Cliente[] clientes) {
		this.clientes = clientes;
	}
	
	public boolean hasNext() {
		return this.clientes[indice]!=null&&indice<this.clientes.length;
	}
	public Cliente next() {
		Cliente resposta = clientes[indice];
		this.indice = this.indice + 1;
		return resposta;
	}
}
