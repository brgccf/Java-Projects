package br.ufpe.cin.banco;

public class ContaImposto extends ContaAbstrata {
	public static final double CPMF = 0.0038;
	
	public ContaImposto(String numero) {
		super(numero);
	}
	
	public void debitar(double valor) {
	    double imposto = valor * CPMF;
	    double total = valor + imposto;
	    this.setSaldo(this.getSaldo() - total);
	}

}