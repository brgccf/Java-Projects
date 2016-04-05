package negocio;

import locadora.Cliente;
import dados.RepositorioCliente;
import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.RepositorioException;

public class NegocioClientes {
	
	private RepositorioCliente clientes;
	
	public NegocioClientes (RepositorioCliente rep){
		this.clientes = rep;
	}
	
	public void inserir(Cliente cliente) throws ClienteExistenteException, RepositorioException{
		if(this.clientes.existe(cliente.getCpf())){
			throw new ClienteExistenteException();
		}
		this.clientes.inserir(cliente);
	}
	
	public Cliente procurar(String cpf) throws ClienteNaoExistenteException{
		Cliente clienteProcurado = this.clientes.procurar(cpf);
		if(clienteProcurado == null){
			throw new ClienteNaoExistenteException();
		}
		return clienteProcurado;
	}
	
	public void atualizar(Cliente cliente) throws ClienteNaoExistenteException, RepositorioException{
		if(!this.clientes.existe(cliente.getCpf())){
			throw new ClienteNaoExistenteException();
		}
		this.clientes.atualizar(cliente);
	}
	
	public void remover(String cpf) throws ClienteNaoExistenteException, RepositorioException{
		if(!this.clientes.existe(cpf)) {
			throw new ClienteNaoExistenteException();
		}
		this.clientes.remover(cpf);
	}

}
