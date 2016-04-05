package brgccf.q1;

public class Personagens {
	private String nome;
	private Classes classe;
	private char sexo;
	private int nivel;
	
	private boolean sendoUtilizado;
	
	public Personagens(String nome, Classes classe, char sexo) {
		this.nome = nome;
		this.classe = classe;
		this.sexo = sexo;
		this.nivel = 1;
		this.sendoUtilizado = false;
	}
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Classes getClasse() {
		return classe;
	}



	public void setClasse(Classes classe) {
		this.classe = classe;
	}



	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel() {
		this.nivel++;
	}
	
	//o boolean abaixo é usado para evitar que  o personagem seja utilizado em mais e uma sessao

	public boolean getSendoUtilizado() {
		return sendoUtilizado;
	}

	public void setSendoUtilizadoTrue() {
		this.sendoUtilizado = true;
	}
	
	public void setSendoUtilizadoFalse(){
		this.sendoUtilizado = false;
	}
	
	

	
	

}
