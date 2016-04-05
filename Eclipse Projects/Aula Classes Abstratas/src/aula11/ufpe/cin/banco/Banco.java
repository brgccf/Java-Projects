package aula11.ufpe.cin.banco;
import aula13.br.ufpe.cin.banco.*;
import aula14.br.ufpe.cin.dados.*;
public class Banco implements RepositorioContas{
	

	private ContaAbstrata[] contas;
	
	private int indice;
	
	private double taxa;
	
	public Banco (double taxa){
		this.contas = new ContaAbstrata [100];
		this.indice = 0;
		this.taxa = taxa;
	}
	
	public double getTaxa(){
		return this.taxa;
	}
	
	public void cadastrar(ContaAbstrata conta){
		this.contas[indice] = conta;
		this.indice += 1;
	}
	
	
	private ContaAbstrata procurar(String numero){
		ContaAbstrata r = null;
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
	
	
	
	public void creditar(String numero, double valor ){
		ContaAbstrata c = this.procurar(numero);
		c.creditar(valor);
	}
	
	public void debitar (String numero, double valor){
		ContaAbstrata c = this.procurar(numero);
		c.debitar(valor);
	}
	
	public double getSaldo (String numero){
		ContaAbstrata c = this.procurar(numero);
		return c.getSaldo();
	}
	
	public void renderJuros(String numero){
		ContaAbstrata c = this.procurar(numero);
		if (c instanceof Poupanca){
			((Poupanca) c).renderJuros(taxa);
		}
		else{
			throw new RuntimeException ("O numero não é poupança.");
		}
	}
	
	public void renderBonus(String numero){
		ContaAbstrata c = this.procurar(numero);
		if (c instanceof ContaEspecial){
			((ContaEspecial) c).renderBonus();
		}
		else{
			throw new RuntimeException ("Conta não é Especial.");
		}
		
	}
	
	public void transferirContas(String de, double valor, String para){
		ContaAbstrata origem = this.procurar(de);
		ContaAbstrata destino = this.procurar(para);
		origem.debitar(valor);
		destino.creditar(valor);
	}

	@Override
	public void inserir(ContaAbstrata conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String procurar(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remover(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(ContaAbstrata conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existe(String numero) {
		// TODO Auto-generated method stub
		return false;
	}

}
