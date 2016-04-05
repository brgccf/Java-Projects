package br.ufpe.cin.banco;

/**
 * Defina a classe abstrata br.ufpe.cin.banco.ContaAbstrata que tem 
 * os mesmos atributos e metodos de Conta, so que o método debitar 
 * eh abstrato, como visto em sala
 *
 */
public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	
	public ContaAbstrata(String numero) {
		this.numero = numero;
		this.saldo = 0;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void creditar(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public abstract void debitar(double valor);

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
		
}
