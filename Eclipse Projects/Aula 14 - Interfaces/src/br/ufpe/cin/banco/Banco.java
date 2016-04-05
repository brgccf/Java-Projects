package br.ufpe.cin.banco;

/**
 * Modifique a classe Banco para que seja possivel trabalhar 
 * com todos os tipos de conta da aplicacao bancaria
 * 
 */
public class Banco {

	private ContaAbstrata[] contas;
	private int indice;
	
	private final double TAXA = 0.008;

	public Banco() {
		contas = new ContaAbstrata[100];
		indice = 0;
	}

	public void cadastrar(ContaAbstrata conta) {
		contas[indice] = conta;
		indice = indice + 1;
	}

	public void creditar(String numero, double valor) {
		ContaAbstrata c = this.procurar(numero);
		c.creditar(valor);
	}

	public void debitar(String numero, double valor) {
		ContaAbstrata c = this.procurar(numero);
		c.debitar(valor);
	}

	public double getSaldo(String numero) {
		ContaAbstrata c = this.procurar(numero);
		return c.getSaldo();
	}

	public void transferir(String de, String para, double valor) {
		ContaAbstrata origem = this.procurar(de);
		ContaAbstrata destino = this.procurar(para);
		origem.debitar(valor);
		destino.creditar(valor);
	}
	
	public void renderJuros(String numero) {
		ContaAbstrata c = this.procurar(numero);
		if (c instanceof Poupanca) {
			((Poupanca) c).renderJuros(TAXA);
		} 
		else {
			throw new RuntimeException("O numero nao eh de Poupanca");
		}
	}

	public void renderBonus(String numero) {
		ContaAbstrata c = this.procurar(numero);
		if (c instanceof ContaEspecial) {
			((ContaEspecial) c).renderBonus();
		} 
		else {
			throw new RuntimeException("O numero nao eh de ContaEspecial");
		}
	}

	// perceba que esse metodo eh private
	private ContaAbstrata procurar(String numero) {
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < indice)) {
			n = contas[i].getNumero();
			if (n.equals(numero)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		if (i == indice)
			throw new RuntimeException("Conta nao encontrada");
		return contas[i];
	}
}