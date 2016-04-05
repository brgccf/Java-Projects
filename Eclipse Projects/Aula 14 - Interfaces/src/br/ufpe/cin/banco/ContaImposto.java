package br.ufpe.cin.banco;

/**
 * Defina a classe br.ufpe.cin.banco.ContaImposto que herda de 
 * ContaAbstrata e tem uma constante CPMF que armazena o imposto a 
 * ser cobrado quando um valor for debitado na ContaImposto
 *
 */
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