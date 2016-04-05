package aula11.ufpe.cin.banco;

public class ContaEspecial extends Conta {
	private double bonus;
	private double taxa;
	public ContaEspecial (String numero, double taxa){
		super(numero);
		this.taxa = taxa;
	}
	
	public void renderBonus(double valor){
		super.creditar(valor);
		this.bonus = this.bonus + (valor * this.taxa);
	}
	
	public double getBonus(){
		return this.bonus;
	}

}
