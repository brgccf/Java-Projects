package br.ufpe.cin.banco;

public class Conta extends ContaAbstrata {
	
	public Conta(String numero) {
		super(numero);
	}
	
	public void debitar(double valor) throws SaldoInsuficienteException {
		if(valor <= this.getSaldo()){
		this.setSaldo(this.getSaldo() - valor);
		}
		else{
			throw new SaldoInsuficienteException(this.getSaldo(), this.getNumero());
		}
	}
		
}