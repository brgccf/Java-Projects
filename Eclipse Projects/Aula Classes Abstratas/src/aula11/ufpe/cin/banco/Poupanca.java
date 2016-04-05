package aula11.ufpe.cin.banco;

public class Poupanca extends Conta {
	
	public Poupanca (String numero){
		super(numero);
	}
	
	public void renderJuros(double taxa){
		this.creditar(this.getSaldo() * taxa);
	}
	
	public String toString(){
		return "Conta Poupan�a:" + this.getNumero() + "\nSaldo atual: " + this.getSaldo();
	}
	

}
