package dados;

import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;
import locadora.Cliente;
import locadora.Produto;

public class RepositorioClienteArray implements RepositorioCliente {
	private Cliente[] clientes;
	private int indice;
	
	public RepositorioClienteArray() {
		this.clientes = new Cliente[10];
		this.indice=0;
	}

	//m�todo para cadastrar cliente 
	public void inserir(Cliente cliente) throws ClienteExistenteException {
		if (this.clientes[this.clientes.length-1] != null) {
			Cliente[] aux = new Cliente[this.clientes.length*2];
			//passando os dados atuais de cliente para o array auxiliar
			for (int i = 0; i < this.clientes.length; i++) {
				aux[i] = this.clientes[i];
			}
			//agora nosso array ser� maior:
			this.clientes = aux;
		}
		this.clientes[this.indice]=cliente;
		this.indice++;
	}
	//m�todo para verificar se algum cliente j� existe:
	public boolean existe(String cpf) {
		boolean achou = false;
		//se encontrarmos, achou ser� true, ent�o teremos um cliente j� cadastrado
		for (int i = 0; !achou && i < this.clientes.length; i++) {
			if (this.clientes[i]!=null) {
				if (this.clientes[i].getCpf().equalsIgnoreCase(cpf)) {
					achou = true;
				}
			}
		}

		return achou;
	}

	//m�todo para procurar cliente
	public Cliente procurar(String cpf) throws ClienteNaoExistenteException {
		Cliente clienteProcurado = null;
		boolean achou = false;
		for (int i = 0;!achou && i < this.clientes.length; i++) {
			if (this.clientes[i]!=null) {
				if(this.clientes[i].getCpf().equalsIgnoreCase(cpf)){
					achou = true;
					clienteProcurado = this.clientes[i];
				}
			}
		}
		return clienteProcurado;
	}

	//m�todo para atualizar dados de cliente
	public void atualizar(Cliente cliente) throws ClienteNaoExistenteException {
		boolean achou = false;
		for (int i = 0; !achou && i < this.clientes.length; i++) {
			if (this.clientes[i]!=null) {
				if(this.clientes[i].getCpf().equals(cliente.getCpf())){
					achou = true;
					this.clientes[i] = cliente;		
				}
			}
		}
	}

	//metodo para remover cliente
	public void remover(String cpf) throws ClienteNaoExistenteException {
		boolean achou = false;
		
		for (int i = 0; !achou && i < this.clientes.length; i++) {
			if (this.clientes[i]!=null) {
				if(this.clientes[i].getCpf().equalsIgnoreCase(cpf)){
					achou = true;
					this.clientes[i] = null;
					while (this.clientes[i+1]!=null&&this.clientes.length>i) {
						this.clientes[i]=this.clientes[i+1];
						i++;
					}
					this.indice--;
				}
			}
		}
	}
	
	public Cliente[] getIterator() {
		return this.clientes;
	}

	public void inserirProduto(String cpf, Produto produto) throws ProdutoExistenteException, RepositorioException {
		boolean achou = false;
		for (int i = 0; !achou && i < this.clientes.length; i++) {
			if (this.clientes[i]!=null) {
				if(this.clientes[i].getCpf().equals(cpf)){
					achou = true;
					this.clientes[i].adicionar(produto);	
				}
			}
		}		
	}

	public void removerProduto(String cpf, String nomeProduto) throws ProdutoNaoExistenteException, RepositorioException {
		boolean achou = false;
		for (int i = 0; !achou && i < this.clientes.length; i++) {
			if (this.clientes[i]!=null) {
				if(this.clientes[i].getCpf().equals(cpf)){
					achou = true;
					this.clientes[i].remover(nomeProduto);	
				}
			}
		}		
	}
}
