package br.ufpe.cin.banco;

@SuppressWarnings("serial")
public class SaldoInsuficienteException extends Exception{
	private double saldo;
	private String numero;
	
	public SaldoInsuficienteException(double saldo, String numero){
		super("Saldo insuficiente!");
		this.saldo = saldo;
		this.numero = numero;
		
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public String getNumero(){
		return this.numero;
	}

}
