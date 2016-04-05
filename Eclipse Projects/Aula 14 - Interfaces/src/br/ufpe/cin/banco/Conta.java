package br.ufpe.cin.banco;

/**
 * Altere a classe Conta para herdar da classe ContaAbstrata 
 * e implementar o metodo debitar
 * 
 */
public class Conta extends ContaAbstrata {
	
	public Conta(String numero) {
		super(numero);
	}
	
	public void debitar(double valor) {
		this.setSaldo(this.getSaldo() - valor);
	}
		
}