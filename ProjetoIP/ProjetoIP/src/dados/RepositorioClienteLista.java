package dados;

import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;
import locadora.Cliente;
import locadora.Produto;

public class RepositorioClienteLista implements RepositorioCliente{
	private Cliente cliente;
	private RepositorioClienteLista prox;

	public RepositorioClienteLista() {
		this.cliente=null;
		this.prox=null;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public RepositorioClienteLista getProx() {
		return prox;
	}

	public void setProx(RepositorioClienteLista prox) {
		this.prox = prox;
	}

	public void inserir(Cliente cliente) throws ClienteExistenteException {
		if (this.cliente==null) {
			this.cliente=cliente;
			this.prox=new RepositorioClienteLista();
		} else {
			this.prox.inserir(cliente);
		}
	}
	public boolean existe(String cpf) {
		boolean aux = false;
		if (this.cliente!=null) {
			if (this.cliente.getCpf().equalsIgnoreCase(cpf)) {
				aux=true;
			} else {
				aux=this.prox.existe(cpf);
			}
		}
		return aux;
	}
	public Cliente procurar(String cpf) throws ClienteNaoExistenteException {
		Cliente aux = null;
		if (this.cliente!=null) {
			if (this.cliente.getCpf().equalsIgnoreCase(cpf)) {
				aux=this.cliente;
			} else {
				aux=this.prox.procurar(cpf);
			}
		}
		return aux;
	}
	public void atualizar(Cliente cliente) throws ClienteNaoExistenteException {
		if (this.cliente.getCpf().equals(cliente.getCpf())) {
			this.cliente=cliente;
		} else {
			this.prox.atualizar(cliente);
		}
	}
	public void remover(String cpf) throws ClienteNaoExistenteException {
		if (this.cliente!=null) {
			if (this.cliente.getCpf().equals(cpf)) {
				this.cliente=this.prox.cliente;
				this.prox=this.prox.prox;
			} else {
				this.prox.remover(cpf);
			}
		}
	}
	public void inserirProduto(String cpf, Produto produto) throws ProdutoExistenteException, RepositorioException {
		if (this.cliente.getCpf().equalsIgnoreCase(cpf)) {
			this.cliente.adicionar(produto);
		} else {
			this.prox.inserirProduto(cpf, produto);
		}

	}
	public void removerProduto(String cpf, String nomeProduto) throws ProdutoNaoExistenteException, RepositorioException {
		if (this.cliente.getCpf().equalsIgnoreCase(cpf)) {
			this.cliente.remover(nomeProduto);
		} else {
			this.prox.removerProduto(cpf, nomeProduto);
		}
	}
	
	public RepositorioClienteLista getIterator() {
		return this;
	}
}
