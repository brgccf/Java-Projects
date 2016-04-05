package locadora;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Produto {
	private Calendar calendario;
	
	private String nome;
	private String descricao;
	private boolean alugado;
	private double preco;
	
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.alugado = false;
		this.preco = preco;
		this.calendario = new GregorianCalendar();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean getAlugado() {
		return this.alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado=alugado;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Calendar getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}
	//metodos extras
	public void alugarProduto() {
		Calendar aux = new GregorianCalendar();
		aux.add(Calendar.DATE, 5);
		this.calendario=aux;
		this.alugado=true;
	}
	public abstract String toString();
	
}