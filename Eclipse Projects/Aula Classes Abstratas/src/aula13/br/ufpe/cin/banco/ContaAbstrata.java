package aula13.br.ufpe.cin.banco;
//classe necess�ria para podermos criar uma conta imposto
//que ter� um METODO DEBITAR DIFERENTE das outras classes

//Obs: Classes Abstratas N�O PERMITEM CRIA��O DE OBJETOS PARA ELAS

public abstract class ContaAbstrata {
	private String numero;
	private double saldo;
	
	public ContaAbstrata (String numero){
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
		this.saldo = this.getSaldo() + valor;
	}
	
	/*
	 * novo metodo necessario pois precisaremos alterar
	 * os valores de saldo para cada opera��o realizada
	 * nas outras classes
	 */
	protected void setSaldo(double saldo){
		this.saldo = saldo;
	}
	
	public abstract void debitar (double valor);
	
	
}
