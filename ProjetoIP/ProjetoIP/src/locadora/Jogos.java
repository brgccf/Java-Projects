package locadora;

public class Jogos extends Produto{

	private int faixaEtaria;

	public Jogos(String nome, String descricao, double preco, int faixaEtaria) {
		super(nome, descricao, preco);
		this.faixaEtaria=faixaEtaria;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String toString() {
		return "Nome: " + this.getNome() + "\nDescrição: " + this.getDescricao() + "\nPreço: " + this.getPreco() + "\nFaixa Etaria: " + this.faixaEtaria;
	}

}
