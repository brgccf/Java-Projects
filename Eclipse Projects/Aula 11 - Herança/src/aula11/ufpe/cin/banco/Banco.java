package aula11.ufpe.cin.banco;

public class Banco {
	private Conta[] contas;
	private Poupanca[] poupancas;
	private int indiceContas;
	private int indicePoupancas;
	private double taxa;
	
	public Banco (double taxa){
		this.contas = new Conta [100];
		this.poupancas = new Poupanca [100];
		this.indiceContas = 0;
		this.indicePoupancas = 0;
		this.taxa = taxa;
	}
	
	public double getTaxa(){
		return this.taxa;
	}
	
	public void cadastrar(Conta conta){
		contas[indiceContas] = conta;
		indiceContas += 1;
	}
	
	public void cadastrarPoupanca(Poupanca poupanca){
		poupancas[indicePoupancas] = poupanca;
		indicePoupancas += 1;
	}
	
	private Conta procurar(String numero){
		Conta r = null;
		for(int i = 0; i < this.contas.length; i++){
			
			if (this.contas[i].getNumero().equals(numero)){
				r = this.contas[i];
				i = this.contas.length;
			}
		}
		if(!r.getNumero().equals(numero)){
			throw new RuntimeException ("Conta não encontrada");
		}
		return r;
		
	}
	
	
	private Poupanca procurarPoup(String numero){
		Poupanca r = null;
		for(int i = 0; i < this.contas.length; i++){
			
			if (this.poupancas[i].getNumero().equals(numero)){
				r = this.poupancas[i];
				i = this.poupancas.length;
			}
		}
		if(!r.getNumero().equals(numero)){
			throw new RuntimeException ("Poupança não encontrada");
		}
		return r;
		
	}
	
	public void creditar(String numero, double valor ){
		Conta c = this.procurar(numero);
		c.creditar(valor);
	}
	
	public void debitar (String numero, double valor){
		Conta c = this.procurar(numero);
		c.debitar(valor);
	}
	
	public double getSaldo (String numero){
		Conta c = this.procurar(numero);
		return c.getSaldo();
	}
	
	public void renderJuros(String numero){
		Poupanca c = this.procurarPoup(numero);
		c.renderJuros(this.taxa);
	}
	
	public void transferirContas(String numero1, double valor, String numero2){
		Conta a = this.procurar(numero1);
		Conta b = this.procurar(numero2);
		a.debitar(valor);
		b.creditar(valor);
	}

}
