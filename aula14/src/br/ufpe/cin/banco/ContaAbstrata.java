package br.ufpe.cin.banco;

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
	
	public abstract void debitar(double valor) throws SaldoInsuficienteException;

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
		
}
