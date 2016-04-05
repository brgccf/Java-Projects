package fachada;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import locadora.Cliente;
import locadora.Config;
import locadora.Produto;
import negocio.NegocioClientes;
import negocio.NegocioProdutos;
import excecoes.ClienteExistenteException;
import excecoes.ClienteNaoExistenteException;
import excecoes.ProdutoAlugadoException;
import excecoes.ProdutoExistenteException;
import excecoes.ProdutoNaoExistenteException;
import excecoes.RepositorioException;

public class Locadora {
	private String nome;
	private NegocioClientes fachadaClientes;
	private NegocioProdutos fachadaProdutos;
	
	public Locadora(String nome) throws RepositorioException {
		this.nome=nome;
		this.fachadaClientes= new NegocioClientes(Config.lerCliente()); //metodos staticos de retorno do tipo de repositorio com base no config.txt
		this.fachadaProdutos= new NegocioProdutos(Config.lerProduto());
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//cadastrar clientes e produtos
	public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException, RepositorioException{
		this.fachadaClientes.inserir(cliente);
	}
	
	public void cadastrarProduto(Produto produto) throws ProdutoExistenteException, RepositorioException{
		this.fachadaProdutos.inserirProduto(produto);
	}
	
	//alugando produtos:
	public void alugarProduto(String cpf, String nomeProduto) throws ProdutoNaoExistenteException, ClienteNaoExistenteException, ProdutoExistenteException, RepositorioException{
		Produto produtoAUX = this.fachadaProdutos.procurarProduto(nomeProduto);
		Cliente clienteAUX = this.fachadaClientes.procurar(cpf);
		produtoAUX.alugarProduto();
		this.fachadaProdutos.atualizar(produtoAUX);
		clienteAUX.adicionar(produtoAUX);
		this.fachadaClientes.atualizar(clienteAUX);
	}
	
	//removendo produtos do cliente:
	public double devolucaoProduto(String cpf, String nomeProduto) throws ProdutoNaoExistenteException, RepositorioException, ClienteNaoExistenteException{
		Cliente clienteAUX = this.fachadaClientes.procurar(cpf);
		Produto produtoAUX = this.fachadaProdutos.procurarProduto(nomeProduto);
		produtoAUX.setAlugado(false);
		this.fachadaProdutos.atualizar(produtoAUX);
		clienteAUX.remover(nomeProduto);
		long multa=this.multa(produtoAUX.getCalendario());
		if (multa>5) {
			multa = multa - 5;
		} else {
			multa = 0;
		}
		return multa*2;
	}
	
	//calculando os dias que passaram
	private long multa(Calendar produto) {
		Calendar hoje = new GregorianCalendar();
		Date d1=produto.getTime();
		Date d2=hoje.getTime();
		long dif = d2.getTime() - d1.getTime();
		long days = TimeUnit.MILLISECONDS.toDays(dif);
		return days;
	}
	
	//removendo produtos do cat�logo:
	public void removerProdutoCatalogo(String nomeProduto) throws ProdutoNaoExistenteException, RepositorioException, ProdutoAlugadoException{
		this.fachadaProdutos.remover(nomeProduto);
	}
}
