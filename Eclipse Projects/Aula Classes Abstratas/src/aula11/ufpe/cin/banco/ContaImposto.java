package aula11.ufpe.cin.banco;

import aula13.br.ufpe.cin.banco.ContaAbstrata;

public class ContaImposto extends ContaAbstrata {
	
	//abaixo definimos a taxa constante do imposto
	private static final double CPMF = 0.001;
	
	public ContaImposto (String numero){
		super(numero);
	}
	
	public void debitar (double valor){
		double imposto = valor * CPMF;
		double total = valor + imposto;
		super.setSaldo(this.getSaldo() - total);
	}
	
	public String toString(){
		return "Conta Imposto: " + this.getNumero() + "\nSaldo atual: " + this.getSaldo();
	}
	
	

}
