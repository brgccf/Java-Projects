package brgccf.q1;

public class Jogadores{
	
	private String nome;
	private Classes classe;
	private String login;
	private boolean[] dias;
	private Personagens personagem;
	
	public Jogadores(String nome, Classes classe, String login,  boolean[] dias) {
		this.nome = nome;
		this.classe = classe;
		this.login = login;
		this.dias = dias;
		this.personagem = null;
		
	}

	//metodos get e set
	
	public String getLogin() {
		return login;
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

	public void setLogin(String login) {
		this.login = login;
	}


	public boolean[] getDias() {
		return dias;
	}


	public void setDias(boolean[] dias) {
		this.dias = dias;
	}

	public Personagens getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagens personagem) {
		this.personagem = personagem;
	}

	
	
	
	
	
	

}
