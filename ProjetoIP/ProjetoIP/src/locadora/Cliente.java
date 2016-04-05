package locadora;

import dados.RepositorioProduto;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

public class Cliente {
	private String nome;
	private String cpf;
	private RepositorioProduto produtos;
	public Cliente(String nome, String cpf) throws RepositorioException {
		this.nome = nome;
		this.cpf = cpf;
		this.produtos = Config.lerProdutoCliente();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public RepositorioProduto getRepositorioProduto() {
		return this.produtos;
	}
	public void setRepositorioProduto(RepositorioProduto produtos) {
		this.produtos = produtos;
	}
	public void adicionar(Produto produto) throws ProdutoExistenteException, RepositorioException{
		this.produtos.inserir(produto);
	}
	public void remover(String nome) throws ProdutoNaoExistenteException, RepositorioException{
		this.produtos.remover(nome);
	}
}
