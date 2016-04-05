package exercicios;

public class Pessoa {
	private String nome;
	
	//contrutor: inicializar os atributos
	public Pessoa(String nome){
		this.nome = nome;
	}
	//metodo: alterar os atributos
	public void setNome(String nome){
		this.nome = nome;
	}
	//armazenando: 
	public String getNome(){
		return this.nome;
	}
	public static void main(String [] args){
	Pessoa pessoa1 = new Pessoa ("José");
	String pessoa2 = pessoa1;
	}
	
	
	
}
