package aula11.ufpe.cin.banco;

import aula13.br.ufpe.cin.banco.ContaAbstrata;

public class Conta extends ContaAbstrata {

	public Conta (String numero){
		super(numero);
	}
	
	public void debitar(double valor){
		this.setSaldo(this.getSaldo() - valor);
	}
	
	public String toString(){
		return "Conta:" + this.getNumero() + "\nSaldo atual: " + this.getSaldo();
	}
	
	
	
	
	
	
}
