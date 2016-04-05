package aula11.ufpe.cin.banco;

public class ContaEspecial extends Conta {
	private double bonus;
	
	//declaramos uma variavel CONSTANTE da forma explicitada a seguir
	private static final double TAXA = 0.01;
	/* isso é util pois ela sera utilizada por toda a classe com este mesmo valor
	 * obs:
	 * static impede que sejam criados objetos com esta vatiavel
	 * final determina a constância do valor desta variavel
	 */
	
	public ContaEspecial (String numero){
		super(numero);
		this.bonus = 0.0;
	}
	
	public void renderBonus(){
		super.creditar(this.bonus);
		this.bonus = 0;
	}
	
	public void creditar(double valor){
		super.creditar(valor);
		this.bonus = valor * TAXA;
	}
	
	public double getBonus(){
		return this.bonus;
	}
	
	public String toString(){
		return "Conta Especial:" + this.getNumero() + "\nSaldo atual: " + this.getSaldo() + "\nBonus atual: " + this.getBonus();
	}
	

}
