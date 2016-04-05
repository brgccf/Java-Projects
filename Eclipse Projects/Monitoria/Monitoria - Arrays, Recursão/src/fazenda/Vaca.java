package fazenda;

public class Vaca {
	private String nome;
	private int idade;
	private double peso;
	private double alimento;
	public Vaca(String nome, int idade, double peso, double alimento){
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.alimento = alimento;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public int getIdade(){
		return idade;
	}
	public void setIdade(int idade){
		this.idade = idade;
	}
	public double getPeso(){
		return peso;
	}
	public void setPeso(double peso){
		this.peso = peso;
	}
	public double getAlimento(){
		return alimento;
	}
	public void setAlimento(double alimento){
		this.alimento = alimento;
	}
	public int virarHamburguer(){
		return (int) (this.peso*this.alimento);
	}

	public String toVacaString(){
		return "Nome: " + this.nome + "\nIdade = " + this.idade;
	}

	public static void main(String[] args){
		Vaca vaquinha = new Vaca("Mimosa", 16, 500.0, 100.0);
		System.out.println(vaquinha.toVacaString());
	}
}
