package brgccf.q1;

public class Mestres extends Jogadores{


	private Personagens[] personagens;
	//contador de sessoes do mestre
	private int SessoesMestradas;

	public Mestres(String nome, Classes classe, String login, boolean[] dias) {
		super(nome, classe, login, dias);
		this.SessoesMestradas = 0;
		this.personagens = null;
	}

	public int getSessoesMestradas() {
		return SessoesMestradas;
	}

	public void setSessoesMestradas() {
		this.SessoesMestradas++;
	}

	public Personagens[] getPersonagens() {
		return personagens;
	}

	public void setPersonagens(Personagens[] personagens) {
		this.personagens = personagens;
	}
	
	


}
