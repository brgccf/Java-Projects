package aula11.ufpe.cin.banco;

public class Conta {
	private String numero;
	private double saldo;
	
	public Conta (String numero){
		this.numero = numero;
		this.saldo = 0.0;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public void creditar(double valor){
		this.saldo = this.saldo + valor;
	}
	
	public void debitar(double valor){
		this.saldo = this.saldo - valor;
	}
	
	

}
