package locadora;

public class DVD extends Produto{

	private int duracao;
	
	public DVD(String nome, String descricao, double preco, int duracao) {
		super(nome, descricao, preco);
	}
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String toString() {
		return "Nome: " + this.getNome() + "\nDescrição: " + this.getDescricao() + "\nPreço: " + this.getPreco() + "\nDuração: " + this.duracao;
	}
	

}
